package t.twinparadox.kotlinloginexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val id="twinparadox"
    private val password="password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin.setOnClickListener {
            val inputLogin = textviewID.text.trim().toString()
            val inputPassword = textviewPassword.text.trim().toString()
            if(inputLogin==id && inputPassword==password) {
                val intent = Intent(this, ManagamentActivity::class.java)
                startActivity(intent)
            }
            else {
                if (inputLogin.isNullOrEmpty() && inputPassword.isNullOrEmpty()) {
                    Toast.makeText(this, "ID와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
                else if(inputLogin!=id) {
                    Toast.makeText(this, "존재하지 않는 ID입니다.", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
