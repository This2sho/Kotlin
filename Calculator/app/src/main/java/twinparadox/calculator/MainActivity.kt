package twinparadox.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isNewOp=true
    var op=""
    var prevNumber=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick_buttonNumberEvent(view: View) {
        if(isNewOp==true) {
            etShowNumber.setText("")
        }
        var isNewOp=false

        val EntryData = etShowNumber.text

        val selectedButton=view as Button
        var value:String=etShowNumber.text.toString()

        when(selectedButton.id) {
            button0.id-> {
                value+="0"
            }
            button1.id-> {
                value+="1"
            }
            button2.id-> {
                value+="2"
            }
            button3.id-> {
                value+="3"
            }
            button4.id-> {
                value+="4"
            }
            button5.id-> {
                value+="5"
            }
            button6.id-> {
                value+="6"
            }
            button7.id-> {
                value+="7"
            }
            button8.id-> {
                value+="8"
            }
            button9.id-> {
                value+="9"
            }
            buttonDot.id->{
                //TODO : 2개 이상의 dot가 찍히지 않게 해야 함.
                value+="."
            }
            buttonPlusMins.id->{
                value="-"+value
            }
        }
        etShowNumber.setText(value)
    }

    fun onClick_buttonOpEvent(view:View) {

        val selectedButton=view as Button
        when(selectedButton.id) {
            buttonSum.id-> {

            }
            buttonSubtraction.id-> {

            }
            buttonMultiply.id-> {

            }
            buttonDivide.id-> {

            }
        }

        prevNumber=etShowNumber.text.toString()
        isNewOp=true
    }

    fun onClick_buttonEqualEvent(view:View) {

        val newNumber=etShowNumber.text.toString()
        var finalNumber:Double?=null

        when(op) {
            "+"-> {
                finalNumber=prevNumber.toDouble() + newNumber.toDouble()
            }
            "-"-> {
                finalNumber=prevNumber.toDouble() - newNumber.toDouble()
            }
            "*"-> {
                finalNumber=prevNumber.toDouble() * newNumber.toDouble()
            }
            "/"-> {
                finalNumber=prevNumber.toDouble() / newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }

    fun onClick_buttonPercent(view:View) {

        val number=etShowNumber.text.toString().toDouble()/100

        etShowNumber.setText(number.toString())
        isNewOp=true
    }

    fun onClick_buttonClean(view:View) {
        etShowNumber.setText("0")
        isNewOp=true
    }
}
