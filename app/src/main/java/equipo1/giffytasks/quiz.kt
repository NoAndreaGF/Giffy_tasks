package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val button: Button = findViewById(R.id.siguiente2)

        button.setOnClickListener{
            var intent: Intent = Intent(this,quiz3::class.java)
            startActivity(intent)
        }
    }
}