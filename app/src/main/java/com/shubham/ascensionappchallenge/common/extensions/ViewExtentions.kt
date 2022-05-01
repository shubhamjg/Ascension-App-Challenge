package com.shubham.ascensionappchallenge.common.extensions

import androidx.appcompat.widget.AppCompatImageView
import com.shubham.ascensionappchallenge.R
import com.squareup.picasso.Picasso

fun AppCompatImageView.loadUrl(url: String?) {
    if (url != null) {
        Picasso.get().load(url).placeholder(R.mipmap.ic_launcher).into(this)
    } else {
        Picasso.get().load(R.mipmap.ic_launcher).into(this)
    }
}

