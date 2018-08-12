package twinparadox.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var player1=ArrayList<Int>()
    private var player2=ArrayList<Int>()
    private var turn=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun buttonClick(view:View) {
        val buttonSelected=view as Button
        var id=0
        when(buttonSelected.id) {
            R.id.button1-> id=1
            R.id.button2-> id=2
            R.id.button3-> id=3
            R.id.button4-> id=4
            R.id.button5-> id=5
            R.id.button6-> id=6
            R.id.button7-> id=7
            R.id.button8-> id=8
            R.id.button9-> id=9
        }

        Toast.makeText(this,"ID:"+id,Toast.LENGTH_LONG).show()
        playGame(id,buttonSelected)
    }

    fun playGame(id:Int, buttonSelected:Button) {
        if(turn==1) {
            buttonSelected.text="X"
            buttonSelected.setBackgroundColor(Color.GREEN)
            player1.add(id)
            turn=2
        }
        else {
            buttonSelected.text="O"
            buttonSelected.setBackgroundColor(Color.BLUE)
            player2.add(id)
            turn=1
        }

        var winner = checkWinner()

        if(winner==1) {
            Toast.makeText(this,"Player 1 WIN", Toast.LENGTH_LONG).show()
        }
        else if(winner==2) {
            Toast.makeText(this,"Player 2 WIN", Toast.LENGTH_LONG).show()
        }

        buttonSelected.isEnabled=false
    }

    fun checkWinner():Int {
        for(low in 0..2) {
            if(player1.contains(low*3+1) && player1.contains(low*3+2) && player1.contains(low*3+3)) {

            }
            if(player2.contains(low*3+1) && player2.contains(low*3+2) && player2.contains(low*3+3)) {
            }
        }

        for(col in 1..3) {
            if(player1.contains(col) && player1.contains(col+3) && player1.contains(col+6)) {
                return 1
            }
            if(player2.contains(col) && player2.contains(col+3) && player2.contains(col+6)) {
                return 2
            }
        }
        return 0
    }

    fun AIPlay() {
        var emptyCells=ArrayList<Int>()
        for(id in 1..9) {
            if(!player1.contains(id) && !player2.contains(id)) {
                emptyCells.add(id)
            }
        }
    }
}
