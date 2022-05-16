package equipo1.giffytasks

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class AdapterUsers(private val usersList: ArrayList<User>, private val  picsArrayList: ArrayList<String>) : RecyclerView.Adapter<AdapterUsers.MyViewHolder>() {


    public class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imagen : ImageView = itemView.findViewById(R.id.iv_usuario)
        val nombre : TextView = itemView.findViewById(R.id.tv_nombre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_friend_view,
            parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val usuario : User = usersList[position]
        val uid : String = picsArrayList[position]
        holder.nombre.text = usuario.nombre

        var storageRef = FirebaseStorage.getInstance().getReference("image/" + uid)

        val localFile = File.createTempFile("tempImage", "jpeg")

        if (uid != null) {
            storageRef.getFile(localFile).addOnSuccessListener {
                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                holder.imagen.setImageBitmap(bitmap)
            }.addOnFailureListener {
                println("No cargo la imagen.")
            }
        }

        holder.nombre.setOnClickListener {
            isUserFriend(it, holder, uid)
            /**if (isUserFriend(it, holder, uid)) {
                onClickFriend(it, holder,uid)
            }
            else {
                onClickNotFriend(it, holder,uid)
            }**/
            /**val intent = Intent(contexto, add_friend::class.java)
            intent.putExtra("nombre",  holder.nombre.text)
            intent.putExtra("uid",  uid)
            contexto.startActivity(intent)**/
        }
    }

    fun onClickFriend(v: View?, holder: MyViewHolder, uid: String) {
        val intent = Intent(v!!.context, wishlist::class.java)
        intent.putExtra("nombre",  holder.nombre.text)
        intent.putExtra("uid",  uid)
        v!!.context.startActivity(intent)
    }

    fun onClickNotFriend(v: View?, holder: MyViewHolder, uid: String) {
        val intent = Intent(v!!.context, add_friend::class.java)
        intent.putExtra("nombre",  holder.nombre.text)
        intent.putExtra("uid",  uid)
        v!!.context.startActivity(intent)
    }

    fun isUserFriend(v: View?, holder: MyViewHolder, uid: String) {
        var auth: FirebaseAuth = FirebaseAuth.getInstance()
        val myUid = auth.currentUser?.uid.toString()
        var databaseReference = FirebaseDatabase.getInstance().getReference("users").child("user")
        databaseReference.child(myUid).child("amigos").child(uid).get()
            .addOnSuccessListener { task ->
                if (task.exists()) {
                    onClickFriend(v, holder,uid)
                } else {
                    onClickNotFriend(v, holder,uid)
                }
        }.addOnFailureListener {
                onClickNotFriend(v, holder,uid)
            }

    }

    override fun getItemCount(): Int {
        return usersList.size
    }


}