package equipo1.giffytasks

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import equipo1.giffytasks.databinding.ActivityQuiz2Binding
import equipo1.giffytasks.databinding.ActivityQuiz4Binding

class quiz4 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityQuiz4Binding
    private lateinit var databaseReference: DatabaseReference

    // Question
    private var respuesta14 = "empty"

    //regalo
    var regalo14 = "empty"

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuiz4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        val uid = auth.currentUser?.uid

        // ImageButton
        val notSelected = resources.getDrawable(R.drawable.border_image, theme)
        val selected = resources.getDrawable(R.drawable.border_image_selected, theme)

        recoverQuiz(uid, selected)

        // Pregunta 14
        var pony = binding.btnPony
        var peluches = binding.btnPeluche
        var ropa = binding.btnRopa
        var dinero = binding.btnDinero
        var joyas = binding.btnJoyas
        var perfume = binding.btnPerfume
        var tecno = binding.btnTecno
        var utiles = binding.btnUtiles
        var juegos = binding.btnJuegos
        var funkos = binding.btnFunkos
        var maquillaje = binding.btnMaquillaje
        var juegos_mesa = binding.btnJuegosMesa

        pony.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            pony.background = selected
            respuesta14 = "pony"
            regalo14 = "https://www.amazon.com.mx/My-Little-Pony-Generation-Princesa/dp/B08SSNP64N/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1DZIAD28TDZ0N&keywords=pony&qid=1652584005&sprefix=ponny%2Caps%2C241&sr=8-1"
        }
        peluches.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            peluches.background = selected
            respuesta14 = "peluches"
            regalo14 = "https://www.amazon.com.mx/mini-Peluche-Cerdito-Sentado-Dinosaurio/dp/B08LN8VGXG/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=263MB4MDW3JTR&keywords=peluche&qid=1652584021&sprefix=peluch%2Caps%2C176&sr=8-1"
        }
        ropa.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            ropa.background = selected
            respuesta14 = "ropa"
            regalo14 = "https://www.amazon.com.mx/AVEDISTANTE-Lavander%C3%ADa-Almacenamiento-Organizaci%C3%B3n-Compartimientos/dp/B07XLBWXPV/ref=sr_1_38?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=370BITDPL61CU&keywords=ropa&qid=1652584040&sprefix=r%2Caps%2C176&sr=8-38"
        }
        dinero.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            dinero.background = selected
            respuesta14 = "dinero"
            regalo14="https://www.amazon.com.mx/Dinero-Domina-juego-Tony-Robbins/dp/6077475025/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2G4WOX8W9NZQG&keywords=dinero&qid=1652584073&sprefix=dinero%2Caps%2C201&sr=8-1"

        }
        joyas.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            joyas.background = selected
            respuesta14 = "joyas"
            regalo14 = "https://www.amazon.com.mx/CHIFEI-Pulsera-Colgante-Cristal-Joyeria/dp/B07S6GC5W6/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=P1QAYT51KAQP&keywords=joyas&qid=1652584092&sprefix=joya%2Caps%2C160&sr=8-1"
        }
        perfume.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            perfume.background = selected
            respuesta14 = "perfume"
            regalo14 = "https://www.amazon.com.mx/ESIKA-Element/dp/B08B44RF9R/ref=sr_1_5?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=LM5KYR2P60V2&keywords=perfume&qid=1652584113&sprefix=perfume%2Caps%2C220&sr=8-5"
        }
        tecno.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            tecno.background = selected
            respuesta14 = "tecno"
            regalo14 = "https://www.amazon.com.mx/TXG-Bluetooth-Port%C3%A1til-Altavoces-Est%C3%A9reo/dp/B086HD1KRW/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1DIB5KLDXIH6L&keywords=bocina&qid=1652584147&sprefix=bocina%2Caps%2C177&sr=8-1"
        }
        utiles.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            utiles.background = selected
            respuesta14 = "utiles"
            regalo14 = "https://www.amazon.com.mx/MTQ-Escritura-Organizar-Ergon%C3%B3mico-Corrector/dp/B0893CNGX9/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1726A4RLTILW7&keywords=utiles&qid=1652584171&sprefix=utiles%2Caps%2C172&sr=8-1"
        }
        juegos.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            juegos.background = selected
            respuesta14 = "juegos"
            regalo14 = "https://www.amazon.com.mx/Elden-Ring-Standard-Playstation-5/dp/B097J32ZM9/ref=sr_1_2?keywords=elden+ring&qid=1652584191&sprefix=elde%2Caps%2C182&sr=8-2"
        }
        funkos.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            funkos.background = selected
            respuesta14 = "funkos"
            regalo14 = "https://www.amazon.com.mx/Funko-Pop-Animation-Brotherhood-Possiblity/dp/B09315VCY3/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3TC6ULPG9TRGV&keywords=funko&qid=1652584227&sprefix=funko%2Caps%2C174&sr=8-1"
        }
        maquillaje.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            maquillaje.background = selected
            respuesta14 = "maquillaje"
            regalo14="https://www.amazon.com.mx/Makeupbox-maquillaje-Profesionales-Aplicaci%C3%B3n-Firmes-100/dp/B079KJVLB2/ref=sr_1_4?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3SRYY5JD535KJ&keywords=maquillaje&qid=1652584239&sprefix=maquillaje%2Caps%2C172&sr=8-4"
        }
        juegos_mesa.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            juegos_mesa.background = selected
            respuesta14 = "juegos_mesa"
            regalo14 = "https://www.amazon.com.mx/Hasbro-Gaming-B7404-Risk-Nuevo/dp/B01HEQHKNM/ref=sr_1_26?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1PXAUH2MT68EU&keywords=juego+de+mesa&qid=1652584270&sprefix=juego+de+mes%2Caps%2C167&sr=8-26"
        }

        binding.siguiente.setOnClickListener {
            fillQuiz(respuesta14, regalo14)
        }
    }

    private fun recoverQuiz(uid: String?, selected: Drawable?) {
        var databaseReference = FirebaseDatabase.getInstance().getReference("users")
        if (uid != null) {
            databaseReference.child("user").child(uid).child("quiz").get().addOnSuccessListener { task ->
                if (task.exists()) {
                    val seleccion = task.child("seleccion").value.toString()
                    answer14(seleccion, selected)
                } else {
                    Toast.makeText(this, "No se recupero el quiz.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun answer14(seleccion: String, selected: Drawable?) {
        if (seleccion.equals("pony")) {
            binding.btnPony.background = selected
            respuesta14 = "pony"
            regalo14 = "https://www.amazon.com.mx/My-Little-Pony-Generation-Princesa/dp/B08SSNP64N/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1DZIAD28TDZ0N&keywords=pony&qid=1652584005&sprefix=ponny%2Caps%2C241&sr=8-1"
        } else if (seleccion.equals("peluches")) {
            binding.btnPeluche.background = selected
            respuesta14 = "peluches"
            regalo14 = "https://www.amazon.com.mx/mini-Peluche-Cerdito-Sentado-Dinosaurio/dp/B08LN8VGXG/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=263MB4MDW3JTR&keywords=peluche&qid=1652584021&sprefix=peluch%2Caps%2C176&sr=8-1"
        } else if (seleccion.equals("ropa")) {
            binding.btnRopa.background = selected
            respuesta14 = "ropa"
            regalo14 = "https://www.amazon.com.mx/AVEDISTANTE-Lavander%C3%ADa-Almacenamiento-Organizaci%C3%B3n-Compartimientos/dp/B07XLBWXPV/ref=sr_1_38?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=370BITDPL61CU&keywords=ropa&qid=1652584040&sprefix=r%2Caps%2C176&sr=8-38"
        } else if (seleccion.equals("dinero")) {
            binding.btnDinero.background = selected
            respuesta14 = "dinero"
            regalo14="https://www.amazon.com.mx/Dinero-Domina-juego-Tony-Robbins/dp/6077475025/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2G4WOX8W9NZQG&keywords=dinero&qid=1652584073&sprefix=dinero%2Caps%2C201&sr=8-1"
        } else if (seleccion.equals("joyas")) {
            binding.btnJoyas.background = selected
            respuesta14 = "joyas"
            regalo14 = "https://www.amazon.com.mx/CHIFEI-Pulsera-Colgante-Cristal-Joyeria/dp/B07S6GC5W6/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=P1QAYT51KAQP&keywords=joyas&qid=1652584092&sprefix=joya%2Caps%2C160&sr=8-1"
        } else if (seleccion.equals("perfume")) {
            binding.btnPerfume.background = selected
            respuesta14 = "perfume"
            regalo14 = "https://www.amazon.com.mx/ESIKA-Element/dp/B08B44RF9R/ref=sr_1_5?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=LM5KYR2P60V2&keywords=perfume&qid=1652584113&sprefix=perfume%2Caps%2C220&sr=8-5"
        } else if (seleccion.equals("tecno")) {
            binding.btnTecno.background = selected
            respuesta14 = "tecno"
            regalo14 = "https://www.amazon.com.mx/TXG-Bluetooth-Port%C3%A1til-Altavoces-Est%C3%A9reo/dp/B086HD1KRW/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1DIB5KLDXIH6L&keywords=bocina&qid=1652584147&sprefix=bocina%2Caps%2C177&sr=8-1"
        } else if (seleccion.equals("utiles")) {
            binding.btnUtiles.background = selected
            respuesta14 = "utiles"
            regalo14 = "https://www.amazon.com.mx/MTQ-Escritura-Organizar-Ergon%C3%B3mico-Corrector/dp/B0893CNGX9/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1726A4RLTILW7&keywords=utiles&qid=1652584171&sprefix=utiles%2Caps%2C172&sr=8-1"
        } else if (seleccion.equals("juegos")) {
            binding.btnJuegos.background = selected
            respuesta14 = "juegos"
            regalo14 = "https://www.amazon.com.mx/Elden-Ring-Standard-Playstation-5/dp/B097J32ZM9/ref=sr_1_2?keywords=elden+ring&qid=1652584191&sprefix=elde%2Caps%2C182&sr=8-2"
        } else if (seleccion.equals("funkos")) {
            binding.btnFunkos.background = selected
            respuesta14 = "funkos"
            regalo14 = "https://www.amazon.com.mx/Funko-Pop-Animation-Brotherhood-Possiblity/dp/B09315VCY3/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3TC6ULPG9TRGV&keywords=funko&qid=1652584227&sprefix=funko%2Caps%2C174&sr=8-1"
        } else if (seleccion.equals("maquillaje")) {
            binding.btnMaquillaje.background = selected
            respuesta14 = "maquillaje"
            regalo14="https://www.amazon.com.mx/Makeupbox-maquillaje-Profesionales-Aplicaci%C3%B3n-Firmes-100/dp/B079KJVLB2/ref=sr_1_4?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3SRYY5JD535KJ&keywords=maquillaje&qid=1652584239&sprefix=maquillaje%2Caps%2C172&sr=8-4"
        } else if (seleccion.equals("juegos_mesa")) {
            binding.btnJuegosMesa.background = selected
            respuesta14 = "juegos_mesa"
            regalo14 = "https://www.amazon.com.mx/Hasbro-Gaming-B7404-Risk-Nuevo/dp/B01HEQHKNM/ref=sr_1_26?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1PXAUH2MT68EU&keywords=juego+de+mesa&qid=1652584270&sprefix=juego+de+mes%2Caps%2C167&sr=8-26"
        }
    }

    private fun question14(pony: ImageButton, peluches: ImageButton, ropa: ImageButton, dinero: ImageButton,
                          perfume: ImageButton, tecno: ImageButton, utiles: ImageButton, juegos: ImageButton,
                          funkos: ImageButton, maquillaje: ImageButton, juegos_mesa: ImageButton, notSelected: Drawable) {
        pony.background = notSelected
        peluches.background = notSelected
        ropa.background = notSelected
        dinero.background = notSelected
        perfume.background = notSelected
        tecno.background = notSelected
        utiles.background = notSelected
        juegos.background = notSelected
        funkos.background = notSelected
        maquillaje.background = notSelected
        juegos_mesa.background = notSelected
    }

    private fun fillQuiz(pregunta15: String, regalo14: String) {
        val uid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        val taskMap: MutableMap<String, Any> = HashMap()
        taskMap["seleccion"] = pregunta15

        val taskRegalo : MutableMap<String, Any> = HashMap()
        taskRegalo["seleccion"] = regalo14
        if (uid != null) {
            databaseReference.child("user").child(uid).child("regalos")
                .updateChildren(taskRegalo).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        //todo bien
                    } else {
                        Toast.makeText(baseContext, "Fallo al registrar las respuestas.",
                            Toast.LENGTH_SHORT).show()
                    }
                }


            databaseReference.child("user").child(uid).child("quiz")
                .updateChildren(taskMap).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        var intent: Intent = Intent(this,NavigationActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(baseContext, "Fallo al registrar las respuestas.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}