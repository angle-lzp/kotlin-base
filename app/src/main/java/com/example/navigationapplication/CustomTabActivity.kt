package com.example.navigationapplication

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationapplication.databinding.ActivityCustomTabBinding
import com.example.navigationapplication.ui.customTab.CustomTabFragment
import com.google.android.material.button.MaterialButton

/**
 * author: Angelo.Luo
 * date : 01/12/2024 5:09 PM
 * description:tab页的设置，不同的tab页显示不同的fragment
 */
class CustomTabActivity : AppCompatActivity() {

    //Jinx
    private lateinit var binding: ActivityCustomTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * 设置内容布局:如果使用了
         * 如果使用了：binding = ActivityCustomTabBinding.inflate(layoutInflater)，需要用到binding里面的组件
         * 那么就得这样设置setContentView(binding.root)
         * 使用setContentView(R.layout.activity_custom_tab)是不可行的
         */
        //setContentView(R.layout.activity_custom_tab)
        //布局绑定
        binding = ActivityCustomTabBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //group：这个按钮组；checkedId：被点击的按钮ID；isChecked：当前是否选中MaterialButton

        binding.toggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            val childCount = group.childCount
            var selectIndex = 0
            //0 <= until < childCount
            //循环遍历每个按钮，看看是哪个被点击了
            for (index in 0 until childCount) {
                //获取当个按钮
                val childAt = group.getChildAt(index) as MaterialButton
                //判断当前被点击的是否是当前的按钮
                if (childAt.id == checkedId) {
                    selectIndex = index
                    childAt.setTextColor(Color.BLUE)
                    childAt.iconTint = ColorStateList.valueOf(Color.BLUE)
                } else {
                    childAt.setTextColor(Color.BLACK)
                    childAt.iconTint = ColorStateList.valueOf(Color.BLACK)
                }
            }
            switchFragment(selectIndex)
        }
        //默认选择第一个
        binding.toggleGroup.check(R.id.tab1)
        Log.e("CustomTabActivity", "onCreate")
    }

    private var tab1Fragment = CustomTabFragment()
    private var tab2Fragment = CustomTabFragment()
    private var tab3Fragment = CustomTabFragment()
    private var primaryFragment: CustomTabFragment? = null

    //对对应的tab对应的fragment进行设置
    private fun switchFragment(selectIndex: Int) {
        val fragment = when (selectIndex) {
            0 -> {
                val bundle = Bundle()
                bundle.putString("tab", "first tab")
                tab1Fragment.arguments = bundle
                tab1Fragment
            }

            1 -> {
                val bundle = Bundle()
                bundle.putString("tab", "second tab")
                tab2Fragment.arguments = bundle
                tab2Fragment
            }

            2 -> {
                val bundle = Bundle()
                bundle.putString("tab", "third tab")
                tab3Fragment.arguments = bundle
                tab3Fragment
            }

            else -> {
                throw IllegalStateException("没有存在的fragment")
            }
        }

        val ft = supportFragmentManager.beginTransaction()

        fragment.let {
            if (!it.isAdded) {
                ft.add(R.id.container, fragment)
            }
            if (primaryFragment != null) {
                ft.hide(primaryFragment!!)
            }
            ft.show(fragment)
            primaryFragment = fragment
            ft.commitNowAllowingStateLoss()
        }
    }
}