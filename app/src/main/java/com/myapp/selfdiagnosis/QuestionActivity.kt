package com.myapp.selfdiagnosis


import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*


class QuestionActivity : AppCompatActivity() {

    private var Name:String?=null
    private var score:Int=0

    private var currentPosition:Int=1
    private var questionList:ArrayList<Questiondata> ? = null
    private var selecedOption:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)


        questionList=setData.getQuestion()

        setQuestion()

        idOption1.setOnClickListener{

            selectedOptionStyle(idOption1,1)
        }
        idOption2.setOnClickListener{

            selectedOptionStyle(idOption2,2)
        }


        idBtnsubmit.setOnClickListener {
            if(selecedOption!=0)
            {
                val question=questionList!![currentPosition-1]

                if(selecedOption==question.answer)
                    score++

                setColor(question.answer,R.drawable.correct_ans)
                if(currentPosition==questionList!!.size)
                    idBtnsubmit.text="FINISH"
                else
                    idBtnsubmit.text="Go to Next"
            }else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }
                    else->{
                        var intent= Intent(this,Result::class.java)

                        intent.putExtra(setData.score,score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())

                        startActivity(intent)
                        finish()
                    }
                }
            }
            selecedOption=0
        }

    }

    fun setColor(opt:Int,color:Int){
        when(opt){
            1->{
                idOption1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                idOption2.background=ContextCompat.getDrawable(this,color)
            }

        }
    }


    fun setQuestion(){

        val question = questionList!![currentPosition-1]
        setOptionStyle()


        idProgess.progress=currentPosition
        idProgess.max=questionList!!.size
        idquestion.text=question.question
        idOption1.text=question.option_one
        idOption2.text=question.option_two


    }

    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,idOption1)
        optionList.add(1,idOption2)

        for(op in optionList)
        {
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface= Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view:TextView,opt:Int){

        setOptionStyle()
        selecedOption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.option_selected_bg)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))

    }
}