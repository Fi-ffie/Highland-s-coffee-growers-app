package com.example.highlandscoffeegrowersapp.ui.theme.pages.register

import android.content.res.Configuration
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.digitalfarminspection.ui.theme.pages.login.Loginscreen
import com.example.highlandscoffeegrowersapp.R
import com.example.highlandscoffeegrowersapp.data.AuthViewModel
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_INDEX
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_LOGIN
import com.example.highlandscoffeegrowersapp.ui.theme.DigitalFarmInspectionAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registerscreen(navController: NavHostController) {

    var  email by remember { mutableStateOf(TextFieldValue("")) }
    var  pass by remember { mutableStateOf(TextFieldValue("")) }
    var  confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally)
    {

//        var context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Register Here..",
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
        OutlinedTextField(
            value = email, onValueChange = {email=it},
            label = { Text(text = "Enter Email" , color = Color.Black) },

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = pass, onValueChange = {pass=it},
            label = { Text(text = "Enter Password" , color = Color.Black) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = confirmpass, onValueChange = {confirmpass=it},
            label = { Text(text = "Confirm Password" , color = Color.Black) },

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Button(onClick = {
            val myregister= AuthViewModel(navController, context)
            myregister.register(email.text.trim(),pass.text.trim(),confirmpass.text.trim())
//            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
            Text(text = "Register")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
            Text(text = "Have an account? Click to Login.")
        }
    }
}
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun RegisterScreenPreview() {
//    DigitalFarmInspectionAppTheme {
        Registerscreen(rememberNavController())
    }
