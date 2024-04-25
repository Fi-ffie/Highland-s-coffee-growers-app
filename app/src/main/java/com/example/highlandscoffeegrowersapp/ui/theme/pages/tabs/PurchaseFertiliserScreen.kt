package com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs

import android.app.DatePickerDialog
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.highlandscoffeegrowersapp.data.PurchaseRepository
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_INDEX
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_PURCHASE_FERTILISER
import com.example.highlandscoffeegrowersapp.ui.theme.DigitalFarmInspectionAppTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)

//@Composable
//fun CustomDatePicker(
//    selectedDate: Date?,
//    onDateSelected: (Date) -> Unit
//) {
//    val calendar = Calendar.getInstance()
//    val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
//        calendar.set(Calendar.YEAR, year)
//        calendar.set(Calendar.MONTH, month)
//        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//        onDateSelected(calendar.time)
//    }
//    val context = LocalContext.current
//
//    OutlinedButton(
//        onClick = {
//            val year = calendar.get(Calendar.YEAR)
//            val month = calendar.get(Calendar.MONTH)
//            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
//            val datePickerDialog = DatePickerDialog(context, dateSetListener, year, month, dayOfMonth)
//            datePickerDialog.show()
//        },
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth()
//            .background(Color.Transparent),
//        shape = RoundedCornerShape(8.dp),
//        colors = ButtonDefaults.outlinedButtonColors(
//            contentColor = Color(0xFFFF9800),
//        ),
//        border = BorderStroke(0.5.dp, Color.Black),
//        contentPadding = PaddingValues(8.dp)
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                tint = MaterialTheme.colorScheme.background,
//                imageVector = Icons.Default.DateRange,
//                contentDescription = null,
//                modifier = Modifier.size(24.dp)
//            )
//            Text(
//                text = selectedDate?.formatToDisplayDate() ?: "Select Date",
//                modifier = Modifier
//                    .padding(8.dp)
//                    .weight(1f),
//                color = Color(0xFF000000),
//            )
//        }
//    }
//}
//
//fun Date.formatToDisplayDate(): String {
//    val sdf = SimpleDateFormat("dd/MMMM/yyyy", Locale.getDefault())
//    return sdf.format(this)
//}
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun PurchaseFertiliser(navController: NavHostController) {
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .verticalScroll(rememberScrollState()),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        var context = LocalContext.current
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.Green),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Text(
//                text = "Purchase Fertiliser.",
//                color = Color.Black,
//                fontSize = 30.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(20.dp)
//            )
//        }
//        Spacer(modifier = Modifier.height(20.dp))
//
//        var quantity by remember { mutableStateOf(TextFieldValue("")) }
//        var supplier by remember { mutableStateOf(TextFieldValue("")) }
//        val successPurchase = remember { mutableStateOf(false) }
//
//         prices
//         Define the prices for each bike type
//        val DAP = 1500
//        val Humipower = 200
//        val CAN = 150
//        val  BoneManure = 2000
//        val Optimizer = 1200
//
//         Calculate the total price based on the selected bike type and quantity
//        var selectedname by remember { mutableStateOf(fertilisername[0]) }
//        val totalPrice = when (selectedOption) {
//            "DAP" -> DAP * quantity.toInt()
//            "Humipower" -> Humipower * quantity.toInt()
//            "CAN" -> CAN * quantity.toInt()
//            "BoneManure" -> BoneManure * quantity.toInt()
//            "Optimizer" -> Optimizer * quantity.toInt()
//            else -> 0 // Handle default case
//        }
//
//
//
//        val fertilisername = listOf(
//            "DAP : 1500ksh Per bag.",
//            "Humipower : 1800ksh Per bag.",
//            "CAN : 800ksh Per bag",
//            "Bone Manure : 2000 Per bag.",
//            "Optimizer : 1200 Per bag.")
//        // Add your specific options here
//        var selectedname by remember { mutableStateOf(fertilisername[0]) }
//        val options by remember { mutableStateOf(fertilisername) }
//        var selectedOption by remember { mutableStateOf(options[0]) }
//        var selectedDate by remember { mutableStateOf<Date?>(null) }
//
//
//        CustomDatePicker(
//            selectedDate = selectedDate,
//            onDateSelected = { date -> selectedDate = date }
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//
//        OutlinedDropdown(
//            value = selectedname,
//            onValueChange = { selectedname = it },
//            options = fertilisername,
//            label = { Text("Fertiliser Name with Tag Price.", color = Color.Black) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//            )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        OutlinedTextField(
//            value = quantity,
//            label = { Text(text = "Enter Quantity (bags)**") },
//            onValueChange = {
//                quantity = it
//
//            },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//
//        OutlinedTextField(
//            value = supplier,
//            label = { Text(text = "Enter Supplier **") },
//            onValueChange = {
//                supplier = it
//            },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        //Text("Total Price: $totalPrice", modifier = Modifier.padding(8.dp),color= Color.Black)
//
//
//        Button(onClick = {
////            Write the save logic here
//            var purchaseRepository = PurchaseRepository(navController,context)
//            purchaseRepository.savePurchase(
//                selectedDate?.formatToDisplayDate() ?:"",
//                selectedname.trim(),
//                quantity.text.trim(),
//                supplier.text.trim(),
//                successPurchase)
//
//            navController.navigate(ROUTE_INDEX )
//
//        }, colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
//            Text(text = "Purchase")
//        }
//        Spacer(modifier = Modifier.height(20.dp))
//
//    }
//}
//
//@Composable
//fun OutlinedDropdown(
//    value: String,
//    onValueChange: (String) -> Unit,
//    options: List<String>,
//    label: @Composable () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    var expanded by remember { mutableStateOf(false) }
//    var selectedIndex by remember { mutableStateOf(0) }
//    var hasSelection by remember { mutableStateOf(false) }
//
//    Column(
//        modifier = modifier
//    ) {
//        BasicTextField(
//            value = if (hasSelection) options[selectedIndex] else "Fertiliser Name with Tag price.",
//            onValueChange = {},
//            textStyle = TextStyle(color = Color(0xFF0C0C0C)),
//            readOnly = true,
//            decorationBox = { innerTextField ->
//                Box(
//                    contentAlignment = Alignment.CenterStart,
//                    modifier = Modifier
//                        .border(1.dp, Color.Gray)
//                        .padding(16.dp)
//                        .fillMaxSize()
//                        .clickable { expanded = !expanded },
//                ) {
//                    Spacer(modifier = Modifier.width(8.dp))
//                    innerTextField()
//                }
//            },
//
//            )
//
//        if (expanded) {
//            options.forEachIndexed { index, option ->
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable {
//                            selectedIndex = index
//                            onValueChange(option)
//                            expanded = false
//                            hasSelection = true
//                        }
//                        .padding(8.dp)
//                ) {
//                    Text(text = option,color= Color(0xFFFF9800))
//                }
//            }
//        }
//    }
//}
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Composable
//fun PurchaseFertiliserScreenPreview() {
//    DigitalFarmInspectionAppTheme {
//        PurchaseFertiliser(rememberNavController())
//
//    }
//}
//
@Composable
fun CustomDatePicker(
    selectedDate: Date?,
    onDateSelected: (Date) -> Unit
) {
    val calendar = Calendar.getInstance()
    val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        onDateSelected(calendar.time)
    }
    val context = LocalContext.current

    OutlinedButton(
        onClick = {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(context, dateSetListener, year, month, dayOfMonth)
            datePickerDialog.show()
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Color.Transparent),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color(0xFFFF9800),
        ),
        border = BorderStroke(0.5.dp, Color.Black),
        contentPadding = PaddingValues(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                tint = MaterialTheme.colorScheme.background,
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = selectedDate?.formatToDisplayDate() ?: "Select Date",
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                color = Color(0xFF000000),
            )
        }
    }
}

