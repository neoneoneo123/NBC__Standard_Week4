package com.example.nbc__standardtaskweek4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbc__standardtaskweek4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var data: List<Card>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        data = DataSource.getDataSource().getCardList()
        setView(data)
    }

    private fun setView(data: List<Card>) {
        val adapter = CardAdapter(data)
        binding.apply {
            rvItem.adapter = adapter
            rvItem.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        //번을을 이용하여 데이터 클래스 전달 및 액티비티 이동
        adapter.itemClick = object : CardAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                val bundle = Bundle().apply {
                    putParcelable("item", data[position])
                }
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}