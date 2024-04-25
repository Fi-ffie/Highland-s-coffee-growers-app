package com.example.highlandscoffeegrowersapp.ui.theme.pages.growerinfo

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_EDIT_GROWER_DETAILS
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_ENTER_GROWER_DETAILS
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_VIEW_GROWER_DETAILS

@Composable
fun GrowerInfoScreen(navController: NavHostController) {
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
                text = "Grower Tab",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

//        Button(onClick = {
//            navController.navigate(ROUTE_REGISTER_GROWER)
//        }, colors = ButtonDefaults.buttonColors()
//            ,modifier = Modifier.fillMaxWidth()) {
//            Text(text = "Register Grower.")
//        }
//        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                navController.navigate(ROUTE_ENTER_GROWER_DETAILS)
            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Enter Grower Details.")
        }
        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                navController.navigate(ROUTE_VIEW_GROWER_DETAILS)
            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "View Grower Details.")
        }
        Spacer(modifier = Modifier.height(5.dp))

//        Button(
//            onClick = {
//                navController.navigate(ROUTE_UPDATE_GROWER_DETAILS)
//            },
//            colors = ButtonDefaults.buttonColors(Color.Gray),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(text = "Update Grower Details.")
//        }
//        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                navController.navigate(ROUTE_EDIT_GROWER_DETAILS)
            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Edit Grower Details.")
        }
        Spacer(modifier = Modifier.height(5.dp))
    }
}
