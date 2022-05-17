package equipo1.giffytasks.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import equipo1.giffytasks.*
import equipo1.giffytasks.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentHomeBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var usersArrayList: ArrayList<User>
    private lateinit var picsArrayList: ArrayList<String>
    private lateinit var adapterFriends: AdapterFriends

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = binding.rvAmigos
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        usersArrayList = arrayListOf()
        picsArrayList = arrayListOf()

        adapterFriends = AdapterFriends(usersArrayList, picsArrayList)

        recyclerView.adapter = adapterFriends

        val layoutManager = GridLayoutManager(context, 3)
        recyclerView.setLayoutManager(layoutManager);

        UserChangeListener()

        val imagenview: ImageView = binding.rectangleMensaje

        imagenview.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), messages::class.java)
            startActivity(intent)
        }

        val search: Button = binding.searchFriend

        search.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), SearchFriendsActivity::class.java)
            startActivity(intent)
        }

        return root

    }

    private fun UserChangeListener() {
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        if (uid != null) {
            var databaseReference = FirebaseDatabase.getInstance().getReference("users")
            databaseReference.child("user").child(uid).child("amigos")
                .addValueEventListener(object: ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            for (usuario in snapshot.children) {
                                val key = usuario.key.toString()
                                var db = FirebaseDatabase.getInstance().getReference("users")
                                db.child("user").child(key).get().addOnSuccessListener { task ->
                                    if (task.exists()) {
                                        var nombre = task.child("nombre").value.toString()
                                        usersArrayList.add(User(nombre, nombre, nombre, nombre, nombre, nombre, nombre, nombre))
                                        picsArrayList.add(key)
                                        adapterFriends.notifyDataSetChanged()
                                    }
                                    else {
                                        Toast.makeText(activity, "No tiene nombre.",
                                            Toast.LENGTH_SHORT).show()
                                    }
                                }.addOnFailureListener {
                                    Toast.makeText(activity, "No existe el usuario.",
                                        Toast.LENGTH_SHORT).show()
                                }

                            }

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(activity, "No se recuperaron usuarios.",
                            Toast.LENGTH_SHORT).show()
                    }
                })
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}