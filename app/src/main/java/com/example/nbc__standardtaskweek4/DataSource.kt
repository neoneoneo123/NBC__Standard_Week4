package com.example.nbc__standardtaskweek4

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

class DataSource {
    companion object {
        private var INSTANCE: DataSource? = null
        @OptIn(InternalCoroutinesApi::class)
        fun getDataSource(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    fun getCardList() : List<Card> {
        return cardList()
    }
}