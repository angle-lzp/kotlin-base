package com.example.navigationapplication

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewpager2.widget.ViewPager2.Orientation
import com.example.navigationapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var imageView: ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        /**
         * 1.LifeCycle的使用MVVC--后续讲解
         */
        /*lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate() {

            }

        })
        lifecycle.addObserver(object:LifecycleEventObserver{
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                TODO("Not yet implemented")
            }
        })
*/
        /*binding =  .inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_study,
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/

        /**
         * get请求
         */
//        HiOkHttp.getSync("https://www.baidu.com")
        /**
         * post请求：http://boot3.jeecg.com/jeecgboot/sys/login
         */
//        HiOkHttp.postSync("http://boot3.jeecg.com/jeecgboot/sys/login")


        /**
         * 1.Activity跳转和启动：下面这种是--显示启动
         *  A Activity(带数据) --> B Activity
         */
                /*var textView = TextView(this)
                textView.text = "MainActivity"
                textView.gravity = Gravity.CENTER
                //设置这个Activity上面的内容
                setContentView(textView)
               //点击之后跳转到第二个Activity
                textView.setOnClickListener {
                    //设置跳转的Activity从哪里跳到哪里
                    val intent = Intent(MainActivity@this, SecondActivity::class.java)
                    //在跳转的时候携带上参数
                    intent.putExtra("userName","angelo")
                    intent.putExtra("password",10086)
                    startActivity(intent)
                }*/

        /**
         * 2.Activity跳转和启动：下面这种是--显示启动
         *  A Activity(带数据) --> B Activity(带数据) --> A Activity(获取B中的数据)
         */
        /*var textView = TextView(this)
        textView.text = "MainActivity"
        textView.gravity = Gravity.CENTER
        //设置这个Activity上面的内容
        setContentView(textView)
        //点击之后跳转到第二个Activity
        textView.setOnClickListener {
            //设置跳转的Activity从哪里跳到哪里
            val intent = Intent(MainActivity@ this, SecondActivity::class.java)
            //在跳转的时候携带上参数
            intent.putExtra("userName","angelo")
            intent.putExtra("password",10086)
            //从后一个activity再跳回来获取结果，forresult看方法名称就知道
            startActivityForResult(intent,1000)
        }*/

        /**
         * 3.Activity跳转和启动：下面是--隐式跳转
         */
        /*var textView = TextView(this)
        textView.text = "MainActivity"
        textView.gravity = Gravity.CENTER
        //设置这个Activity上面的内容
        setContentView(textView)
        //点击之后跳转到第二个Activity
        textView.setOnClickListener {
            //设置跳转的Activity从哪里跳到哪里：进行一个隐式跳转
            val intent = Intent()
            intent.action = "com.example.action.SECONDACTIVITY"//和AndroidManifest.xml中的配置一致
            intent.addCategory("com.example.action.SECONDACTIVITY")//和AndroidManifest.xml中的配置一致
            //在跳转的时候携带上参数
            intent.putExtra("userName","angelo")
            intent.putExtra("password",10086)
            //从后一个activity再跳回来获取结果，forresult看方法名称就知道
            startActivityForResult(intent,1000)
        }*/

        /**
         * 4.系统常见Activity
         */
        var textView = TextView(this)
        textView.text = "MainActivity"
        textView.gravity = Gravity.CENTER
        //再新建一个ImageView
        imageView = ImageView(this)
        imageView.setImageResource(R.drawable.icon_course)
        //设置这个Activity上面的内容
        setContentView(imageView)
        setContentView(textView)
        //点击之后跳转到第二个Activity
        textView.setOnClickListener {
            //todo 打电话
            /*val uri: Uri = Uri.parse("tel:10086")
                     val intent: Intent = Intent(Intent.ACTION_DIAL, uri)
                     startActivity(intent)*/
            //todo 发短信
            /*val uri = Uri.parse("smsto:10086")
            var intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body","hello")
            startActivity(intent)*/
            //todo 打开摄像头拍照(在Activity的onActivityResult方法回调中取出照片数据)
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 0)
        }
        Log.e("MainActivity：", "onCreate")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 1000 && resultCode == Activity.RESULT_OK) {
//            Log.e(
//                "MainActivity：",
//                "${data?.getStringExtra("other")},other is ${data?.getStringExtra("userName")}"
//            )
//        }
        //照片展示问题？？？
        val imageBitmap = intent.extras?.get("data") as Bitmap
        imageView.setImageBitmap(imageBitmap)
        imageView.visibility = View.VISIBLE
    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity：", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity：", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity：", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity：", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity：", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity：", "onDestroy")
    }
}

