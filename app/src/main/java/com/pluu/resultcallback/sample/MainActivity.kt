package com.pluu.resultcallback.sample

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.pluu.resultcallback.sample.databinding.ActivityMainBinding
import com.pluu.utils.loggerTag
import logcat.logcat

class MainActivity : AppCompatActivity() {

    private val launcher = registerForActivityResult(StartActivityForResult()) {
        logcat(loggerTag) { "[MainActivity] ActivityResultCallback" }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMove.setOnClickListener {
            launcher.launch(Intent(this, SubActivity::class.java))
        }
    }

    override fun onRestart() {
        super.onRestart()
        logcat(loggerTag) { "[MainActivity] onRestart" }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        logcat(loggerTag) { "[MainActivity] onActivityResult" }
    }
}