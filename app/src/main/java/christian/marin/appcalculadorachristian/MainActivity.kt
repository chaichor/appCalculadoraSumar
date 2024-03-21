package christian.marin.appcalculadorachristian

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //1- mandar a llamar a todos los elementos de la vista

        val txtNum1 = findViewById<EditText>(R.id.txtNum1)
        val txtNum2 = findViewById<EditText>(R.id.txtNum2)
        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val lblResultado = findViewById<TextView>(R.id.lblResul)

        //2- creo un objeto de clase calculadora para acceder al metodo

        val objCalculadora = Calculadora()

        //3- Programar boton de sumar

        btnSumar.setOnClickListener {

            val res = objCalculadora.sumar(txtNum1.text.toString().toInt(), txtNum2.text.toString().toInt())

            println("Este es el resultado: $res")

            lblResultado.text = "el resultado es: $res"
        }




    }
}