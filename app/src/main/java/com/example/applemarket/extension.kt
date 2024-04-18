package com.example.applemarket

import android.widget.ImageView
import android.widget.TextView

fun ImageView.switchHeart(isLike: Boolean){
    setImageResource(
        if (isLike) R.drawable.ic_heart_filled
        else R.drawable.ic_heart_empty
    )
}
fun TextView.setWonText(value: Int){
    val wonText = decimal.format(value) + "원"
    text = wonText
}