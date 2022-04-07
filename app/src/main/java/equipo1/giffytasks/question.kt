package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class question : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val button: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)

        button.setOnClickListener{
            var intent: Intent = Intent(this,quiz::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener{
            var intent: Intent = Intent(this,NavigationActivity::class.java)
            startActivity(intent)
        }
    }
}