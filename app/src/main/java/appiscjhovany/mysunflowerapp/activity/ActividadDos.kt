package appiscjhovany.mysunflowerapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import appiscjhovany.mysunflowerapp.R
const val TEXTO = "TEXTO"
class ActividadDos : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_dos)

        val message = intent.getStringExtra(TEXTO)

        textView = findViewById<TextView?>(R.id.message_tv).apply {
            text = message
        }

    }
}