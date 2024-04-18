package com.example.applemarket

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

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

fun showSnackBar(view: View, isLike: Boolean){
    val snackBar = Snackbar.make(view,
        if(isLike) "관심목록에 추가되었습니다."
        else "관심목록에서 제거되었습니다"
        , Snackbar.LENGTH_SHORT
    )
    snackBar.show()
}