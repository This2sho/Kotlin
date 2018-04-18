package twinparadox.myfirstkotlinexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var click=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonTest.setOnClickListener({
            Toast.makeText(this,"This is My First Kotlin App", Toast.LENGTH_LONG).show()
            click++
            textViewClickNumbers.text = click.toString()
        })

        buttonSnackBar.setOnClickListener({})
            Snackbar.make(mainlayout,"This is SnackBar",Snackbar.LENGTH_LONG).show()
        })
    }
}