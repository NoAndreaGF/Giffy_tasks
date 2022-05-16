package equipo1.giffytasks.ui.profile

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract.CalendarCache.URI
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import com.google.firebase.storage.FirebaseStorage
import equipo1.giffytasks.*
import equipo1.giffytasks.databinding.FragmentProfileBinding
import equipo1.giffytasks.ui.calendar.ProfileViewModel
import equipo1.giffytasks.ui.home.HomeViewModel
import java.io.File

class ProfileFragment : Fragment(){

    private var _binding: FragmentProfileBinding? = null
    private lateinit var auth: FirebaseAuth
    var databaseReference = FirebaseDatabase.getInstance().getReference("users")
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
        //nombre del pasatiempo o regalo
        val producto1: ImageButton = binding.imageButton1
        val producto2: ImageButton = binding.imageButton2
        val producto3: ImageButton = binding.imageButton3
        val producto4: ImageButton = binding.imageButton4
        val producto5: ImageButton = binding.imageButton5
        val producto6: ImageButton = binding.imageButton6
        //se manda para que se le setee una wea a ver que sale
        abrirProducto(producto1, producto2, producto3, producto4, producto5, producto6)

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

    /*
    Esta clase permite abrir los links de los productos según el gusto del cliente
     */
    fun abrirProducto(producto1: ImageButton, producto2: ImageButton, producto3: ImageButton,
                      producto4: ImageButton, producto5: ImageButton, producto6: ImageButton){
        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        if (uid != null) {
            //aquí obtenemos los regalos de 'user'
            databaseReference.child("user").child(uid).child("regalos").get().addOnSuccessListener { task ->
                if (task.exists()) {
                    var color:String = task.child("color").value.toString()
                    producto1.setOnClickListener{
                        val uri = Uri.parse(color)
                        val intents = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intents)
                    }

                    var cultura:String = task.child("cultura_popular").value.toString()
                    producto2.setOnClickListener{
                        val uri = Uri.parse(cultura)
                        val intents = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intents)
                    }

                    var dulces: String = task.child("dulces").value.toString()
                    producto3.setOnClickListener{
                        val uri = Uri.parse(dulces)
                        val intents = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intents)
                    }
                    var flor_chocolate = task.child("flor_chocolate").value.toString()
                    producto4.setOnClickListener{
                        val uri = Uri.parse(flor_chocolate)
                        val intents = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intents)
                    }
                    var hobbie = task.child("hobbie").value.toString()
                    producto5.setOnClickListener{
                        val uri = Uri.parse(hobbie)
                        val intents = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intents)
                    }
                    var seleccion = task.child("seleccion").value.toString()
                    producto6.setOnClickListener{
                        val uri = Uri.parse(seleccion)
                        val intents = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intents)
                    }

                } else {
                    Toast.makeText(activity, "No se recupero.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}