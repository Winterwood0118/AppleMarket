package com.example.applemarket.Data

import com.example.applemarket.DataClass.AppleItem

class ItemData {
    companion object{
        private var itemData: ItemData? = null

        fun getInstance(): ItemData {
            return itemData?: ItemData().apply { itemData = this }
        }
    }

    private val itemList = mutableListOf<AppleItem>(
    )

    val items: List<AppleItem> = itemList

    fun addItem(appleItem: AppleItem){
        itemList.add(appleItem)
    }

    fun deleteItem(appleItem: AppleItem){
        itemList.remove(appleItem)
    }

}