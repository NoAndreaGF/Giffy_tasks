package equipo1.giffytasks.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import equipo1.giffytasks.*
import equipo1.giffytasks.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bin = FragmentHomeBinding.inflate(layoutInflater)
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val textView: TextView = binding.olvido

        val textView1: TextView = binding.invite

        textView.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), invite::class.java)
            startActivity(intent)
        }

        textView1.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), invite::class.java)
            startActivity(intent)
        }

        val imagenview: ImageView = binding.rectangleMensaje

        imagenview.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), messages::class.java)
            startActivity(intent)
        }

        val imageButton: ImageButton = binding.fotoRegalar

        imageButton.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), wishlist::class.java)
            startActivity(intent)
        }

        val textView2: TextView = binding.nombreRegalar

        textView2.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), wishlist::class.java)
            startActivity(intent)
        }

        val search: TextView = binding.searchFriend

        search.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), SearchFriendsActivity::class.java)
            startActivity(intent)
        }

        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}