package twinparadox.bluetoothremotecontroller

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import java.util.*

class ControlActivity: AppCompatActivity() {

    companion object {
        var m_myUUID: UUID = UUID.fromString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun sendCommand(input:String) {

    }

    private fun disconnect() {

    }

    private class ConnectToDevice(c: Context): AsyncTask<Void, Void, String>() {
        private var connectSuccess:Boolean = true
        private val context:Context

        init {
            this.context=c
        }

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: Void?): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }
    }
}