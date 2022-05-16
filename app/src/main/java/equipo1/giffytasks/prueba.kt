package equipo1.giffytasks

import android.R
import android.R.id
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.FirebaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase


class prueba {
    /**fun loadExperiences() {
        val ref =
            Firebase("https://sizzling-torch-8367.firebaseio.com/users/" + id.toString() + "/experiences")
        ref.addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    experienceViews = ArrayList()
                    val layout = findViewById(id.EditResumeLinearLayoutExperience) as LinearLayout
                    layout.removeAllViews()
                    for (experience in dataSnapshot.children) {
                        val exp = FirebaseExperience(
                            this@EditResumeActivity,
                            experience.key,
                            experience.child("position").value.toString(),
                            experience.child("name").value.toString(),
                            experience.child("startDate").value.toString(),
                            experience.child("endDate").value.toString(),
                            experience.child("city").value.toString(),
                            experience.child("state").value.toString(),
                            experience.child("info").value.toString()
                        )
                        experienceViews.add(exp)
                    }
                    for (i in 0 until experienceViews.size()) {
                        layout.addView(experienceViews.get(i).getLayout(), i)
                    }
                }

                fun onCancelled(firebaseError: FirebaseError?) {}
            })
    }

    private fun getMensajesFromFirebase() {
        mDatabase = findViewById(id.btnCrearDatos) as Button
        mMensajesList = findViewById(id.editTextMensaje) as EditText
        mrecyclerView = findViewById(id.recyclerViewMensajes) as RecyclerView
        mDatabase.child("Mensajes").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.existes()) {
                    for (ds in dataaSnapshot.getChildren()) {
                        val texto = ds.child("texto").value.toString()
                        mMensajesList.add(Mensaje(texto))
                    }
                    mAdapter = MensajeAdapter(mMensajeList, R - layout.mensaje_view)
                    mrecyclerView.setAdapter(mAdapter)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }**/
}