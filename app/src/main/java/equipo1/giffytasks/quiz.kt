package equipo1.giffytasks

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import equipo1.giffytasks.databinding.ActivityQuizBinding

class quiz : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityQuizBinding
    private lateinit var databaseReference: DatabaseReference

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        val uid = auth.currentUser?.uid

        // Colors
        val black = resources.getColor(R.color.black, theme)
        val white = resources.getColor(R.color.white, theme)

        recoverQuiz(uid, black)

        // Questions
        var respuesta1 = "empty"
        var respuesta2 = "empty"
        var respuesta3 = "empty"
        var respuesta4_c = "empty"
        var respuesta4_p = "empty"
        var respuesta4_z = "empty"

        // Pregunta 1
        var musica = binding.btnMusica
        var dibujar = binding.btnDibujar
        var leer = binding.btnLeer
        var deporte = binding.btnDeporte
        var cocinar = binding.btnCocinar
        var peliculas = binding.btnPeliculas
        var jardineria = binding.btnJardineria
        var otro = binding.btnOtro
        var bailar = binding.btnBailar

        musica.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            musica.setTextColor(black)
            respuesta1 = "musica"

        }
        dibujar.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            dibujar.setTextColor(black)
            respuesta1 = "dibujar"
        }
        leer.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            leer.setTextColor(black)
            respuesta1 = "leer"
        }
        deporte.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            deporte.setTextColor(black)
            respuesta1 = "deporte"
        }
        cocinar.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            cocinar.setTextColor(black)
            respuesta1 = "cocinar"
        }
        peliculas.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            peliculas.setTextColor(black)
            respuesta1 = "peliculas"
        }
        jardineria.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            jardineria.setTextColor(black)
            respuesta1 = "jardineria"
        }
        otro.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            otro.setTextColor(black)
            respuesta1 = "otro"
        }
        bailar.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            bailar.setTextColor(black)
            respuesta1 = "bailar"
        }

        // Pregunta 2
        var mexicana = binding.btnMexicana
        var italiana = binding.btnItaliana
        var china = binding.btnChina
        var espaniola = binding.btnEspaniola
        var suiza = binding.btnSuiza
        var rapida = binding.btnRapida

        mexicana.setOnClickListener {
            question2(mexicana, italiana, china, espaniola, suiza, rapida, white)
            mexicana.setTextColor(black)
            respuesta2 = "mexicana"
        }
        italiana.setOnClickListener {
            question2(mexicana, italiana, china, espaniola, suiza, rapida, white)
            italiana.setTextColor(black)
            respuesta2 = "italiana"
        }
        china.setOnClickListener {
            question2(mexicana, italiana, china, espaniola, suiza, rapida, white)
            china.setTextColor(black)
            respuesta2 = "china"
        }
        espaniola.setOnClickListener {
            question2(mexicana, italiana, china, espaniola, suiza, rapida, white)
            espaniola.setTextColor(black)
            respuesta2 = "espaniola"
        }
        suiza.setOnClickListener {
            question2(mexicana, italiana, china, espaniola, suiza, rapida, white)
            suiza.setTextColor(black)
            respuesta2 = "suiza"
        }
        rapida.setOnClickListener {
            question2(mexicana, italiana, china, espaniola, suiza, rapida, white)
            rapida.setTextColor(black)
            respuesta2 = "rapida"
        }

        // Pregunta 3
        var ninguna = binding.btnNinguna
        var rap = binding.btnRap
        var pop = binding.btnPop
        var reggeaton = binding.btnReggeaton
        var kpop = binding.btnKpop
        var rock = binding.btnRock

        ninguna.setOnClickListener {
            question3(ninguna, rap, pop, reggeaton, kpop, rock, white)
            ninguna.setTextColor(black)
            respuesta3 = "ninguna"
        }
        rap.setOnClickListener {
            question3(ninguna, rap, pop, reggeaton, kpop, rock, white)
            rap.setTextColor(black)
            respuesta3 = "rap"
        }
        pop.setOnClickListener {
            question3(ninguna, rap, pop, reggeaton, kpop, rock, white)
            pop.setTextColor(black)
            respuesta3 = "pop"
        }
        reggeaton.setOnClickListener {
            question3(ninguna, rap, pop, reggeaton, kpop, rock, white)
            reggeaton.setTextColor(black)
            respuesta3 = "reggeaton"
        }
        kpop.setOnClickListener {
            question3(ninguna, rap, pop, reggeaton, kpop, rock, white)
            kpop.setTextColor(black)
            respuesta3 = "kpop"
        }
        rock.setOnClickListener {
            question3(ninguna, rap, pop, reggeaton, kpop, rock, white)
            rock.setTextColor(black)
            respuesta3 = "rock"
        }

        binding.siguiente2.setOnClickListener {
            val mCamisa = binding.etCamiseta.text.toString()
            val mPantalon = binding.etPantalon.text.toString()
            val mZapatos = binding.etZapatos.text.toString()

            if (mCamisa.isEmpty()) {
                Toast.makeText(this, "Ingrese una talla de camisa valida.",
                    Toast.LENGTH_SHORT).show()
            } else if (mPantalon.isEmpty()) {
                Toast.makeText(this, "Ingrese una talla de pantalon valido.",
                    Toast.LENGTH_SHORT).show()
            } else if (mZapatos.isEmpty()) {
                Toast.makeText(this, "Ingrese una talla de zapatos valido.",
                    Toast.LENGTH_SHORT).show()
            } else if (respuesta1.equals("empty")) {
                Toast.makeText(this, "Seleccione un hobbie.",
                    Toast.LENGTH_SHORT).show()
            } else if (respuesta2.equals("empty")) {
                Toast.makeText(this, "Seleccione un comida favorita.",
                    Toast.LENGTH_SHORT).show()
            } else if (respuesta3.equals("empty")) {
                Toast.makeText(this, "Seleccione un tipo de música.",
                    Toast.LENGTH_SHORT).show()
            } else{
                respuesta4_c = mCamisa
                respuesta4_p = mPantalon
                respuesta4_z = mZapatos
                fillQuiz(respuesta1, respuesta2, respuesta3, respuesta4_c, respuesta4_p, respuesta4_z)
            }
        }

    }

    private fun recoverQuiz(uid: String?, black: Int) {
        var databaseReference = FirebaseDatabase.getInstance().getReference("users")
        if (uid != null) {
            databaseReference.child("user").child(uid).child("quiz").get().addOnSuccessListener { task ->
                if (task.exists()) {
                    val hobbie = task.child("hobbie").value.toString()
                    if (hobbie.equals("cocinar")) {
                        binding.btnCocinar.setTextColor(black)
                    }
                    //binding.profileName.text = nombre.toString()
                } else {
                    Toast.makeText(this, "No se recupero el usuario.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun question1(musica: Button, dibujar: Button, leer: Button, deporte: Button,
                          cocinar: Button, peliculas: Button, jardineria: Button, otro: Button,
                          bailar: Button, white: Int) {
        musica.setTextColor(white)
        dibujar.setTextColor(white)
        leer.setTextColor(white)
        deporte.setTextColor(white)
        cocinar.setTextColor(white)
        peliculas.setTextColor(white)
        jardineria.setTextColor(white)
        otro.setTextColor(white)
        bailar.setTextColor(white)
    }

    private fun question2(mexicana: Button, italiana: Button, china: Button, espaniola: Button,
                          suiza: Button, rapida: Button, white: Int) {
        mexicana.setTextColor(white)
        italiana.setTextColor(white)
        china.setTextColor(white)
        espaniola.setTextColor(white)
        suiza.setTextColor(white)
        rapida.setTextColor(white)
    }

    private fun question3(ninguna: Button, rap: Button, pop: Button, reggeaton: Button,
                          kpop: Button, rock: Button, white: Int) {
        ninguna.setTextColor(white)
        rap.setTextColor(white)
        pop.setTextColor(white)
        reggeaton.setTextColor(white)
        kpop.setTextColor(white)
        rock.setTextColor(white)
    }

    private fun fillQuiz(pregunta1: String, pregunta2: String, pregunta3: String,
                         respuesta4_c: String, respuesta4_p: String, respuesta4_z: String) {
        val uid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        val taskMap: MutableMap<String, Any> = HashMap()
        taskMap["hobbie"] = pregunta1
        taskMap["comida"] = pregunta2
        taskMap["musica"] = pregunta3
        taskMap["camisa"] = respuesta4_c
        taskMap["pantalon"] = respuesta4_p
        taskMap["zapatos"] = respuesta4_z
        if (uid != null) {
            databaseReference.child("user").child(uid).child("quiz")
                .updateChildren(taskMap).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    var intent: Intent = Intent(this,quiz2::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(baseContext, "Fallo al registrar respuestas.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}