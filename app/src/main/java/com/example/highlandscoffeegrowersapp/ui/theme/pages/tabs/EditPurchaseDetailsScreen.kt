package com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.highlandscoffeegrowersapp.data.PurchaseRepository
import com.example.highlandscoffeegrowersapp.data.GrowerRepository
import com.example.highlandscoffeegrowersapp.models.Purchase
import com.example.highlandscoffeegrowersapp.models.Grower
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_UPDATE_FERTILISER_PURCHASE

@Composable
fun EditPurchasedetailsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var purchaseRepository = PurchaseRepository(navController,context)

        val emptyPurchaseState = remember { mutableStateOf(Purchase("","","","","","","")) }
        var emptyPurchasesListState = remember { mutableStateListOf<Purchase>() }

        var purchases = purchaseRepository.viewPurchase(emptyPurchaseState, emptyPurchasesListState)

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green),
                horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "Edit Purchase Details.",
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))


            LazyColumn(){
                items(purchases.count()){
                    var date = purchases.get(it).selectedDate
                    var growerName = purchases.get(it).growerName
                    var growerID = purchases.get(it).growerID
                    var name = purchases.get(it).selectedname
                    var quantity = purchases.get(it).quantity
                    var supplier = purchases.get(it).supplier
                    var id = purchases.get(it).id
                    PurchaseItem(
                        date = date,
                        growerName = growerName,
                        growerID = growerID,
                        name = name,
                        quantity = quantity,
                        supplier = supplier,
                        id = id,
                        navController=navController,
                        purchaseRepository = purchaseRepository)

                }

            }
        }



    }

}


@Composable
fun PurchaseItem(
    date: String,
    growerName: String,
    growerID: String,
    name: String,
    quantity: String,
    supplier: String,
    id: String,
    navController: NavHostController,
    purchaseRepository: PurchaseRepository
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Date: $date", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(text = "growerName: $growerName")
            Text(text = "growerID: $growerID")
            Text(text = "Name: $name")
            Text(text = "Quantity: $quantity")
            Text(text = "Supplier: $supplier")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(colors = ButtonDefaults.buttonColors(Color.Black),
                    onClick = {
                        navController.navigate(ROUTE_UPDATE_FERTILISER_PURCHASE + "/$id")
                    }

                ) {
                    Text(text = "Update",color = Color.Yellow)
                }

                Button(colors = ButtonDefaults.buttonColors(Color.Black),
                    onClick = {
                        purchaseRepository.deletePurchase(id)
                    }
                ) {
                    Text(text = "Delete",color = Color.Yellow)
                }
            }
        }
    }
}
