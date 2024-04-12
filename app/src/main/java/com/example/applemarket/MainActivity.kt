package com.example.applemarket

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ReportFragment.Companion.reportFragment
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
    private lateinit var notification: Notification
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
        notification = Notification(this)

        itemAdapter.itemList = itemData.items
        with(binding.mainItemRecyclerView){
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(divider)
        }

        binding.mainAlarmImageView.setOnClickListener {
/*            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // 권한 체크용
                val notiPermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                if (notiPermission == PackageManager.PERMISSION_GRANTED){
                    notification.deliverNotification()
                }
            }*/
            notification.deliverNotification()

        }

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

    }


    private fun adapterOnClick(appleItem: AppleItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("data", appleItem)
        startActivity(intent)
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val dialog = AlertDialog.Builder(this@MainActivity)

            dialog.apply{
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
}

