package equipo1.giffytasks

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import equipo1.giffytasks.databinding.ActivityWishlistBinding
import java.io.File

class wishlist : AppCompatActivity() {
    private lateinit var binding: ActivityWishlistBinding
    private var databaseReference = FirebaseDatabase.getInstance().getReference("users")
    private var listhobbie = listOf("bailar", "cocinar", "deporte", "dibujar", "jardineria","leer","musica",
        "otro", "peliculas")

    private var listFlores_chocolate = listOf("chocolate", "flores")

    private var listdulces = listOf("chocolate", "gomitas","chicles","caramelo","chile","fruta","tipicos",
        "artesanales", "rellenos")

    private var listseleccion = listOf("pony", "peluches","ropa", "dinero", "joyas", "perfume", "tecno",
        "utiles", "juegos", "funkos", "maquillaje", "juegos_mesa")

    private var listcolor = listOf("rojo","naranja","amarillo","verde","azul","morado","cafe","negro","blanco")

    private var listcultura_popular= listOf("starWars", "marvel", "dccomics", "harry_potter", "nintendo","disney",
        "wwe","los_simpson", "silent_hill")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWishlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //nombre del pasatiempo o regalo
        val producto1 = binding.ibRegalo1
        val producto2 = binding.ibRegalo2
        val producto3 = binding.ibRegalo3
        val producto4 = binding.ibRegalo4
        val producto5 = binding.ibRegalo5
        val producto6 = binding.ibRegalo6

        val uidUser = intent.getStringExtra("uid")
        val nombre = intent.getStringExtra("nombre")

        //se manda para que se le setee una wea a ver que sale
        abrirProducto(uidUser, producto1, producto2, producto3, producto4, producto5, producto6)

        var databaseReference = FirebaseDatabase.getInstance().getReference("users")
        val localFile = File.createTempFile("tempImage", "jpeg")

