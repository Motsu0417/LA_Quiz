package app.motsu.hiromoto.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quizIntent: Intent = Intent(this,QuizActivity::class.java)
        
        startButton.setOnClickListener{
            startActivity(quizIntent)
        }


    }



}