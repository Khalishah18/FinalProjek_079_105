package com.example.finalprojek_079_105.ui.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.finalprojek_079_105.R
import com.example.finalprojek_079_105.data.Pembeli
import com.example.finalprojek_079_105.navigasi.DestinasiNavigasi

object DestinasiHome : DestinasiNavigasi {
    override val route: String = "home"
    override val titleRes: Int = R.string.app_name
}

@Composable
fun BodyHome(
    itemPembeli: List<Pembeli>,
    modifier: Modifier = Modifier
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        if (itemPembeli.isEmpty()){
            Text(
                text = stringResource(R.string.deskripsi_no_item),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListPembeli(
                itemPembeli = itemPembeli,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun ListPembeli(
    itemPembeli: List<Pembeli>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = Modifier){
        items(items = itemPembeli, key = {it.id}) {
                person ->
            DataPembeli(
                pembeli = person,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun DataPembeli(
    pembeli: Pembeli,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column (
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = pembeli.nama,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                )
                Text(
                    text = pembeli.telpon,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = pembeli.alamat,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}