package com.example.applemarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.MainRecyclerviewItemBinding

class ItemAdapter(private val onClick: (AppleItem) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    var itemList = listOf<AppleItem>()

    inner class ItemViewHolder(
        private val binding: MainRecyclerviewItemBinding,
        val onClick: (AppleItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var currentItem: AppleItem? = null

        init {
            itemView.setOnClickListener {
                currentItem?.let {
                    onClick(it)
                }
            }
        }

        fun bind(item: AppleItem) {
            currentItem = item
            val valueString = decimal.format(item.iItemInfo.iValue) + "원"
            binding.itemImageView.setImageResource(item.iItemInfo.iImageID)
            binding.itemAddressTextView.setText(item.iSeller.sAddressId)
            binding.itemNameTextView.setText(item.iItemInfo.iNameId)
            binding.itemValueTextView.text = valueString
            binding.itemLikeTextView.text = item.iLike.toString()
            binding.itemChatTextView.text = item.iComment.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_recyclerview_item, parent, false)
        return ItemViewHolder(MainRecyclerviewItemBinding.bind(view), onClick)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}