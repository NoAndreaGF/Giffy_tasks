package equipo1.giffytasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val eventList: ArrayList<Event>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    public class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val fecha_evento : TextView = itemView.findViewById(R.id.evento)
        val mes : TextView = itemView.findViewById(R.id.tv_mes)
        val dia : TextView = itemView.findViewById(R.id.tv_dia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_event_view,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val evento : Event = eventList[position]
        holder.fecha_evento.text = evento.fecha_evento
        holder.mes.text = evento.mes
        holder.dia.text = evento.dia
    }

    override fun getItemCount(): Int {
        return eventList.size
    }
}