package com.example.navigationapplication.ui.study

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.navigationapplication.R
import com.example.navigationapplication.databinding.FragmentStudyBinding

class StudyFragment : Fragment(R.layout.fragment_study) {

    private var _binding: FragmentStudyBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //提取出Adapter对象
        var myAdapter = MyAdapter()
        //列表布局
        _binding?.recycleView?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        _binding?.recycleView?.adapter = myAdapter;
        val defaultCourseList = myAdapter.getDefaultData()
        myAdapter.setData(defaultCourseList)

        //点击事件
        _binding?.itemAdd?.setOnClickListener {
            //行新增第一个
            val course = Course(
                "收费课程",
                R.drawable.icon_course,
                "90",
                "JavaWeb全栈开发"
            )
            myAdapter.addData(course)
        }

        _binding?.itemUpdate?.setOnClickListener {
            myAdapter.updateDataById(0)
        }

        _binding?.itemDelete?.setOnClickListener {
            myAdapter.deleteDataById(0)
        }
    }

    inner class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
        //创建一个接收数据方法
        private var courseList = mutableListOf<Course>()

        @SuppressLint("NotifyDataSetChanged")
        fun setData(datas: MutableList<Course>): Unit {
            if (datas.isNotEmpty()) {
                courseList.addAll(datas)
                //设置数据的更改
                notifyDataSetChanged()
            }
        }

        //新增
        @SuppressLint("NotifyDataSetChanged")//就是为了去除提示，没什么用
        fun addData(course: Course) {
            courseList.add(0, course)
            //notifyDataSetChanged()方法不能少，不然不会刷新数据
            notifyDataSetChanged()
        }

        //修改
        @SuppressLint("NotifyDataSetChanged")//就是为了去除提示
        fun updateDataById(position: Int) {
            val course = courseList[position]
            course.title = "Angelo大师JavaWeb课程"
            //notifyDataSetChanged()方法不能少，不然不会刷新数据
            notifyDataSetChanged()
        }

        //删除
        @SuppressLint("NotifyDataSetChanged")//就是为了去除提示
        fun deleteDataById(position: Int) {
            var course = courseList.removeAt(position)
            //notifyDataSetChanged()方法不能少，不然不会刷新数据

            notifyDataSetChanged()
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            //获取我们的那个模板试图对象
            var view =
                LayoutInflater.from(context).inflate(R.layout.item_fragment_study, parent, false);
            return MyViewHolder(view);
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val course = courseList[position]
            //给这个试图对象添加属性
            holder.itemView.findViewById<ImageView>(R.id.cour_image)
                .setImageResource(course.poster)
            holder.itemView.findViewById<TextView>(R.id.cour_title).text = course.title
            holder.itemView.findViewById<TextView>(R.id.cour_desc).text = course.label
            holder.itemView.findViewById<TextView>(R.id.cour_process).text =
                "完成${course.progress}%"
        }

        override fun getItemCount(): Int {
            return courseList.size;
        }

        fun getDefaultData(): MutableList<Course> {
            var datas = mutableListOf<Course>()
            for (i in 1..20) {
                datas.add(
                    Course(
                        "免费课程",
                        R.drawable.icon_course,
                        ((i / 20f) * 100).toInt().toString(),
                        "[$i]Android的课程"
                    )
                )
            }
            return datas
        }

    }

    class MyViewHolder(view: View) : ViewHolder(view) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

data class Course(
    var label: String,
    var poster: Int,
    var progress: String,
    var title: String
)