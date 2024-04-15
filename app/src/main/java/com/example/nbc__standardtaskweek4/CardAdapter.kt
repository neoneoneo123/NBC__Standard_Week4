package com.example.nbc__standardtaskweek4

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc__standardtaskweek4.databinding.ItemType1Binding
import com.example.nbc__standardtaskweek4.databinding.ItemType2Binding
import com.example.nbc__standardtaskweek4.databinding.ItemType3Binding
import java.lang.IllegalArgumentException
import java.text.DecimalFormat

class CardAdapter(private val cards: List<Card>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemClick: ItemClick? = null
    private val ITEM_TYPE_ONE = 1
    private val ITEM_TYPE_TWO = 2
    private val ITEM_TYPE_THREE = 3
    private val format = DecimalFormat("$#,##0.00")

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_TYPE_ONE -> {
                val binding =
                    ItemType1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                TypeOneViewHolder(binding)
            }

            ITEM_TYPE_TWO -> {
                val binding =
                    ItemType2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                TypeTwoViewHolder(binding)
            }

            ITEM_TYPE_THREE -> {
                val binding =
                    ItemType3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                TypeThreeViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = cards.size

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ITEM_TYPE_ONE
            1 -> ITEM_TYPE_TWO
            2 -> ITEM_TYPE_THREE
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = cards[position]
        when (holder.itemViewType) {
            ITEM_TYPE_ONE -> {
                val typeOneHolder = holder as TypeOneViewHolder
                typeOneHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it, position)
                }
            }

            ITEM_TYPE_TWO -> {
                val typeTwoHolder = holder as TypeTwoViewHolder
                typeTwoHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it, position)
                }
            }

            ITEM_TYPE_THREE -> {
                val typeThreeViewHolder = holder as TypeThreeViewHolder
                typeThreeViewHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it, position)
                }
            }
        }
    }

    inner class TypeOneViewHolder(private val binding: ItemType1Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                tvUserName.text = card.userMame
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = format.format(card.balance)
                tvCardManager.text = card.cardManager
            }
        }
    }

    inner class TypeTwoViewHolder(private val binding: ItemType2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                tvUserName.text = card.userMame
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = format.format(card.balance)
                tvCardManager.text = card.cardManager
            }
        }
    }

    inner class TypeThreeViewHolder(private val binding: ItemType3Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                tvUserName.text = card.userMame
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = format.format(card.balance)
                tvCardManager.text = card.cardManager
            }
        }
    }
}