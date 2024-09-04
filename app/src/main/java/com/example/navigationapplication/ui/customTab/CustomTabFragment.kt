package com.example.navigationapplication.ui.customTab

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

class CustomTabFragment : Fragment(R.layout.fragment_custom_tab) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("CustomTabFragment", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("CustomTabFragment", "onCreate")
    }

    //创建试图
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textView = TextView(context)
        textView.text = "CustomTabFragment"
        textView.gravity = Gravity.CENTER
        Log.e("CustomTabFragment", "onCreateView")
        return textView
    }

    //试图创建完成后，在这个阶段可以给试图设置数据
    //view:这个试图就是上面onCreateView返回的view
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tab = arguments?.getString("tab")
        val textView = view as TextView
        textView.text = java.lang.String("customFragment i am new data is $tab ----()")
    }

    /**
     * 隐藏和显示进行改变的时候回调这个方法
     * 当前fragment 可见的时候 false ft.show()
     * 当前fragment 不可见的时候 true ft.hide()
     */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e("CustomTabFragment", "onActivityCreated：${arguments?.getString("tab")} --> $hidden")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("CustomTabFragment", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.e("CustomTabFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("CustomTabFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("CustomTabFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("CustomTabFragment", "onStop")
    }

    //onCreateView 返回的对象被销毁的时候，会执行这个回调
    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("CustomTabFragment", "onDestroyView")
    }

    //是指fragment对象被销毁的时候，会回调
    override fun onDestroy() {
        super.onDestroy()
        Log.e("CustomTabFragment", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("CustomTabFragment", "onDetach")
    }
}