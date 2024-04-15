package com.example.nbc__standardtaskweek4

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Card(
    val userMame: String,
    val cardNumber: String,
    val cardType: String,
    val period: String,
    val balance: Double,
    val cardManager: String,
) : Parcelable
