package com.example.multilanguage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    lateinit var myPreference: MyPreference
    lateinit var context:Context
    private val languageList = arrayOf("en","ta","hi","fr")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        context=this
        myPreference= MyPreference(this)
        spinner.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,languageList)

        val lang=myPreference.getPreferenceLanguage()
        val index=languageList.indexOf(lang)
        if(index>=0){
            spinner.setSelection(index)
        }

        button.setOnClickListener {
            myPreference.setPreferenceLanguage(languageList[spinner.selectedItemPosition])
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }


}