package equipo1.giffytasks

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import equipo1.giffytasks.databinding.ActivityAddFriendBinding
import java.io.File

class add_friend : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityAddFriendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddFriendBinding.inflate(layoutInflater)
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
        binding.btnAgregar.setOnClickListener {
            val myUid = auth.currentUser?.uid
            if ((uidUser != null ) && (myUid != null)) {
                val solicitud : MutableMap<String, Any> = HashMap()
                solicitud[myUid] = myUid

                databaseReference.child("user").child(uidUser).child("solicutudes")
                    .updateChildren(solicitud).addOnCompleteListener{ task ->
                    if (task.isCanceled) {
                        Toast.makeText(baseContext, "Fallo al enviar solicitud.",
                            Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(baseContext, "Solicitud enviada.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }
            val intent = Intent(baseContext, SearchFriendsActivity::class.java)
            startActivity(intent)
        }
    }
}