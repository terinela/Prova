package com.example.apoio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apoio.View.CadastroVoluntario
import com.example.apoio.View.Login
import com.example.apoio.View.Splash
import com.example.apoio.View.SplashScreen
import com.example.apoio.View.TelaInicial


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "telainicial"
            ) {
                composable(route = "telainicial"){
                    TelaInicial(navController = navController)
                }

                composable(route = "splash") {
                    SplashScreen(navController = navController)
                }
                composable(route = "splash2") {
                    Splash(navController = navController)
                }

                composable(route="login"){
                    Login()
            }

                composable(route="cadastro"){
                    CadastroVoluntario()
                }
         }


        }
    }
}

