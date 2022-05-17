package equipo1.giffytasks.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import equipo1.giffytasks.databinding.FragmentProfileBinding
import equipo1.giffytasks.databinding.FragmentStoresBinding
import equipo1.giffytasks.invite

class StoresFragment : Fragment() {

    private var _binding: FragmentStoresBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val storesViewModel =
            ViewModelProvider(this).get(StoresViewModel::class.java)
        _binding = FragmentStoresBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val producto1: ImageButton = binding.imageButton1
        val producto2: ImageButton = binding.imageButton2
        val producto3: ImageButton = binding.imageButton3
        val producto4: ImageButton = binding.imageButton4
        val producto5: ImageButton = binding.imageButton5
        val producto6: ImageButton = binding.imageButton6
        val producto7: ImageButton = binding.imageButton7
        val producto8: ImageButton = binding.imageButton8
        val producto9: ImageButton = binding.imageButton9
        //función donde se abren los links de los productos
        abrirProducto(producto1, producto2, producto3, producto4, producto5, producto6, producto7,
            producto8, producto9)

        val vermas1: TextView = binding.amazonVer
        val vermas2: TextView = binding.etMercadoLibre
        val vermas3: TextView = binding.etEbay
        verMas(vermas1, vermas2, vermas3)

        val buscar: EditText = binding.etSearch
        buscar.setOnFocusChangeListener { view, b ->
            if (b) {
                val uri = Uri.parse("https://www.amazon.com.mx/")
                val intents = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intents)
            }
        }

        //_binding = FragmentStoresBinding.inflate(inflater, container, false)
        //val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun abrirProducto(producto1: ImageButton,producto2: ImageButton, producto3: ImageButton,
                      producto4: ImageButton, producto5: ImageButton, producto6: ImageButton,
                      producto7: ImageButton, producto8: ImageButton, producto9: ImageButton){
       producto1.setOnClickListener{
           val uri = Uri.parse("https://www.amazon.com.mx/Adidas-Bal%C3%B3n-Top-Glider-Telstar/dp/B075LGNPYB/ref=sr_1_1?keywords=balon+de+futbol&qid=1652671466&sprefix=balon+de+%2Caps%2C164&sr=8-1")
           val intents = Intent(Intent.ACTION_VIEW, uri)
           startActivity(intents)
       }
       producto2.setOnClickListener{
           val uri = Uri.parse("https://www.amazon.com.mx/Gaser-Futbol-Original-Classic-Profesional/dp/B09CB8V9PN/ref=sr_1_5?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=M6QNT0Z4UW7D&keywords=balon+tamanaco&qid=1652672671&sprefix=balon+tamanaco%2Caps%2C165&sr=8-5")
           val intents = Intent(Intent.ACTION_VIEW, uri)
           startActivity(intents)
       }
        producto3.setOnClickListener{
            val uri = Uri.parse("https://www.amazon.com.mx/Gaser-Bal%C3%B3n-F%C3%BAtbol-Verde-Naranja/dp/B084HP81C6/ref=sr_1_3?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=JW1R2W4Z95IZ&keywords=balon+de+futbol+naranja&qid=1652672762&sprefix=balon+de+futbol+naranja%2Caps%2C192&sr=8-3")
            val intents = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intents)
        }
        producto4.setOnClickListener{
            val uri = Uri.parse("https://articulo.mercadolibre.com.mx/MLM-866595620-balon-molten-forza-f5g1500-5-f5g1500-_JM?searchVariation=73868064552#searchVariation=73868064552&position=1&search_layout=stack&type=item&tracking_id=26d7f8fd-968b-409e-b3aa-9b0380a39f48")
            val intents = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intents)
        }
        producto5.setOnClickListener{
            val uri = Uri.parse("https://articulo.mercadolibre.com.mx/MLM-1354789162-balon-de-futbol-nike-airlock-street-_JM?searchVariation=174005155480#searchVariation=174005155480&position=1&search_layout=grid&type=item&tracking_id=2c22538c-2f34-4c3c-ad49-0a818d3a712b")
            val intents = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intents)
        }
        producto6.setOnClickListener{
            val uri = Uri.parse("https://articulo.mercadolibre.com.mx/MLM-746108456-balon-futbol-adidas-blanco-num-5-champions-bayern-16-ap0398-_JM?searchVariation=48249955579#searchVariation=48249955579&position=16&search_layout=stack&type=item&tracking_id=f7a1185d-4914-46d6-9b27-97b376fa2112")
            val intents = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intents)
        }
        producto7.setOnClickListener{
            val uri = Uri.parse("https://www.ebay.com/itm/175263723217?hash=item28ce882ed1:g:TzsAAOSwe0FibY48")
            val intents = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intents)
        }
        producto8.setOnClickListener{
            val uri = Uri.parse("https://www.ebay.com/itm/185369914624?hash=item2b28e86d00:g:fmcAAOSwawNhp3A5")
            val intents = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intents)
        }
        producto9.setOnClickListener {
            val uri = Uri.parse("https://www.ebay.com/itm/324769759949?epid=9049200051&hash=item4b9dc942cd:g:yfUAAOSwvOhhKxRd")
            val intents = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intents)
        }
    }

    fun verMas(verAmazon: TextView, verMercadoLibre: TextView, verEbay: TextView){
        verAmazon.setOnClickListener{
            val uri = Uri.parse("https://www.amazon.com.mx/s?k=balones+futbol&sprefix=balones+fut%2Caps%2C199&ref=nb_sb_ss_retrain-deeppltr_2_11")
            val intents = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intents)
        }
        verMercadoLibre.setOnClickListener{
            val uri = Uri.parse("https://listado.mercadolibre.com.mx/balon-futbol#D[A:balon%20futbol]")
            val intents = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intents)
        }
        verEbay.setOnClickListener{
            val uri = Uri.parse("https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2334524.m570.l1313&_nkw=balon+futbol&_sacat=0&LH_TitleDesc=0&_odkw=balon+futbol+adidas&_osacat=0")
            val intents = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intents)
        }
    }
}