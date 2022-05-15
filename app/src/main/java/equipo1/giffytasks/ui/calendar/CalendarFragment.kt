package equipo1.giffytasks.ui.calendar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.firebase.ui.auth.AuthUI.getApplicationContext
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import equipo1.giffytasks.databinding.FragmentCalendarBinding
import equipo1.giffytasks.quiz2


class CalendarFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!
    private lateinit var databaseReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val calendarViewModel =
            ViewModelProvider(this).get(CalendarViewModel::class.java)
        auth = FirebaseAuth.getInstance()
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val calendarView: CalendarView = binding.calendarView
        val dateView: TextView = binding.date
        val btnregistrar: Button = binding.btnregistrar
        val eventoTexto: EditText = binding.etevento

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val msg = "" + dayOfMonth + "/" + (month + 1) + "/" + year
            dateView.setText(msg)
            dateView.text = msg
        }

        btnregistrar.setOnClickListener {
            var fecha = dateView.getText() as String
            var evento = eventoTexto.getText().toString()
            var fechaEvento = fecha + "-" + evento
            dates(fechaEvento)
        }
        return root
    }

    private lateinit var calendarView: CalendarView
    private lateinit var dateView: TextView
    var activity: Activity? = getActivity()

    private fun dates(text: String) {
        Toast.makeText(
            this@CalendarFragment.requireContext(),
            "Evento registrado",
            Toast.LENGTH_SHORT
        )
            .show();
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("users")
        if (uid != null) {
            databaseReference.child("user").child(uid).child("evento").push()
                .setValue(text.toString()).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this@CalendarFragment.requireContext(),
                            "Evento registrado",
                            Toast.LENGTH_SHORT
                        )
                            .show();
                    } else {
                        Toast.makeText(
                            this@CalendarFragment.requireContext(),
                            "Fallo al registrar evento",
                            Toast.LENGTH_SHORT
                        )
                            .show();
                    }
                }
        }
        //text.toString()
    }

    /**override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.fragment_calendar)
    calendarView = findViewById(R.id.calendarView)
    dateView = findViewById(R.id.date)
    calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
    val msg = "La fecha es " + dayOfMonth + "/" + (month + 1) + "/" + year
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    dateView.text= msg
    }
    }**/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}