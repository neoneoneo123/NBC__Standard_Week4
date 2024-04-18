package com.example.nbc__standardtaskweek4.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc__standardtaskweek4.data.Card
import com.example.nbc__standardtaskweek4.databinding.ItemBlueBinding
import com.example.nbc__standardtaskweek4.databinding.ItemOrangeBinding
import com.example.nbc__standardtaskweek4.databinding.ItemSkyBinding
import java.lang.IllegalArgumentException
import java.text.DecimalFormat

class CardAdapter(private val cards: List<Card>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemClick: ItemClick? = null
    private val format = DecimalFormat("$#,##0.00")

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MultiViewEnum.BLUE.viewType -> {
                val binding =
                    ItemBlueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BlueViewHolder(binding)
            }

            MultiViewEnum.SKY.viewType -> {
                val binding =
                    ItemSkyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SkyViewHolder(binding)
            }

            MultiViewEnum.ORANGE.viewType -> {
                val binding =
                    ItemOrangeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                OrangeViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = cards.size

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> MultiViewEnum.BLUE.viewType
            1 -> MultiViewEnum.SKY.viewType
            2 -> MultiViewEnum.ORANGE.viewType
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = cards[position]
        when (holder.itemViewType) {
            MultiViewEnum.BLUE.viewType -> {
                val blueHolder = holder as BlueViewHolder
                blueHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it, position)
                }
            }

            MultiViewEnum.SKY.viewType -> {
                val skyHolder = holder as SkyViewHolder
                skyHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it, position)
                }
            }

            MultiViewEnum.ORANGE.viewType -> {
                val orangeViewHolder = holder as OrangeViewHolder
                orangeViewHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it, position)
                }
            }
        }
    }

    inner class BlueViewHolder(private val binding: ItemBlueBinding) : RecyclerView.ViewHolder(binding.root) {
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

    inner class SkyViewHolder(private val binding: ItemSkyBinding) :
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

    inner class OrangeViewHolder(private val binding: ItemOrangeBinding) :
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