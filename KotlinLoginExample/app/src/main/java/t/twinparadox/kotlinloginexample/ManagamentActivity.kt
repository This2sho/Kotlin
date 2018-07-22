package t.twinparadox.kotlinloginexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_managament.*

class ManagamentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_managament)

        buttonCustomer.setOnClickListener {
            Toast.makeText(this,buttonCustomer.text,Toast.LENGTH_SHORT).show()
        }
        buttonSales.setOnClickListener {
            Toast.makeText(this,buttonSales.text,Toast.LENGTH_SHORT).show()
        }
        buttonMerchandise.setOnClickListener {
            Toast.makeText(this,buttonMerchandise.text,Toast.LENGTH_LONG).show()
        }
    }
}
