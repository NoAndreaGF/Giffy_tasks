package equipo1.giffytasks.ui.profile

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import equipo1.giffytasks.*
import equipo1.giffytasks.databinding.FragmentProfileBinding
import equipo1.giffytasks.ui.calendar.ProfileViewModel
import equipo1.giffytasks.ui.home.HomeViewModel
import java.io.File

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private lateinit var auth: FirebaseAuth

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        /**var databaseReference = FirebaseDatabase.getInstance().getReference("users")
        val uid = auth.currentUser?.uid

        var storageRef = FirebaseStorage.getInstance().getReference("image/" + uid)

        val localFile = File.createTempFile("tempImage", "jpeg")

        if (uid != null) {
            storageRef.getFile(localFile).addOnSuccessListener {
                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                binding.ivPerfil.setImageBitmap(bitmap)
            }.addOnFailureListener {
                Toast.makeText(activity, "Imagen no cargada.", Toast.LENGTH_SHORT).show()
            }
            databaseReference.child("user").child(uid).get().addOnSuccessListener { task ->
                if (task.exists()) {
                    val nombre = task.child("nombre").value
                    binding.profileName.text = nombre.toString()
                } else {
                    Toast.makeText(activity, "No se recupero el usuario.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }**/


        val profilePic: ImageView = binding.ivPerfil
        val name: TextView = binding.profileName
        profileViewModel.text.observe(viewLifecycleOwner) {
            name.text = it
        }
        profileViewModel.imagen.observe(viewLifecycleOwner) {
            profilePic.setImageBitmap(it)
        }

        val textView1: TextView = binding.button3
        textView1.setOnClickListener{
            val intent = Intent(this@ProfileFragment.requireContext(), menu::class.java)
            startActivity(intent)
        }

        val button: Button = binding.grupos

        button.setOnClickListener{
            val intent = Intent(this@ProfileFragment.requireContext(), my_group::class.java)
            startActivity(intent)
        }

        val button2: Button = binding.listas

        button2.setOnClickListener{
            val intent = Intent(this@ProfileFragment.requireContext(), my_list::class.java)
            startActivity(intent)
        }

        val imagenview: ImageView = binding.rectangleMensaje

        imagenview.setOnClickListener{
            val intent = Intent(this@ProfileFragment.requireContext(), messages::class.java)
            startActivity(intent)
        }

        val btn_quiz: Button = binding.quiz

        btn_quiz.setOnClickListener{
            val intent = Intent(this@ProfileFragment.requireContext(), quiz::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}