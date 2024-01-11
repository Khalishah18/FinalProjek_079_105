package com.example.finalprojek_079_105.ui.halaman

import android.provider.MediaStore.Audio.AlbumColumns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalprojek_079_105.R
import com.example.finalprojek_079_105.navigasi.DestinasiNavigasi
import com.example.finalprojek_079_105.navigasi.PembeliTopAppBar

object DestinasiAlbum : DestinasiNavigasi {
    override val route: String = "album"
    override val titleRes: Int = R.string.app_name
    var selectedAlbumName by mutableStateOf<String?>(null)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumScreen(
    navigateAlbum: () -> Unit,
    onDetailClick: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold (
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PembeliTopAppBar(
                title = stringResource(DestinasiAlbum.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },

        ) { innerPadding ->
        AlbumBody(
            onNextButtonClicked = navigateAlbum,
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@Composable
fun AlbumBody(
    modifier: Modifier,
    onNextButtonClicked: () -> Unit
) {

    val image = painterResource(id = R.drawable.img)
    val image2 = painterResource(id = R.drawable.img_1)
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        OutlinedCard (
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            border = BorderStroke(0.dp, Color.Transparent),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp)
                .align(Alignment.CenterHorizontally)
        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Black Pink - BORN PINK Album",
                    color = Color.DarkGray,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "RP. 1.540.000",
                    color = Color.Gray,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .weight(1f, false),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                    verticalAlignment = Alignment.Bottom
                ){
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            DestinasiAlbum.selectedAlbumName = "Black Pink - BORN PINK Album"
                            onNextButtonClicked()
                        }
                    ) {
                        Text(stringResource(R.string.next))
                    }
                }
                Image(
                    painter = image2,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "BTS - Love Your Self Album",
                    color = Color.DarkGray,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "RP. 1.378.000",
                    color = Color.Gray,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .weight(1f, false),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                    verticalAlignment = Alignment.Bottom
                ){
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            DestinasiAlbum.selectedAlbumName = "BTS - Love Your Self Album"
                            onNextButtonClicked()
                        }
                    ) {
                        Text(stringResource(R.string.next))
                    }
                }
            }
        }

    }
}

