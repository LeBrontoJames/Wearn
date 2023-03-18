package com.reift.wearn.data



data class Learn(
    val question: String,
    val listAnswer: List<String>,
    val trueAnswer: Int,
    val explanation: String
)
