package com.shubham.ascensionappchallenge.common

object Constants {
    const val DOMAIN = "https://api.themoviedb.org/3/"
    const val API_KEY = "571557204630efc3350e7c70cf9a4b0e"
    const val PAGINATION_SIZE = 6
    const val FIRST_POSITION = 0
    const val IS_MOVIE = "movie"
    const val IMAGE_URL_W300 = "https://image.tmdb.org/t/p/w300"
    const val IMAGE_URL_W500 = "https://image.tmdb.org/t/p/w500"
    const val SEARCH_RESPONSE = """{
        "page": 1,
        "results": [
        {
            "adult": false,
            "backdrop_path": "/s6cQgJSkviamXAXBggT2xmj7JiG.jpg",
            "genre_ids": [
            28,
            878,
            12
            ],
            "id": 1726,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "Iron Man",
            "overview": "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.",
            "popularity": 120.383,
            "poster_path": "/78lPtwv72eTNqFW9COBYI0dWDJa.jpg",
            "release_date": "2008-04-30",
            "title": "Iron Man",
            "video": false,
            "vote_average": 7.6,
            "vote_count": 22625
        },
        {
            "adult": false,
            "backdrop_path": "/6zINLC59ButA0fjAQIyJmFFNdjM.jpg",
            "genre_ids": [
            12,
            28,
            878
            ],
            "id": 10138,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "Iron Man 2",
            "overview": "With the world now aware of his dual life as the armored superhero Iron Man, billionaire inventor Tony Stark faces pressure from the government, the press and the public to share his technology with the military. Unwilling to let go of his invention, Stark, with Pepper Potts and James 'Rhodey' Rhodes at his side, must forge new alliances – and confront powerful enemies.",
            "popularity": 172.277,
            "poster_path": "/6WBeq4fCfn7AN0o21W9qNcRF2l9.jpg",
            "release_date": "2010-04-28",
            "title": "Iron Man 2",
            "video": false,
            "vote_average": 6.8,
            "vote_count": 17833
        },
        {
            "adult": false,
            "backdrop_path": "/4TSqtluelcWByj8YZdqwzQVjI0O.jpg",
            "genre_ids": [
            28,
            12,
            878
            ],
            "id": 68721,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "Iron Man 3",
            "overview": "When Tony Stark's world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of rebuilding and retribution.",
            "popularity": 117.914,
            "poster_path": "/qhPtAc1TKbMPqNvcdXSOn9Bn7hZ.jpg",
            "release_date": "2013-04-18",
            "title": "Iron Man 3",
            "video": false,
            "vote_average": 6.9,
            "vote_count": 19365
        },
        {
            "adult": false,
            "backdrop_path": null,
            "genre_ids": [
            99
            ],
            "id": 448344,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "Ultimate Iron Man: The Making of Iron Man 2",
            "overview": "A four-part documentary that covers several film-critical elements in greater detail.",
            "popularity": 37.711,
            "poster_path": "/zPDfxcdBSeLLXhdZKFhHe2de5Kz.jpg",
            "release_date": "2010-09-28",
            "title": "Ultimate Iron Man: The Making of Iron Man 2",
            "video": true,
            "vote_average": 6.5,
            "vote_count": 42
        },
        {
            "backdrop_path": "/ijOzFQw37jjfZdG1zproCkO6oue.jpg",
            "first_air_date": "1994-09-24",
            "genre_ids": [
            16,
            10759,
            10765
            ],
            "id": 3097,
            "media_type": "tv",
            "name": "Iron Man",
            "origin_country": [
            "US"
            ],
            "original_language": "en",
            "original_name": "Iron Man",
            "overview": "Industrialist Tony Stark leads a private team of superheroes as Iron Man against the forces of evil.",
            "popularity": 13.876,
            "poster_path": "/nTQWWH6CFtl37x1nPx8HRwbwvGn.jpg",
            "vote_average": 7,
            "vote_count": 65
        },
        {
            "adult": false,
            "backdrop_path": "/oUi2pvNbHCUiEFSqawp5dJdQNMK.jpg",
            "genre_ids": [
            28,
            12,
            16,
            14,
            878
            ],
            "id": 13647,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "The Invincible Iron Man",
            "overview": "When a cocky industrialist's efforts to raise an ancient Chinese temple leads him to be seriously wounded and captured by enemy forces, he must use his ideas for a revolutionary power armor in order to fight back as a superhero.",
            "popularity": 24.217,
            "poster_path": "/eebNTSRa5Hh5skPKGdGJIJpo9Ls.jpg",
            "release_date": "2007-01-23",
            "title": "The Invincible Iron Man",
            "video": false,
            "vote_average": 6.2,
            "vote_count": 181
        },
        {
            "backdrop_path": "/geoJ7FkV4NXAhZ7pYNCOWGYEBLV.jpg",
            "first_air_date": "2009-04-24",
            "genre_ids": [
            16,
            10759,
            10765
            ],
            "id": 7330,
            "media_type": "tv",
            "name": "Iron Man: Armored Adventures",
            "origin_country": [
            "US"
            ],
            "original_language": "en",
            "original_name": "Iron Man: Armored Adventures",
            "overview": "Iron Man: Armored Adventures is a 3D CGI cartoon series based on the Marvel Comics superhero Iron Man. It debuted in the USA on the Nicktoons on April 24, 2009, and has already begun airing on Canadian network Teletoon. Iron Man: Armored Adventures aired on Nickelodeon on July 4, 2009 until September 12, 2009. The series is story edited by showrunner Christopher Yost, who also worked on Wolverine and the X-Men, and numerous other Marvel Animation projects. The television show is not related to the 2007 animated film The Invincible Iron Man; It has a different voice cast, but some story elements are similar and the show uses the same musical score as the film in some instances. It is the first Iron Man television series since Iron Man from 1994–1996, and started airing after the success of the live action Iron Man film.\n\nThe series follows the adventures of teenage child prodigy Tony Stark and his alter ego of Iron Man. As Iron Man, he uses his technological inventions to fight various similarly technologically advanced threats. His friends, James \"Rhodey\" Rhodes and Pepper Potts help him on his courageous, and dangerous adventures.",
            "popularity": 18.881,
            "poster_path": "/uwMIL8PR1jHpHQksIq7kzdeqg2A.jpg",
            "vote_average": 7.6,
            "vote_count": 97
        },
        {
            "adult": false,
            "backdrop_path": "/kSx2V2sNpxad4LytV0Y9Y0SZVPN.jpg",
            "genre_ids": [
            99
            ],
            "id": 448341,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "I Am Iron Man",
            "overview": "A documentary covering pre-production topics like suit design and construction, storyboards, animatics, and pre-viz, sets, working in the suit, casting, rehearsals, and preparation, and the start of the shoot. From there we look at performances, locations and production design, stunts, hardware and practical effects, and various sequence specifics. Finally, the program goes through post-production at Skywalker Ranch, the titles and a few visual elements, and wrapping up the flick.",
            "popularity": 25.956,
            "poster_path": "/81zROb3C2MnOE67AwgAdWWfy4gK.jpg",
            "release_date": "2008-09-30",
            "title": "I Am Iron Man",
            "video": false,
            "vote_average": 7.2,
            "vote_count": 58
        },
        {
            "adult": false,
            "backdrop_path": "/zxpQlh172HOLlG7UohW8sm7iOdz.jpg",
            "genre_ids": [
            12,
            16,
            28
            ],
            "id": 284274,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "Iron Man & Captain America: Heroes United",
            "overview": "Iron Man and Captain America battle to keep the Red Skull and his triggerman, Taskmaster, from unleashing an army of Hydra Brutes on the world!  Sequel to the film \"Iron Man & Hulk: Heroes United\" and feature Iron Man teaming up with Captain America, it comes to accompany the live-action film \"Captain America: The Winter Soldier\".",
            "popularity": 25.086,
            "poster_path": "/CX7eRlaxFXiW3UGQBdQUoSVZRi.jpg",
            "release_date": "2014-07-29",
            "title": "Iron Man & Captain America: Heroes United",
            "video": false,
            "vote_average": 6.3,
            "vote_count": 107
        },
        {
            "adult": false,
            "backdrop_path": "/vgqZxgFEOMbtBMUNUiCJ3CpVBs8.jpg",
            "genre_ids": [
            99
            ],
            "id": 512127,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "The Invincible Iron Man",
            "overview": "A documentary divided into six-part: For a look at the movie's comic book origins, we hear notes from Brevoort, Quesada, creator Stan Lee, writers Gerry Conway, Joe Casey, Dan Knauf, Charles Knauf and Warren Ellis, writer/artist Bob Layton, and artists Gene Colan, John Romita, Jr., Patrick Zircher and Adi Granov. The piece examines the origins of Iron Man as well as aspects of the character, supporting roles and villains. We also learn about the series' development, various story lines it pursued over the years, and challenges.",
            "popularity": 15.322,
            "poster_path": "/7sk9MyHMuipgIo5m6v6biCNXPHv.jpg",
            "release_date": "2008-09-30",
            "title": "The Invincible Iron Man",
            "video": true,
            "vote_average": 6.5,
            "vote_count": 7
        },
        {
            "adult": false,
            "backdrop_path": "/hmgY7LbcoIm8YQ7wZG8elRzK8rB.jpg",
            "genre_ids": [
            28,
            12,
            16,
            10751
            ],
            "id": 230896,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "Iron Man & Hulk: Heroes United",
            "overview": "The Invincible Iron Man and the Incredible Hulk must join forces to save the Earth from its greatest threat yet! When two Hydra scientists try to supercharge a Stark Arc Reactor with Hulk's Gamma Energy, they unleash a being of pure electricity called Zzzax - and he's hungry for destruction. Together, Iron Man and Hulk are the only force that stands in the way of the Zzzax's planetary blackout. But first, the super heroic duo will have to get through snarling Wendigos, deadly robots and the scaly powerhouse, Abomination.  Can two of Marvel's mightiest heroes find a way to work together without smashing each other before time runs out?",
            "popularity": 12.294,
            "poster_path": "/e7F2ZNA7wMneoSKGonLKjDmjFEd.jpg",
            "release_date": "2013-12-03",
            "title": "Iron Man & Hulk: Heroes United",
            "video": false,
            "vote_average": 5.7,
            "vote_count": 146
        },
        {
            "backdrop_path": "/znw6gXnby8fWRR74ZnXqtsfyJvR.jpg",
            "first_air_date": "2010-11-30",
            "genre_ids": [
            16
            ],
            "id": 77362,
            "media_type": "tv",
            "name": "Iron Man: Extremis",
            "origin_country": [
            "US"
            ],
            "original_language": "en",
            "original_name": "Iron Man: Extremis",
            "overview": "An experimental serum called Extremis gets stolen, and Iron Man rockets into action. The ensuing battles test Stark's spirit and Iron Man's power.",
            "popularity": 3.278,
            "poster_path": "/w10ClxT6uqnyxJZiMAx2ty9GkWu.jpg",
            "vote_average": 6.8,
            "vote_count": 10
        },
        {
            "adult": false,
            "backdrop_path": "/ga2YZp5sysUrRu1luxq1rZUKucc.jpg",
            "genre_ids": [
            18
            ],
            "id": 69592,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "Iron Man",
            "overview": "In Coaltown, Pennsylvania, miner Coke Mason hopes to better himself, buy a radio store, and marry Rose Warren. His gambler brother George thinks Coke can be more successful as a boxer, knowing that when he fights he's consumed with a murderous rage that makes him an \"iron man.\" Seeing dollar signs in Rose's eyes, Coke reluctantly agrees, though he's fearful of the \"killer instinct\" that makes him a knockout success in the ring...and brings him the booing hatred of the fans. Will Coke throw off his personal demon before he kills someone?",
            "popularity": 2.898,
            "poster_path": "/557kSHg8i3LP8DnoTZkCF8HHEBx.jpg",
            "release_date": "1951-09-20",
            "title": "Iron Man",
            "video": false,
            "vote_average": 3.7,
            "vote_count": 7
        },
        {
            "adult": false,
            "backdrop_path": "/ub8wdPp4jDAwqJFjsRwAYmDw5l5.jpg",
            "genre_ids": [
            99
            ],
            "id": 635802,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "Elon Musk: The Real Life Iron Man",
            "overview": "Discover the meteoric rise of Elon Musk, the man who is transforming the way we think about travel technology through electric cars, the Hyperloop, and revolutionary ideas on how we live through artificial intelligence and colonizing Mars.",
            "popularity": 4.584,
            "poster_path": "/wAmSMgyxCwjSxhqExSYmstMQPH.jpg",
            "release_date": "2018-12-04",
            "title": "Elon Musk: The Real Life Iron Man",
            "video": false,
            "vote_average": 5.5,
            "vote_count": 6
        },
        {
            "adult": false,
            "backdrop_path": "/hkBkmIxfKD4nFYgk7jaXPWGf4Rt.jpg",
            "genre_ids": [
            18
            ],
            "id": 194310,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "Iron Man",
            "overview": "Prizefighter Mason loses his opening fight so wife Rose leaves him for Hollywood. Without her around Mason trains and starts winning. Rose comes back and wants Mason to dump his manager Regan and replace him with her secret lover Lewis.",
            "popularity": 2.114,
            "poster_path": "/t5Isp5w4elUOrnXtj11JUdyEMP7.jpg",
            "release_date": "1931-04-29",
            "title": "Iron Man",
            "video": false,
            "vote_average": 4.8,
            "vote_count": 9
        },
        {
            "adult": false,
            "backdrop_path": "/3qip09WgTU9P6CqkROH5LkgLdeR.jpg",
            "genre_ids": [
            28
            ],
            "id": 928743,
            "media_type": "movie",
            "original_language": "zh",
            "original_title": "The Iron Man",
            "overview": "In 1944 Chang Chin's father was murdered by the Japanese with the help of Ching Tang and Fan Hsi-Shang, two collaborators led by Fung Mu. Now a grown up and a master of kung fu, Chang is ready to revenge his father.",
            "popularity": 0.6,
            "poster_path": "/cv1C3Bpvb2zUaO1deWosihfmgHV.jpg",
            "release_date": "1973-01-19",
            "title": "The Iron Man",
            "video": false,
            "vote_average": 0,
            "vote_count": 0
        },
        {
            "adult": false,
            "backdrop_path": null,
            "genre_ids": [],
            "id": 579122,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "The Iron Man",
            "overview": "A tale based on the life of the inventor of the original \"Iron Man\".",
            "popularity": 0.681,
            "poster_path": "/fNXKrWMad6ubB4wBhOHUcevgwVE.jpg",
            "release_date": "2007-07-27",
            "title": "The Iron Man",
            "video": false,
            "vote_average": 5,
            "vote_count": 1
        },
        {
            "adult": false,
            "backdrop_path": null,
            "genre_ids": [],
            "id": 951647,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "Iron Man",
            "overview": "Video work by Ahaad Al Amoudi",
            "popularity": 0.6,
            "poster_path": "/A6aK12Ysdez1SRnGakxodg0SuQ5.jpg",
            "release_date": "2020-01-01",
            "title": "Iron Man",
            "video": false,
            "vote_average": 0,
            "vote_count": 0
        },
        {
            "backdrop_path": null,
            "first_air_date": "",
            "genre_ids": [
            10759,
            18
            ],
            "id": 18189,
            "media_type": "tv",
            "name": "Faujji...The Iron Man",
            "origin_country": [
            "IO"
            ],
            "original_language": "en",
            "original_name": "Faujji...The Iron Man",
            "overview": "Faujji...The Iron Man is a Hindi language Indian television series that airs on the national channel, DD National. The series premiered on March 21, 2009, and airs every Saturday and Sunday at 8:30 pm IST. The story is about the army battling terrorism. On its first day, the series received a Television Rating Point of 1.7 among other shows on other general entertainment channels.",
            "popularity": 0.6,
            "poster_path": null,
            "vote_average": 0,
            "vote_count": 0
        },
        {
            "adult": false,
            "backdrop_path": null,
            "genre_ids": [
            16,
            35
            ],
            "id": 165457,
            "media_type": "movie",
            "original_language": "en",
            "original_title": "The Iron Man",
            "overview": "A feline organ grinder wanders by Farmer Al Falfa's house making some very bad music. Farmer Al Falfa chases him away. Later, the old man chases two roosters up a tree. One of the roosters, improbably, lays an egg and throws it at Al Falfa. The old man climbs up the tree with a handsaw. He sits on the same branch as the roosters, and begins sawing it off. The roosters jump from the branch into a hole in the tree. Al Falfa doesn't realize what he's doing until he saws the branch clean through. Cartoon magic is on his side: the tree falls, but the branch stays in place. Later, a delivery man drops off a large package. Al Falfa is surprised to see that it's a robot. The robot performs a dance, and Al Falfa feels compelled to mimic him. The robot kicks Farmer Al Falfa in the behind. Al Falfa does the same to the robot, which causes it to grow so tall it reaches outer space.",
            "popularity": 0.651,
            "poster_path": null,
            "release_date": "1931-04-14",
            "title": "The Iron Man",
            "video": false,
            "vote_average": 4.5,
            "vote_count": 2
        }
        ],
        "total_pages": 3,
        "total_results": 49
    }"""

