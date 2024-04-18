package com.example.nbc__standardtaskweek4.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nbc__standardtaskweek4.R
import com.example.nbc__standardtaskweek4.data.Card
import com.example.nbc__standardtaskweek4.data.DataSource
import com.example.nbc__standardtaskweek4.databinding.ActivityDetailBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val format = DecimalFormat("$#,##0.00")
    private val cardsViewModel by viewModels<CardViewModel> {
        CardViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //데이터 받아오기
        val item = intent.getParcelableExtra<Card>("item")
//        val cardData = DataSource.getDataSource().getCardForName(item!!.userMame)
        val cardData = cardsViewModel.getCardForName(item!!.userMame)

        binding.apply {
            detailName.text = "이름 : ${cardData?.userMame}"
            detailCardNum.text = "카드 번호 : ${cardData?.cardNumber}"
            detailPeiod.text = "유효기간 : ${cardData?.period}"
            detailBalance.text = "잔액 : ${format.format(cardData?.balance)}"
        }

    }
}