package equipo1.giffytasks

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import equipo1.giffytasks.databinding.ActivityQuiz2Binding
import equipo1.giffytasks.databinding.ActivityQuiz3Binding

class quiz3 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityQuiz3Binding
    private lateinit var databaseReference: DatabaseReference

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuiz3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Colors
        val black = resources.getColor(R.color.black, theme)
        val white = resources.getColor(R.color.white, theme)

        // Questions
        var respuesta9 = "empty"
        var respuesta10 = "empty"
        var respuesta11 = "empty"
        var respuesta12 = "empty"
        var respuesta13 = "empty"

        // Pregunta 10
        var accion = binding.btnAccion
        var fantasia = binding.btnFantasia
        var scifi = binding.btnCiencia
        var comedia = binding.btnComedia
        var romance = binding.btnRomance
        var animadas = binding.btnAnimadas

        accion.setOnClickListener {
            question10(accion, fantasia, scifi, comedia, romance, animadas, white)
            accion.setTextColor(black)
            respuesta10= "accion"
        }
        fantasia.setOnClickListener {
            question10(accion, fantasia, scifi, comedia, romance, animadas, white)
            fantasia.setTextColor(black)
            respuesta10= "fantasia"
        }
        scifi.setOnClickListener {
            question10(accion, fantasia, scifi, comedia, romance, animadas, white)
            scifi.setTextColor(black)
            respuesta10= "scifi"
        }
        comedia.setOnClickListener {
            question10(accion, fantasia, scifi, comedia, romance, animadas, white)
            comedia.setTextColor(black)
            respuesta10= "comedia"
        }
        romance.setOnClickListener {
            question10(accion, fantasia, scifi, comedia, romance, animadas, white)
            romance.setTextColor(black)
            respuesta10= "romance"
        }
        animadas.setOnClickListener {
            question10(accion, fantasia, scifi, comedia, romance, animadas, white)
            animadas.setTextColor(black)
            respuesta10= "animadas"
        }

        // Pregunta 11
        var regalo = binding.btnRegalo
        var dinero = binding.btnDinero

        regalo.setOnClickListener {
            question11(regalo, dinero, white)
            regalo.setTextColor(black)
            respuesta11= "regalo"
        }
        dinero.setOnClickListener {
            question11(regalo, dinero, white)
            dinero.setTextColor(black)
            respuesta11= "dinero"
        }

        // Pregunta 12
        var starWars = binding.btnStarwars
        var marvel = binding.btnMarvel
        var dc = binding.btnDc
        var hp = binding.btnHarryPotter
        var nintendo = binding.btnNintendo
        var disney = binding.btnDisney
        var wwe = binding.btnWwe
        var simpson = binding.btnSimpson
        var silentHill = binding.btnSilentHill

        starWars.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            starWars.setTextColor(black)
            respuesta12= "starWars"
        }
        marvel.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            marvel.setTextColor(black)
            respuesta12= "marvel"
        }
        dc.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            dc.setTextColor(black)
            respuesta12= "dc"
        }
        hp.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            hp.setTextColor(black)
            respuesta12= "harry_potter"
        }
        nintendo.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            nintendo.setTextColor(black)
            respuesta12= "nintendo"
        }
        disney.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            disney.setTextColor(black)
            respuesta12= "disney"
        }
        wwe.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            wwe.setTextColor(black)
            respuesta12= "wwe"
        }
        simpson.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            simpson.setTextColor(black)
            respuesta12= "los_simpson"
        }
        silentHill.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            silentHill.setTextColor(black)
            respuesta12= "silent_hill"
        }

        // Pregunta 13
        var ropa = binding.btnRopa
        var comida = binding.btnComida
        var juguetes = binding.btnJuguetes

        ropa.setOnClickListener {
            question13(ropa, comida, juguetes, white)
            ropa.setTextColor(black)
            respuesta13= "ropa"
        }
        comida.setOnClickListener {
            question13(ropa, comida, juguetes, white)
            comida.setTextColor(black)
            respuesta13= "comida"
        }
        juguetes.setOnClickListener {
            question13(ropa, comida, juguetes, white)
            juguetes.setTextColor(black)
            respuesta13= "juguetes"
        }

        binding.siguiente.setOnClickListener {
            val mModelo = binding.etModelo.text.toString()

            if (!(mModelo.isEmpty())) {
                respuesta9 = mModelo
            } else if (respuesta10.equals("empty")) {
                Toast.makeText(this, "Seleccione un tipo de regalo.",
                    Toast.LENGTH_SHORT).show()
            } else if (respuesta11.equals("empty")) {
                Toast.makeText(this, "Seleccione un estampado.",
                    Toast.LENGTH_SHORT).show()
            } else if (respuesta12.equals("empty")) {
                Toast.makeText(this, "Seleccione un color.",
                    Toast.LENGTH_SHORT).show()
            } else if (respuesta13.equals("empty")) {
                Toast.makeText(this, "Seleccione un tipo de dulce.",
                    Toast.LENGTH_SHORT).show()
            } else{
                fillQuiz(respuesta9, respuesta10, respuesta11, respuesta12, respuesta13)
            }
        }

    }

    private fun question10(accion: Button, fantasia: Button, scifi: Button, comedia: Button,
                           romance: Button, animadas: Button, white: Int) {
        accion.setTextColor(white)
        fantasia.setTextColor(white)
        scifi.setTextColor(white)
        comedia.setTextColor(white)
        romance.setTextColor(white)
        animadas.setTextColor(white)
    }

    private fun question11(regalo: Button, dinero: Button, white: Int) {
        regalo.setTextColor(white)
        dinero.setTextColor(white)
    }

    private fun question12(starWars: Button, marvel: Button, dc: Button, hp: Button,
                           nintendo: Button, disney: Button, wwe: Button, simpson: Button,
                           silentHill: Button, white: Int) {
        starWars.setTextColor(white)
        marvel.setTextColor(white)
        dc.setTextColor(white)
        hp.setTextColor(white)
        nintendo.setTextColor(white)
        disney.setTextColor(white)
        wwe.setTextColor(white)
        simpson.setTextColor(white)
        silentHill.setTextColor(white)
    }

    private fun question13(ropa: Button, comida: Button, juguetes: Button, white: Int) {
        ropa.setTextColor(white)
        comida.setTextColor(white)
        juguetes.setTextColor(white)
    }

    private fun fillQuiz(pregunta9: String, pregunta10: String, pregunta11: String,
                         pregunta12: String, pregunta13: String) {
        val uid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        val taskMap: MutableMap<String, Any> = HashMap()
        taskMap["celular_modelo"] = pregunta9
        taskMap["genero_peliculas"] = pregunta10
        taskMap["regalo_dinero"] = pregunta11
        taskMap["cultura_popular"] = pregunta12
        taskMap["no_gusta"] = pregunta13
        if (uid != null) {
            databaseReference.child("user").child(uid).child("quiz")
                .updateChildren(taskMap).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        var intent: Intent = Intent(this,quiz4::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(baseContext, "Fallo al registrar las respuestas.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}