    const val MOVIE_RESPONSE ="""{
    "adult": false,
    "backdrop_path": "/s6cQgJSkviamXAXBggT2xmj7JiG.jpg",
    "belongs_to_collection": {
        "id": 131292,
        "name": "Iron Man Collection",
        "poster_path": "/fbeJ7f0aD4A112Bc1tnpzyn82xO.jpg",
        "backdrop_path": "/rI8zOWkRQJdlAyQ6WJOSlYK6JxZ.jpg"
    },
    "budget": 140000000,
    "genres": [
        {
            "id": 28,
            "name": "Action"
        },
        {
            "id": 878,
            "name": "Science Fiction"
        },
        {
            "id": 12,
            "name": "Adventure"
        }
    ],
    "homepage": "https://www.marvel.com/movies/iron-man",
    "id": 1726,
    "imdb_id": "tt0371746",
    "original_language": "en",
    "original_title": "Iron Man",
    "overview": "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.",
    "popularity": 109.872,
    "poster_path": "/78lPtwv72eTNqFW9COBYI0dWDJa.jpg",
    "production_companies": [
        {
            "id": 420,
            "logo_path": "/hUzeosd33nzE5MCNsZxCGEKTXaQ.png",
            "name": "Marvel Studios",
            "origin_country": "US"
        }
    ],
    "production_countries": [
        {
            "iso_3166_1": "US",
            "name": "United States of America"
        }
    ],
    "release_date": "2008-04-30",
    "revenue": 585174222,
    "runtime": 126,
    "spoken_languages": [
        {
            "english_name": "English",
            "iso_639_1": "en",
            "name": "English"
        },
        {
            "english_name": "Persian",
            "iso_639_1": "fa",
            "name": "فارسی"
        },
        {
            "english_name": "Urdu",
            "iso_639_1": "ur",
            "name": "اردو"
        },
        {
            "english_name": "Arabic",
            "iso_639_1": "ar",
            "name": "العربية"
        }
    ],
    "status": "Released",
    "tagline": "Heroes aren't born. They're built.",
    "title": "Iron Man",
    "video": false,
    "vote_average": 7.6,
    "vote_count": 22624
}"""
}

object BUNDLE {
    const val MOVIE_DETAILS = "movieDetails"
    const val movieId = 131292
}

object ACTIVITY_RESULT {
    const val DETAILS = "details"
}
