package com.example.apoio.View

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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


@Composable
fun CadastroTarefa(
    viewModel: TarefaViewModel = viewModel()
) {
    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var data by remember { mutableStateOf("") }
    var local by remember { mutableStateOf("") }
    var responsavel by remember { mutableStateOf("") }

    var prioridade by remember { mutableStateOf(Prioridade.MEDIA) }
    var estado by remember { mutableStateOf(EstadoTarefa.PENDENTE) }

    var erro by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Cadastro de Tarefa",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4CAF50)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título da tarefa") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = data,
            onValueChange = { data = it },
            label = { Text("Data de vencimento") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = local,
            onValueChange = { local = it },
            label = { Text("Local / Bairro") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = responsavel,
            onValueChange = { responsavel = it },
            label = { Text("Responsável") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Prioridade")
        DropdownMenuBox(
            selected = prioridade.name,
            options = Prioridade.values().map { it.name }
        ) {

            val it = ""
            prioridade = Prioridade.valueOf(it)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Estado")
        DropdownMenuBox(
            selected = estado.name,
            options = EstadoTarefa.values().map { it.name }
        ) {

            val it = ""
            estado = EstadoTarefa.valueOf(it)
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (erro.isNotEmpty()) {
            Text(text = erro, color = Color.Red)
        }

        Button(
            onClick = {
                erro = when {
                    titulo.isBlank() || descricao.isBlank() || data.isBlank() ->
                        "Preencha todos os campos obrigatórios."
                    else -> {
                        viewModel.adicionarTarefa(
                            Tarefa(
                                titulo = titulo,
                                descricao = descricao,
                                dataVencimento = data,
                                prioridade = prioridade,
                                estado = estado,
                                local = local,
                                responsavel = responsavel
                            )
                        )
                        ""
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4CAF50)
            )
        ) {
            Text("Salvar Tarefa", color = Color.White)
        }
    }
}

@Composable
fun DropdownMenuBox(
    selected: String,
    options: List<String>,
    onSelect: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedButton(onClick = { expanded = true }) {
            Text(selected)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach {
                DropdownMenuItem(
                    text = { Text(it) },
                    onClick = {
                        onSelect(it)
                        expanded = false
                    }
                )
            }
        }
    }
}

