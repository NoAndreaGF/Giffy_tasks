package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import equipo1.giffytasks.databinding.ActivityLoginBinding

class login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.login.setOnClickListener{
            val mEmail = binding.etCorreo.text.toString()
            val mPassword = binding.etPassword.text.toString()

            when {
                mEmail.isEmpty() || mPassword.isEmpty()->{
                    Toast.makeText(baseContext, "Ingrese Correo y contraseña.",
                        Toast.LENGTH_SHORT).show()
                } else ->{
                SignIn(mEmail, mPassword)
            }
            }
        }
        binding.registro.setOnClickListener{
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        binding.olvido.setOnClickListener{
            val intent = Intent(this, forgot_password::class.java)
            startActivity(intent)
        }

    }

    private fun SignIn(email: String, password: String) {
        // we are using Google, Email-Password, and Phone Number based authentication

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "signInWithEmail:success")
                    readload()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Correo o contraseña incorrectos.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun readload() {
        val intent = Intent(this, quiz::class.java)
        //intent.putExtra("user", user)
        this.startActivity(intent)
    }
}