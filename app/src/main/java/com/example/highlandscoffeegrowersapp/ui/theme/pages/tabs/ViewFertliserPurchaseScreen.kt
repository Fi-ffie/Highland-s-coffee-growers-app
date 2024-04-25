package com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.highlandscoffeegrowersapp.models.Purchase

@Composable
fun ViewPurchase(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var purchaseRepository = PurchaseRepository(navController,context)

        val emptyPurchaserState = remember { mutableStateOf(Purchase("", "", "", "","","","")) }
        var emptyPurchaseListState = remember { mutableStateListOf<Purchase>() }

        var purchase = purchaseRepository.viewPurchase(emptyPurchaserState, emptyPurchaseListState)

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
                    text = "Fertiliser Purchase Details.",
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))


            LazyColumn(){
                items(purchase.count()){
                    var selectedDate = purchase.get(it).selectedDate
                    var growerName = purchase.get(it).growerName
                    var growerID = purchase.get(it).growerID
                    var selectedname = purchase.get(it).selectedname
                    var quantity = purchase.get(it).quantity
                    var supplier = purchase.get(it).supplier
                    var id = purchase.get(it).id
                    ViewPurchaseItem(
                        selectedDate = selectedDate,
                        growerName = growerName,
                        growerID = growerID,
                        selectedname = selectedname,
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
fun ViewPurchaseItem(
    selectedDate: String,
    growerName: String,
    growerID: String,
    selectedname: String,
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
            Text(text = "selectedDate: $selectedDate", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(text = "growerName: $growerName")
            Text(text = "growerID: $growerID")
            Text(text = "selectedname: $selectedname")
            Text(text = "quantity: $quantity")
            Text(text = "supplier: $supplier")
        }
    }
}
