package twinparadox.memoapp

import android.content.ContentValues
import android.os.Build.ID
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_memos.*
import java.lang.Exception

class AddMemos : AppCompatActivity() {
    val dbTable="Memos"
    var id=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_memos)

        var bundle:Bundle=intent.extras
        try {
            id = bundle.getInt("ID")
            if (id != 0) {
                editTextTitle.setText(bundle.getString("Title"))
                editTextContent.setText(bundle.getString("Content"))
            }
        }
        catch (ex:Exception) {}
    }

    fun buttonAdd(view:View) {
        var dbManager=DBManager(this)
        val values= ContentValues()
        values.put("Title",editTextTitle.text.toString())
        values.put("Content",editTextContent.text.toString())

        var ID:Long
        if(id==0) {
            ID = dbManager.Insert(values)
        }
        else {
            var selectionArr=arrayOf(id.toString())
            ID=dbManager.Update(values,"ID=?",selectionArr)
        }
        if (ID > 0) {
            Toast.makeText(this, "MEMO IS ADDED", Toast.LENGTH_LONG).show()
            finish()
        } else {
            Toast.makeText(this, "CANNOT ADD MEMO", Toast.LENGTH_LONG).show()
        }
    }
}
