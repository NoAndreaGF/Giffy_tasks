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

    // Questions
    private var respuesta9 = "empty"
    private var respuesta10 = "empty"
    private var respuesta11 = "empty"
    private var respuesta12 = "empty"
    private var respuesta13 = "empty"

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuiz3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        val uid = auth.currentUser?.uid

        // Colors
        val black = resources.getColor(R.color.black, theme)
        val white = resources.getColor(R.color.white, theme)

        recoverQuiz(uid, black)

        //regalos
        var regalo10 = "empty"
        var regalo11 = "empty"
        var regalo12 = "empty"

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
            regalo10 = "https://www.amazon.com.mx/Br-Paquete-Rapidos-Furiosos-Blu-ray/dp/B09KP693D8/ref=sr_1_2?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1PECO7KGYS3VM&keywords=pel%C3%ADcula+de+accion&qid=1652582624&sprefix=pelicula+de+accion%2Caps%2C186&sr=8-2"

        }
        fantasia.setOnClickListener {
            question10(accion, fantasia, scifi, comedia, romance, animadas, white)
            fantasia.setTextColor(black)
            respuesta10= "fantasia"
            regalo10 = "https://www.amazon.com.mx/BR-GAME-THRONES-S-8-Blu-ray/dp/B07YBRR446/ref=sr_1_11?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2LMHZFTIW2Y9Q&keywords=pel%C3%ADcula+de+fantasia&qid=1652582640&sprefix=pel%C3%ADcula+de+fantasia%2Caps%2C177&sr=8-11"

        }
        scifi.setOnClickListener {
            question10(accion, fantasia, scifi, comedia, romance, animadas, white)
            scifi.setTextColor(black)
            respuesta10= "scifi"
            regalo10= "https://www.amazon.com.mx/Avatar-pel%C3%ADcula-ciencia-pulgadas-enrollado/dp/B09WLVJJDF/ref=sr_1_3?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3BYF1IZSFTGZG&keywords=pel%C3%ADcula+de+ciencia+ficcion&qid=1652582676&sprefix=pel%C3%ADcula+de+ciencia+ficcion%2Caps%2C150&sr=8-3"

        }
        comedia.setOnClickListener {
            question10(accion, fantasia, scifi, comedia, romance, animadas, white)
            comedia.setTextColor(black)
            respuesta10= "comedia"
            regalo10 = "https://www.amazon.com.mx/BIG-BANG-TEORY-S12-Blu-ray/dp/B07YBRHCVS/ref=sr_1_9?keywords=the+big+bang+theory&qid=1652582716&sprefix=the+big+ba%2Caps%2C158&sr=8-9"

        }
        romance.setOnClickListener {
            question10(accion, fantasia, scifi, comedia, romance, animadas, white)
            romance.setTextColor(black)
            respuesta10= "romance"
            regalo10 = "https://www.amazon.com.mx/Yo-Antes-Ti-Emilia-Clarke/dp/B01JOM6UW6/ref=sr_1_17?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=39I6V0CRIQ1IZ&keywords=pel%C3%ADcula+de+romance&qid=1652582760&sprefix=pelicula+de+romance%2Caps%2C160&sr=8-17"

        }
        animadas.setOnClickListener {
            question10(accion, fantasia, scifi, comedia, romance, animadas, white)
            animadas.setTextColor(black)
            respuesta10= "animadas"
            regalo10 = "https://www.amazon.com.mx/VILLANO-FAVORITO-BOXSET-blu_ray-Blu-ray/dp/B093J4FTS4/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3H0B58B4WJJKD&keywords=minions+dvd&qid=1652582786&sprefix=minions+dvd%2Caps%2C147&sr=8-1"

        }

        // Pregunta 11
        var regalo = binding.btnRegalo
        var dinero = binding.btnDinero

        regalo.setOnClickListener {
            question11(regalo, dinero, white)
            regalo.setTextColor(black)
            respuesta11= "regalo"
            regalo11 = "https://www.amazon.com.mx/Tarjeta-de-Regalo-Digital-Amazon-com-mx/dp/B07PMMFSPC/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2T3XT77B9ECZR&keywords=regalos&qid=1652582833&sprefix=regalo%2Caps%2C179&sr=8-1"
        }
        dinero.setOnClickListener {
            question11(regalo, dinero, white)
            dinero.setTextColor(black)
            respuesta11= "dinero"
            regalo11 = "https://www.amazon.com.mx/Redlemon-Seguridad-Cerradura-Registradora-Almacenamiento/dp/B09F8M5H5H/ref=sr_1_2?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3BGZSCK82X14H&keywords=dinero&qid=1652582808&sprefix=dinero%2Caps%2C176&sr=8-2"
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
            regalo12 = "https://www.amazon.com.mx/STAR-WARS-colecci%C3%B3n-Vintage-Juguete/dp/B09LVWTHDH/ref=sr_1_1?keywords=star+wars&qid=1652582868&sprefix=sta%2Caps%2C158&sr=8-1"

        }
        marvel.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            marvel.setTextColor(black)
            respuesta12= "marvel"
            regalo12 = "https://www.amazon.com.mx/Marvel-Legends-Coleccionable-Defender-Accesorios/dp/B09PVDMJ1D/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3AAJXM5TJ2JMF&keywords=marvel&qid=1652582901&sprefix=marvel%2Caps%2C160&sr=8-1"

        }
        dc.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            dc.setTextColor(black)
            respuesta12= "dc"
            regalo12 = "https://www.amazon.com.mx/DC-Universe-Master-Figura-Superman/dp/B07WGHZMH1?ref_=ast_sto_dp&th=1&psc=1"
        }
        hp.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            hp.setTextColor(black)
            respuesta12= "harry_potter"
            regalo12 = "https://www.amazon.com.mx/Harry-Potter-Box-Set-Books/dp/0545044251/ref=sr_1_2?keywords=harry+potter&qid=1652582985&sprefix=harr%2Cspecialty-aps%2C153&sr=8-2&ufe=app_do%3Aamzn1.fos.8a46d436-f8dd-421d-a49c-494b5d1632c6"

        }
        nintendo.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            nintendo.setTextColor(black)
            respuesta12= "nintendo"
            regalo12 = "https://www.amazon.com.mx/Nintendo-Consola-Switch-Neon-Version/dp/B07VGRJDFY/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=LBJ4ARPR0I7W&keywords=nintendo&qid=1652583009&sprefix=nintendo%2Caps%2C159&sr=8-1&ufe=app_do%3Aamzn1.fos.8a46d436-f8dd-421d-a49c-494b5d1632c6"

        }
        disney.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            disney.setTextColor(black)
            respuesta12= "disney"
            regalo12 = "https://www.amazon.com.mx/Disney-DCM-9-Mickey-Waffle-Maker/dp/B00QHUT7MO/ref=sr_1_6?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=36YXYR37S1WAI&keywords=disney&qid=1652583028&sprefix=disney%2Caps%2C159&sr=8-6"

        }
        wwe.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            wwe.setTextColor(black)
            respuesta12= "wwe"
            regalo12 = "https://www.amazon.com.mx/WWE-Elite-Collection-Action-Figure/dp/B09CFY7TC5/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&keywords=wwe&qid=1652583048&sr=8-1"

        }
        simpson.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            simpson.setTextColor(black)
            respuesta12= "los_simpson"
            regalo12 = "https://www.amazon.com.mx/1738-185-Simpsons-Homero-Colecci%C3%B3n-Cer%C3%A1mica/dp/B09H8KP2RQ/ref=sr_1_6?keywords=los+simpsons&qid=1652583061&sprefix=los+simp%2Caps%2C180&sr=8-6"

        }
        silentHill.setOnClickListener {
            question12(starWars, marvel, dc, hp, nintendo, disney, wwe, simpson, silentHill, white)
            silentHill.setTextColor(black)
            respuesta12= "silent_hill"
            regalo12 = "https://www.amazon.com.mx/Konami-Silent-Hill-Collection-PlayStation/dp/B0050SXAIG/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=27F6ABAHVK12P&keywords=silent+hill&qid=1652583084&sprefix=silent+hill%2Caps%2C177&sr=8-1"

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

            if (mModelo.isEmpty()) {
                Toast.makeText(this, "Ingrese una modelo de celular.",
                    Toast.LENGTH_SHORT).show()
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
                respuesta9 = mModelo
                fillQuiz(respuesta9, respuesta10, respuesta11, respuesta12, respuesta13,
                    regalo10, regalo11, regalo12)
            }
        }

    }

    private fun recoverQuiz(uid: String?, black: Int) {
        var databaseReference = FirebaseDatabase.getInstance().getReference("users")
        if (uid != null) {
            databaseReference.child("user").child(uid).child("quiz").get().addOnSuccessListener { task ->
                if (task.exists()) {
                    val celular_modelo = task.child("celular_modelo").value.toString()
                    binding.etModelo.setText(celular_modelo)
                    respuesta9 = celular_modelo
                    val genero_peliculas = task.child("genero_peliculas").value.toString()
                    answer10(genero_peliculas, black)
                    val regalo_dinero = task.child("regalo_dinero").value.toString()
                    answer11(regalo_dinero, black)
                    val cultura_popular = task.child("cultura_popular").value.toString()
                    answer12(cultura_popular, black)
                    val no_gusta = task.child("no_gusta").value.toString()
                    answer13(no_gusta, black)
                } else {
                    Toast.makeText(this, "No se recupero el quiz.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun answer10(generoPeliculas: String, black: Int) {
        if (generoPeliculas.equals("accion")) {
            binding.btnAccion.setTextColor(black)
            respuesta10 = "accion"
        } else if (generoPeliculas.equals("fantasia")) {
            binding.btnFantasia.setTextColor(black)
            respuesta10 = "fantasia"
        } else if (generoPeliculas.equals("scifi")) {
            binding.btnCiencia.setTextColor(black)
            respuesta10 = "scifi"
        } else if (generoPeliculas.equals("comedia")) {
            binding.btnComedia.setTextColor(black)
            respuesta10 = "comedia"
        } else if (generoPeliculas.equals("romance")) {
            binding.btnRomance.setTextColor(black)
            respuesta10 = "romance"
        } else if (generoPeliculas.equals("animadas")) {
            binding.btnAnimadas.setTextColor(black)
            respuesta10 = "animadas"
        }
    }

    private fun answer11(regaloDinero: String, black: Int) {
        if (regaloDinero.equals("regalo")) {
            binding.btnRegalo.setTextColor(black)
            respuesta11 = "regalo"
        } else if (regaloDinero.equals("dinero")) {
            binding.btnDinero.setTextColor(black)
            respuesta11 = "dinero"
        }
    }

    private fun answer12(culturaPopular: String, black: Int) {
        if (culturaPopular.equals("starWars")) {
            binding.btnStarwars.setTextColor(black)
            respuesta12 = "starWars"
        } else if (culturaPopular.equals("marvel")) {
            binding.btnMarvel.setTextColor(black)
            respuesta12 = "marvel"
        } else if (culturaPopular.equals("dc")) {
            binding.btnDc.setTextColor(black)
            respuesta12 = "dc"
        } else if (culturaPopular.equals("harry_potter")) {
            binding.btnHarryPotter.setTextColor(black)
            respuesta12 = "harry_potter"
        } else if (culturaPopular.equals("nintendo")) {
            binding.btnNintendo.setTextColor(black)
            respuesta12 = "nintendo"
        } else if (culturaPopular.equals("disney")) {
            binding.btnDisney.setTextColor(black)
            respuesta12 = "disney"
        } else if (culturaPopular.equals("wwe")) {
            binding.btnWwe.setTextColor(black)
            respuesta12 = "wwe"
        } else if (culturaPopular.equals("los_simpson")) {
            binding.btnSimpson.setTextColor(black)
            respuesta12 = "los_simpson"
        } else if (culturaPopular.equals("silent_hill")) {
            binding.btnSilentHill.setTextColor(black)
            respuesta12 = "silent_hill"
        }
    }

    private fun answer13(noGusta: String, black: Int) {
        if (noGusta.equals("ropa")) {
            binding.btnRopa.setTextColor(black)
            respuesta13 = "ropa"
        } else if (noGusta.equals("comida")) {
            binding.btnComida.setTextColor(black)
            respuesta13 = "comida"
        } else if (noGusta.equals("juguetes")) {
            binding.btnJuguetes.setTextColor(black)
            respuesta13 = "juguetes"
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
                         pregunta12: String, pregunta13: String, regalo10: String,
                            regalo11: String, regalo12: String) {
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        val taskMap: MutableMap<String, Any> = HashMap()
        taskMap["celular_modelo"] = pregunta9
        taskMap["genero_peliculas"] = pregunta10
        taskMap["regalo_dinero"] = pregunta11
        taskMap["cultura_popular"] = pregunta12
        taskMap["no_gusta"] = pregunta13

        val taskRegalo : MutableMap<String, Any> = HashMap()
        taskRegalo["genero_peliculas"] = regalo10
        taskRegalo["regalo_dinero"] = regalo11
        taskRegalo["cultura_popular"] = regalo12

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