package com.example.navigationapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.navigationapplication.R
import com.example.navigationapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //todo 列表布局
        //如果需要水平滑动：LinearLayoutManager.HORIZONTAL
        _binding?.recycleView?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        _binding?.recycleView?.adapter = MyAdapter();

        //todo 网格布局
        //2:表示网格布局有几列
        /*        recycle_view.layoutManager =GridLayoutManager(requireContext(),2)
                recycle_view.adapter = MyAdapter();*/

        //todo 瀑布流布局
        //2:表示瀑布流布局有几列
        //StaggeredGridLayoutManager.VERTICAL：垂直滑动
        /*        recycle_view.layoutManager =StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                recycle_view.adapter = MyAdapter();*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    inner class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

        //获取试图那整个的试图对象
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

            var itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_view_linear_vertical_demo, parent, false)
            return MyViewHolder(itemView)
        }

        //绑定试图对象数据（给控件设置资源）
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            //获取图片数据相关
            //方式一：
            /**
             * holder.itemView：获取当前试图对象
             * item_image：当前试图中图片控件的ID
             * setImageResource：设置图片资源
             */
            holder.itemView.findViewById<ImageView>(R.id.item_image)
                .setImageResource(R.drawable.icon_jetpack)
            /*//方式二：
            holder.itemView.item_image.setImageDrawable(
                ContextCompat.getDrawable(context!!, R.drawable.icon_jetpack)
            )
            //方式三：
            holder.itemView.item_image.setImageBitmap(
                BitmapFactory.decodeResource(
                    context!!.resources,
                    R.drawable.icon_jetpack
                )
            )*/
            //设置标题控件数据
            holder.itemView.findViewById<TextView>(R.id.item_title).text = "【$position】架构师课程"
            holder.itemView.findViewById<TextView>(R.id.item_message).text =
                "xxxxx,xxxxxx.kkkkk.xxxllkjsx.ksjkjflw.sjdlkfje"

        }

        override fun getItemCount(): Int {
            return 20;
        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}