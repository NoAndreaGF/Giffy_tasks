package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class send_password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_password)

        val button: Button = findViewById(R.id.siguiente)


        button.setOnClickListener{
            var intent: Intent = Intent(this,login::class.java)
            startActivity(intent)
        }
    }
}