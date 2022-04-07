package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button: Button = findViewById(R.id.siguiente)
        val olvido: TextView = findViewById(R.id.olvido)
        val registro: TextView = findViewById(R.id.registro)

        button.setOnClickListener{
            var intent: Intent = Intent(this,NavigationActivity::class.java)
            startActivity(intent)
        }
        olvido.setOnClickListener{
            var intent: Intent = Intent(this,forgot_password::class.java)
            startActivity(intent)
        }
        registro.setOnClickListener{
            var intent: Intent = Intent(this,register::class.java)
            startActivity(intent)
        }

    }
}