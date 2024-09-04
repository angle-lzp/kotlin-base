package com.example.navigationapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * author: Angelo.Luo
 * date : 01/22/2024 9:50 AM
 * description:
 */
class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)

        val listView = findViewById<ListView>(R.id.lv)
        val data: MutableList<String> = mutableListOf()
        for (i in 0 until 20) {
            data.add("angelo $i")
        }
        listView.adapter = MyAdapter(data, this)
    }
}

class MyAdapter() : BaseAdapter() {

    private lateinit var data: List<String>
    private lateinit var context: Context

    init {
        Log.e("MyAdapter", "主构造器初始化")
    }

    constructor(data: List<String>, context: Context) : this() {
        this.data = data
        this.context = context
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return null!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val convertViewNew =
            LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false) as View
        var textView = convertViewNew.findViewById<TextView>(R.id.lt)
        textView.text = data[position]
        Log.e("MyAdapter", position.toString())
        return convertView ?: convertViewNew
    }
}