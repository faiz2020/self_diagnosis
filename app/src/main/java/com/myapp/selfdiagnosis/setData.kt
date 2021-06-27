package com.myapp.selfdiagnosis

object setData {

    const val score:String="score"

    fun getQuestion():ArrayList<Questiondata>{
        var que:ArrayList<Questiondata> = arrayListOf()
        var q1= Questiondata(
            1,
        "Trubbleing with bry cough from past few days?",
            "yes",
        "no",

        1

        )
        var q2= Questiondata(
            2,
            "Is your body's temperature normal?",
            "yes",
            "no",

            2

        )
        var q3= Questiondata(
            3,
            "having loss of speech or movement?",
            "yes",
            "no",

            1

        )
        var q4= Questiondata(
            4,
            "easy to breath and activeness",
            "yes",
            "no",

            2

        )
        var q5= Questiondata(
            5,
            "Is your chest paining! or felt any pressure on chest?",
            "yes",
            "no",

            1

        )
        var q6= Questiondata(
            5,
            "did you toke covid-19 vaccination?",
            "yes",
            "no",

            2

        )
        var q7= Questiondata(
            5,
            "have you lost your ability to test or smell?",
            "yes",
            "no",

            1

        )
        var q8= Questiondata(
            5,
            "had problems like sore throat,conjunctivities,diarrhoea,headache,etc",
            "yes",
            "no",

            1

        )

        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        que.add(q6)
        que.add(q7)
        que.add(q8)

        return que
    }
}
