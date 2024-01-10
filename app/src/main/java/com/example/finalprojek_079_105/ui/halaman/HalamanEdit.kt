package com.example.finalprojek_079_105.ui.halaman

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojek_079_105.R
import com.example.finalprojek_079_105.model.EditViewModel
import com.example.finalprojek_079_105.model.PenyediaViewModel
import com.example.finalprojek_079_105.navigasi.DestinasiNavigasi
import com.example.finalprojek_079_105.navigasi.PembeliTopAppBar
import kotlinx.coroutines.launch

object ItemEditDestination: DestinasiNavigasi {
    override val route  = "item_entry"
    override val titleRes = R.string.edit_pembeli
    const val itemIdArg  = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold (
        topBar = {
            PembeliTopAppBar(
                title = stringResource(id = ItemEditDestination.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ){innerPadding ->
        EntryPembeliBody(
            uiStatePembeli = viewModel.pembeliUiState,
            onPembeliValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updatePembeli()
                    navigateBack()
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}