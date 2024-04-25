package com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs

import android.content.res.Configuration
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.highlandscoffeegrowersapp.data.GrowerRepository
import com.example.highlandscoffeegrowersapp.models.Grower
import com.example.highlandscoffeegrowersapp.ui.theme.DigitalFarmInspectionAppTheme

@Composable
fun ViewdetailsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var growerRepository = GrowerRepository(navController,context)

        val emptyGrowerState = remember { mutableStateOf(Grower("","","","","","","")) }
        var emptyGrowersListState = remember { mutableStateListOf<Grower>() }

        var growers = growerRepository.viewGrower(emptyGrowerState, emptyGrowersListState)

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
                    text = "Grower Details.",
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))


            LazyColumn(){
                items(growers.count()){
                    var growerName = growers.get(it).name
                    var growerNumber = growers.get(it).gnumber
                    var growerId = growers.get(it).idnumber
                    var phoneNumber = growers.get(it).phone
                    var numberofBushes = growers.get(it).bushes
                    var area = growers.get(it).garea
                    var id = growers.get(it).id
                    ViewGrowerItem(
                        name = growerName,
                        gnumber = growerNumber,
                        idnumber = growerId,
                        phone = phoneNumber,
                        bushes = numberofBushes,
                        garea = area,
                        id = id,
                        navController=navController,
                        growerRepository = growerRepository)

                }

            }
        }



    }

}


@Composable
fun ViewGrowerItem(
    name: String,
    gnumber: String,
    idnumber: String,
    phone: String,
    bushes: String,
    garea: String,
    id: String,
    navController: NavHostController,
    growerRepository: GrowerRepository
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
            Text(text = "Name: $name", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(text = "Grower Number: $gnumber")
            Text(text = "ID Number: $idnumber")
            Text(text = "Phone: $phone")
            Text(text = "Bushes: $bushes")
            Text(text = "Area(Acres): $garea")
        }
    }
}
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Composable
//fun ViewdetailsScreenPreview() {
//    DigitalFarmInspectionAppTheme {
//        ViewdetailsScreen(rememberNavController())
//    }
//}

