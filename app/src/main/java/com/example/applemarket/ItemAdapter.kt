package com.example.applemarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.MainRecyclerviewItemBinding

class ItemAdapter(
    private val onClick: (AppleItem) -> Unit, private val onLongClick: (AppleItem, Int) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    var itemList = listOf<AppleItem>()

    inner class ItemViewHolder(
        private val binding: MainRecyclerviewItemBinding,
        val onClick: (AppleItem) -> Unit,
        val onLongClick: (AppleItem, Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var currentItem: AppleItem? = null
        private var currentposition = -1

        init {
            itemView.setOnClickListener {
                currentItem?.let {
                    onClick(it)
                }
            }
            itemView.setOnLongClickListener {
                onLongClick(currentItem?:itemList[0], currentposition)
                true
            }

        }

        fun bind(item: AppleItem, position: Int) {
            currentItem = item
            currentposition = position
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
        return ItemViewHolder(MainRecyclerviewItemBinding.bind(view), onClick, onLongClick)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position], position)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}