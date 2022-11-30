package appiscjhovany.mysunflowerapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import appiscjhovany.mysunflowerapp.activity.ActividadDos
import appiscjhovany.mysunflowerapp.activity.ActividadInventario
import com.google.android.material.textfield.TextInputEditText

const val TEXTO = "TEXTO"
class MainActivity : AppCompatActivity() {

    lateinit var editText: TextInputEditText
    lateinit var buttonColor:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.text_input_et)
        buttonColor = findViewById(R.id.button_color)

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
    }

    fun updateEditText(message: String){
        editText.setText("Botón pulsado: "+message)
    }
}