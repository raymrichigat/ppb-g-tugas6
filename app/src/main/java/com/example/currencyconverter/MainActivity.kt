package com.example.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import com.example.currencyconverter.ui.theme.CurrencyConverterTheme
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurrencyConverterTheme {
                CurrencyConverterApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyConverterApp() {
    var amountToConvert by remember { mutableStateOf("") }
    var selectedConversion by remember { mutableStateOf("IDR to USD") }
    var result by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    val rates = mapOf(
        "IDR to USD" to 0.000059,
        "USD to IDR" to 16832.0,
        "IDR to EUR" to 0.000052,
        "EUR to IDR" to 19124.12,
        "IDR to JPY" to 0.0085,
        "JPY to IDR" to 117.86
    )

    val currencySymbols = mapOf(
        "IDR" to "Rp",
        "USD" to "$",
        "EUR" to "€",
        "JPY" to "¥"
    )

    val conversionRate = rates[selectedConversion] ?: 1.0
    val conversionOptions = rates.keys.toList()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Currency Converter") })
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    TextField(
                        value = amountToConvert,
                        onValueChange = { amountToConvert = it },
                        label = { Text("Enter amount") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Dropdown menu
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded }
                    ) {
                        OutlinedTextField(
                            value = selectedConversion,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Conversion Type") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                            },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth()
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            conversionOptions.forEach { selectionOption ->
                                DropdownMenuItem(
                                    text = { Text(selectionOption) },
                                    onClick = {
                                        selectedConversion = selectionOption
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            val amount = amountToConvert.toDoubleOrNull()
                            if (amount != null) {
                                val converted = amount * conversionRate
                                val targetCurrency = selectedConversion.split(" to ").last()
                                val currencySymbol = currencySymbols[targetCurrency] ?: ""
                                val formatter = NumberFormat.getNumberInstance(Locale.getDefault())
                                formatter.minimumFractionDigits = 2
                                formatter.maximumFractionDigits = 2
                                result = "$currencySymbol ${formatter.format(converted)}"
                            } else {
                                result = "Invalid input"
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Convert", style = MaterialTheme.typography.labelLarge)
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    if (result.isNotEmpty() && result != "Invalid input") {
                        Text(
                            text = "Result: $result",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    } else if (result == "Invalid input") {
                        Text(
                            text = result,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
    }
}