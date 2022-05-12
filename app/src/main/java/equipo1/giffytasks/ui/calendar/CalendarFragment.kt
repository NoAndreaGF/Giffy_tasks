package equipo1.giffytasks.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import equipo1.giffytasks.R
import equipo1.giffytasks.databinding.FragmentCalendarBinding

class CalendarFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val calendarViewModel =
            ViewModelProvider(this).get(CalendarViewModel::class.java)

        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val calendarView: CalendarView = binding.calendarView
        val dateView: TextView = binding.date

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val msg = "Fecha de tu evento " + dayOfMonth + "/" + (month + 1) + "/" + year
            //Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            dateView.setText(msg)
            dateView.text = msg
        }

        return root
    }

    private lateinit var calendarView: CalendarView
    private lateinit var dateView: TextView

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