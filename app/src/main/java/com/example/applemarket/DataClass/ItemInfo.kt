package com.example.applemarket.DataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemInfo(
    val iImageID: Int,
    val iName: String,
    val iValue: String,
    val iIntroduction: String
):Parcelable
