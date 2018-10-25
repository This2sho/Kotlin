package twinparadox.memoapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ticket.view.*

class MainActivity : AppCompatActivity() {

    var listMemos=ArrayList<Memo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // DUMMY DATA
        /*
        listMemos.add(Memo(1,getString(R.string.title_rorem),getString(R.string.content_rorem)))
        listMemos.add(Memo(2,getString(R.string.title_rorem),getString(R.string.content_rorem)))
        listMemos.add(Memo(3,getString(R.string.title_rorem),getString(R.string.content_rorem)))
        */


        // Load from DB
        LoadQuery("%")
    }

    // Always Load from DB
    override fun onResume() {
        super.onResume()
        LoadQuery("%")
    }

    fun LoadQuery(title:String) {
        var dbManager=DBManager(this)
        val projections=arrayOf("ID","Title","Content")
        val selectionArgs= arrayOf(title)
        val cursor=dbManager.Query(projections,"Title like ?",selectionArgs,"Title")

        listMemos.clear()
        if(cursor.moveToFirst()) {
            do {
                val ID=cursor.getInt(cursor.getColumnIndex("ID"))
                val Title= cursor.getString(cursor.getColumnIndex("Title"))
                val Content=cursor.getString(cursor.getColumnIndex("Content"))
                listMemos.add(Memo(ID,Title,Content))
            } while(cursor.moveToNext())
        }

        var myMemosAdapter=MyMemosAdapter(this, listMemos)
        listViewMemos.adapter=myMemosAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)

        val sv=menu!!.findItem(R.id.searchMemo).actionView as SearchView
        val sm=getSystemService(Context.SEARCH_SERVICE) as SearchManager
        sv.setSearchableInfo(sm.getSearchableInfo(componentName))
        sv.setOnQueryTextListener(object:SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(applicationContext,query, Toast.LENGTH_LONG).show()
                LoadQuery("%"+query+"%")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item!=null) {
            when (item.itemId) {
                R.id.addMemo -> {
                    var intent= Intent(this,AddMemos::class.java)
                    startActivity(intent)
                }
                R.id.searchMemo -> {

                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    inner class MyMemosAdapter:BaseAdapter{
        var listMemosAdapter=ArrayList<Memo>()
        var context:Context?=null
        constructor(context:Context, listMemosAdapter:ArrayList<Memo>):super() {
            this.listMemosAdapter=listMemosAdapter
            this.context=context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var myView=layoutInflater.inflate(R.layout.ticket,null)
            var myMemo=listMemosAdapter[position]

            myView.textViewTitle.text=myMemo.nodeTitle
            myView.textViewContent.text=myMemo.nodeContent
            myView.imageViewDelete.setOnClickListener (View.OnClickListener {
                var dbManager=DBManager(this.context!!)
                var selectionArgs=arrayOf(myMemo.nodeID.toString())
                dbManager.Delete("ID=?",selectionArgs)
            })
            myView.imageViewCreate.setOnClickListener(View.OnClickListener {
                GoToUpdate(myMemo)
            })

            return myView
        }

        override fun getItem(position: Int): Any {
            return listMemosAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listMemosAdapter.size
        }
    }

    fun GoToUpdate(memo:Memo) {
        var intent= Intent(this,AddMemos::class.java)
        intent.putExtra("ID",memo.nodeID)
        intent.putExtra("Title",memo.nodeTitle)
        intent.putExtra("Content",memo.nodeContent)
        startActivity(intent)
    }
}
