package com.codepath.wordle


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TextView[] textViews =
        val guessButton = findViewById<Button>(R.id.guessButton)
        val simpleEditText = findViewById<EditText>(R.id.editText)
        val guess_1 = findViewById<TextView>(R.id.textView_guess_1)
        val guess_2 = findViewById<TextView>(R.id.textView_guess_2)
        val guess_3 = findViewById<TextView>(R.id.textView_guess_3)
        val res_1 = findViewById<TextView>(R.id.textView_result_1)
        val res_2 = findViewById<TextView>(R.id.textView_result_2)
        val res_3 = findViewById<TextView>(R.id.textView_result_3)
        val res_final = findViewById<TextView>(R.id.textView_final)




        val strValue = simpleEditText.text.toString()
    }

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
//    private fun checkGuess(guess: String) : String {
//        var result = ""
//        for (i in 0..3) {
//            if (guess[i] == wordToGuess[i]) {
//                result += "O"
//            }
//            else if (guess[i] in wordToGuess) {
//                result += "+"
//            }
//            else {
//                result += "X"
//            }
//        }
//        return result
//    }
}