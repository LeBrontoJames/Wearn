package com.reift.wearn.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Learn(
    val question: String,
    val listAnswer: List<String>,
    val trueAnswer: Int,
    val explanation: String
): Parcelable
