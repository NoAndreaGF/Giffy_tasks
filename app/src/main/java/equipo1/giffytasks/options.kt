package equipo1.giffytasks

import android.app.ActivityOptions
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import equipo1.giffytasks.databinding.ActivityListFriendBinding
import equipo1.giffytasks.databinding.ActivityOptionsBinding
import java.io.File

class options : AppCompatActivity() {
    private lateinit var binding: ActivityOptionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uidUser = intent.getStringExtra("uid")
        val nombre = intent.getStringExtra("nombre")

        var databaseReference = FirebaseDatabase.getInstance().getReference("users")
        val localFile = File.createTempFile("tempImage", "jpeg")

        if((uidUser != null) && (nombre != null)){
            var storageRef = FirebaseStorage.getInstance().getReference("image/" + uidUser)

            storageRef.getFile(localFile).addOnSuccessListener {
                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                binding.ivPerfilAmigo.setImageBitmap(bitmap)
            }.addOnFailureListener {
                Toast.makeText(baseContext, "Imagen no cargada.", Toast.LENGTH_SHORT).show()
            }
            databaseReference.child("user").child(uidUser).get().addOnSuccessListener { task ->
                if (task.exists()) {
                    val nombre = task.child("nombre").value
                    binding.tvNombreAmigo.text = nombre.toString()
                } else {
                    Toast.makeText(baseContext, "No se recupero el usuario.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}