package com.example.myblocnoteinkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    var listTitre = ArrayList<String>()
    var listNote = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //affichage de mon layout
        setContentView(R.layout.activity_accueil)

        //récupération de la liste
        val intent = getIntent()
        val titre = intent.getStringExtra("titre")
        val note = intent.getStringExtra("note")
        val listCacheTitre = intent.getStringArrayListExtra("listTitre")
        val listCacheNote = intent.getStringArrayListExtra("listNote")
        if (listCacheTitre != null && listCacheNote != null) {
            listTitre.addAll(listCacheTitre)
            listNote.addAll(listCacheNote)
        }

        //si on ajoute une note, on ajoute à la liste
        if (!titre.isNullOrBlank() && !note.isNullOrBlank()) {
            listTitre.add(titre.toString())
            listNote.add(note.toString())
        }

        //initialisation de ma liste
        var simpleList = findViewById<View>(R.id.simpleListView) as ListView
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.item_list, R.id.textView, listTitre)
        simpleList.setAdapter(arrayAdapter)

        //initialisation de mon bouton ajout de note
        val btnAddNote = findViewById<Button>(R.id.BtnAddNote)
        btnAddNote.setOnClickListener {
            val intent = Intent(this, add_note::class.java)
            val stringListTitre = listTitre.map { it.toString() }.toMutableList()
            val stringListNote = listNote.map { it.toString() }.toMutableList()

            intent.putStringArrayListExtra("listTitre", ArrayList(stringListTitre))
            intent.putStringArrayListExtra("listNote", ArrayList(stringListNote))
            startActivity(intent)
        }


        //clique pour la modification d'une note
        simpleList.setOnItemClickListener { _, _, position, _ ->
            val selectedIemTitre = listTitre[position]
            val selectedIemNote = listNote[position]
            val intent = Intent(this, edit_note::class.java)

            intent.putExtra("titre", selectedIemTitre.toString())
            intent.putExtra("note", selectedIemNote.toString())
            listTitre.removeAt(position)
            listNote.removeAt(position)
            intent.putStringArrayListExtra("listTitre", ArrayList(listTitre))
            intent.putStringArrayListExtra("listNote", ArrayList(listNote))

            startActivity(intent)
        }

        //suppression d'un élément lors d'un long click
        simpleList.setOnItemLongClickListener { parent, view, position, id ->
            listTitre.removeAt(position)
            listNote.removeAt(position)
            arrayAdapter.notifyDataSetChanged()
            true
        }
    }
}

