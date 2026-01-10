package com.example.apoio.data

data class Tarefa (
        val id: Int = 0,
        val titulo: String,
        val descricao: String,
        val dataVencimento: String,
        val prioridade: Prioridade,
        val estado: EstadoTarefa,
        val local: String,
        val responsavel: String
    )

    enum class Prioridade {
        BAIXA, MEDIA, ALTA, URGENTE
    }

    enum class EstadoTarefa {
        PENDENTE, EM_ANDAMENTO, CONCLUIDA, CANCELADA
    }

