package com.example.lazyitem.layout

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.lazyitem.viewmodel.ItemViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lazyitem.R
import com.example.lazyitem.model.ItemData

@Composable
fun HomeScreen(
    viewModel: ItemViewModel = viewModel()
) {
    val context = LocalContext.current
    val listData by viewModel.itemlist.collectAsStateWithLifecycle()

    HomeComponent(
        items = listData,
        onListClicked = {item->
            Toast.makeText(
                context,
                "Item telah ditekan untuk item ${item.id}",
                Toast.LENGTH_SHORT
            ).show()
        },
        onButtonClicked = {item ->
            Toast.makeText(
                context,
                "Tombol telah ditekan untuk tombol ${item.id}",
                Toast.LENGTH_SHORT
            ).show()
        },
        onSwitchClicked = {item, isChecked->
            viewModel.updateSwitchState(item.id, isChecked)
            val status = if (isChecked) "hidup" else "Mati"
            Toast.makeText(
                context,
                "Switch $status pada item ${item.id}",
                Toast.LENGTH_SHORT
            ).show()
        }
    )
}

@Composable
fun HomeComponent (
    items: List<ItemData>,
    onListClicked: (ItemData)-> Unit,
    onButtonClicked: (ItemData)-> Unit,
    onSwitchClicked: (ItemData, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(innerPadding)
        ) {
            itemsIndexed(items = items, key = { _, item -> item.id }) { index, item ->
                ItemCard(
                    item = item,
                    index = index,
                    onListClicked = { onListClicked(item) },
                    onButtonClicked = { onButtonClicked(item) },
                    onSwitchClicked = { isChecked -> onSwitchClicked(item, isChecked) }
                )
            }
        }
    }
}


@Composable
fun ItemCard(
    item: ItemData,
    index : Int,
    onListClicked: () -> Unit,
    onButtonClicked: () -> Unit,
    onSwitchClicked: (Boolean) -> Unit
){
    val cardBackgroundColor = if (index % 2 == 0){
        colorResource(id = R.color.oddItem)
    }else{
        colorResource(id = R.color.evenItem)
    }
    Card(
        colors = CardDefaults.cardColors(containerColor = cardBackgroundColor),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {onListClicked()}
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.size(64.dp)
            ){
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ){
                Text(
                    text = stringResource(id = item.title),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = item.description),
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Switch(
                    checked = item.isSwitched,
                    onCheckedChange = { isChecked -> onSwitchClicked(isChecked)}
                )
                Spacer(modifier = Modifier.height(4.dp))
                Button(
                    onClick = {onButtonClicked()},
                    contentPadding = PaddingValues(16.dp, 4.dp),
                    modifier = Modifier.heightIn(min = 32.dp)
                ) {
                    Text(
                        text = stringResource(R.string.action),
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

