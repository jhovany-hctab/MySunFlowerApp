package appiscjhovany.mysunflowerapp.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import appiscjhovany.mysunflowerapp.R
import appiscjhovany.mysunflowerapp.data.DataHttp
import org.json.JSONObject

class ActividadHTTP : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_http)

        textView = findViewById<TextView?>(R.id.text_data)
        button = findViewById(R.id.button_data_http)

        button.setOnClickListener {
            var text = DataHttp().HttpGet("https://catfact.ninja/fact")
            //val jsonArray: JSONArray = JSONArray(text)
            val jObject = JSONObject(text)

            textView.text = jObject.getString("fact")
        }
    }
}