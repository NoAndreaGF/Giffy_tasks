package equipo1.giffytasks

import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class AdapterFriends(private val usersList: ArrayList<User>, private val  picsArrayList: ArrayList<String>) : RecyclerView.Adapter<AdapterFriends.MyViewHolder>() {


    public class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imagen : ImageView = itemView.findViewById(R.id.iv_home_amigo)
        val nombre : TextView = itemView.findViewById(R.id.tv_home_amigo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_user_view,
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

        holder.imagen.setOnClickListener {
            onClickFriend(it, holder, uid)
        }
    }

    fun onClickFriend(v: View?, holder: MyViewHolder, uid: String) {
        val intent = Intent(v!!.context, wishlist::class.java)
        intent.putExtra("nombre",  holder.nombre.text)
        intent.putExtra("uid",  uid)
        v!!.context.startActivity(intent)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }


}