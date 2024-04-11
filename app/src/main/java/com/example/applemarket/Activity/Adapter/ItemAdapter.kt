package com.example.applemarket.Activity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.Data.DECIMAL
import com.example.applemarket.DataClass.AppleItem
import com.example.applemarket.R
import com.example.applemarket.databinding.MainRecyclerviewItemBinding

class ItemAdapter(private val itemData: List<AppleItem>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: MainRecyclerviewItemBinding): RecyclerView.ViewHolder(binding.root){
        private val item: AppleItem? = null

        fun bind(item: AppleItem){
            with(binding){
                val valueString = DECIMAL.format(item.iItemInfo.iValue) + "원"
                itemImageView.setImageResource(item.iItemInfo.iImageID)
                itemAddressTextView.setText(item.iSeller.sAddressId)
                itemNameTextView.setText(item.iItemInfo.iNameId)
                itemValueTextView.text = valueString
                itemLikeTextView.text = item.iLike.toString()
                itemChatTextView.text = item.iComment.toString()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_recyclerview_item, parent ,false)
        return ItemViewHolder(MainRecyclerviewItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemData[position])
    }

    override fun getItemCount(): Int {
        return itemData.size
    }


}