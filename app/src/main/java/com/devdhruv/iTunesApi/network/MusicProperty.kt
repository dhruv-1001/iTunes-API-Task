package com.devdhruv.iTunesApi.network

import com.squareup.moshi.Json

data class MusicProperty(
    @Json(name = "artistName") val artistName: String,
    @Json(name = "artworkUrl100") val img_src: String,
    @Json(name = "trackName") val songName: String,
    @Json(name = "trackTimeMillis") val songDuration: Long
)