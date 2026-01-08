package com.example.apoio.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apoio.R
import com.example.apoio.ui.theme.GreenDark
import com.example.apoio.ui.theme.GreenLight
import com.example.apoio.ui.theme.GreenPrimary
import kotlinx.coroutines.delay

@Composable
fun TelaInicial(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        GreenDark,
                        GreenLight,
                        GreenPrimary,
                        GreenDark,
                        GreenDark
                    )
                )
            )
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Empurra o conteúdo para baixo (ajusta este valor)
        Spacer(modifier = Modifier.height(180.dp))

        Image(
            painter = painterResource(id = R.drawable.capa1),
            contentDescription = null,
            modifier = Modifier
                .width(400.dp)
                .height(420.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = buildAnnotatedString {
                append(" Seja Bem-Vindo \n ao Apoio ")
                withStyle(
                    style = SpanStyle(
                        color = Green
                    )
                ){
                    append(" Comunitário \n e Social")
                }
                append(" \n O seu apoio é + \n ")
            },
            color = White, fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

        ){

            Button(
                onClick ={
                    navController.navigate("splash2")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor =  Color.Transparent
                    ),
                border = BorderStroke(
                    width = 1.dp,
                    color = White
                )
            ) {
                Text(text = "Cadastra-se", fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                    color = White
                )

            }

            Button(
                onClick ={
                    navController.navigate("splash")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green
                ),
                modifier = Modifier.shadow(
                    elevation = 18.dp,
                    shape = CircleShape,
                    spotColor = GreenLight
                )
            ) {
                Text(text = " Fazer Login", fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )

            }
        }
    }

}

