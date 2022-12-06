package appiscjhovany.mysunflowerapp.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import appiscjhovany.mysunflowerapp.R
import appiscjhovany.mysunflowerapp.data.DataHttp
import appiscjhovany.mysunflowerapp.model.WeatherData
import com.google.gson.Gson

const val URL ="b78f6b532a7e9f1d6776330a94931cad"
class ActividadTemperatura : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_temperatura)

        textView = findViewById(R.id.Texto_Temperatura)
        button = findViewById(R.id.Boton_Temperatura)

        button.setOnClickListener {
            var text = DataHttp().HttpGet("https://api.openweathermap.org/data/2.5/weather?lat=16.245359&lon=-92.143213&appid="+URL+"&lang=es")
            //val jsonArray: JSONArray = JSONArray(text)
            //val jObject = JSONObject(text)
            val gson = Gson()

            val currentWeather: WeatherData = gson.fromJson(
                text,
                WeatherData::class.java
            )

            textView.text = currentWeather.weather.firstOrNull()?. description ?: ""
        }
    }
}