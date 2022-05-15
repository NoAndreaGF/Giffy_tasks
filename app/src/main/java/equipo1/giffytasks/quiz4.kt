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

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuiz4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Colors
        val black = resources.getColor(R.color.black, theme)
        val white = resources.getColor(R.color.white, theme)

        // ImageButton
        val notSelected = resources.getDrawable(R.drawable.border_image, theme)
        val selected = resources.getDrawable(R.drawable.border_image_selected, theme)


        // Question
        var respuesta14 = "empty"

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
        }
        peluches.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            peluches.background = selected
            respuesta14 = "peluches"
        }
        ropa.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            ropa.background = selected
            respuesta14 = "ropa"
        }
        dinero.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            dinero.background = selected
            respuesta14 = "dinero"
        }
        joyas.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            joyas.background = selected
            respuesta14 = "joyas"
        }
        perfume.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            perfume.background = selected
            respuesta14 = "perfume"
        }
        tecno.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            tecno.background = selected
            respuesta14 = "tecno"
        }
        utiles.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            utiles.background = selected
            respuesta14 = "utiles"
        }
        juegos.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            juegos.background = selected
            respuesta14 = "juegos"
        }
        funkos.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            funkos.background = selected
            respuesta14 = "funkos"
        }
        maquillaje.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            maquillaje.background = selected
            respuesta14 = "maquillaje"
        }
        juegos_mesa.setOnClickListener {
            question14(pony, peluches, ropa, dinero, perfume, tecno, utiles, juegos, funkos,
                maquillaje, juegos_mesa, notSelected)
            juegos_mesa.background = selected
            respuesta14 = "juegos_mesa"
        }

        binding.siguiente.setOnClickListener {
            fillQuiz(respuesta14)
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

    private fun fillQuiz(pregunta15: String) {
        val uid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        val taskMap: MutableMap<String, Any> = HashMap()
        taskMap["seleccion"] = pregunta15
        if (uid != null) {
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