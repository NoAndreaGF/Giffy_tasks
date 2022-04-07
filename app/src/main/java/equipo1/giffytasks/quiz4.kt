package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class quiz4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz4)

        val button: Button = findViewById(R.id.siguiente)

        button.setOnClickListener{
            var intent: Intent = Intent(this,NavigationActivity::class.java)
            startActivity(intent)
        }
    }
}