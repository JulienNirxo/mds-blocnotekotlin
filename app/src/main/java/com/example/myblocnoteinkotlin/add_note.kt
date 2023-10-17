package com.example.myblocnoteinkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class add_note : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        //initialisation des composants
        val btnAddNote = findViewById<Button>(R.id.btnAdd)
        val EditTextTitre = findViewById<EditText>(R.id.EditTextTitre)
        val EditTextNote = findViewById<EditText>(R.id.EditTextNote)

        //ajout d'une note
        btnAddNote.setOnClickListener {
            val editTextValueTitre: String = EditTextTitre.getText().toString()
            val editTextValueNote: String = EditTextNote.getText().toString()

            val intentAccueil = getIntent()
            val list = intent.getStringArrayListExtra("list")

            val intent = Intent(applicationContext, MainActivity::class.java);
            intent.putExtra("titre", editTextValueTitre)
            intent.putExtra("note", editTextValueNote)
            intent.putStringArrayListExtra("list", list)
            startActivity(intent);
        }
    }
}