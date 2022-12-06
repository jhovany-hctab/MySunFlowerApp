package appiscjhovany.mysunflowerapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import appiscjhovany.mysunflowerapp.activity.ActividadDos
import appiscjhovany.mysunflowerapp.activity.ActividadHTTP
import appiscjhovany.mysunflowerapp.activity.ActividadInventario
import appiscjhovany.mysunflowerapp.activity.ActividadTemperatura
import com.google.android.material.textfield.TextInputEditText

const val TEXTO = "TEXTO"

class MainActivity : AppCompatActivity() {

    lateinit var editText: TextInputEditText
    lateinit var buttonColor:Button
    lateinit var buttonMessage: Button
    lateinit var buttonData: Button
    lateinit var buttonList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.text_input_et)
        buttonColor = findViewById(R.id.button_color)
        buttonMessage = findViewById(R.id.button_message)
        buttonData = findViewById(R.id.button_data_http)
        buttonList = findViewById(R.id.button_list)

        buttonColor.setOnClickListener{
            if (buttonColor.text != "Soy Azul"){
                buttonColor.setBackgroundColor(Color.parseColor("#6495ED"))
                buttonColor.setText("Soy Azul")
                updateEditText("Soy Azul")
            }else {
                buttonColor.setBackgroundColor(Color.parseColor("#FF0000"))
                buttonColor.setText("Soy Rojo")
                updateEditText("Soy Rojo")
            }
        }
        buttonMessage.setOnClickListener{
            changeActivity()
        }
        buttonList.setOnClickListener{
            changeActivityList()
        }
        buttonData.setOnClickListener {
            changeActivityHttp()
        }
    }

    private fun changeActivityHttp() {
        val intent = Intent(this, ActividadHTTP::class.java)
        startActivity(intent)
    }

    fun updateEditText(message: String){
        editText.setText("Botón pulsado: "+message)
    }
    fun changeActivity() {
        var message = editText.text.toString()
        val intent = Intent(this, ActividadDos::class.java).apply {
            putExtra(TEXTO, message)
        }
        startActivity(intent)
    }

    fun changeActivityList() {
        val intent = Intent(this, ActividadInventario::class.java)
        startActivity(intent)
    }

    fun changeActivityWeather() {
        val intent = Intent(this, ActividadTemperatura::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.sunflower_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.inventario -> {
                changeActivityList()
                true
            }
            R.id.temperatura -> {
                changeActivityWeather()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}