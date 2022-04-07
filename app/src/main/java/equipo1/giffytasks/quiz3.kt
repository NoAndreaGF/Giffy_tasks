package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class quiz3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz3)

        val button: Button = findViewById(R.id.siguiente)

        button.setOnClickListener{
            var intent: Intent = Intent(this,quiz4::class.java)
            startActivity(intent)
        }
    }
}