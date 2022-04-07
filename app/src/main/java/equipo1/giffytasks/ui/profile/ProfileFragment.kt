package equipo1.giffytasks.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import equipo1.giffytasks.*
import equipo1.giffytasks.databinding.FragmentProfileBinding
import equipo1.giffytasks.ui.calendar.ProfileViewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val calendarViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

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

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}