package com.example.localizeyourapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set data to the listView using arrayAdapter.
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,resources.getStringArray(R.array.languages))
        list.adapter = arrayAdapter

        list.setOnItemClickListener { adapterView, view, i, l ->
            when(i){
                //change app language depending on user interaction with listView
                0-> setLocale("te")
                1->setLocale("hi")
                2->setLocale("ta")
                3->setLocale("ml")
                4->setLocale("kn")
                else -> setLocale("en")
            }
        }
    }

    fun setLocale(lan : String){
        val locale = Locale(lan)
        val resources = resources
        //displayMetrics -> describe information about a display such as its size,density and font scaling.
        val displayMetrics = resources.displayMetrics
        //configuration -> describe all device configuration information that can impact resource the application retrieves.
        val configuration = resources.configuration
        //change the locale to locale we want
        configuration.locale = locale
        //update configuration
        resources.updateConfiguration(configuration,displayMetrics)
        val refresh = Intent(this,MainActivity::class.java)
        startActivity(refresh)
    }
}