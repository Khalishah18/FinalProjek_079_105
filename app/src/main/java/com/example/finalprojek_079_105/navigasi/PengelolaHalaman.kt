package com.example.finalprojek_079_105.navigasi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.finalprojek_079_105.R
import com.example.finalprojek_079_105.ui.halaman.DestinasiEntry
import com.example.finalprojek_079_105.ui.halaman.DestinasiHome
import com.example.finalprojek_079_105.ui.halaman.DetailScreen
import com.example.finalprojek_079_105.ui.halaman.DetailsDestination
import com.example.finalprojek_079_105.ui.halaman.EntryPembeliScreen
import com.example.finalprojek_079_105.ui.halaman.HomeScreen
import com.example.finalprojek_079_105.ui.halaman.ItemEditDestination
import com.example.finalprojek_079_105.ui.halaman.ItemEditScreen

@Composable
fun PembeliApp(navController: NavHostController = rememberNavController()){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PembeliTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
){
    CenterAlignedTopAppBar(title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        })

}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = {
                    navController.navigate("${DetailsDestination.route}/$it")
                }
            )
        }
        composable(DestinasiEntry.route){
            EntryPembeliScreen(navigaeBack = { navController.popBackStack() },
            )
        }

        composable(
            DetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailsDestination.pembeliIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailScreen(
                navigateToEditItem = {
                    navController.navigate(("${ItemEditDestination.route}/$it")
                    )
                },
                navigateBack = { navController.popBackStack()},
            )
        }

        composable(
            ItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemEditScreen(
                onNavigateUp = {
                    navController.navigateUp()
                },
                navigateBack = { navController.popBackStack()},
            )
        }
    }
}