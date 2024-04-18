package com.example.applemarket

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applemarket.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val itemData = ItemData.getInstance()
        val currentItem: AppleItem = intent.getParcelableExtra("data")?:itemData.items[0]
        val currentPosition = intent.getIntExtra("position", 0)

        with(binding){
            detailItemImageView.setImageResource(currentItem.iItemInfo.iImageID)
            detailItemNameTextView.setText(currentItem.iItemInfo.iNameId)
            detailValueTextView.setWonText(currentItem.iItemInfo.iValue)
            detailItemInfoTextView.setText(currentItem.iItemInfo.iIntroductionId)
            detailAddressTextView.setText(currentItem.iSeller.sAddressId)
            detailSellerTextView.setText(currentItem.iSeller.sNameId)
            detailReturnImageView.setOnClickListener {
                finish()
            }
            detailLikeImageView.apply {
                switchHeart(currentItem.isLike)
                setOnClickListener {
                    itemData.switchLike(currentPosition)
                    showSnackBar(this, itemData.items[currentPosition].isLike)
                    switchHeart(itemData.items[currentPosition].isLike)
                }
            }
        }


    }
}