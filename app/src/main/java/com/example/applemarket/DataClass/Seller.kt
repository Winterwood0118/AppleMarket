package com.example.applemarket.DataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Seller(
    val sName: String,
    val sAddress: String
): Parcelable
