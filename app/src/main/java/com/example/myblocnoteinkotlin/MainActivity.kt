package com.example.myblocnoteinkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var Toto = jeMappelleToto()
                    //Greeting(Toto)
                    val number = 6
                    var Table = tableDeMultiplication(number)
                    //Greeting(Table)
                    var Calcul = calculatriceBasique(4, "*", 6)
                    //Greeting(Calcul)
                    var Farenheit = celsiusVersFahrenheit(12.3)
                    //Greeting(Farenheit.toString())
                    var Fruits = listeDeFruits()
                    Greeting(Fruits)
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

@Composable
fun Greeting(text: String) {
    Text(
        text = "$text",
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyBlocNoteInKotlinTheme {
        Greeting("Android")
    }
}