package equipo1.giffytasks.ui.calendar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
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
import equipo1.giffytasks.Event
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

        // Date
        var anio = "aaaa"
        var mes = "mm"
        var dia = "dd"

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val msg = "" + dayOfMonth + "/" + (month + 1) + "/" + year
            anio = year.toString()
            mes = month.toString()
            dia = dayOfMonth.toString()

            dateView.setText(msg)
            dateView.text = msg
        }

        btnregistrar.setOnClickListener {
            var fecha = dateView.getText() as String
            var evento = eventoTexto.getText().toString()
            if (TextUtils.isEmpty(fecha) or TextUtils.isEmpty(evento)) {
                Toast.makeText(
                    this@CalendarFragment.requireContext(),
                    "Ingrese la fecha del evento y nombre",
                    Toast.LENGTH_SHORT
                )
                    .show();

            } else {
                dates(anio, mes, dia, evento)
            }
        }
        return root
    }

    private fun dates(anio: String, mes: String, dia: String, fecha_evento: String) {
        val uid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().getReference("users")
        val evento = Event(anio, mes, dia, fecha_evento)
        if (uid != null) {
            databaseReference.child("user").child(uid).child("evento").push()
                .setValue(evento).addOnCompleteListener { task ->
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}