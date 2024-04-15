package com.example.nbc__standardtaskweek4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nbc__standardtaskweek4.databinding.ActivityDetailBinding
import com.example.nbc__standardtaskweek4.databinding.ActivityMainBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val format = DecimalFormat("$#,##0.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //데이터 받아오기
        val item = intent.getParcelableExtra<Card>("item")

        binding.apply {
            detailName.text = "이름 : ${item!!.userMame}"
            detailCardNum.text = "카드 번호 : ${item.cardNumber}"
            detailPeiod.text = "유효기간 : ${item.period}"
            detailBalance.text = "잔액 : ${format.format(item.balance)}"
        }

    }
}