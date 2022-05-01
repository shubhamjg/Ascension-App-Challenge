package com.shubham.ascensionappchallenge.ui.fragment.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import closeSoftKeyboard
import com.shubham.ascensionappchallenge.R
import com.shubham.ascensionappchallenge.common.ACTIVITY_RESULT
import com.shubham.ascensionappchallenge.common.BUNDLE
import com.shubham.ascensionappchallenge.common.Constants
import com.shubham.ascensionappchallenge.databinding.ActivityHomeBinding
import com.shubham.ascensionappchallenge.mvvm.viewModel.home.HomeViewModel
import com.shubham.ascensionappchallenge.ui.adapter.home.HomeRecyclerViewAdapter
import com.shubham.ascensionappchallenge.ui.base.BaseFragment
import com.shubham.ascensionappchallenge.ui.custom.pagination.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel>() {

    private val homeViewModel: HomeViewModel by viewModels()
    private var homeRecyclerViewAdapter: HomeRecyclerViewAdapter? = null
    private var paginationScrollListener: PaginationScrollListener? = null
    private var binding: ActivityHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentResult()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
        binding?.let {
            initViewModel(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun initViewModel(binding: ActivityHomeBinding) {
        viewModel = homeViewModel
        initViewModelState(binding.loadingLayout, binding.emptyLayout)
        viewModel?.getSearchList()?.observe(viewLifecycleOwner) { resultList ->
            resultList?.let {
                if (resultList.isEmpty()) {
                    binding.emptyLayout.root.visibility = View.VISIBLE
                }
                homeRecyclerViewAdapter?.setSearchList(it)
            } ?: run {
            }
        }

        viewModel?.getToolbarTitle()?.observe(viewLifecycleOwner) { value ->
            value?.let { isWatchlistMode ->
                binding.toolbarLayout.toolbarTitleTextView.text = when {
                    isWatchlistMode -> getString(R.string.home_watch_list)
                    else -> getString(R.string.home_toolbar_title)
                }
            }
        }

        viewModel?.getPaginationStatus()?.observe(viewLifecycleOwner) { value ->
            value?.let { isPaginationFinished ->
                paginationScrollListener?.finishedPagination(isPaginationFinished)
            }
        }

        viewModel?.getPaginationLoader()?.observe(viewLifecycleOwner) { value ->
            value?.let { show ->
                binding.recyclerViewLayout.moreProgressView.visibility =
                    if (show) View.VISIBLE else View.GONE
            }
        }
    }

    private fun initLayout() {
        binding?.apply {
            toolbarLayout.toolbarTitleTextView.text = getString(R.string.home_toolbar_title)

            toolbarLayout.backButtonImageView.visibility = View.INVISIBLE

            searchImageButton.setOnClickListener {
                if (searchEditText.text.toString()
                        .isEmpty() && viewModel?.isWatchListMode == false
                ) {
                    showErrorDialog(
                        getString(R.string.home_empty_field),
                        closeListener = { dialog ->
                            dialog.dismiss()
                            viewModel?.genericErrorLiveData?.value = false
                        })
                }
                handleClickSearch()
            }

            searchEditText.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(
                    charSequence: CharSequence,
                    arg1: Int,
                    arg2: Int,
                    arg3: Int
                ) {
                    viewModel?.setQueryText(searchEditText.text?.trim().toString())
                }

                override fun beforeTextChanged(
                    arg0: CharSequence,
                    arg1: Int,
                    arg2: Int,
                    arg3: Int
                ) {
                }

                override fun afterTextChanged(arg0: Editable) {}
            })

            searchEditText.setOnEditorActionListener(object : TextView.OnEditorActionListener {
                override fun onEditorAction(v: TextView, actionId: Int, event: KeyEvent?): Boolean {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        handleClickSearch()
                        return true
                    }
                    return false
                }
            })

            val linearLayoutManager = LinearLayoutManager(activity)
            binding?.recyclerViewLayout?.homeRecyclerView?.layoutManager = linearLayoutManager
            homeRecyclerViewAdapter = HomeRecyclerViewAdapter(
                onItemClicked = { homeDataModel ->
                    val action = HomeFragmentDirections.actionHomeFragmentToDetailsComposeFragment2(
                        homeDataModel
                    )
                    findNavController().navigate(action)

                })

            paginationScrollListener = PaginationScrollListener(
                linearLayoutManager,
                {
                    if (viewModel?.isWatchListMode == true) {
                        return@PaginationScrollListener
                    }
                    if (searchEditText.text.toString().isNotEmpty()) {
                        binding?.recyclerViewLayout?.moreProgressView?.visibility = View.VISIBLE
                    }
                    viewModel?.fetchSearchResult()
                },
                Constants.PAGINATION_SIZE
            )
            paginationScrollListener?.let {
                binding?.recyclerViewLayout?.homeRecyclerView?.addOnScrollListener(it)
            }
            binding?.recyclerViewLayout?.homeRecyclerView?.adapter = homeRecyclerViewAdapter
        }
    }

    private fun handleClickSearch() {
        binding?.recyclerViewLayout?.homeRecyclerView?.smoothScrollToPosition(Constants.FIRST_POSITION)
        binding?.searchEditText?.clearFocus()
        activity?.let { closeSoftKeyboard(it) }
        viewModel?.searchForResults()
    }

    private fun fragmentResult() {
        setFragmentResultListener(ACTIVITY_RESULT.DETAILS) { _: String, bundle: Bundle ->
            viewModel?.updateModel(bundle.getParcelable(BUNDLE.MOVIE_DETAILS))
            viewModel?.readWatchListFromDatabase()
        }
    }
}
