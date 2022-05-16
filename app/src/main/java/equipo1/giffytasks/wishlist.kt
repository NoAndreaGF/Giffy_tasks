package equipo1.giffytasks

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import equipo1.giffytasks.databinding.ActivityAddFriendBinding
import equipo1.giffytasks.databinding.ActivityWishlistBinding
import java.io.File

class wishlist : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityWishlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWishlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        val uidUser = intent.getStringExtra("uid")
        val nombre = intent.getStringExtra("nombre")

        var databaseReference = FirebaseDatabase.getInstance().getReference("users")
        val localFile = File.createTempFile("tempImage", "jpeg")

        if((uidUser != null) && (nombre != null)){
            var storageRef = FirebaseStorage.getInstance().getReference("image/" + uidUser)

            storageRef.getFile(localFile).addOnSuccessListener {
                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                binding.ivPerfilUsuario.setImageBitmap(bitmap)
            }.addOnFailureListener {
                Toast.makeText(baseContext, "Imagen no cargada.", Toast.LENGTH_SHORT).show()
            }
            databaseReference.child("user").child(uidUser).get().addOnSuccessListener { task ->
                if (task.exists()) {
                    val nombre = task.child("nombre").value
                    binding.tvNombreUsuario.text = nombre.toString()
                } else {
                    Toast.makeText(baseContext, "No se recupero el usuario.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnAmigosAmigo.setOnClickListener{
            var intent = Intent(this,list_friend::class.java)
            intent.putExtra("nombre",  nombre)
            intent.putExtra("uid",  uidUser)
            startActivity(intent)
        }

        binding.quizAmigo.setOnClickListener{
            var intent = Intent(this,quiz_gift::class.java)
            intent.putExtra("nombre",  nombre)
            intent.putExtra("uid",  uidUser)
            startActivity(intent)
        }

        binding.btnOpcionesAmigo.setOnClickListener{
            var intent= Intent(this,options::class.java)
            intent.putExtra("nombre",  nombre)
            intent.putExtra("uid",  uidUser)
            startActivity(intent)
        }
    }
}