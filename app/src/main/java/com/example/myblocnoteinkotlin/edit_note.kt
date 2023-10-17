package com.example.myblocnoteinkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class edit_note : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        // Initialisation des composants
        val btnEditNote = findViewById<Button>(R.id.btnEdit)
        val EditTextTitre = findViewById<EditText>(R.id.EditTextTitre)
        val EditTextNote = findViewById<EditText>(R.id.EditTextNote)

        //Récup des données
        val intent = getIntent()
        val titre = intent.getStringExtra("titre")
        val note = intent.getStringExtra("note")
        val listTitre = intent.getStringArrayListExtra("listTitre")
        val listNote = intent.getStringArrayListExtra("listNote")

        //Modif des editText
        EditTextTitre.setText(titre)
        EditTextNote.setText(note)

        //Sauvegarde des modifs
        btnEditNote.setOnClickListener {
            val editedTitre: String = EditTextTitre.text.toString()
            val editedNote: String = EditTextNote.text.toString()

            val intentAccueil = Intent(this, MainActivity::class.java)
            intentAccueil.putExtra("titre", editedTitre)
            intentAccueil.putExtra("note", editedNote)
            intentAccueil.putStringArrayListExtra("listTitre", listTitre)
            intentAccueil.putStringArrayListExtra("listNote", listNote)
            startActivity(intentAccueil)
        }
    }
}
