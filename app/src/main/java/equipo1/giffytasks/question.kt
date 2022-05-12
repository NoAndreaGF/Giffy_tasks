package equipo1.giffytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import equipo1.giffytasks.databinding.ActivityQuestionBinding

class question : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityQuestionBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        binding.btnQuiz.setOnClickListener{
            var intent: Intent = Intent(this,quiz::class.java)
            startActivity(intent)
        }

        binding.btnNoquiz.setOnClickListener{
            fillQuiz()
        }
    }

    private fun fillQuiz() {
        val uid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        val userQuiz = UserQuiz("empty", "empty", "empty", "empty",
            "empty", "empty", "empty", "empty", "empty",
            "empty", "empty", "empty", "empty", "empty",
            "empty")
        if (uid != null) {
            databaseReference.child("user").child(uid).child("quiz").setValue(userQuiz).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    var intent: Intent = Intent(this,NavigationActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(baseContext, "Fallo al registrar el quiz.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}