package twinparadox.listviewexam

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val something = arrayOf("some1","some2","some3","some4","some5")

        listView.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,something)

        listView.setOnItemClickListener { adapterView, view, position, i ->
            Toast.makeText(applicationContext,something[i]+"가 선택되었습니다.",Toast.LENGTH_LONG).show()
        }
    }
}
