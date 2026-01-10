package com.example.apoio.network

import com.example.apoio.data.Tarefa2
import com.google.android.gms.drive.query.Query

interface ApiService {

    @GET("tarefas")
    suspend fun buscarTarefas(
       // @Query("busca") busca: String?,
        //@Query("categoria") categoria: String?,
        //@Query("status") status: String?,
        //@Query("prioridade") prioridade: String?
    ): List<Tarefa2>
}

annotation class GET(val value: String)
