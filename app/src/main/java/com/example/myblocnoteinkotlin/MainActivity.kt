package com.example.myblocnoteinkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myblocnoteinkotlin.ui.theme.MyBlocNoteInKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBlocNoteInKotlinTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Text("Exo 1 :")
                    Text(jeMappelleToto())
                    Text("Exo 2 :")
                    Text(tableDeMultiplication(6))
                    Text("Exo 3 :")
                    Text(calculatriceBasique(4, "*", 6))
                    Text("Exo 4")
                    Text(celsiusVersFahrenheit(12.3).toString())
                    Text("Exo 5")
                    Text(listeDeFruits())
                }
            }
        }
    }
}

fun jeMappelleToto(): String{
    var MaPetitePhrase = "Je m'appelle toto et j'ai 27ans."
    println(MaPetitePhrase)
    return MaPetitePhrase
}

fun tableDeMultiplication(number : Int): String{
    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    var tableofmultiplication = ""
    for(n in numbers){
        var result = number.toInt() * n.toInt()
        tableofmultiplication += "" + number + " x " + n + " = " + result + " "
    }
    println(tableofmultiplication)
    return tableofmultiplication
}

fun calculatriceBasique(number1 : Int, operation : String, number2 : Int): String{
    var result = 0
    if("*" == operation){
        result = number1 * number2
    }else if("+" == operation){
        result = number1 + number2
    }else if("-" == operation){
        result = number1 - number2
    }else if("/" == operation){
        result = number1 / number2
    }
    println(""+number1 + " "+operation+" " + number2 + " = " + result)
    return ""+number1 + " "+operation+" " + number2 + " = " + result
}

fun celsiusVersFahrenheit(celsius: Double): Double {
    return (celsius * 9/5) + 32
}

fun listeDeFruits(): String{
    val fruits = listOf("Banane", "Pomme", "Cerise", "Poire")
    var listedefruits = ""
    for(f in fruits){
        listedefruits += f+ " "
        println(f)
    }
    return listedefruits
}