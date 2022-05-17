package equipo1.giffytasks

import android.content.Intent
import android.graphics.drawable.Drawable
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

class quiz2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityQuiz2Binding
    private lateinit var databaseReference: DatabaseReference

    // Questions
    private var respuesta5 = "empty"
    private var respuesta6 = "empty"
    private var respuesta7 = "empty"
    private var respuesta8 = "empty"

    private var regalo5 = "empty"
    private var regalo7 = "empty"
    private var regalo8 = "empty"

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuiz2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        val uid = auth.currentUser?.uid

        // Colors
        val black = resources.getColor(R.color.black, theme)
        val white = resources.getColor(R.color.white, theme)

        // ImageButton
        val notSelected = resources.getDrawable(R.drawable.border_image, theme)
        val selected = resources.getDrawable(R.drawable.border_image_selected, theme)

        recoverQuiz(uid, black, selected)

        //regalos
        var regalo6 = "empty"


        // Pregunta 5
        var regalos = binding.btnRegalos
        var comida = binding.btnComida

        regalos.setOnClickListener {
            question5(regalos, comida, white)
            regalos.setTextColor(black)
            respuesta5= "flores"
            regalo5 = "https://www.amazon.com.mx/PUBUNUS-Artificial-Elegante-Aniversario-Cumplea%C3%B1os/dp/B09TRBX1CX/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=JEJLQUVZYUE3&keywords=flores&qid=1652580514&sprefix=flores%2Caps%2C265&sr=8-1"

        }
        comida.setOnClickListener {
            question5(regalos, comida, white)
            comida.setTextColor(black)
            respuesta5= "chocolate"
            regalo5 = "https://www.amazon.com.mx/ESTUCHE-CHOCOLATES-FERRERO-RELLENO-AVELLANA/dp/B004VNCCEO/ref=sr_1_7?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=13M68LM0DN9P7&keywords=chocolate&qid=1652580570&sprefix=chocolate%2Caps%2C195&sr=8-7"
        }

        // Pregunta 6
        var flores = binding.btnFlores
        var figuras = binding.btnFiguras
        var puntos = binding.btnPuntos

        flores.setOnClickListener {
            flores.background = selected
            figuras.background = notSelected
            puntos.background = notSelected
            respuesta6 = "flores"
            regalo6 = "https://www.amazon.com.mx/estampado-reversible-cremallera-almohada-microfibra/dp/B07PJNG273/ref=sr_1_10?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=ALFOB9UBZLE6&keywords=estampado+de+flores&qid=1652580652&sprefix=estampado+de+flore%2Caps%2C173&sr=8-10"

        }
        figuras.setOnClickListener {
            flores.background = notSelected
            figuras.background = selected
            puntos.background = notSelected
            respuesta6 = "figuras"
            regalo6 = "https://www.amazon.com.mx/Maui-Sons-Multicolor-Estampado-Figuras/dp/B08BPHQXHW/ref=sr_1_11?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1PLU11G5JSYCD&keywords=estampado+de+figuras&qid=1652580682&sprefix=estampado+de+figuras%2Caps%2C180&sr=8-11"

        }
        puntos.setOnClickListener {
            flores.background = notSelected
            figuras.background = notSelected
            puntos.background = selected
            respuesta6 = "puntos"
            regalo6 = "https://www.amazon.com.mx/Daily-Ritual-Estampado-Abstracto-Lunares/dp/B08JNTFX52/ref=sr_1_41?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2NTUEM085BAB3&keywords=estampado+de+puntos&qid=1652580706&sprefix=estampado+de+punto%2Caps%2C134&sr=8-41"

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
            regalo7 = "https://www.amazon.com.mx/T-fal-Freidora-Capacidad-Porciones-Personas/dp/B096HD6LX7/ref=sr_1_32?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2XECLMO98CPY7&keywords=rojo&qid=1652580738&sprefix=rojo%2Caps%2C156&sr=8-32"

        }
        naranja.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            naranja.setTextColor(black)
            respuesta7 = "naranja"
            regalo7 = "https://www.amazon.com.mx/CubreBocas-Tapabocas-Termosellado-cubreboca-mascarilla/dp/B0929FXJYV/ref=sr_1_6?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2O4KMN6OT6O72&keywords=naranja&qid=1652580827&sprefix=naranja%2Caps%2C166&sr=8-6"

        }
        amarillo.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            amarillo.setTextColor(black)
            respuesta7 = "amarillo"
            regalo7= "https://www.amazon.com.mx/CUBREBOCAS-PLIEGOS-EL%C3%81STICO-AMARILLO-CAJA/dp/B08ZB69Z53/ref=sr_1_24?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1AJEABB7LKTU2&keywords=amarillo&qid=1652580853&sprefix=amarillo%2Caps%2C157&sr=8-24"

        }
        verde.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            verde.setTextColor(black)
            respuesta7 = "verde"
            regalo7 = "https://www.amazon.com.mx/Minecraft-Gorra-b%C3%A9isbol-Snapback-j%C3%B3venes/dp/B09KZQCTZX/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=19QC6HKDN0NRJ&keywords=verde&qid=1652580883&sprefix=verde%2Caps%2C187&sr=8-1"

        }
        azul.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            azul.setTextColor(black)
            respuesta7 = "azul"
            regalo7 = "https://www.amazon.com.mx/Best-Trading-Cubrebocas-Termosellado-Protecci%C3%B3n/dp/B093QBYJ8Y/ref=sr_1_14?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1IRWI1CSLPT82&keywords=azul&qid=1652580921&sprefix=azul%2Caps%2C168&sr=8-14"

        }
        morado.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            morado.setTextColor(black)
            respuesta7 = "morado"
            regalo7 = "https://www.amazon.com.mx/Best-Trading-Cubrebocas-Termosellado-Protecci%C3%B3n/dp/B092PV58TC/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1QQTMU4QQT01Y&keywords=morado&qid=1652580960&sprefix=morado%2Caps%2C155&sr=8-1"
        }
        cafe.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            cafe.setTextColor(black)
            respuesta7 = "cafe"
            regalo7 = "https://www.amazon.com.mx/Nescaf%C3%A9-Clasico-Caf%C3%A9-Sol-225/dp/B07NTVCSDS/ref=sr_1_6?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1NS10BAUJ5KD9&keywords=cafe&qid=1652581039&sprefix=caf%2Caps%2C178&sr=8-6"

        }
        negro.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            negro.setTextColor(black)
            respuesta7 = "negro"
            regalo7 = "https://www.amazon.com.mx/Hanes-Playera-cuelllo-P2-Negro/dp/B09NQLFPTY/ref=sr_1_20?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=8C9I8TDM9IET&keywords=negro&qid=1652581066&s=amazon-super&sprefix=negro%2Cspecialty-aps%2C141&sr=8-20&srs=18073069011&th=1"

        }
        blanco.setOnClickListener {
            question7(rojo, naranja, amarillo, verde, azul, morado, cafe, negro, blanco, white)
            blanco.setTextColor(black)
            respuesta7 = "blanco"
            regalo7 = "https://www.amazon.com.mx/Hanes-Playera-Redondo-Caballero-Unidades/dp/B01DZTJBLQ/ref=sr_1_2?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=FA81NSHTZWEN&keywords=blanco&qid=1652581132&s=amazon-super&sprefix=blanco%2Cspecialty-aps%2C139&sr=8-2&srs=18073069011"

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
            regalo8 = "https://www.amazon.com.mx/Chocolate-Leche-Hersheys-Kisses-809/dp/B08ZXH2CY1/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3FUTRFW2BXUN0&keywords=kisses&qid=1652581197&sprefix=kisses%2Caps%2C187&sr=8-1"

        }
        gomitas.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            gomitas.setTextColor(black)
            respuesta8 = "gomitas"
            regalo8 = "https://www.amazon.com.mx/Gen%C3%A9rico-Gomitas-Panditas-Clasicas-Dulcigomas/dp/B087Z2MPT1/ref=sr_1_2?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=281FS3JZKAN4M&keywords=gomitas&qid=1652581212&sprefix=gomitas%2Caps%2C166&sr=8-2"

        }
        chicles.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            chicles.setTextColor(black)
            respuesta8 = "chicles"
            regalo8 = "https://www.amazon.com.mx/Trident-4S-Menta-208-Gramos/dp/B08C3KG47T/ref=sr_1_2?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=QG1XOQ76KQ60&keywords=chicles&qid=1652581253&sprefix=chicle%2Caps%2C168&sr=8-2&th=1"
        }
        caramelo.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            caramelo.setTextColor(black)
            respuesta8 = "caramelo"
            regalo8 = "https://www.amazon.com.mx/Starbucks-Crema-L%C3%ADquida-Caramel-Macchiato/dp/B07VTDSZPH/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=13M8WSTAJLA38&keywords=caramelo&qid=1652581305&sprefix=caramelo%2Caps%2C175&sr=8-1"

        }
        chile.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            chile.setTextColor(black)
            respuesta8 = "chile"
            regalo8 = "https://www.amazon.com.mx/Paquete-Picantes-Botanas-Surtidas-Enchilados/dp/B09DS1SXZB/ref=sr_1_4?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3ENBE2S800RRP&keywords=dulce+de+chile&qid=1652581341&sprefix=dulce+de+chile%2Caps%2C162&sr=8-4"

        }
        frutas.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            frutas.setTextColor(black)
            respuesta8 = "frutas"
            regalo8 = "https://www.amazon.com.mx/Hi-Chew-Sensationally-Chewy-dulces-japonesa/dp/B07RZ3NX7J/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=24FOXZ3PAOBW3&keywords=dulces+de+frutas&qid=1652581359&sprefix=dulces+de+fruta%2Caps%2C159&sr=8-1"

        }
        tipicos.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            tipicos.setTextColor(black)
            respuesta8 = "tipicos"
            regalo8 = "https://www.amazon.com.mx/Las-Sevillanas-palanqueta-mazapanes-natillas/dp/B08HJ7NHFM/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3C1TKKSD9LJMA&keywords=dulces+tipicos&qid=1652581388&sprefix=dulces+tipicos%2Caps%2C165&sr=8-1"

        }
        artesanales.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            artesanales.setTextColor(black)
            respuesta8 = "artesanales"
            regalo8 = "https://www.amazon.com.mx/B%C3%ABfi-D%C3%A4nsu-palanquetas-cristalizada-tradicionales/dp/B093B5NTPL/ref=sr_1_2?keywords=dulces+artesanales&qid=1652581415&sprefix=dulces+artesan%2Caps%2C152&sr=8-2"

        }
        rellenos.setOnClickListener {
            question8(chocolate, gomitas, chicles, caramelo, chile, frutas, tipicos, artesanales,
                rellenos, white)
            rellenos.setTextColor(black)
            respuesta8 = "rellenos"
            regalo8 = "https://www.amazon.com.mx/Toffees-Caramelos-rellenos-Amaretto-Rompope/dp/B09LC2SSM5/ref=sr_1_3?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2ZROXGXN4FK4C&keywords=dulces+rellenos&qid=1652581522&sprefix=dulces+relleno%2Caps%2C155&sr=8-3"

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
                fillQuiz(respuesta5, respuesta6, respuesta7, respuesta8,regalo5, regalo6,regalo7,
                    regalo8)
            }
        }
    }

    private fun recoverQuiz(uid: String?, black: Int, selected: Drawable) {
        var databaseReference = FirebaseDatabase.getInstance().getReference("users")
        if (uid != null) {
            databaseReference.child("user").child(uid).child("quiz").get().addOnSuccessListener { task ->
                if (task.exists()) {
                    val flor_chocolate = task.child("flor_chocolate").value.toString()
                    answer5(flor_chocolate, black)
                    val estampado = task.child("estampado").value.toString()
                    answer6(estampado, selected)
                    val color = task.child("color").value.toString()
                    answer7(color, black)
                    val dulces = task.child("dulces").value.toString()
                    answer8(dulces, black)
                } else {
                    Toast.makeText(this, "No se recupero el quiz.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun answer5(florChocolate: String, black: Int) {
        println(florChocolate)
        if (florChocolate.equals("flores")) {
            binding.btnRegalos.setTextColor(black)
            respuesta5 = "flores"
            regalo5 = "https://www.amazon.com.mx/PUBUNUS-Artificial-Elegante-Aniversario-Cumplea%C3%B1os/dp/B09TRBX1CX/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=JEJLQUVZYUE3&keywords=flores&qid=1652580514&sprefix=flores%2Caps%2C265&sr=8-1"
        } else if (florChocolate.equals("chocolate")) {
            binding.btnComida.setTextColor(black)
            respuesta5 = "chocolate"
            regalo5 = "https://www.amazon.com.mx/ESTUCHE-CHOCOLATES-FERRERO-RELLENO-AVELLANA/dp/B004VNCCEO/ref=sr_1_7?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=13M68LM0DN9P7&keywords=chocolate&qid=1652580570&sprefix=chocolate%2Caps%2C195&sr=8-7"
        }
    }

    private fun answer6(estampado: String, selected: Drawable) {
        if (estampado.equals("flores")) {
            binding.btnFlores.background = selected
            respuesta6 = "flores"
        } else if (estampado.equals("figuras")) {
            binding.btnFiguras.background = selected
            respuesta6 = "figuras"
        } else if (estampado.equals("puntos")) {
            binding.btnPuntos.background = selected
            respuesta6 = "puntos"
        }
    }

    private fun answer7(color: String, black: Int) {
        if (color.equals("rojo")) {
            binding.btnRojo.setTextColor(black)
            respuesta7 = "rojo"
            regalo7 = "https://www.amazon.com.mx/T-fal-Freidora-Capacidad-Porciones-Personas/dp/B096HD6LX7/ref=sr_1_32?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2XECLMO98CPY7&keywords=rojo&qid=1652580738&sprefix=rojo%2Caps%2C156&sr=8-32"
        } else if (color.equals("naranja")) {
            binding.btnNaranja.setTextColor(black)
            respuesta7 = "naranja"
            regalo7 = "https://www.amazon.com.mx/CubreBocas-Tapabocas-Termosellado-cubreboca-mascarilla/dp/B0929FXJYV/ref=sr_1_6?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2O4KMN6OT6O72&keywords=naranja&qid=1652580827&sprefix=naranja%2Caps%2C166&sr=8-6"
        } else if (color.equals("amarillo")) {
            binding.btnAmarillo.setTextColor(black)
            respuesta7 = "amarillo"
            regalo7= "https://www.amazon.com.mx/CUBREBOCAS-PLIEGOS-EL%C3%81STICO-AMARILLO-CAJA/dp/B08ZB69Z53/ref=sr_1_24?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1AJEABB7LKTU2&keywords=amarillo&qid=1652580853&sprefix=amarillo%2Caps%2C157&sr=8-24"
        } else if (color.equals("verde")) {
            binding.btnVerde.setTextColor(black)
            respuesta7 = "verde"
            regalo7 = "https://www.amazon.com.mx/Minecraft-Gorra-b%C3%A9isbol-Snapback-j%C3%B3venes/dp/B09KZQCTZX/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=19QC6HKDN0NRJ&keywords=verde&qid=1652580883&sprefix=verde%2Caps%2C187&sr=8-1"
        } else if (color.equals("azul")) {
            binding.btnAzul.setTextColor(black)
            respuesta7 = "azul"
            regalo7 = "https://www.amazon.com.mx/Best-Trading-Cubrebocas-Termosellado-Protecci%C3%B3n/dp/B093QBYJ8Y/ref=sr_1_14?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1IRWI1CSLPT82&keywords=azul&qid=1652580921&sprefix=azul%2Caps%2C168&sr=8-14"
        } else if (color.equals("morado")) {
            binding.btnMorado.setTextColor(black)
            respuesta7 = "morado"
            regalo7 = "https://www.amazon.com.mx/Best-Trading-Cubrebocas-Termosellado-Protecci%C3%B3n/dp/B092PV58TC/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1QQTMU4QQT01Y&keywords=morado&qid=1652580960&sprefix=morado%2Caps%2C155&sr=8-1"
        } else if (color.equals("cafe")) {
            binding.btnCafe.setTextColor(black)
            respuesta7 = "cafe"
            regalo7 = "https://www.amazon.com.mx/Nescaf%C3%A9-Clasico-Caf%C3%A9-Sol-225/dp/B07NTVCSDS/ref=sr_1_6?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1NS10BAUJ5KD9&keywords=cafe&qid=1652581039&sprefix=caf%2Caps%2C178&sr=8-6"
        } else if (color.equals("negro")) {
            binding.btnNegro.setTextColor(black)
            respuesta7 = "negro"
            regalo7 = "https://www.amazon.com.mx/Hanes-Playera-cuelllo-P2-Negro/dp/B09NQLFPTY/ref=sr_1_20?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=8C9I8TDM9IET&keywords=negro&qid=1652581066&s=amazon-super&sprefix=negro%2Cspecialty-aps%2C141&sr=8-20&srs=18073069011&th=1"
        } else if (color.equals("blanco")) {
            binding.btnBlanco.setTextColor(black)
            respuesta7 = "blanco"
            regalo7 = "https://www.amazon.com.mx/Hanes-Playera-Redondo-Caballero-Unidades/dp/B01DZTJBLQ/ref=sr_1_2?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=FA81NSHTZWEN&keywords=blanco&qid=1652581132&s=amazon-super&sprefix=blanco%2Cspecialty-aps%2C139&sr=8-2&srs=18073069011"
        }
    }

    private fun answer8(dulces: String, black: Int) {
        if (dulces.equals("chocolate")) {
            binding.btnChocolate.setTextColor(black)
            respuesta8 = "chocolate"
            regalo8 = "https://www.amazon.com.mx/Chocolate-Leche-Hersheys-Kisses-809/dp/B08ZXH2CY1/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3FUTRFW2BXUN0&keywords=kisses&qid=1652581197&sprefix=kisses%2Caps%2C187&sr=8-1"
        } else if (dulces.equals("gomitas")) {
            binding.btnGomitas.setTextColor(black)
            respuesta8 = "gomitas"
            regalo8 = "https://www.amazon.com.mx/Gen%C3%A9rico-Gomitas-Panditas-Clasicas-Dulcigomas/dp/B087Z2MPT1/ref=sr_1_2?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=281FS3JZKAN4M&keywords=gomitas&qid=1652581212&sprefix=gomitas%2Caps%2C166&sr=8-2"
        } else if (dulces.equals("chicles")) {
            binding.btnChicles.setTextColor(black)
            respuesta8 = "chicles"
            regalo8 = "https://www.amazon.com.mx/Trident-4S-Menta-208-Gramos/dp/B08C3KG47T/ref=sr_1_2?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=QG1XOQ76KQ60&keywords=chicles&qid=1652581253&sprefix=chicle%2Caps%2C168&sr=8-2&th=1"
        } else if (dulces.equals("caramelo")) {
            binding.btnCaramelos.setTextColor(black)
            respuesta8 = "caramelo"
            regalo8 = "https://www.amazon.com.mx/Starbucks-Crema-L%C3%ADquida-Caramel-Macchiato/dp/B07VTDSZPH/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=13M8WSTAJLA38&keywords=caramelo&qid=1652581305&sprefix=caramelo%2Caps%2C175&sr=8-1"
        } else if (dulces.equals("chile")) {
            binding.btnChile.setTextColor(black)
            respuesta8 = "chile"
            regalo8 = "https://www.amazon.com.mx/Paquete-Picantes-Botanas-Surtidas-Enchilados/dp/B09DS1SXZB/ref=sr_1_4?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3ENBE2S800RRP&keywords=dulce+de+chile&qid=1652581341&sprefix=dulce+de+chile%2Caps%2C162&sr=8-4"
        } else if (dulces.equals("frutas")) {
            binding.btnFrutas.setTextColor(black)
            respuesta8 = "frutas"
            regalo8 = "https://www.amazon.com.mx/Hi-Chew-Sensationally-Chewy-dulces-japonesa/dp/B07RZ3NX7J/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=24FOXZ3PAOBW3&keywords=dulces+de+frutas&qid=1652581359&sprefix=dulces+de+fruta%2Caps%2C159&sr=8-1"
        } else if (dulces.equals("tipicos")) {
            binding.btnTipicos.setTextColor(black)
            respuesta8 = "tipicos"
            regalo8 = "https://www.amazon.com.mx/Las-Sevillanas-palanqueta-mazapanes-natillas/dp/B08HJ7NHFM/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3C1TKKSD9LJMA&keywords=dulces+tipicos&qid=1652581388&sprefix=dulces+tipicos%2Caps%2C165&sr=8-1"
        } else if (dulces.equals("artesanales")) {
            binding.btnArtesanal.setTextColor(black)
            respuesta8 = "artesanales"
            regalo8 = "https://www.amazon.com.mx/B%C3%ABfi-D%C3%A4nsu-palanquetas-cristalizada-tradicionales/dp/B093B5NTPL/ref=sr_1_2?keywords=dulces+artesanales&qid=1652581415&sprefix=dulces+artesan%2Caps%2C152&sr=8-2"
        } else if (dulces.equals("rellenos")) {
            binding.btnRellenos.setTextColor(black)
            respuesta8 = "rellenos"
            regalo8 = "https://www.amazon.com.mx/Toffees-Caramelos-rellenos-Amaretto-Rompope/dp/B09LC2SSM5/ref=sr_1_3?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2ZROXGXN4FK4C&keywords=dulces+rellenos&qid=1652581522&sprefix=dulces+relleno%2Caps%2C155&sr=8-3"

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
                         pregunta8: String, regalo5: String, regalo6: String,
                            regalo7: String, regalo8: String) {
        val uid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        val taskMap: MutableMap<String, Any> = HashMap()
        val taskRegalo : MutableMap<String, Any> = HashMap()
        taskMap["flor_chocolate"] = pregunta5
        taskMap["estampado"] = pregunta6
        taskMap["color"] = pregunta7
        taskMap["dulces"] = pregunta8

        taskRegalo["flor_chocolate"] = regalo5
        taskRegalo["estampado"] = regalo6
        taskRegalo["color"] = regalo7
        taskRegalo["dulces"] = regalo8
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