package sebastian.maciel.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnCold: Button = findViewById(R.id.button_cold_drinks) as Button
        var btnHot: Button = findViewById(R.id.button_hot_drinks) as Button
        var btnSweet: Button = findViewById(R.id.button_sweets) as Button
        var btnSalties: Button = findViewById(R.id.button_salties) as Button
        var btnCombos: Button = findViewById(R.id.button_combo) as Button
        var btnCustom: Button = findViewById(R.id.button_custom) as Button




        btnCold.setOnClickListener {
            var intent: Intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("ItemSelected", "Cold")
            startActivity(intent)
        }

        btnHot.setOnClickListener {
            var intent: Intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("ItemSelected", "Hot")
            startActivity(intent)
        }
        btnSweet.setOnClickListener {
            var intent: Intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("ItemSelected", "Sweet")
            startActivity(intent)
        }
        btnSalties.setOnClickListener {
            var intent: Intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("ItemSelected", "Salties")
            startActivity(intent)
        }

    }


}