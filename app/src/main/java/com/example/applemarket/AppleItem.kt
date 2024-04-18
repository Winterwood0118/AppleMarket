package com.example.applemarket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppleItem(
    val iSeller: Seller,
    val iItemInfo: ItemInfo,
    var iLike: Int = 0,
    val iComment: Int = 0,
    var isLike: Boolean = false
): Parcelable
