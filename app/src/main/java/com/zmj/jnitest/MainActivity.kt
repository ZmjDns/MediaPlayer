package com.zmj.jnitest

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zmj.jnitest.threadpool.ThreadPoolTester
import com.zmj.sdk.util.StringUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private lateinit var tvHell: TextView
    private lateinit var btnThread: Button
    private lateinit var progress: Button
    private var progressInt: Int = 0;

    private val handler: Handler? = object : Handler() {
        override fun handleMessage(msg: Message) {
            when(msg.what){
                1 -> {
                    if (progressInt < 100){
                        progressInt += 10
                        pb_bar.setProgress(progressInt)
                        timer()
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHell = findViewById(R.id.tv_hello)
        btnThread = findViewById(R.id.btn_threadPool)
        progress = findViewById(R.id.btn_progress)

        tvHell.text = StringUtil.ndkString()



        btnThread.setOnClickListener {
            val threadPool = ThreadPoolTester()

            //threadPool.cacheThreadPool()
            //threadPool.fixedThreadPool()
            //threadPool.singleThreadPool()
            //threadPool.scheduleThreadPool()
        }

        progress.setOnClickListener {
            pb_bar.visibility = View.VISIBLE

            timer()
        }

        btn_jump.setOnClickListener {
            startActivity(Intent(this,SecondAct::class.java))

            //https://www.jianshu.com/p/b78a38c857e8  Android10.0 activity的启动

        }


    }

    fun timer(){
        if (handler != null){
            handler?.sendEmptyMessageDelayed(1,2000)



        }
    }
}
