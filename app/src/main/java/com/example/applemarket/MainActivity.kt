package com.example.applemarket

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applemarket.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val itemAdapter by lazy {
        ItemAdapter { appleItem ->
            adapterOnClick(appleItem)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val itemData = ItemData.getInstance()
        val divider = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        itemAdapter.itemList = itemData.items
        with(binding.mainItemRecyclerView){
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(divider)
        }
    }

    private fun adapterOnClick(appleItem: AppleItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("data", appleItem)
        startActivity(intent)
    }
}

