package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class menu : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        auth = Firebase.auth
        val textView: TextView = findViewById(R.id.btn_aboout_us)
        val textView1: TextView = findViewById(R.id.contact_us)
        val btnlogout: TextView = findViewById(R.id.btndesconectarse)

        textView.setOnClickListener {
            var intent: Intent = Intent(this, about_us::class.java)
            startActivity(intent)
        }
        textView1.setOnClickListener {
            var intent: Intent = Intent(this, contact::class.java)
            startActivity(intent)
        }
        btnlogout.setOnClickListener {
            Firebase.auth.signOut()
            var intent: Intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }
}