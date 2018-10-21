package twinparadox.memoapp

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_memos.*

class AddMemos : AppCompatActivity() {
    val dbTable="Memos"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_memos)
    }

    fun buttonAdd(view:View) {
        var dbManager=DBManager(this)
        val values= ContentValues()
        values.put("Title",editTextTitle.text.toString())
        values.put("Content",editTextContent.text.toString())

        val ID=dbManager.Insert(values)
        if(ID>0) {
            Toast.makeText(this,"MEMO IS ADDED", Toast.LENGTH_LONG).show()
            finish()
        }
        else {
            Toast.makeText(this,"CANNOT ADD MEMO", Toast.LENGTH_LONG).show()
        }
    }
}
