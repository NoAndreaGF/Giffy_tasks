package equipo1.giffytasks

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import equipo1.giffytasks.databinding.ActivityRegister2Binding
import java.text.SimpleDateFormat
import java.util.*

class register2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegister2Binding
    private lateinit var databaseReference: DatabaseReference
    private lateinit var imageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegister2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        var imagenSelec = false

        binding.ivPerfil.setOnClickListener {
            pickImageGallery()
            imagenSelec = true
        }

        binding.siguiente.setOnClickListener {
            val mNombre = binding.etNombre.text.toString()
            val mEdad = binding.etEdad.text.toString()
            val mSexo = binding.etSexo.text.toString()
            val mPais = binding.etPais.text.toString()
            val mIdioma = binding.etIdioma.text.toString()
            val mTel = binding.etTelefono.text.toString()
            val mDom = binding.etDom.text.toString()
            val mCP = binding.etCp.text.toString()

            if (mNombre.isEmpty()) {
                Toast.makeText(this, "Ingrese un nombre valido.",
                    Toast.LENGTH_SHORT).show()
            } else if (mEdad.isEmpty() ) {
                Toast.makeText(this, "Ingrese una edad valida.",
                    Toast.LENGTH_SHORT).show()
            } else if (mSexo.isEmpty()) {
                Toast.makeText(this, "Ingrese un sexo valido.",
                    Toast.LENGTH_SHORT).show()
            } else if (mPais.isEmpty()) {
                Toast.makeText(this, "Ingrese un país valida.",
                    Toast.LENGTH_SHORT).show()
            } else if (mIdioma.isEmpty()) {
                Toast.makeText(this, "Ingrese un idioma valido.",
                    Toast.LENGTH_SHORT).show()
            } else if (mTel.isEmpty() || !Patterns.PHONE.matcher(mTel).matches()) {
                Toast.makeText(this, "Ingrese un número de teléfono valido.",
                    Toast.LENGTH_SHORT).show()
            } else if (mDom.isEmpty()) {
                Toast.makeText(this, "Ingrese un domicilio valido.",
                    Toast.LENGTH_SHORT).show()
            } else if (mCP.isEmpty()) {
                Toast.makeText(this, "Ingrese un código postal valido.",
                    Toast.LENGTH_SHORT).show()
            } else if (!imagenSelec) {
                Toast.makeText(this, "Ingrese una imagen.",
                    Toast.LENGTH_SHORT).show()
            } else {
                uploadPic()
                fillProfile(mNombre, mEdad, mSexo, mPais, mIdioma, mTel, mDom, mCP)
            }
        }

    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK) {
            imageUri = data?.data!!
            binding.ivPerfil.setImageURI(imageUri)
        }
    }

    private fun fillProfile(nombre: String, edad: String, sexo: String, pais: String, idioma: String,
                            telefono: String, domicilio: String, cp: String) {
        val uid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        val user = User(nombre, edad, sexo, pais, idioma, telefono, domicilio, cp)
        if (uid != null) {
            databaseReference.child("user").child(uid).setValue(user).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    var intent: Intent = Intent(this,question::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(baseContext, "Fallo al registrar los datos.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun uploadPic() {
        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val fileName = formatter.format(now)
        val storageReference = FirebaseStorage.getInstance().getReference("image/" + auth.currentUser?.uid)

        storageReference.putFile(imageUri).
        addOnSuccessListener {
        } .addOnFailureListener {
            Toast.makeText(baseContext, "Imagen no subida.",
                Toast.LENGTH_SHORT).show()
        }
    }

    /**private fun uploadPic() {
        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val fileName = formatter.format(now)
        val storageReference = FirebaseStorage.getInstance().getReference("image/$fileName")

        storageReference.putFile(imageUri).
        addOnSuccessListener {
            Toast.makeText(baseContext, "Imagen subida correctamente.",
                Toast.LENGTH_SHORT).show()
        } .addOnFailureListener {
            Toast.makeText(baseContext, "Imagen no subida.",
                Toast.LENGTH_SHORT).show()
        }
    }**/
}