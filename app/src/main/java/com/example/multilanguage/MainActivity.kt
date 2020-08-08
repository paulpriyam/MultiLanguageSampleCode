package com.example.multilanguage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  lateinit var myPreference: MyPreference
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    welcome.setOnClickListener {
      startActivity(Intent(this,SettingsActivity::class.java))
    }
  }

  override fun attachBaseContext(newBase: Context?) {
    myPreference= MyPreference(newBase!!)
    val lang=myPreference.getPreferenceLanguage()
    super.attachBaseContext(MyContextWrapper.wrap(newBase,lang))
  }
}