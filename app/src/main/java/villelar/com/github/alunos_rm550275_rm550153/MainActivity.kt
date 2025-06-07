package villelar.com.github.alunos_rm550275_rm550153

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import villelar.com.github.alunos_rm550275_rm550153.model.Evento
import villelar.com.github.alunos_rm550275_rm550153.viewmodel.EventoAdapter
import villelar.com.github.alunos_rm550275_rm550153.viewmodel.EventoViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: EventoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val campoLocal = findViewById<EditText>(R.id.edtLocal)
        val campoTipo = findViewById<EditText>(R.id.edtTipo)
        val campoGrau = findViewById<EditText>(R.id.edtGrau)
        val campoData = findViewById<EditText>(R.id.edtData)
        val campoPessoas = findViewById<EditText>(R.id.edtPessoas)
        val botaoIncluir = findViewById<Button>(R.id.btnIncluir)
        val botaoId = findViewById<Button>(R.id.btnIdentificacao)
        val lista = findViewById<RecyclerView>(R.id.recyclerView)

        lista.layoutManager = LinearLayoutManager(this)

        viewModel.eventos.observe(this) { eventos ->
            lista.adapter = EventoAdapter(eventos) { viewModel.remover(it) }
        }

        botaoIncluir.setOnClickListener {
            val local = campoLocal.text.toString()
            val tipo = campoTipo.text.toString()
            val grau = campoGrau.text.toString()
            val data = campoData.text.toString()
            val pessoas = campoPessoas.text.toString().toIntOrNull() ?: -1

            if (local.isBlank() || tipo.isBlank() || grau.isBlank() || data.isBlank() || pessoas <= 0) {
                Toast.makeText(this, "Preencha tudo corretamente", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.adicionar(Evento(local, tipo, grau, data, pessoas))
                campoLocal.text.clear()
                campoTipo.text.clear()
                campoGrau.text.clear()
                campoData.text.clear()
                campoPessoas.text.clear()
            }
        }

        botaoId.setOnClickListener {
            startActivity(Intent(this, TelaIdentificacaoActivity::class.java))
        }
    }
}
