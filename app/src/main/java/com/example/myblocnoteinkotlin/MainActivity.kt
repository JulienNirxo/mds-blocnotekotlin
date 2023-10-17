package com.example.myblocnoteinkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    var list = ArrayList<Any>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //affichage de mon layout
        setContentView(R.layout.activity_accueil)

        //récupération de la liste
        val intent = getIntent()
        val titre = intent.getStringExtra("titre")
        val note = intent.getStringExtra("note")
        val listCache = intent.getStringArrayListExtra("list")
        if (listCache != null) {
            list.addAll(listCache)
        }

        //si on ajoute une note, on ajoute à la liste
        if(titre.toString() != "" || titre.toString() != null){
            list.add(arrayListOf(titre.toString(), note.toString()))
        }


        //initialisation de ma liste
        var simpleList = findViewById<View>(R.id.simpleListView) as ListView
        val arrayAdapter: ArrayAdapter<Any> = ArrayAdapter<Any>(this, R.layout.item_list, R.id.textView, list)
        simpleList.setAdapter(arrayAdapter)

        //initialisation de mon bouton ajout de note
        val btnAddNote = findViewById<Button>(R.id.BtnAddNote)
        btnAddNote.setOnClickListener {
            val intent = Intent(this, add_note::class.java)
            val stringList = list.map { it.toString() }.toMutableList()
            intent.putStringArrayListExtra("list", ArrayList(stringList))
            startActivity(intent)
        }
    }
}

