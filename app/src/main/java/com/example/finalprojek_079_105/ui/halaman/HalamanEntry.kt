package com.example.finalprojek_079_105.ui.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojek_079_105.R
import com.example.finalprojek_079_105.model.DetailPembeli
import com.example.finalprojek_079_105.model.EntryViewModel
import com.example.finalprojek_079_105.model.PenyediaViewModel
import com.example.finalprojek_079_105.model.UIStatePembeli
import com.example.finalprojek_079_105.navigasi.DestinasiNavigasi
import com.example.finalprojek_079_105.navigasi.PembeliTopAppBar
import kotlinx.coroutines.launch

object DestinasiEntry: DestinasiNavigasi{
    override val route = "item_entry"
    override val titleRes = R.string.entry_pembeli
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryPembeliScreen(
    navigaeBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EntryViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold (
        modifier = modifier.nestedScroll(
            scrollBehavior.nestedScrollConnection
        ),
        topBar = {
            PembeliTopAppBar(
                title = stringResource(DestinasiEntry.titleRes),
                canNavigateBack = true,
                scrollBehavior = scrollBehavior

            )
        }
    ){ innerPadding ->
        EntryPembeliBody(
            uiStatePembeli = viewModel.uiStatePembeli,
            onPembeliValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.savePembeli()
                    navigaeBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )

    }
}


@Composable
fun EntryPembeliBody(
    uiStatePembeli: UIStatePembeli,
    onPembeliValueChange: (DetailPembeli) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column (
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large)),
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))

    ){
        FormInputPembeli(
            detailPembeli = uiStatePembeli.DetailPembeli,
            onValueChange = onPembeliValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = onSaveClick,
            enabled = uiStatePembeli.isEntryValid,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()) {
            Text(stringResource(id = R.string.btn_submit))

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputPembeli(
    detailPembeli: DetailPembeli,
    modifier: Modifier = Modifier,
    onValueChange: (DetailPembeli) -> Unit = {},
    enabled: Boolean = true
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        OutlinedTextField(
            value = detailPembeli.nama,
            onValueChange = {onValueChange(detailPembeli.copy(nama = it))},
            label = { Text(stringResource(id = R.string.nama)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = detailPembeli.alamat,
            onValueChange = {onValueChange(detailPembeli.copy(alamat = it))},
            label = { Text(stringResource(id = R.string.alamat)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value =detailPembeli.telpon,
            onValueChange = {onValueChange(detailPembeli.copy(telpon = it))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(stringResource(id = R.string.telpon)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = detailPembeli.email,
            onValueChange = {onValueChange(detailPembeli.copy(email = it))},
            label = { Text(stringResource(id = R.string.email)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = detailPembeli.payment,
            onValueChange = {onValueChange(detailPembeli.copy(payment = it))},
            label = { Text(stringResource(id = R.string.payment)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        if (enabled) {
            Text(text = stringResource(id = R.string.required_field),
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
            )
        }
        Divider(
            thickness = dimensionResource(id = R.dimen.padding_small),
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
        )
    }
}

