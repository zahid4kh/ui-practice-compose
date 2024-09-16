package com.practice.ubereats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.ubereats.ui.theme.UbereatsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UbereatsTheme {
                //App()
            }
        }
    }
}



@Composable
@Preview
fun App(){}

@Composable
@Preview
fun Categories(){
    Row (horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(MaterialTheme.colorScheme.background)) {

        Card (modifier = Modifier.fillMaxWidth().weight(0.5f).padding(horizontal = 5.dp, vertical = 5.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                Column(verticalArrangement = Arrangement.SpaceBetween, modifier=Modifier.weight(4f).padding(horizontal = 10.dp)){

                    Text(text = "Promo", modifier=Modifier.padding(vertical = 10.dp))
                    Text(text = "Restaurants", modifier=Modifier.padding(vertical = 10.dp))
                }
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
                    modifier=Modifier.weight(1f)){
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = "")
                }
            }
        }

        Card (modifier = Modifier.fillMaxWidth().weight(0.5f).padding(horizontal = 5.dp, vertical = 5.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                Column(verticalArrangement = Arrangement.SpaceBetween, modifier=Modifier.weight(4f).padding(horizontal = 10.dp)){

                    Text(text = "Promo", modifier=Modifier.padding(vertical = 10.dp))
                    Text(text = "Lebensmittel", modifier=Modifier.padding(vertical = 10.dp))
                }
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
                    modifier=Modifier.weight(1f)){
                    Icon(imageVector = Icons.Default.Home, contentDescription = "")
                }
            }
        }


    }
}


@Composable
@Preview
fun SearchBar(){

}































