package com.thiagofialho.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagofialho.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpended by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(0.01) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        //Here all the UI elements will be stacked below each other
        Text(text = "Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
            },
            label = { Text(text = "Enter Value")}
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            //Input Box
            Box{
                //Input Button
                Button(onClick = {
                    iExpended = true
                }) {
                    Text(text = "Select")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpended, onDismissRequest = { iExpended = false }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            iExpended = false
                            inputValue = "Centimeters"
                            conversionFactor.value = 0.01
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Milimeters") },
                        onClick = { /*TODO*/ }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            //Output Box
            Box{
                //Output Button
                Button(onClick = {
                    oExpanded = true
                }) {
                    Text(text = "Select")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Milimeters") },
                        onClick = { /*TODO*/ }
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun previewUnitConverter(){
    UnitConverter()
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UnitConverterTheme {
        Greeting("Android")
    }
}