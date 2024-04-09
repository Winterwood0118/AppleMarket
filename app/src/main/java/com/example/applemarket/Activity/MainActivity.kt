package com.example.applemarket.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applemarket.Data.*
import com.example.applemarket.DataClass.AppleItem
import com.example.applemarket.DataClass.ItemInfo
import com.example.applemarket.DataClass.Seller
import com.example.applemarket.R
import com.example.applemarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val itemList = ItemData.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dataInit()

    }

    private fun dataInit() {
        for (i in 0..9) {
            val seller = Seller(getString(sellerId[i]), getString(addressId[i]))
            val itemInfo = ItemInfo(
                imageId[i],
                getString(nameId[i]),
                getString(valueId[i]),
                getString(introductionId[i])
            )
            val item = AppleItem(seller, itemInfo, likeList[i], chatList[i])
            itemList.addItem(item)
        }
    }
}

