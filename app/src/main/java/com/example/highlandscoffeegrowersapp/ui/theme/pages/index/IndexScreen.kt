package com.example.highlandscoffeegrowersapp.ui.theme.pages.index

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.highlandscoffeegrowersapp.R
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_CONTACT_US
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_EDIT_GROWER_DETAILS
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_EDIT_PURCHASE_DETAILS
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_ENTER_GROWER_DETAILS
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_GROWER_INFO
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_PURCHASE_FERTILISER
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_PURCHASE_INFO
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_UPDATE_GROWER_DETAILS
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_VIEW_FERTILISER_PURCHASE
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_VIEW_GROWER_DETAILS

@Composable
fun IndexScreen(navController: NavHostController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Navigation Tab",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.innerlogo),
            contentDescription = "Stunning",
            modifier = Modifier.size(300.dp)
        )

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
                navController.navigate(ROUTE_GROWER_INFO)
            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Grower Tab.")
        }
        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                navController.navigate(ROUTE_PURCHASE_INFO)
            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Fertliser Purchase Tab.")
        }
        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                navController.navigate(ROUTE_CONTACT_US)
            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Contact Us.")
        }
        Spacer(modifier = Modifier.height(5.dp))
    }
}
@Preview
@Composable
fun IndexPreview() {
    IndexScreen(rememberNavController())
}
