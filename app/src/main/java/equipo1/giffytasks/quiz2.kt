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

class quiz2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityQuiz2Binding
    private lateinit var databaseReference: DatabaseReference

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuiz2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Colors
        val black = resources.getColor(R.color.black, theme)
        val white = resources.getColor(R.color.white, theme)

        // Questions
        var respuesta5 = "empty"
        var respuesta6 = "empty"
        var respuesta7 = "empty"
        var respuesta8 = "empty"

        // Pregunta 5
        var regalos = binding.btnRegalos
        var comida = binding.btnComida

        regalos.setOnClickListener {
            question5(regalos, comida, white)
            regalos.setTextColor(black)
            respuesta5= "flores"
        }
        comida.setOnClickListener {
            question5(regalos, comida, white)
            comida.setTextColor(black)
            respuesta5= "chocolate"
        }

        // Pregunta 6
        var flores = binding.btnFlores
        var figuras = binding.btnFiguras
        var puntos = binding.btnPuntos

        // ImageButton
        val notSelected = resources.getDrawable(R.drawable.border_image, theme)
        val selected = resources.getDrawable(R.drawable.border_image_selected, theme)

        flores.setOnClickListener {
            flores.background = selected
            figuras.background = notSelected
            puntos.background = notSelected
            respuesta6 = "flores"
        }
        figuras.setOnClickListener {
            flores.background = notSelected
            figuras.background = selected
            puntos.background = notSelected
            respuesta6 = "figuras"
        }
        puntos.setOnClickListener {
            flores.background = notSelected
            figuras.background = notSelected
            puntos.background = selected
            respuesta6 = "puntos"
        }

        // Pregunta 7
        var rojo = binding.btnRojo
        var naranja = binding.btnNaranja
        var amarillo = binding.btnAmarillo
        var verde = binding.btnVerde
        var azul = binding.btnAzul
        var morado = binding.btnMorado
        var cafe = binding.btnCafe
        var negro = binding.btnNegro
        var blanco = binding.btnBlanco

        rojo.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            rojo.setTextColor(black)
            respuesta7 = "rojo"
        }
        naranja.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            naranja.setTextColor(black)
            respuesta7 = "naranja"
        }
        amarillo.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            amarillo.setTextColor(black)
            respuesta7 = "amarillo"
        }
        verde.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            verde.setTextColor(black)
            respuesta7 = "verde"
        }
        azul.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            azul.setTextColor(black)
            respuesta7 = "azul"
        }
        morado.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            morado.setTextColor(black)
            respuesta7 = "morado"
        }
        cafe.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            cafe.setTextColor(black)
            respuesta7 = "cafe"
        }
        negro.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            negro.setTextColor(black)
            respuesta7 = "negro"
        }
        blanco.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            blanco.setTextColor(black)
            respuesta7 = "blanco"
        }

        // Pregunta 8
        var chocolate = binding.btnChocolate
        var gomitas = binding.btnGomitas
        var chicles = binding.btnChicles
        var caramelo = binding.btnCaramelos
        var chile = binding.btnChile
        var frutas = binding.btnFrutas
        var tipicos = binding.btnTipicos
        var artesanales = binding.btnArtesanal
        var rellenos = binding.btnRellenos

        chocolate.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            chocolate.setTextColor(black)
            respuesta8 = "chocolate"
        }
        gomitas.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            gomitas.setTextColor(black)
            respuesta8 = "gomitas"
        }
        chicles.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            chicles.setTextColor(black)
            respuesta8 = "chicles"
        }
        caramelo.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            caramelo.setTextColor(black)
            respuesta8 = "caramelo"
        }
        chile.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            chile.setTextColor(black)
            respuesta8 = "chile"
        }
        frutas.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            frutas.setTextColor(black)
            respuesta8 = "frutas"
        }
        tipicos.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            tipicos.setTextColor(black)
            respuesta8 = "tipicos"
        }
        artesanales.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            artesanales.setTextColor(black)
            respuesta8 = "artesanales"
        }
        rellenos.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            rellenos.setTextColor(black)
            respuesta8 = "rellenos"
        }

        binding.siguiente.setOnClickListener {
            if (respuesta5.equals("empty")) {
                Toast.makeText(this, "Seleccione un tipo de regalo.",
                    Toast.LENGTH_SHORT).show()
            } else if (respuesta6.equals("empty")) {
                Toast.makeText(this, "Seleccione un estampado.",
                    Toast.LENGTH_SHORT).show()
            } else if (respuesta7.equals("empty")) {
                Toast.makeText(this, "Seleccione un color.",
                    Toast.LENGTH_SHORT).show()
            } else if (respuesta8.equals("empty")) {
                Toast.makeText(this, "Seleccione un tipo de dulce.",
                    Toast.LENGTH_SHORT).show()
            } else{
                fillQuiz(respuesta5, respuesta6, respuesta7, respuesta8)
            }
        }

    }

    private fun question5(regalos: Button, comida: Button, white: Int) {
        regalos.setTextColor(white)
        comida.setTextColor(white)
    }

    private fun question7(rojo: Button, naranja: Button, amarillo: Button, verde: Button,
                          azul: Button, morado: Button, cafe: Button, negro: Button, blanco: Button,
                          white: Int) {
        rojo.setTextColor(white)
        naranja.setTextColor(white)
        amarillo.setTextColor(white)
        verde.setTextColor(white)
        azul.setTextColor(white)
        morado.setTextColor(white)
        cafe.setTextColor(white)
        negro.setTextColor(white)
        blanco.setTextColor(white)
    }

    private fun question8(chocolate: Button, gomitas: Button, chicles: Button, caramelo: Button,
                          chile: Button, frutas: Button, tipicos: Button, artesanales: Button,
                          rellenos: Button, white: Int) {
        chocolate.setTextColor(white)
        gomitas.setTextColor(white)
        chicles.setTextColor(white)
        caramelo.setTextColor(white)
        chile.setTextColor(white)
        frutas.setTextColor(white)
        tipicos.setTextColor(white)
        artesanales.setTextColor(white)
        rellenos.setTextColor(white)
    }

    private fun fillQuiz(pregunta5: String, pregunta6: String, pregunta7: String,
                         pregunta8: String) {
        val uid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        val taskMap: MutableMap<String, Any> = HashMap()
        taskMap["flor_chocolate"] = pregunta5
        taskMap["estampado"] = pregunta6
        taskMap["color"] = pregunta7
        taskMap["dulces"] = pregunta8
        if (uid != null) {
            databaseReference.child("user").child(uid).child("quiz")
                .updateChildren(taskMap).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        var intent: Intent = Intent(this,quiz3::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(baseContext, "Fallo al registrar las respuestas.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

}