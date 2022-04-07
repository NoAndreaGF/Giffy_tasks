package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class register2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        val button: Button = findViewById(R.id.siguiente)

        button.setOnClickListener{
            var intent: Intent = Intent(this,question::class.java)
            startActivity(intent)
        }
    }
}