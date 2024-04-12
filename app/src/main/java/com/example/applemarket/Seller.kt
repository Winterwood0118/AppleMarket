package com.example.applemarket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Seller(
    val sNameId: Int,
    val sAddressId: Int
): Parcelable
