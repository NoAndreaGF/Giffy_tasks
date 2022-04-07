package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class forgot_password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val button: Button = findViewById(R.id.siguiente)


        button.setOnClickListener{
            var intent: Intent = Intent(this,send_password::class.java)
            startActivity(intent)
        }
    }
}