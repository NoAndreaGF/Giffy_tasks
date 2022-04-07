package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val textView: TextView = findViewById(R.id.btn_aboout_us)
        val textView1: TextView = findViewById(R.id.contact_us)

        textView.setOnClickListener{
            var intent: Intent = Intent(this,about_us::class.java)
            startActivity(intent)
        }
        textView1.setOnClickListener{
            var intent: Intent = Intent(this,contact::class.java)
            startActivity(intent)
        }
    }
}