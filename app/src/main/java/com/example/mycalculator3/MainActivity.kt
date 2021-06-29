package com.example.mycalculator3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit internal var numb1 : String
    lateinit internal var numb2 : String

    internal var numButtons = ArrayList<Button>(10)
    internal var numBtnIDs = arrayOf(R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..9 step 1){
            numButtons.add(findViewById<Button>(numBtnIDs[i]))
        }

        for(i in 0..numBtnIDs.size-1 step 1){
            numButtons[i].setOnClickListener {
                if(edtNum1.isFocused==true){
                    numb1=edtNum1.text.toString() + numButtons[i].getText().toString()
                    edtNum1.setText(numb1)
                }else if(edtNum2.isFocused == true){
                    numb2=edtNum2.text.toString() + numButtons[i].getText().toString()
                    edtNum2.setText(numb2)
                }else{
                    Toast.makeText(applicationContext,"먼저 에디트텍스트를 선택하세요.",Toast.LENGTH_SHORT).show()
                }
            }
        }

        delNum1.setOnClickListener {
            edtNum1.setText("")
        }
        delNum2.setOnClickListener {
            edtNum2.setText("")
        }
        delAllNum.setOnClickListener {
            edtNum1.setText("")
            edtNum2.setText("")
            resultView.text="계산 결과:"
            resultView.setTextColor(Color.RED)
        }

        btnAdd.setOnClickListener {
            val num1=edtNum1.text.toString()
            val num2=edtNum2.text.toString()

            if(num1=="" || num2==""){
                Toast.makeText(applicationContext,"숫자를 입력하시오", Toast.LENGTH_SHORT).show()
            }else{
                val result=(num1.toDouble()+num2.toDouble())
                resultView.text= "계산 결과: $result"
                resultView.setTextColor(Color.RED)
            }
        }

        btnSub.setOnClickListener {
            val num1=edtNum1.text.toString()
            val num2=edtNum2.text.toString()

            if(num1=="" || num2==""){
                Toast.makeText(applicationContext,"숫자를 입력하시오", Toast.LENGTH_SHORT).show()
            }else{
                val result=(num1.toDouble()-num2.toDouble())
                resultView.text= "계산 결과: $result"
                resultView.setTextColor(Color.RED)
            }
        }

        btnMul.setOnClickListener {
            val num1=edtNum1.text.toString()
            val num2=edtNum2.text.toString()

            if(num1=="" || num2==""){
                Toast.makeText(applicationContext,"숫자를 입력하시오", Toast.LENGTH_SHORT).show()
            }else{
                val result=(num1.toDouble()*num2.toDouble())
                resultView.text= "계산 결과: $result"
                resultView.setTextColor(Color.RED)
            }
        }

        btnDiv.setOnClickListener {
            val num1=edtNum1.text.toString()
            val num2=edtNum2.text.toString()

            if(num1=="" || num2==""){
                Toast.makeText(applicationContext,"숫자를 입력하시오",Toast.LENGTH_SHORT).show()
            }else if(num2=="0"){
                Toast.makeText(applicationContext,"0으로 나눌 수 없습니다.",Toast.LENGTH_SHORT).show()
            }else{
                val result=(num1.toDouble()/num2.toDouble())
                resultView.text= "계산 결과: $result"
                resultView.setTextColor(Color.RED)
            }
        }


    }
}