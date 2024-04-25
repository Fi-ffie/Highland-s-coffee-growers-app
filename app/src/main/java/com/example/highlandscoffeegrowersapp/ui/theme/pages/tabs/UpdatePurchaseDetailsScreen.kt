package com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs

import android.content.res.Configuration
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.highlandscoffeegrowersapp.data.PurchaseRepository
import com.example.highlandscoffeegrowersapp.data.GrowerRepository
import com.example.highlandscoffeegrowersapp.models.Purchase
import com.example.highlandscoffeegrowersapp.models.Grower
import com.example.highlandscoffeegrowersapp.ui.theme.DigitalFarmInspectionAppTheme
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateFertiliserPurchase(navController: NavHostController, id:String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Update Purchase Details",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))


        var date by remember { mutableStateOf("") }
        var growerName by remember { mutableStateOf("") }
        var growerID by remember { mutableStateOf("") }
        var name by remember { mutableStateOf("") }
        var quantity by remember { mutableStateOf("") }
        var supplier by remember { mutableStateOf("") }
        var currentDataRef = FirebaseDatabase.getInstance().getReference().child("Purchases/$id")

        var displayState by remember {
            mutableStateOf(0)
        }

        currentDataRef.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var purchase = snapshot.getValue(Purchase::class.java)

                if (displayState<1){
                    displayState++
                    date = purchase!!.selectedDate
                    growerName = purchase!!.growerName
                    growerID = purchase!!.growerID
                    name = purchase!!.selectedname
                    quantity = purchase!!.quantity
                    supplier = purchase!!.supplier
                    Log.d("fetch_display_state", "onDataChange: "+displayState)
                }else{
                    displayState+=10
                }


            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        OutlinedTextField(
            value = date,
            label = { Text(text = "Enter Purchase Date**") },
            onValueChange = {
                date = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
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
            value = growerID,
            label = { Text(text = "Enter ID Number **") },
            onValueChange = {
                growerID = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            label = { Text(text = "Enter Fertiliser Name**") },
            onValueChange = {
                name = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = quantity,
            label = { Text(text = "Enter Quantity **") },
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



        Button(onClick = {
//            Write the update logic here
            var purchaseRepository = PurchaseRepository(navController, context)
            purchaseRepository.updatePurchase(date.trim(),growerName.trim(),growerID.trim(),
                name.trim(), quantity.trim(),supplier.trim(),id)

        }, colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
            Text(text = "Update")
        }
    }
}
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun UpdateFertiliserPurchase() {
    DigitalFarmInspectionAppTheme {
        UpdateFertiliserPurchase(rememberNavController(), id = "")

    }
}
