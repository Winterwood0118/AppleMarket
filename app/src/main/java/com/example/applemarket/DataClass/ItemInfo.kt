package com.example.applemarket.DataClass

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemInfo(
    @DrawableRes
    val iImageID: Int,
    val iNameId: Int,
    val iValue: Int,
    val iIntroductionId: Int
):Parcelable
