package com.example.myblocnoteinkotlin

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    var list = arrayOf("India", "China", "australia", "Portugle", "America", "NewZealand")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //affichage de mon layout
        setContentView(R.layout.activity_accueil)

        //initialisation de ma liste
        var simpleList = findViewById<View>(R.id.simpleListView) as ListView
        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, R.layout.item_list, R.id.textView, list)
        simpleList.setAdapter(arrayAdapter)
    }
}

