package com.codepath.wordle



import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    var count = 0
    var tempString = "Guess #"
    private lateinit var wordToGuess: String
    private lateinit var inputString: String
    private lateinit var checkString: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val guessButton = findViewById<Button>(R.id.guessButton)
        val editText = findViewById<EditText>(R.id.editText)
        val guess_1 = findViewById<TextView>(R.id.textView_guess_1)
        val guess_2 = findViewById<TextView>(R.id.textView_guess_2)
        val guess_3 = findViewById<TextView>(R.id.textView_guess_3)
        val res_1 = findViewById<TextView>(R.id.textView_result_1)
        val res_2 = findViewById<TextView>(R.id.textView_result_2)
        val res_3 = findViewById<TextView>(R.id.textView_result_3)
        val res_final = findViewById<TextView>(R.id.textView_final)
        var spaceLong = "                          "
        var spaceShort = "              "

        wordToGuess = FourLetterWordList.getRandomFourLetterWord()
        res_final.setText(wordToGuess)
        println(wordToGuess)



        var arr = arrayListOf<TextView>(guess_1,res_1,guess_2,res_2,guess_3,res_3,res_final)
        for (x in arr){
            x.visibility = View.INVISIBLE
        }
        guessButton.setOnClickListener {
            inputString = editText.getText().toString().uppercase()
            checkString = checkGuess(inputString)
            if (count<=3) {
                arr[count].setText(arr[count].text.toString() + spaceLong+inputString )
                arr[count+1].setText(arr[count+1].text.toString()+ spaceShort+ checkString)
                arr[count].visibility = View.VISIBLE
                arr[count+1].visibility = View.VISIBLE
                count +=2
            }
            else if(count >3 && count <=6){
                arr[count].setText(arr[count].text.toString()+ spaceLong+ inputString)
                arr[count+1].setText(arr[count+1].text.toString() + spaceShort+ checkString)
                arr[count].visibility = View.VISIBLE
                arr[count+1].visibility = View.VISIBLE
                arr[count+2].visibility = View.VISIBLE
                count += 3
            }

            if (wordToGuess.equals(inputString )){
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                arr[6].visibility = View.VISIBLE
                guessButton.isEnabled=false
                guessButton.isClickable=false
            }

            if (count == 7){
                Toast.makeText(this, "Run out of guess", Toast.LENGTH_SHORT).show()
                guessButton.isEnabled=false
                guessButton.isClickable=false
            }




            editText.onEditorAction(EditorInfo.IME_ACTION_DONE)
            editText.getText().clear()
        }








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
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}

