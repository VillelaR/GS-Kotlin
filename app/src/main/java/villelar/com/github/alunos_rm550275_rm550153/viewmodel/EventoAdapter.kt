package villelar.com.github.alunos_rm550275_rm550153.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import villelar.com.github.alunos_rm550275_rm550153.R
import villelar.com.github.alunos_rm550275_rm550153.model.Evento

class EventoAdapter(
    private val lista: List<Evento>,
    private val aoExcluir: (Evento) -> Unit
) : RecyclerView.Adapter<EventoAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_evento, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.vincular(lista[position])
    }

    override fun getItemCount() = lista.size

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val local = view.findViewById<TextView>(R.id.textLocal)
        private val tipo = view.findViewById<TextView>(R.id.textTipo)
        private val grau = view.findViewById<TextView>(R.id.textGrau)
        private val data = view.findViewById<TextView>(R.id.textData)
        private val pessoas = view.findViewById<TextView>(R.id.textPessoas)
        private val excluir = view.findViewById<Button>(R.id.btnExcluir)

        fun vincular(evento: Evento) {
            local.text = evento.local
            tipo.text = evento.tipo
            grau.text = evento.grau
            data.text = evento.data
            pessoas.text = "Pessoas: ${evento.pessoasAfetadas}"
            excluir.setOnClickListener { aoExcluir(evento) }
        }
    }
}
