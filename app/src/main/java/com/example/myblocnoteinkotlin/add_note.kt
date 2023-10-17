package com.example.myblocnoteinkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class add_note : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        //initialisation des composants
        val btnAddNote = findViewById<Button>(R.id.btnAdd)
        val btnReturn = findViewById<Button>(R.id.btnReturn)
        val EditTextTitre = findViewById<EditText>(R.id.EditTextTitre)
        val EditTextNote = findViewById<EditText>(R.id.EditTextNote)

        //initialisation du intent avec les listes
        val intentAccueil = getIntent()
        val listTitre = intentAccueil.getStringArrayListExtra("listTitre")
        val listNote = intentAccueil.getStringArrayListExtra("listNote")
        val intent = Intent(applicationContext, MainActivity::class.java);
        intent.putStringArrayListExtra("listTitre", listTitre)
        intent.putStringArrayListExtra("listNote", listNote)

        //ajout d'une note
        btnAddNote.setOnClickListener {
            val editTextValueTitre: String = EditTextTitre.getText().toString()
            val editTextValueNote: String = EditTextNote.getText().toString()

            if (editTextValueTitre.isEmpty() || editTextValueNote.isEmpty()) {
                // Afficher un Toast pour indiquer que les champs sont vides
                Toast.makeText(this, "Les champs ne doivent pas être vides", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("titre", editTextValueTitre)
                intent.putExtra("note", editTextValueNote)
                startActivity(intent);
            }
        }

        btnReturn.setOnClickListener {
            startActivity(intent);
        }
    }
}