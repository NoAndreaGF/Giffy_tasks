package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class quiz_gift : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_gift)

        val textView: TextView = findViewById(R.id.enviar)

        textView.setOnClickListener{
            var intent: Intent = Intent(this,product::class.java)
            startActivity(intent)
        }
    }
}