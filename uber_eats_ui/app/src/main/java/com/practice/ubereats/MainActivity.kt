package com.practice.ubereats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.ubereats.ui.theme.UbereatsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UbereatsTheme {
                App()
            }
        }
    }
}



@Composable
@Preview
fun App(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .verticalScroll(ScrollState(1), enabled = true)){

        Spacer(modifier=Modifier.height(50.dp))
        SearchBar()
        Categories()
        Options()
        Pics()
    }
}
//TODO - change promo fill & Outline
@Composable
@Preview
fun Categories(){
    val restaurantVector = ImageVector.vectorResource(R.drawable.restaurant)
    val foodVector = ImageVector.vectorResource(R.drawable.food)
    Row (horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(MaterialTheme.colorScheme.background)) {

        Card (modifier = Modifier
            .fillMaxWidth()
            .weight(0.5f)
            .padding(horizontal = 5.dp, vertical = 5.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                Column(verticalArrangement = Arrangement.SpaceBetween, modifier= Modifier
                    .weight(3f)
                    .padding(horizontal = 10.dp)){

                    //Text(text = "Promo", modifier=Modifier.padding(vertical = 10.dp))
                    Text(text = "Restaurants", modifier=Modifier.padding(vertical = 10.dp), fontWeight = FontWeight.Bold)
                }
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
                    modifier=Modifier.weight(1f)){
                    Icon(restaurantVector, contentDescription = "", modifier=Modifier.padding(10.dp))
                }
            }
        }

        Card (modifier = Modifier
            .fillMaxWidth()
            .weight(0.5f)
            .padding(horizontal = 5.dp, vertical = 5.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                Column(verticalArrangement = Arrangement.SpaceBetween, modifier= Modifier
                    .weight(3f)
                    .padding(horizontal = 10.dp)){

                    //Text(text = "Promo", modifier=Modifier.padding(vertical = 10.dp))
                    Text(text = "Food", modifier=Modifier.padding(vertical = 10.dp), fontWeight = FontWeight.Bold)
                }
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
                    modifier=Modifier.weight(1f)){
                    Icon(foodVector, contentDescription = "", modifier=Modifier.padding(10.dp))
                }
            }
        }


    }
}


@Composable
@Preview
fun SearchBar(){
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = {text = it},
        placeholder = {Text("Essen, Lebensmittel, Getränke...")},
        shape = MaterialTheme.shapes.extraLarge,
        leadingIcon = { Icon(Icons.Default.Search, "", modifier = Modifier.padding(start=10.dp))},
        trailingIcon = { Icon(Icons.AutoMirrored.Filled.List, "", modifier = Modifier.padding(end = 10.dp)) },
        colors = TextFieldDefaults.colors(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 15.dp)
    )
}


@Composable
@Preview
fun Options(){
    val columnWeight = 0.5f
    val columnPadding = 5.dp
    val textPadding = 5.dp
    val textFontSize = 13.sp
    val iconSize = 20.dp
    val iconPadding = 20.dp

    val drinkVector = ImageVector.vectorResource(id = R.drawable.drink)
    val carVector = ImageVector.vectorResource(id = R.drawable.car)
    val flowerVector = ImageVector.vectorResource(id = R.drawable.flower)
    val convVector = ImageVector.vectorResource(id = R.drawable.convenience)

    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()){

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .weight(columnWeight)
            .padding(columnPadding)){

            Card (modifier = Modifier.fillMaxWidth()) {
                Icon(drinkVector, "", modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(iconPadding)
                    .size(iconSize))
            }
            Text(text = "Alcohol",
                fontSize = textFontSize,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = textPadding))
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .weight(columnWeight)
            .padding(columnPadding)){

            Card (modifier = Modifier.fillMaxWidth()) {
                Icon(carVector, "", modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(iconPadding)
                    .size(iconSize))
            }
            Text(text = "Fahrt",
                fontSize = textFontSize,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = textPadding))
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .weight(columnWeight)
            .padding(columnPadding)){

            Card (modifier = Modifier.fillMaxWidth()) {
                Icon(convVector, "", modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(iconPadding)
                    .size(iconSize))
            }
            Text(text = "Convenience",
                fontSize = textFontSize,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = textPadding))
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .weight(columnWeight)
            .padding(columnPadding)){

            Card (modifier = Modifier.fillMaxWidth()) {
                Icon(flowerVector, "", modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(iconPadding)
                    .size(iconSize))
            }
            Text(text = "Blumen",
                fontSize = textFontSize,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = textPadding))
        }

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun Pics(){
    val textColor = MaterialTheme.colorScheme.onBackground
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp).background(MaterialTheme.colorScheme.background)){
        Card(modifier = Modifier.fillMaxWidth().padding(top = 5.dp)){
            Image(painter = painterResource(id = R.drawable._3295049_5193138), contentDescription = "")
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.horizontalScroll(ScrollState(0), enabled = true)){
            Column(modifier=Modifier.fillMaxWidth().padding(top = 3.dp)){
                Text(text = "Italian Pizza", fontWeight = FontWeight.Bold, color = textColor)

                Row(modifier = Modifier.fillMaxWidth()){
                    Text(text = "Gesponsert", textDecoration = TextDecoration.Underline, color = textColor )
                    Text(" | ", color = textColor)
                    Text(text = "€0 Liefergebühr", color = colorResource(R.color.OrangeDark))
                    Text(" | ", color = textColor)
                    Text("10-25 Min.", color = textColor)
                }
            }

            Column(modifier = Modifier
                .fillMaxSize()
                .clip(shape = CircleShape)
                .background(Color.LightGray),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){

                Text("4.3", fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }
    }


}























