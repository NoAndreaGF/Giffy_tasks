package equipo1.giffytasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class contact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val button: Button = findViewById(R.id.volver)

        button.setOnClickListener{
            finish()
        }
    }
}