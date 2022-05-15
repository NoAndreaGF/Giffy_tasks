package equipo1.giffytasks

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class forgot_password : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val mToolBar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        auth = Firebase.auth
        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        val button: Button = findViewById(R.id.siguiente)
        val emailAdress: TextView = findViewById(R.id.etcorreo)

        button.setOnClickListener{
                val userEmail = emailAdress.text.toString()
                if (TextUtils.isEmpty(userEmail)) {
                    Toast.makeText(
                        this@forgot_password,
                        "Por favor, ingrese el correo",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    auth.sendPasswordResetEmail(userEmail)
                        .addOnCompleteListener(OnCompleteListener<Void?> { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(
                                    this@forgot_password,
                                    "Correo enviado",
                                    Toast.LENGTH_LONG
                                ).show()
                                val loginIntent =
                                    Intent(this@forgot_password, send_password::class.java)
                                startActivity(loginIntent)
                            } else {
                                val message = task.exception.toString()
                                Toast.makeText(
                                    this@forgot_password,
                                    "Error: $message",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        })
                }
        }
    }
}