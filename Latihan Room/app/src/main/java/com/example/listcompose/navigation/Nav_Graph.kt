package com.example.listcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.listcompose.data.database.FilafiDatabase
import com.example.listcompose.data.entity.FilmRoomEntity
import com.example.listcompose.data.repository.FilmRepository
import com.example.listcompose.layout.DetailScreen
import com.example.listcompose.layout.HomeScreen
import com.example.listcompose.layout.LanguageScreen
import com.example.listcompose.viewmodel.FilmViewModel
import com.example.listcompose.viewmodel.FilmViewModelFactory

@Composable
fun Nav_Graph(navController: NavHostController) {
    val context = LocalContext.current
    val database = FilafiDatabase.getDatabase(context)
    val repository = FilmRepository(database.reviewDao())

    val viewModel: FilmViewModel = viewModel(
        factory = FilmViewModelFactory(repository)
    )

    LaunchedEffect(Unit) {
        for (i in 1..5) {
            repository.insertFilmId(FilmRoomEntity(id = i))
        }
    }
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController = navController, viewModel = viewModel)
        }

        composable(
            route = "detail/{filmId}",
            arguments = listOf(navArgument("filmId") { type = NavType.IntType })
        ) { backStackEntry ->
            val filmId = backStackEntry.arguments?.getInt("filmId") ?: 0
            DetailScreen(
                filmId = filmId,
                viewModel = viewModel,
                navController = navController
            )
        }
        composable("language") {
            LanguageScreen(navController = navController)
        }
    }
}