package com.example.applemarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.MainRecyclerviewItemBinding

class ItemAdapter(
    private val onClick: (AppleItem, Int) -> Unit, private val onLongClick: (AppleItem, Int) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private val itemData = ItemData.getInstance()
    val itemList = itemData.items

    inner class ItemViewHolder(
        private val binding: MainRecyclerviewItemBinding,
        val onClick: (AppleItem, Int) -> Unit,
        val onLongClick: (AppleItem, Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var currentItem: AppleItem? = null
        private var currentPosition = -1

        init {
            itemView.setOnClickListener {
                onClick(currentItem ?: itemList[0], currentPosition)
            }
            itemView.setOnLongClickListener {
                onLongClick(currentItem ?: itemList[0], currentPosition)
                true
            }

        }

        fun bind(item: AppleItem, position: Int) {
            currentItem = item
            currentPosition = position
            binding.itemImageView.setImageResource(item.iItemInfo.iImageID)
            binding.itemAddressTextView.setText(item.iSeller.sAddressId)
            binding.itemNameTextView.setText(item.iItemInfo.iNameId)
            binding.itemValueTextView.setWonText(item.iItemInfo.iValue)
            binding.itemLikeTextView.text = item.iLike.toString()
            binding.itemChatTextView.text = item.iComment.toString()
            binding.itemLikeImageView.apply {
                switchHeart(currentItem?.isLike ?: false)
                setOnClickListener {
                    itemData.switchLike(currentPosition)
                    currentItem?.isLike?.let {
                        switchHeart(it)
                    }
                    this@ItemAdapter.notifyItemChanged(currentPosition)
                    showSnackBar(this, currentItem?.isLike ?: false)
                }
            }

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