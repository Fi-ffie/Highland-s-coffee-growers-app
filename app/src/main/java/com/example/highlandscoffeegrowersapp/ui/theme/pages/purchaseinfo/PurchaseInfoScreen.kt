package com.example.highlandscoffeegrowersapp.ui.theme.pages.purchaseinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_CONTACT_US
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_EDIT_PURCHASE_DETAILS
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_PURCHASE_FERTILISER
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_VIEW_FERTILISER_PURCHASE


@Composable
fun PurchaseInfoScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Fertiliser Purchase Tab",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate(ROUTE_PURCHASE_FERTILISER)
            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Purchase Fertiliser.")
        }
        Spacer(modifier = Modifier.height(5.dp))

        val context = LocalContext.current
        OutlinedButton(
            onClick = {
                val simToolKitLaunchIntent =
                    context.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Pay Via Mpesa.")
        }
        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                navController.navigate(ROUTE_VIEW_FERTILISER_PURCHASE)
            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "View Purchase Details.")
        }
        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                navController.navigate(ROUTE_EDIT_PURCHASE_DETAILS)
            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Edit Purchase Details.")
        }
        Spacer(modifier = Modifier.height(5.dp))
        }
    }






