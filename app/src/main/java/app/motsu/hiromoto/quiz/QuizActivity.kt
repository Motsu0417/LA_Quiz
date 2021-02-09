package app.motsu.hiromoto.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    val quizLists: List<List<String>> = listOf(
        listOf("もつの出身地は", "広島", "神戸", "名古屋", "広島"),
        listOf("もつの誕生日は", "3月12日", "5月9日", "4月17日", "4月17日"),
        listOf("モスの人気1位は", "モスバーガー", "とびきりチーズ", "ロースかつ", "とびきりチーズ")
    )

    val shuffledLists: List<List<String>> = quizLists.shuffled()
    var quizCount: Int = 0
    var correctCount: Int = 0
    var correctAnswer: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        showQuestion()

        answerButton1.setOnClickListener {
            checkAnswer(answerButton1.text as String)
        }
        answerButton2.setOnClickListener {
            checkAnswer(answerButton2.text as String)
        }
        answerButton3.setOnClickListener {
            checkAnswer(answerButton3.text as String)
        }

        nextButton.setOnClickListener {
            if(quizCount == quizLists.size){
                // end
            }else{
                // continue
                imageView.isVisible = false
                nextButton.isVisible = false

                answerButton1.isEnabled = true
                answerButton2.isEnabled = true
                answerButton3.isEnabled = true

                correctAnswerText.text = ""

                showQuestion()
            }
        }
    }


    fun showQuestion() {
        val question: List<String> = shuffledLists[quizCount]

        quizText.text = question[0]

        answerButton1.text = question[1]
        answerButton2.text = question[2]
        answerButton3.text = question[3]

        correctAnswer = question[4]
    }

    fun checkAnswer(answerText: String) {
        if (answerText.equals(correctAnswer)) {
            imageView.setImageResource(R.drawable.maru_image)
            correctCount++
        } else {
            imageView.setImageResource(R.drawable.batu_image)
        }
        showAnswer()
        quizCount++
    }

    fun showAnswer() {
        correctAnswerText.text = "正解：${correctAnswer}"
        imageView.isVisible = true
        nextButton.isVisible = true

        answerButton1.isEnabled = false
        answerButton2.isEnabled = false
        answerButton3.isEnabled = false
    }
}