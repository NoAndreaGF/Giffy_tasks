package equipo1.giffytasks.ui.notifications

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.storage.FirebaseStorage
import equipo1.giffytasks.Event
import equipo1.giffytasks.MyAdapter
import equipo1.giffytasks.databinding.FragmentNotificationsBinding
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var eventArrayList: ArrayList<Event>
    private lateinit var myAdapter: MyAdapter
    private lateinit var auth: FirebaseAuth

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = binding.rvEventos
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        eventArrayList = arrayListOf()

        myAdapter = MyAdapter(eventArrayList)

        recyclerView.adapter = myAdapter

        EventChangeListener()

        return root
    }

    private fun EventChangeListener() {
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        var databaseReference = FirebaseDatabase.getInstance().getReference("users")
        val uid = auth.currentUser?.uid
        if (uid != null) {
            databaseReference.child("user").child(uid).child("evento")
                .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (evento in snapshot.children) {
                            val anio = evento.child("anio").getValue().toString()
                            val dia = evento.child("dia").getValue().toString()
                            val fecha_evento = evento.child("fecha_evento").getValue().toString()
                            val mes = evento.child("mes").getValue().toString()

                            eventArrayList.add(Event(anio, mes, dia, fecha_evento))
                        }
                        myAdapter.notifyDataSetChanged()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(activity, "No se recuperaron los eventos.",
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