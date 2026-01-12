package com.example.apoio.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apoio.model.TarefaViewModel
import com.example.apoio.data.Tarefa
import com.example.apoio.data.Prioridade
import com.example.apoio.data.EstadoTarefa
import com.example.apoio.ui.theme.DarkGraySoft
import com.example.apoio.ui.theme.GreenPrimary


@Composable
fun CadastroTarefa() {
    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var data by remember { mutableStateOf("") }
    var local by remember { mutableStateOf("") }
    var responsavel by remember { mutableStateOf("") }

    var prioridade by remember { mutableStateOf("Normal") }
    var estado by remember { mutableStateOf("Pendente") }

    var erro by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(60.dp)) // Ajuste para posicionar mais abaixo

        Text(
            text = "Cadastro de Tarefa",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = GreenPrimary
        )

        Spacer(modifier = Modifier.height(28.dp))

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título da tarefa") },
            modifier = Modifier.fillMaxWidth()
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        OutlinedTextField(
            value = data,
            onValueChange = { data = it },
            label = { Text("Data de vencimento") },
            placeholder = { Text("dd/mm/aaaa") },
            modifier = Modifier.fillMaxWidth()
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        OutlinedTextField(
            value = local,
            onValueChange = { local = it },
            label = { Text("Local / Bairro") },
            modifier = Modifier.fillMaxWidth()
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        OutlinedTextField(
            value = responsavel,
            onValueChange = { responsavel = it },
            label = { Text("Responsável") },
            modifier = Modifier.fillMaxWidth()
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        // PRIORIDADE
        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "Prioridade",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF2A2B2B) // DarkGraySoft
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PrioridadeOption("Normal", prioridade) { prioridade = it }
            PrioridadeOption("Média", prioridade) { prioridade = it }
            PrioridadeOption("Urgente", prioridade) { prioridade = it }
        }

        // ESTADO
        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "Estado da tarefa",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF2A2B2B) // DarkGraySoft
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            EstadoOption("Pendente", estado) { estado = it }
            EstadoOption("Em andamento", estado) { estado = it }
            EstadoOption("Concluída", estado) { estado = it }
        }

        Spacer(modifier = Modifier.height(36.dp))

        Button(
            onClick = {
                erro = when {
                    titulo.isBlank() || descricao.isBlank() || data.isBlank() ->
                        "Preencha todos os campos obrigatórios."
                    else -> {
                        // Aqui você pode chamar a função para adicionar a tarefa
                        ""
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenPrimary
            )
        ) {
            Text("Salvar Tarefa", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun PrioridadeOption(label: String, selected: String, onSelect: (String) -> Unit) {
    OutlinedButton(
        onClick = { onSelect(label) },
        border = if (label == selected) BorderStroke(1.dp, GreenPrimary) else null
    ) {
        Text(label, color = if (label == selected) GreenPrimary else Color.Black)
    }
}

@Composable
fun EstadoOption(label: String, selected: String, onSelect: (String) -> Unit) {
    OutlinedButton(
        onClick = { onSelect(label) },
        border = if (label == selected) BorderStroke(1.dp, GreenPrimary) else null
    ) {
        Text(label, color = if (label == selected) GreenPrimary else Color.Black)
    }
}
