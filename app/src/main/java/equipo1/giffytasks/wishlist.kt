package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class wishlist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)

        val button: ImageButton = findViewById(R.id.quiz_amigo)

        button.setOnClickListener{
            var intent: Intent = Intent(this,quiz_gift::class.java)
            startActivity(intent)
        }
        val textView: TextView = findViewById(R.id.quiz_texto)

        textView.setOnClickListener{
            var intent: Intent = Intent(this,quiz_gift::class.java)
            startActivity(intent)
        }

        val imageButton: ImageButton = findViewById(R.id.configuracion)

        imageButton.setOnClickListener{
            var intent: Intent = Intent(this,options::class.java)
            startActivity(intent)
        }
    }
}