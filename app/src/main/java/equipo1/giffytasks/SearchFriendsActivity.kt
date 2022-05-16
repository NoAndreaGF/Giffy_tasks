package equipo1.giffytasks

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import equipo1.giffytasks.databinding.ActivitySearchFriendsBinding

class SearchFriendsActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySearchFriendsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var usersArrayList: ArrayList<User>
    private lateinit var picsArrayList: ArrayList<String>
    private lateinit var adapterUsers: AdapterUsers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchFriendsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.rvUsuarios
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        usersArrayList = arrayListOf()
        picsArrayList = arrayListOf()

        adapterUsers = AdapterUsers(usersArrayList, picsArrayList)

        recyclerView.adapter = adapterUsers

        UserChangeListener()
    }

    private fun UserChangeListener() {
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        var databaseReference = FirebaseDatabase.getInstance().getReference("users")
        databaseReference.child("user")
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (usuario in snapshot.children) {
                            val nombre = usuario.child("nombre").getValue().toString()
                            usersArrayList.add(User(nombre, nombre, nombre, nombre, nombre, nombre, nombre, nombre))
                            val key_imagen = usuario.key.toString()
                            picsArrayList.add(key_imagen)
                        }
                        adapterUsers.notifyDataSetChanged()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(baseContext, "No se recuperaron usuarios.",
                        Toast.LENGTH_SHORT).show()
                }
            })

    }
}