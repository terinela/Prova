package com.example.apoio.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.apoio.data.Tarefa


class TarefaViewModel : ViewModel() {

        private val _tarefas = mutableStateListOf<Tarefa>()
        val tarefas: List<Tarefa> = _tarefas

        fun adicionarTarefa(tarefa: Tarefa) {
            _tarefas.add(tarefa.copy(id = _tarefas.size + 1))
        }

        fun removerTarefa(tarefa: Tarefa) {
            _tarefas.remove(tarefa)
        }

        fun atualizarTarefa(tarefaAtualizada: Tarefa) {
            val index = _tarefas.indexOfFirst { it.id == tarefaAtualizada.id }
            if (index != -1) {
                _tarefas[index] = tarefaAtualizada
            }
        }
    }



