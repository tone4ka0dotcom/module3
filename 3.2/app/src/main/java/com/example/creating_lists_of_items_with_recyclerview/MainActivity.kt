package com.example.creating_lists_of_items_with_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.creating_lists_of_items_with_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(fillList())

        pressedButtonName()
        pressedButtonPhone()
        pressedButtonSex()
    }

    private fun fillList(): List<Person> {
        val data = mutableListOf<Person>()
        data.apply{
            add(Person("male","Misha","1234896"))
            add(Person("male","Maks","624358"))
            add(Person("male","Alex","12345"))
            add(Person("male","Danya","363973"))
            add(Person("male","Vasiliy","557956"))
            add(Person("male","Ivan","103159"))
            add(Person("female","Maria","0131"))
            add(Person("female","Natasha","1244"))
            add(Person("female","Ramila","594566"))
            add(Person("female","Nastya","13852"))
            add(Person("female","Irina","632789"))
            add(Person("male","Dima","345200"))
            add(Person("female","Alina","120356"))
            add(Person("male","Oleg","012"))
            add(Person("female","Katya","1234"))
        }
        Log.d("ggs",data.toString())
        return data
    }

    private fun pressedButtonName(){
        binding.btnName.setOnClickListener {
            sortedBy(fillList(),1)
        }
    }

    private fun pressedButtonPhone(){
        binding.btnPhone.setOnClickListener {
            sortedBy(fillList(),2)
        }
    }

    private fun pressedButtonSex(){
        binding.btnSex.setOnClickListener {
            sortedBy(fillList(),3)
        }
    }

    private fun sortedBy(arList: List<Person>, sortBy: Int){
        when (sortBy) {
            1 -> {
                recyclerView.adapter = CustomAdapter(arList.sortedBy { it.name })
            }
            2 -> {
                recyclerView.adapter = CustomAdapter(arList.sortedBy { it.phoneNumber })
            }
            else -> {
                recyclerView.adapter = CustomAdapter(arList.sortedBy { it.sex })
            }
        }
    }
}