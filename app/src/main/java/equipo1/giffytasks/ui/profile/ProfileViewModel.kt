package equipo1.giffytasks.ui.calendar

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class ProfileViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

    var databaseReference = FirebaseDatabase.getInstance().getReference("users")


    private val _name =MutableLiveData<String>().apply {
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid

        if (uid != null) {
            databaseReference.child("user").child(uid).get().addOnSuccessListener { task ->
                if (task.exists()) {
                    val nombre = task.child("nombre").value
                    value = nombre as String?
                    //binding.profileName.text = nombre.toString()
                } else {
                    //Toast.makeText(activity, "No se recupero el usuario.", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private val _image =MutableLiveData<Bitmap>().apply {
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid

        var storageRef = FirebaseStorage.getInstance().getReference("image/" + uid)

        val localFile = File.createTempFile("tempImage", "jpeg")

        if (uid != null) {
            storageRef.getFile(localFile).addOnSuccessListener {
                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                value = bitmap
                // binding.ivPerfil.setImageBitmap(bitmap)
            }.addOnFailureListener {
                //Toast.makeText(this@ProfileViewModel, "Imagen no cargada.", Toast.LENGTH_SHORT).show()
            }
            databaseReference.child("user").child(uid).get().addOnSuccessListener { task ->
                if (task.exists()) {
                    val nombre = task.child("nombre").value
                    //binding.profileName.text = nombre.toString()
                } else {
                    //Toast.makeText(activity, "No se recupero el usuario.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //val text: LiveData<String> = _name
    //val imagen: LiveData<Bitmap> = _image

}