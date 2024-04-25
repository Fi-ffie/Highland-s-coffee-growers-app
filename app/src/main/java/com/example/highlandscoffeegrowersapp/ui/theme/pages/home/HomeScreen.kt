@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.highlandscoffeegrowersapp.ui.theme.pages.home

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_REGISTER
import com.example.highlandscoffeegrowersapp.ui.theme.DigitalFarmInspectionAppTheme
import com.example.highlandscoffeegrowersapp.R
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_INDEX

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {


    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Column(modifier = Modifier
            .fillMaxWidth().background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Highlands Coffee Grower's App",
                color = Color.Black ,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }


        Spacer(modifier = Modifier.height(15.dp))


        Image(
            painter = painterResource(id = R.drawable.innerlogo),
            contentDescription = null,
            modifier = Modifier.height(80.dp).width(100.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))


//Start of text
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,


        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth().padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier.height(50.dp).width(50.dp)
                )
                Text(
                    text = "Our Company",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Nyeri County is renowned for its high-quality coffee. Highlands Coffee growers’ Cooperative society supports farmers in the region." +
                            "We offer training, access to extension services, and help with processing and marketing to ensure that Nyeri coffee maintains its premium status.",
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.height(17.dp))


                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier.height(50.dp).width(50.dp)
                )
                Text(
                    text = "Our Coffee",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Our specialty coffees, and in particular the AA and AB grades, out-match other coffees when it comes to acidity and complexity." +
                            "Our highland Arabica coffee beans are the key gradient of prestigious gourmet roasters all around the world.",
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.height(17.dp))


                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier.height(50.dp).width(50.dp)
                )
                Text(
                    text = "Sustainability",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Through continuously improving our processes, we strive to adhere to" +
                            " ethical standards for processing our coffee throughout our supply chain.",
                    color = Color.Black,
                )
            }
        }


        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                navController.navigate(ROUTE_REGISTER)

            },
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
        )
        {
            Text(
                text = " WELCOME :)",
                color = Color.White,
                fontFamily = androidx.compose.ui.text.font.FontFamily.Serif
            )


        }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                Button(
//                    onClick = {
//                        navController.navigate(ROUTE_REGISTER_GROWER)
//                    },
//                    modifier = Modifier.height(45.dp).width(170.dp),
//                    shape = CircleShape,
//                    colors = ButtonDefaults.buttonColors(Color.Yellow)
//                ) {
//                    Text(
//                        text = "Register Grower",
//                        color = Color.Black,
//                        fontSize = 15.sp,
//
//                    )
//                }
//                Spacer(modifier = Modifier.width(15.dp))
//
//                Button(
//                    onClick = {
//                        navController.navigate(ROUTE_GROWER_DETAILS)
//                    },
//                    modifier = Modifier.height(45.dp).width(170.dp),
//                    shape =CircleShape,
//                    colors = ButtonDefaults.buttonColors(Color.Yellow)
//                ) {
//                    Text(
//                        text = "Grower Details",
//                        color = Color.Black,
//                        fontSize = 15.sp,
//
//                    )
//                }

            }
    }

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreview() {
    DigitalFarmInspectionAppTheme() {
        HomeScreen(rememberNavController())
    }


}



