package com.example.navigationapplication.ui.third

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.navigationapplication.R

/**
 * author: Angelo.Luo
 * date : 01/12/2024 5:21 PM
 * description:
 */

class ThirdFragment : Fragment(R.layout.fragment_third) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("ThirdFragment", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("ThirdFragment", "onCreate")
    }

    //创建试图
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textView = TextView(context)
        textView.text = "ThirdFragment"
        textView.gravity = Gravity.CENTER
        Log.e("ThirdFragment", "onCreateView")
        return textView
    }

    //试图创建完成后，在这个阶段可以给试图设置数据
    //view:这个试图就是上面onCreateView返回的view
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val age = arguments?.getInt("age")
        val userName = arguments?.getString("userName")
        val textView = view as TextView
        textView.text = java.lang.String("i am new data is $age, and $userName ----()")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("ThirdFragment", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.e("ThirdFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("ThirdFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("ThirdFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("ThirdFragment", "onStop")
    }

    //onCreateView 返回的对象被销毁的时候，会执行这个回调
    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("ThirdFragment", "onDestroyView")
    }

    //是指fragment对象被销毁的时候，会回调
    override fun onDestroy() {
        super.onDestroy()
        Log.e("ThirdFragment", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("ThirdFragment", "onDetach")
    }
}