package com.example.applemarket

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val itemAdapter by lazy { ItemAdapter { adapterOnClick(it) } }
    private val fadeOut = AlphaAnimation(1.0f, 0.0f).apply { duration = 100 }
    private val fadeIn = AlphaAnimation(0.0f, 1.0f).apply { duration = 100 }


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
        with(binding.mainItemRecyclerView) {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(divider)
            addOnScrollListener(onScrollListener)
        }

        binding.mainAlarmImageView.setOnClickListener {
            makeNotification(this)
        }

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        binding.goTopFloating.apply{
            visibility = View.GONE
            setOnClickListener { goTop() }
        }
    }


    private fun adapterOnClick(appleItem: AppleItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("data", appleItem)
        startActivity(intent)
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val dialog = AlertDialog.Builder(this@MainActivity)

            dialog.apply {
                setMessage("종료하시겠습니까?")
                setPositiveButton("예") { _, _ ->
                    finish()
                }
                setNegativeButton("아니오") { a, _ ->
                    a.dismiss()
                }
            }
            dialog.show()
        }
    }

    private fun makeNotification(context: Context) {
        val notification = Notification(context)
        val notificationPermission = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.POST_NOTIFICATIONS
        )
        if (notificationPermission == PackageManager.PERMISSION_GRANTED) {
            notification.deliverNotification()
        } else {
            Toast.makeText(context, "알림 권한을 설정해주세요", Toast.LENGTH_SHORT).show()
        }
    }

    private val onScrollListener = object : RecyclerView.OnScrollListener() {
        private var isTop = true
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (!binding.mainItemRecyclerView.canScrollVertically(-1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                if (!isTop) {
                    binding.goTopFloating.apply {
                        startAnimation(fadeOut)
                        visibility = View.GONE
                        isTop = true
                    }
                }
            } else {
                if (isTop) {
                    binding.goTopFloating.apply {
                        visibility = View.VISIBLE
                        startAnimation(fadeIn)
                        isTop = false
                    }
                }
            }
        }
    }

    private fun goTop() {
        binding.mainItemRecyclerView.smoothScrollToPosition(0)
    }
}

