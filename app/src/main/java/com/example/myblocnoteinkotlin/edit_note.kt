package com.example.myblocnoteinkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class edit_note : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        // Initialisation des composants
        val btnEditNote = findViewById<Button>(R.id.btnEdit)
        val btnReturn2 = findViewById<Button>(R.id.btnReturn2)
        val EditTextTitre = findViewById<EditText>(R.id.EditTextTitre)
        val EditTextNote = findViewById<EditText>(R.id.EditTextNote)

        //Récup des données
        val intent = getIntent()
        val titre = intent.getStringExtra("titre")
        val note = intent.getStringExtra("note")
        val listTitre = intent.getStringArrayListExtra("listTitre")
        val listNote = intent.getStringArrayListExtra("listNote")

        //initialisation intent
        val intentAccueil = Intent(this, MainActivity::class.java)
        intentAccueil.putStringArrayListExtra("listTitre", listTitre)
        intentAccueil.putStringArrayListExtra("listNote", listNote)

        //Modif des editText
        EditTextTitre.setText(titre)
        EditTextNote.setText(note)

        //Sauvegarde des modifs
        btnEditNote.setOnClickListener {
            val editedTitre: String = EditTextTitre.text.toString()
            val editedNote: String = EditTextNote.text.toString()

            if (editedTitre.isEmpty() || editedNote.isEmpty()) {
                Toast.makeText(this, "Les champs ne doivent pas être vides", Toast.LENGTH_SHORT).show()
            } else {
                intentAccueil.putExtra("titre", editedTitre)
                intentAccueil.putExtra("note", editedNote)
                startActivity(intentAccueil)
            }
        }

        //bouton de retour
        btnReturn2.setOnClickListener {
            intentAccueil.putExtra("titre", titre)
            intentAccueil.putExtra("note", note)
            startActivity(intentAccueil)
        }
    }
}
