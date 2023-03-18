package com.reift.wearn.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Watch(
    val title: String,
    val creator: String,
    val url: String,
    val like: String
): Parcelable