        if((uidUser != null) && (nombre != null)){
            var storageRef = FirebaseStorage.getInstance().getReference("image/" + uidUser)

            storageRef.getFile(localFile).addOnSuccessListener {
                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                binding.ivPerfilUsuario.setImageBitmap(bitmap)
            }.addOnFailureListener {
                Toast.makeText(baseContext, "Imagen no cargada.", Toast.LENGTH_SHORT).show()
            }
            databaseReference.child("user").child(uidUser).get().addOnSuccessListener { task ->
                if (task.exists()) {
                    val nombre = task.child("nombre").value
                    binding.tvNombreUsuario.text = nombre.toString()
                } else {
                    Toast.makeText(baseContext, "No se recupero el usuario.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.quizAmigo.setOnClickListener{
            var intent = Intent(this,quiz_gift::class.java)
            intent.putExtra("nombre",  nombre)
            intent.putExtra("uid",  uidUser)
            startActivity(intent)
        }

        binding.btnOpcionesAmigo.setOnClickListener{
            var intent= Intent(this,options::class.java)
            intent.putExtra("nombre",  nombre)
            intent.putExtra("uid",  uidUser)
            startActivity(intent)
        }
    }

    private fun abrirProducto(
        uid: String?,
        producto1: ImageButton,
        producto2: ImageButton,
        producto3: ImageButton,
        producto4: ImageButton,
        producto5: ImageButton,
        producto6: ImageButton
    ) {
        if (uid != null) {
            //aquí obtenemos los regalos de 'user'
            databaseReference.child("user").child(uid).child("regalos").get().addOnSuccessListener { task ->
                if (task.exists()) {
                    var color:String = task.child("color").value.toString()
                    producto1.setOnClickListener{
                        val uri = Uri.parse(color)
                        val intents = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intents)
                    }

                    var cultura:String = task.child("cultura_popular").value.toString()
                    producto2.setOnClickListener{
                        val uri = Uri.parse(cultura)
                        val intents = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intents)
                    }

                    var dulces: String = task.child("dulces").value.toString()
                    producto3.setOnClickListener{
                        val uri = Uri.parse(dulces)
                        val intents = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intents)
                    }
                    var flor_chocolate = task.child("flor_chocolate").value.toString()
                    producto4.setOnClickListener{
                        val uri = Uri.parse(flor_chocolate)
                        val intents = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intents)
                    }
                    var hobbie = task.child("hobbie").value.toString()
                    producto5.setOnClickListener{
                        val uri = Uri.parse(hobbie)
                        val intents = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intents)
                    }
                    var seleccion = task.child("seleccion").value.toString()
                    producto6.setOnClickListener{
                        val uri = Uri.parse(seleccion)
                        val intents = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intents)
                    }

                } else {
                    Toast.makeText(this, "No se recupero.", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener{
                Toast.makeText(this, "No se recuperaron los productos", Toast.LENGTH_SHORT).show()
            }

            databaseReference.child("user").child(uid).child("quiz").get().addOnSuccessListener { task ->
                if (task.exists()) {
                    val hobbie_user:String = task.child("hobbie").value.toString()
                    for(i in listhobbie){
                        if(i == hobbie_user){
                            var storageRef = FirebaseStorage.getInstance().getReference().child("productos/"+i+".jpeg")
                            val localFile = File.createTempFile(i, "jpeg")
                            storageRef.getFile(localFile).addOnSuccessListener {
                                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                                producto5.setImageBitmap(bitmap)
                            }.addOnFailureListener{
                                Toast.makeText(this, "No se recuperaron las imagenes", Toast.LENGTH_SHORT).show()
                            }
                            break
                        }
                    }
                    val flor_chocolate_user:String = task.child("flor_chocolate").value.toString()
                    println(flor_chocolate_user)
                    for(i in listFlores_chocolate){
                        if(i == flor_chocolate_user){
                            var storageRef = FirebaseStorage.getInstance().getReference().child("productos/"+i+".jpeg")
                            val localFile = File.createTempFile(i, "jpeg")
                            storageRef.getFile(localFile).addOnSuccessListener {
                                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                                producto4.setImageBitmap(bitmap)
                            }.addOnFailureListener{
                                Toast.makeText(this, "No se recuperaron las imagenes", Toast.LENGTH_SHORT).show()
                            }
                            break
                        }
                    }

                    val dulces:String = task.child("dulces").value.toString()
                    println(flor_chocolate_user)
                    for(i in listdulces){
                        if(i == dulces){
                            var storageRef = FirebaseStorage.getInstance().getReference().child("dulces/"+i+".jpeg")
                            val localFile = File.createTempFile(i, "jpeg")
                            storageRef.getFile(localFile).addOnSuccessListener {
                                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                                producto3.setImageBitmap(bitmap)
                            }.addOnFailureListener{
                                Toast.makeText(this, "No se recuperaron las imagenes", Toast.LENGTH_SHORT).show()
                            }
                            break
                        }
                    }

                    val color:String = task.child("color").value.toString()
                    println(flor_chocolate_user)
                    for(i in listcolor){
                        if(i == color){
                            var storageRef = FirebaseStorage.getInstance().getReference().child("color/"+i+".jpeg")
                            val localFile = File.createTempFile(i, "jpeg")
                            storageRef.getFile(localFile).addOnSuccessListener {
                                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                                producto1.setImageBitmap(bitmap)
                            }.addOnFailureListener{
                                Toast.makeText(this, "No se recuperaron las imagenes", Toast.LENGTH_SHORT).show()
                            }
                            break
                        }
                    }

                    val cultura_popular:String = task.child("cultura_popular").value.toString()
                    for(i in listcultura_popular){
                        if(i == cultura_popular){
                            var storageRef = FirebaseStorage.getInstance().getReference().child("cultura_popular/"+i+".jpeg")
                            val localFile = File.createTempFile(i, "jpeg")
                            storageRef.getFile(localFile).addOnSuccessListener {
                                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                                producto2.setImageBitmap(bitmap)
                            }.addOnFailureListener{
                                Toast.makeText(this, "No se recuperaron las imagenes", Toast.LENGTH_SHORT).show()
                            }
                            break
                        }
                    }

                    val seleccion:String = task.child("seleccion").value.toString()
                    for(i in listseleccion){
                        if(i == seleccion){
                            var storageRef = FirebaseStorage.getInstance().getReference().child("seleccion/"+i+".jpeg")
                            val localFile = File.createTempFile(i, "jpeg")
                            storageRef.getFile(localFile).addOnSuccessListener {
                                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                                producto6.setImageBitmap(bitmap)
                            }.addOnFailureListener{
                                Toast.makeText(this, "No se recuperaron las imagenes", Toast.LENGTH_SHORT).show()
                            }
                            break
                        }
                    }
                } else {
                    Toast.makeText(this, "No se recupero.", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener{
                Toast.makeText(this, "No se recupero el quiz", Toast.LENGTH_SHORT).show()
            }

        }
    }
}