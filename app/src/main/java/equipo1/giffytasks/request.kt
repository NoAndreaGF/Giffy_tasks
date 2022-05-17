package equipo1.giffytasks

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
import equipo1.giffytasks.databinding.ActivityRequestBinding
import equipo1.giffytasks.databinding.ActivitySearchFriendsBinding

class request : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRequestBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var usersArrayList: ArrayList<User>
    private lateinit var picsArrayList: ArrayList<String>
    private lateinit var adapterRequest: AdaptadorRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.rvSolicitudes
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        usersArrayList = arrayListOf()
        picsArrayList = arrayListOf()

        adapterRequest = AdaptadorRequest(usersArrayList, picsArrayList)

        recyclerView.adapter = adapterRequest

        RequestsChangeListener()
    }

    private fun RequestsChangeListener() {
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        val uid = auth.currentUser?.uid

        if (uid != null) {
            println("Se ento al metodo y UID no es null")
            var databaseReference = FirebaseDatabase.getInstance().getReference("users")
            databaseReference.child("user").child(uid).child("solicutudes")
                .addValueEventListener(object: ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        println("Se recuperó las solicitudes")
                        if (snapshot.exists()) {
                            for (usuario in snapshot.children) {
                                val key = usuario.key.toString()
                                var db = FirebaseDatabase.getInstance().getReference("users")
                                db.child("user").child(key).get().addOnSuccessListener { task ->
                                    if (task.exists()) {
                                        var nombre = task.child("nombre").value.toString()
                                        usersArrayList.add(User(nombre, nombre, nombre, nombre, nombre, nombre, nombre, nombre))
                                        picsArrayList.add(key)
                                        adapterRequest.notifyDataSetChanged()
                                    }
                                    else {
                                        Toast.makeText(baseContext, "No tiene nombre.",
                                            Toast.LENGTH_SHORT).show()
                                    }
                                }.addOnFailureListener {
                                    Toast.makeText(baseContext, "No existe el usuario.",
                                        Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(baseContext, "No se recuperaron usuarios.",
                            Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}