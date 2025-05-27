package talavera.eduardo.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val txtPrecioOriginal : TextView = findViewById(R.id.txtPrecioOriginal)
        val txtDescuento : TextView = findViewById(R.id.txtDescuento)
        val txtValido : TextView = findViewById(R.id.txtValido)
        val txtTotal : TextView = findViewById(R.id.txtTotal)
        val btnDescuento : Button = findViewById(R.id.btnDescuento)
        val btnPuroDescuento : Button = findViewById(R.id.btnPuroDescuento)

        btnDescuento.setOnClickListener {
            if(txtDescuento.text.toString().isEmpty() || txtPrecioOriginal.text.toString().isEmpty() || txtDescuento.text.toString().toFloat() <= 0 || txtDescuento.text.toString().toFloat() > 100 || txtPrecioOriginal.text.toString().toFloat() <= 0){
                txtValido.visibility = View.VISIBLE
            } else {
            txtValido.visibility = View.GONE
            val descuento = (txtPrecioOriginal.text.toString().toFloat() * txtDescuento.text.toString().toFloat())/100
            val total = txtPrecioOriginal.text.toString().toFloat() - descuento
            txtTotal.text = total.toString()
            }
        }

        btnPuroDescuento.setOnClickListener{
            if(txtDescuento.text.toString().isEmpty() || txtPrecioOriginal.text.toString().isEmpty() || txtDescuento.text.toString().toFloat() <= 0 || txtDescuento.text.toString().toFloat() > 100 || txtPrecioOriginal.text.toString().toFloat() <= 0){
                txtValido.visibility = View.VISIBLE
            } else {
                txtValido.visibility = View.GONE
                val descuento = (txtPrecioOriginal.text.toString().toFloat() * txtDescuento.text.toString().toFloat())/100
                txtTotal.text = descuento.toString()
            }
        }
    }
}
