package appiscjhovany.mysunflowerapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import appiscjhovany.mysunflowerapp.R
import appiscjhovany.mysunflowerapp.adapter.ItemAdapter
import appiscjhovany.mysunflowerapp.data.DataSource

class ActividadInventario : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_inventario)

        val misPlantas = DataSource().cargarPlantas()
        textView = findViewById(R.id.count_flower)
        textView.setText(misPlantas.size.toString())

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, misPlantas)
        recyclerView.setHasFixedSize(true)
    }
}