package com.example.apoio.View

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.apoio.data.Tarefa2

@Composable
fun DetalhesModal(
    open: Boolean,
    onClose: () -> Unit,
    tarefa: Tarefa2?
) {
    if (open && tarefa != null) {
        Dialog(onDismissRequest = onClose) {
            Card(modifier = Modifier.padding(16.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(tarefa.nome, style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Categoria: ${tarefa.categoria}")
                    Text("Status: ${tarefa.status}")
                    Text("Prioridade: ${tarefa.prioridade}")
                    Text("Data: ${tarefa.data}")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Descrição: ${tarefa.descricao}")
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = onClose) { Text("Fechar") }
                }
            }
        }
    }
}
