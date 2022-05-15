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

    // Questions
    private var respuesta1 = "empty"
    private var respuesta2 = "empty"
    private var respuesta3 = "empty"
    private var respuesta4_c = "empty"
    private var respuesta4_p = "empty"
    private var respuesta4_z = "empty"

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

        var regalo1 = "empty"
        var regalo2 = "empty"
        var regalo3 = "empty"

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
            regalo1 = "https://www.amazon.com.mx/Guitarra-el%C3%A9ctrica-amplificador-Accesorios-Stratocaster/dp/B07LH7N6QC/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1OAIPWMRSJCLI&keywords=guitarra&qid=1652575468&sprefix=guitarr%2Caps%2C224&sr=8-1&ufe=app_do%3Aamzn1.fos.8a46d436-f8dd-421d-a49c-494b5d1632c6"

        }
        dibujar.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            dibujar.setTextColor(black)
            respuesta1 = "dibujar"
            regalo1 = "https://www.amazon.com.mx/Suministros-manualidades-borradores-adolescentes-principiantes/dp/B09MVZVJMY/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2DU1W6243P1ZT&keywords=l%C3%A1piz%2Bpara%2Bdibujar&qid=1652575499&sprefix=lapiz%2Bpara%2Bdibujar%2Caps%2C163&sr=8-1&th=1"

        }
        leer.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            leer.setTextColor(black)
            respuesta1 = "leer"
            regalo1 = "https://www.amazon.com.mx/Divina-comedia-Dante-Alighieri/dp/8420682888/ref=sr_1_2?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=33ULUV3V7S4YT&keywords=la+divina+comedia&qid=1652575533&sprefix=la+divina+comedi%2Caps%2C157&sr=8-2"
        }
        deporte.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            deporte.setTextColor(black)
            respuesta1 = "deporte"
            regalo1 = "https://www.amazon.com.mx/LUMOKU-gimnasio%EF%BC%8CMaleta-Compartimento-Impermeable-h%C3%BAmedo%EF%BC%8CBolso/dp/B09SHRBX9G/ref=sr_1_10?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1ZCI3MPNQ6AAD&keywords=deporte&qid=1652575570&sprefix=deporte%2Caps%2C171&sr=8-10&th=1"

        }
        cocinar.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            cocinar.setTextColor(black)
            respuesta1 = "cocinar"
            regalo1 = "https://www.amazon.com.mx/utensilios-Utensilios-resistentes-antiadherentes-inoxidable/dp/B08C7HBP6Q/ref=sr_1_7?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3DHEJZVUF59CH&keywords=cocina&qid=1652575602&sprefix=cocin%2Caps%2C166&sr=8-7"

        }
        peliculas.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            peliculas.setTextColor(black)
            respuesta1 = "peliculas"
            regalo1 = "https://www.amazon.com.mx/Br-Paquete-Lugar-Silencio-Blu-ray/dp/B09KP8X1YC/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2A9IJUVNP1YPL&keywords=peliculas&qid=1652575642&sprefix=peliculas%2Caps%2C166&sr=8-1"
        }
        jardineria.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            jardineria.setTextColor(black)
            respuesta1 = "jardineria"
            regalo1 = "https://www.amazon.com.mx/UKOKE-herramientas-almacenamiento-herramienta-intervensi%C3%B3n/dp/B06XHLQR6D/ref=sr_1_2?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=I1FRQPUPB32H&keywords=jardineria&qid=1652575677&sprefix=jardineria%2Caps%2C162&sr=8-2"

        }
        otro.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            otro.setTextColor(black)
            respuesta1 = "otro"
            regalo1 = "https://www.amazon.com.mx/Consola-PlayStation-5-Standard-Edition/dp/B09HTN51HN/ref=sr_1_3?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1TBB5JDSAV9M1&keywords=videojuegos&qid=1652575713&sprefix=videojuegos%2Caps%2C173&sr=8-3&ufe=app_do%3Aamzn1.fos.8a46d436-f8dd-421d-a49c-494b5d1632c6"
        }
        bailar.setOnClickListener {
            question1(musica, dibujar, leer, deporte, cocinar, peliculas, jardineria, otro,
                bailar, white)
            bailar.setTextColor(black)
            respuesta1 = "bailar"
            regalo1 = "https://www.amazon.com.mx/NEWKIBOU-Grabaci%C3%B3n-ySeguirte-Resplandor-el%C3%A9ctrico/dp/B09PDW31PW/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1YA72G2FW6YDW&keywords=bailar&qid=1652575742&sprefix=baila%2Caps%2C170&sr=8-1"
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
            regalo2="https://www.amazon.com.mx/Comida-Mexicana-Snacks-Tamales-Desserts/dp/1925811492/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=24CL1CMB1SOHZ&keywords=comida+mexicana&qid=1652576893&sprefix=comida+mexicana%2Caps%2C193&sr=8-1"

        }
        italiana.setOnClickListener {
            question2(mexicana, italiana, china, espaniola, suiza, rapida, white)
            italiana.setTextColor(black)
            respuesta2 = "italiana"
            regalo2= "https://www.amazon.com.mx/Jamie-Cocina-En-Italia-Italiana/dp/9502812158/ref=sr_1_1?keywords=comida+italiana&qid=1652576916&sprefix=comida+itali%2Caps%2C173&sr=8-1"
        }
        china.setOnClickListener {
            question2(mexicana, italiana, china, espaniola, suiza, rapida, white)
            china.setTextColor(black)
            respuesta2 = "china"
            regalo2 = "https://www.amazon.com.mx/Salsa-Siracha-Picante-Del-Gallito/dp/B015L53NGQ/ref=sr_1_3?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=38YUZA36IIG0Z&keywords=comida+china&qid=1652576940&sprefix=comida+china%2Caps%2C160&sr=8-3"

        }
        espaniola.setOnClickListener {
            question2(mexicana, italiana, china, espaniola, suiza, rapida, white)
            espaniola.setTextColor(black)
            respuesta2 = "espaniola"
            regalo2="https://www.amazon.com.mx/Comer-rezar-amar-Elizabeth-Gilbert/dp/6073134916/ref=sr_1_1?keywords=comida+espa%C3%B1ola&qid=1652576965&sprefix=comida+espa%C3%B1o%2Caps%2C175&sr=8-1"

        }
        suiza.setOnClickListener {
            question2(mexicana, italiana, china, espaniola, suiza, rapida, white)
            suiza.setTextColor(black)
            respuesta2 = "suiza"
            regalo2="https://www.amazon.com.mx/YOOYIST-Calentador-Derretimiento-Calefacci%C3%B3n-Antioxidante/dp/B08DKN5TPP/ref=sr_1_1?keywords=queso+suizo&qid=1652577159&sprefix=queso+sui%2Caps%2C162&sr=8-1&ufe=app_do%3Aamzn1.fos.8a46d436-f8dd-421d-a49c-494b5d1632c6"

        }
        rapida.setOnClickListener {
            question2(mexicana, italiana, china, espaniola, suiza, rapida, white)
            rapida.setTextColor(black)
            respuesta2 = "rapida"
            regalo2 = "https://www.amazon.com.mx/comida-r%C3%A1pida-soporte-cuadros-Vajilla/dp/B07KQMVBF7/ref=sr_1_5?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=G5YJWI6M467Y&keywords=comida%2Brapida&qid=1652577181&sprefix=comida%2Brapida%2Caps%2C156&sr=8-5&th=1"

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
            regalo3 = "ninguna"
        }
        rap.setOnClickListener {
            question3(ninguna, rap, pop, reggeaton, kpop, rock, white)
            rap.setTextColor(black)
            respuesta3 = "rap"
            regalo3 = "https://www.amazon.com.mx/Eminem-Show/dp/B00006690G/ref=sr_1_4?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=AYQDQ8B02NTF&keywords=eminem&qid=1652577237&sprefix=eminem%2Caps%2C168&sr=8-4"

        }
        pop.setOnClickListener {
            question3(ninguna, rap, pop, reggeaton, kpop, rock, white)
            pop.setTextColor(black)
            respuesta3 = "pop"
            regalo3 = "https://www.amazon.com.mx/Thriller-Michael-Jackson/dp/B00VSHH9GC/ref=sr_1_1?keywords=michael+jackson&qid=1652577272&sprefix=michael+j%2Caps%2C170&sr=8-1"

        }
        reggeaton.setOnClickListener {
            question3(ninguna, rap, pop, reggeaton, kpop, rock, white)
            reggeaton.setTextColor(black)
            respuesta3 = "reggeaton"
            regalo3 = "https://www.amazon.com.mx/Daddy-Yankee-Mundial-Importado/dp/B003AND1QY/ref=sr_1_2?keywords=daddy+yankee&qid=1652577290&sprefix=daddy+%2Caps%2C170&sr=8-2"

        }
        kpop.setOnClickListener {
            question3(ninguna, rap, pop, reggeaton, kpop, rock, white)
            kpop.setTextColor(black)
            respuesta3 = "kpop"
            regalo3 = "https://www.amazon.com.mx/STRAY-KIDS-FRANKENSTEIN-fotogr%C3%A1ficas-adicionales/dp/B09SFWRCSD/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1GIVG2A35WID9&keywords=kpop&qid=1652577317&sprefix=kpop%2Caps%2C182&sr=8-1"

        }
        rock.setOnClickListener {
            question3(ninguna, rap, pop, reggeaton, kpop, rock, white)
            rock.setTextColor(black)
            respuesta3 = "rock"
            regalo3 = "https://www.amazon.com.mx/Appetite-Destruction-Guns-N-Roses/dp/B000008GAC/ref=sr_1_1?keywords=guns+n+roses&qid=1652577366&sprefix=guns%2Caps%2C186&sr=8-1"

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
                fillQuiz(respuesta1, respuesta2, respuesta3, respuesta4_c, respuesta4_p, respuesta4_z,
                regalo1, regalo2, regalo3)
            }
        }

    }

    private fun recoverQuiz(uid: String?, black: Int) {
        var databaseReference = FirebaseDatabase.getInstance().getReference("users")
        if (uid != null) {
            databaseReference.child("user").child(uid).child("quiz").get().addOnSuccessListener { task ->
                if (task.exists()) {
                    val hobbie = task.child("hobbie").value.toString()
                    answer1(hobbie, black)
                    val comida = task.child("comida").value.toString()
                    answer2(comida, black)
                    val musica = task.child("musica").value.toString()
                    answer3(musica, black)
                    val camisa = task.child("camisa").value.toString()
                    binding.etCamiseta.setText(camisa)
                    respuesta4_c = camisa
                    val pantalon = task.child("pantalon").value.toString()
                    binding.etPantalon.setText(pantalon)
                    respuesta4_p = pantalon
                    val zapatos = task.child("zapatos").value.toString()
                    binding.etZapatos.setText(zapatos)
                    respuesta4_z = zapatos
                } else {
                    Toast.makeText(this, "No se recupero el quiz.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun answer1(hobbie: String, black: Int) {
            if (hobbie.equals("musica")) {
                binding.btnMusica.setTextColor(black)
                respuesta1 = "musica"
            } else if (hobbie.equals("dibujar")) {
                binding.btnDibujar.setTextColor(black)
                respuesta1 = "dibujar"
            } else if (hobbie.equals("leer")) {
                binding.btnLeer.setTextColor(black)
                respuesta1 = "leer"
            } else if (hobbie.equals("deporte")) {
                binding.btnDeporte.setTextColor(black)
                respuesta1 = "deporte"
            } else if (hobbie.equals("cocinar")) {
                binding.btnCocinar.setTextColor(black)
                respuesta1 = "cocinar"
            } else if (hobbie.equals("peliculas")) {
                binding.btnPeliculas.setTextColor(black)
                respuesta1 = "peliculas"
            } else if (hobbie.equals("jardineria")) {
                binding.btnJardineria.setTextColor(black)
                respuesta1 = "jardineria"
            } else if (hobbie.equals("otro")) {
                binding.btnOtro.setTextColor(black)
                respuesta1 = "otro"
            } else if (hobbie.equals("bailar")) {
                binding.btnBailar.setTextColor(black)
                respuesta1 = "bailar"
            }
        }

        private fun answer2(comida: String, black: Int) {
            if (comida.equals("mexicana")) {
                binding.btnMexicana.setTextColor(black)
                respuesta2 = "mexicana"
            } else if (comida.equals("italiana")) {
                binding.btnItaliana.setTextColor(black)
                respuesta2 = "italiana"
            } else if (comida.equals("china")) {
                binding.btnChina.setTextColor(black)
                respuesta2 = "china"
            } else if (comida.equals("espaniola")) {
                binding.btnEspaniola.setTextColor(black)
                respuesta2 = "espaniola"
            } else if (comida.equals("suiza")) {
                binding.btnSuiza.setTextColor(black)
                respuesta2 = "suiza"
            } else if (comida.equals("rapida")) {
                binding.btnRapida.setTextColor(black)
                respuesta2 = "rapida"
            }
        }

        private fun answer3(musica: String, black: Int) {
            if (musica.equals("ninguna")) {
                binding.btnNinguna.setTextColor(black)
                respuesta3 = "ninguna"
            } else if (musica.equals("rap")) {
                binding.btnRap.setTextColor(black)
                respuesta3 = "rap"
            } else if (musica.equals("pop")) {
                binding.btnPop.setTextColor(black)
                respuesta3 = "pop"
            } else if (musica.equals("reggeaton")) {
                binding.btnReggeaton.setTextColor(black)
                respuesta3 = "reggeaton"
            } else if (musica.equals("kpop")) {
                binding.btnKpop.setTextColor(black)
                respuesta3 = "kpop"
            } else if (musica.equals("rock")) {
                binding.btnRock.setTextColor(black)
                respuesta3 = "rock"
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
                         respuesta4_c: String, respuesta4_p: String, respuesta4_z: String, regalo1:String,
                            regalo2: String, regalo3: String) {
        val uid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        val taskMap: MutableMap<String, Any> = HashMap()
        val taskRegalo : MutableMap<String, Any> = HashMap()
        taskMap["hobbie"] = pregunta1
        taskMap["comida"] = pregunta2
        taskMap["musica"] = pregunta3
        taskMap["camisa"] = respuesta4_c
        taskMap["pantalon"] = respuesta4_p
        taskMap["zapatos"] = respuesta4_z

        taskRegalo["hobbie"] = regalo1
        taskRegalo["comida"] = regalo2
        taskRegalo["musica"] = regalo3
        if (uid != null) {
            databaseReference.child("user").child(uid).child("regalos")
                .updateChildren(taskRegalo).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        //todo bien, no pasa nada
                    } else {
                        Toast.makeText(baseContext, "Fallo al registrar respuestas.",
                            Toast.LENGTH_SHORT).show()
                    }
                }

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