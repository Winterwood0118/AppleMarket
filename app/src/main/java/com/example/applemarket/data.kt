package com.example.applemarket

import com.example.applemarket.R
import java.text.DecimalFormat

val decimal = DecimalFormat("#,###")

val imageId = arrayOf(
    R.drawable.sample1,
    R.drawable.sample2,
    R.drawable.sample3,
    R.drawable.sample4,
    R.drawable.sample5,
    R.drawable.sample6,
    R.drawable.sample7,
    R.drawable.sample8,
    R.drawable.sample9,
    R.drawable.sample10
)

val nameId = arrayOf(
    R.string.sample1_name,
    R.string.sample2_name,
    R.string.sample3_name,
    R.string.sample4_name,
    R.string.sample5_name,
    R.string.sample6_name,
    R.string.sample7_name,
    R.string.sample8_name,
    R.string.sample9_name,
    R.string.sample10_name
)

val introductionId = arrayOf(
    R.string.sample1_introduction,
    R.string.sample2_introduction,
    R.string.sample3_introduction,
    R.string.sample4_introduction,
    R.string.sample5_introduction,
    R.string.sample6_introduction,
    R.string.sample7_introduction,
    R.string.sample8_introduction,
    R.string.sample9_introduction,
    R.string.sample10_introduction
)

val addressId = arrayOf(
    R.string.address1,
    R.string.address2,
    R.string.address3,
    R.string.address4,
    R.string.address5,
    R.string.address6,
    R.string.address7,
    R.string.address8,
    R.string.address9,
    R.string.address10
)

val sellerId = arrayOf(
    R.string.seller1,
    R.string.seller2,
    R.string.seller3,
    R.string.seller4,
    R.string.seller5,
    R.string.seller6,
    R.string.seller7,
    R.string.seller8,
    R.string.seller9,
    R.string.seller10
)

val valueList = arrayOf(
    1000,
    20000,
    10000,
    10000,
    150000,
    50000,
    150000,
    180000,
    30000,
    190000
)

val likeList = arrayOf(
    13,
    8,
    23,
    14,
    22,
    25,
    142,
    31,
    7,
    40
)

val chatList = arrayOf(
    25,
    28,
    5,
    17,
    9,
    16,
    54,
    7,
    28,
    6
)

fun getData(): List<AppleItem>{
    return listOf(
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
}