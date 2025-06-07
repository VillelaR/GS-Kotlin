package villelar.com.github.alunos_rm550275_rm550153.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import villelar.com.github.alunos_rm550275_rm550153.model.Evento

class EventoViewModel : ViewModel() {

    private val _eventos = MutableLiveData<MutableList<Evento>>(mutableListOf())
    val eventos: LiveData<MutableList<Evento>> get() = _eventos

    fun adicionar(evento: Evento) {
        _eventos.value?.add(evento)
        _eventos.value = _eventos.value
    }

    fun remover(evento: Evento) {
        _eventos.value?.remove(evento)
        _eventos.value = _eventos.value
    }
}
