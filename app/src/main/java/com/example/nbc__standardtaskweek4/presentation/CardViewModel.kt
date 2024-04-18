package com.example.nbc__standardtaskweek4.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nbc__standardtaskweek4.data.Card
import com.example.nbc__standardtaskweek4.data.DataSource

class CardViewModel(val dataSource : DataSource) : ViewModel() {

    var cardLiveData = dataSource.getCardList()

    fun getCardForName(name: String) : Card? {
        val card = dataSource.getCardList()
        return card?.firstOrNull { it.userMame == name }
    }

}

class CardViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardViewModel::class.java)) {
            return CardViewModel(dataSource = DataSource.getDataSource()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
