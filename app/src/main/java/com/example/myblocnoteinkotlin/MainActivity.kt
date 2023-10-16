package com.example.myblocnoteinkotlin

import Personne
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
                    Text("Exo 6 :")
                    Text(fonctionsAddition(5, 3))
                    Text("Exo 7 :")
                    Text(factorielle(5).toString())
                    Text("Exo 8 :")
                    Text(fizzbuzz(8))
                    Text("Exo 9 :")
                    Text(palindrome("racecar"))
                    Text("Exo 10 :")
                    Text(personne())
                }
            }
        }
    }
}

//Créer un programme qui lors de son exécution. Vous devriez voir "Je m'appelle toto et j'ai 27
//ans." s'afficher
fun jeMappelleToto(): String{
    var MaPetitePhrase = "Je m'appelle toto et j'ai 27ans."
    println(MaPetitePhrase)
    return MaPetitePhrase
}

//un programme qui permet d’entrer un nombre lorsque vous y êtes invité. Le programme
//affichera la table de multiplication de ce nombre.
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

//Réaliser un programme. Avec des instructions pour saisir deux nombres et une opération.
//Le programme affichera le résultat.
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

//réaliser un programme qui permet de saisir la température en degrés Celsius lorsque vous y
//êtes invité. Le programme affichera la conversion en degrés Fahrenheit
fun celsiusVersFahrenheit(celsius: Double): Double {
    return (celsius * 9/5) + 32
}

//écrire un programme avec une liste de fruits
//le programme va parcourir la liste. Il affichera chaque fruit de la liste. (utilisation boucle for)
fun listeDeFruits(): String{
    val fruits = listOf("Banane", "Pomme", "Cerise", "Poire")
    var listedefruits = ""
    for(f in fruits){
        listedefruits += f+ " "
        println(f)
    }
    return listedefruits
}

//en utilisant les fonctions écrivez un programme. Il appellera la fonction additionner pour
//additionner 5 et 3, puis affichera le résultat.
fun fonctionsAddition(number1 : Int, number2 : Int): String{
    var result = number1 + number2
    println(""+number1 + " + " + number2 + " = " + result)
    return ""+number1 + " + " + number2 + " = " + result
}

//un programme qui calculera la factorielle de 5 et affichera le résultat.
fun factorielle(number : Int): String{
    var factorielle = 1

    for (i in 1..number) {
        factorielle *= i
    }
    println("La factorielle de $number est $factorielle")
    return "La factorielle de $number est $factorielle"
}

//Il affichera la séquence de Fizz, Buzz et FizzBuzz conformément aux règles.
fun fizzbuzz(n: Int): String{
    var result = ""

    for (i in 1..n) {
        if(i % 3 == 0 && i % 5 == 0){
            result += "FizzBuzz"
        }else if(i % 3 == 0){
            result += "Fizz"
        }else if(i % 5 == 0){
            result += "Buzz"
        }else{
            result += i
        }
    }
    println(result)
    return result
}

//Il vérifiera si la phrase est un palindrome et affichera le résultat.
fun palindrome(phrase: String): String{
    var revert = phrase.reversed()
    var result = ""
    if(revert == phrase){
        result = "$phrase est un palindrome !"
    }else{
        result = "$phrase n'est pas un palindrome !"
    }
    println(result)
    return result
}

//Créez une classe Kotlin nommée Personne avec deux propriétés : nom (String) et
//âge (Int). Ajoutez également un constructeur pour initialiser ces propriétés.
//Créez une liste de personnes avec différentes valeurs.
//Affichez la liste de personnes à l'écran en utilisant une boucle.
//Triez la liste des personnes par âge (du plus jeune au plus âgé).
//Affichez la liste triée.
//Filtrer la liste pour ne conserver que les personnes de moins de 30 ans.
//Affichez la liste filtrée.
fun personne(): String{
    val personnes = listOf(
        Personne("Alice", 25),
        Personne("Bob", 30),
        Personne("Charlie", 22),
        Personne("David", 35),
        Personne("Eve", 28)
    )

    var result = ""

    println("Liste de personnes : ")
    result += "Liste de personnes : "
    for (personne in personnes) {
        println("Nom : ${personne.nom}, Âge : ${personne.âge} ")
        result += "Nom : ${personne.nom}, Âge : ${personne.âge} "
    }

    val personnesTrie = personnes.sortedBy { it.âge }

    println("\nListe triée par âge : ")
    result += "\nListe triée par âge : "
    for (personne in personnesTrie) {
        println("Nom : ${personne.nom}, Âge : ${personne.âge} ")
        result +="Nom : ${personne.nom}, Âge : ${personne.âge} "
    }

    val personnesMoinsDe30Ans = personnes.filter { it.âge < 30 }

    println("\nPersonnes de moins de 30 ans : ")
    result += "\nPersonnes de moins de 30 ans : "
    for (personne in personnesMoinsDe30Ans) {
        println("Nom : ${personne.nom}, Âge : ${personne.âge} ")
        result += "Nom : ${personne.nom}, Âge : ${personne.âge} "
    }
    return result
}