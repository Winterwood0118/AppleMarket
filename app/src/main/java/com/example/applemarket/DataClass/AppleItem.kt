package com.example.applemarket.DataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppleItem(val iSeller: String, val iImageID: Int, val iName: String, val iValue: String, val iAddress: String): Parcelable
