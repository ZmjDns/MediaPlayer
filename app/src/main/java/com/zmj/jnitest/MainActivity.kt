package com.zmj.jnitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.zmj.sdk.util.StringUtil

class MainActivity : AppCompatActivity() {

    private lateinit var tvHell: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHell = findViewById(R.id.tv_hello)

        tvHell.text = StringUtil.ndkString()
    }
}