fun Date.formatToDisplayDate(): String {
    val sdf = SimpleDateFormat("dd/MMMM/yyyy", Locale.getDefault())
    return sdf.format(this)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurchaseFertiliser(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Purchase Fertiliser.",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        var growerName by remember { mutableStateOf(TextFieldValue("")) }
        var growerId by remember { mutableStateOf(TextFieldValue("")) }
        var quantity by remember { mutableStateOf(TextFieldValue("")) }
        var supplier by remember { mutableStateOf(TextFieldValue("")) }
        var successPurchase by remember { mutableStateOf(false) }

        //prices
        //Define the prices for each bike type
//        val DAP = 1500
//        val Humipower = 200
//        val CAN = 150
//        val  BoneManure = 2000
//        val Optimizer = 1200

        //Calculate the total price based on the selected bike type and quantity
        var selectedname by remember { mutableStateOf("") }
        val DAP = 1500
        val Humipower = 200
        val CAN = 150
        val  BoneManure = 2000
        val Optimizer = 1200

        val totalPrice = try {
            val quantityString = quantity.text.trim()
            when (selectedname) {
            "DAP : 1500ksh Per bag." -> DAP * quantityString.toInt()
            "Humipower" -> Humipower * quantityString.toInt()
            "CAN" -> CAN * quantityString.toInt()
            "BoneManure" -> BoneManure * quantityString.toInt()
            "Optimizer" -> Optimizer * quantityString.toInt()
            else -> 0 // Handle default case
        }
    } catch (e: NumberFormatException) {0}


        val fertilisername = listOf(
            "DAP : 1500ksh Per bag.",
            "Humipower : 1800ksh Per bag.",
            "CAN : 800ksh Per bag",
            "Bone Manure : 2000 Per bag.",
            "Optimizer : 1200 Per bag."
        )
        //var selectedname by remember { mutableStateOf(fertilisername[0]) }

        var selectedDate by remember { mutableStateOf<Date?>(null) }

        CustomDatePicker(
            selectedDate = selectedDate,
            onDateSelected = { date -> selectedDate = date }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = growerName,
            label = { Text(text = "Enter Grower's Name**") },
            onValueChange = {
                growerName = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = growerId,
            label = { Text(text = "Enter ID Number **") },
            onValueChange = {
                growerId = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedDropdown(
            value = selectedname,
            onValueChange = { selectedname = it },
            options = fertilisername,
            label = { Text("Fertiliser Name with Tag Price.", color = Color.Black) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = quantity,
            label = { Text(text = "Enter Quantity (bags)**") },
            onValueChange = {
                quantity = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = supplier,
            label = { Text(text = "Enter Supplier **") },
            onValueChange = {
                supplier = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        //var totalPrice by remember { mutableStateOf(0.0) }

//        Text(
//            text = "Total Price: $totalPrice",
//            fontWeight = FontWeight.Bold,
//            fontSize = 16.sp,
//            color = Color.Black
//        )
        Text("Total Price: $totalPrice", modifier = Modifier.padding(8.dp),color= Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                var purchaseRepository = PurchaseRepository(navController, context)
                purchaseRepository.savePurchase(
                    selectedDate?.formatToDisplayDate() ?: "",
                    growerName.text.trim(),
                    growerId.text.trim(),
                    selectedname.trim(),
                    quantity.text.trim(),
                    supplier.text.trim(),
                    successPurchase)

                navController.navigate(ROUTE_PURCHASE_FERTILISER)
            },
            colors = ButtonDefaults.buttonColors(Color.DarkGray)
        ) {
            Text(text = "Purchase")
        }
    }
}

@Composable
fun OutlinedDropdown(
    value: String,
    onValueChange: (String) -> Unit,
    options: List<String>,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    var hasSelection by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        BasicTextField(
            value = if (hasSelection) options[selectedIndex] else "Fertiliser Name with Tag price.",
            onValueChange = {},
            textStyle = TextStyle(color = Color(0xFF0C0C0C)),
            readOnly = true,
            decorationBox = { innerTextField ->
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .border(1.dp, Color.Gray)
                        .padding(16.dp)
                        .fillMaxSize()
                        .clickable { expanded = !expanded },
                ) {
                    Spacer(modifier = Modifier.width(8.dp))
                    innerTextField()
                }
            },
        )

        if (expanded) {
            options.forEachIndexed { index, option ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedIndex = index
                            onValueChange(option)
                            expanded = false
                            hasSelection = true
                        }
                        .padding(8.dp)
                ) {
                    Text(text = option, color = Color(0xFFFF9800))
                }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PurchaseFertiliserScreenPreview() {
    DigitalFarmInspectionAppTheme {
        PurchaseFertiliser(rememberNavController())
    }
}
//