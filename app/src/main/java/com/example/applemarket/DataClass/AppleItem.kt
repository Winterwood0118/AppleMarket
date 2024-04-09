package com.example.applemarket.DataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppleItem(
    val iSeller: Seller,
    val iItemInfo: ItemInfo,
    val iLike: Int,
    val iComment: Int
): Parcelable
