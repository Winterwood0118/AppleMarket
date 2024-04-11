package com.example.applemarket.Data

import com.example.applemarket.DataClass.AppleItem
import com.example.applemarket.DataClass.ItemInfo
import com.example.applemarket.DataClass.Seller

class ItemData {
    companion object{
        private var itemData: ItemData? = null

        fun getInstance(): ItemData {
            return itemData?: ItemData().apply { itemData = this }
        }
    }

    private val itemList = mutableListOf<AppleItem>(
        AppleItem(
            Seller(sellerId[0], addressId[0]),
            ItemInfo(imageId[0], nameId[0], valueList[0], introductionId[0]),
            likeList[0],
            chatList[0]
        ),
        AppleItem(
            Seller(sellerId[1], addressId[1]),
            ItemInfo(imageId[1], nameId[1], valueList[1], introductionId[1]),
            likeList[1],
            chatList[1]
        ),
        AppleItem(
            Seller(sellerId[2], addressId[2]),
            ItemInfo(imageId[2], nameId[2], valueList[2], introductionId[2]),
            likeList[2],
            chatList[2]
        ),
        AppleItem(
            Seller(sellerId[3], addressId[3]),
            ItemInfo(imageId[3], nameId[3], valueList[3], introductionId[3]),
            likeList[3],
            chatList[3]
        ),
        AppleItem(
            Seller(sellerId[4], addressId[4]),
            ItemInfo(imageId[4], nameId[4], valueList[4], introductionId[4]),
            likeList[4],
            chatList[4]
        ),
        AppleItem(
            Seller(sellerId[5], addressId[5]),
            ItemInfo(imageId[5], nameId[5], valueList[5], introductionId[5]),
            likeList[5],
            chatList[5]
        ),
        AppleItem(
            Seller(sellerId[6], addressId[6]),
            ItemInfo(imageId[6], nameId[6], valueList[6], introductionId[6]),
            likeList[6],
            chatList[6]
        ),
        AppleItem(
            Seller(sellerId[7], addressId[7]),
            ItemInfo(imageId[7], nameId[7], valueList[7], introductionId[7]),
            likeList[7],
            chatList[7]
        ),
        AppleItem(
            Seller(sellerId[8], addressId[8]),
            ItemInfo(imageId[8], nameId[8], valueList[8], introductionId[8]),
            likeList[8],
            chatList[8]
        ),
        AppleItem(
            Seller(sellerId[9], addressId[9]),
            ItemInfo(imageId[9], nameId[9], valueList[9], introductionId[9]),
            likeList[9],
            chatList[9]
        )
    )

    val items: List<AppleItem> = itemList

    fun addItem(appleItem: AppleItem){
        itemList.add(appleItem)
    }

    fun deleteItem(appleItem: AppleItem){
        itemList.remove(appleItem)
    }

}
