package com.example.apoio.View

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.apoio.ui.theme.GreenPrimary


@Composable
fun TelaBuscaTarefasVoluntarios() {

    var tituloTarefa by remember { mutableStateOf("") }
    var dataTarefa by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        // ↓↓↓ ESPAÇO GRANDE PARA BAIXAR TUDO ↓↓↓
        Spacer(modifier = Modifier.height(120.dp))

        Text(
            text = "Buscar Tarefas",
            style = MaterialTheme.typography.headlineMedium,
            color = GreenPrimary
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = tituloTarefa,
            onValueChange = { tituloTarefa = it },
            label = { Text("Nome da Tarefa") },
            placeholder = { Text("Ex: Limpeza do bairro") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = GreenPrimary,
                focusedLabelColor = GreenPrimary,
                cursorColor = GreenPrimary
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = dataTarefa,
            onValueChange = { dataTarefa = it },
            label = { Text("Data da Tarefa") },
            placeholder = { Text("dd/mm/aaaa") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = GreenPrimary,
                focusedLabelColor = GreenPrimary,
                cursorColor = GreenPrimary
            )
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                // chamada à API
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenPrimary
            )
        ) {
            Text("Buscar", color = Color.White)
        }
    }
}
