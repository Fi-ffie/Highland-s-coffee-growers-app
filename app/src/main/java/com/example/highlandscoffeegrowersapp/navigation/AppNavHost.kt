package com.example.highlandscoffeegrowersapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.digitalfarminspection.ui.theme.pages.login.Loginscreen
import com.example.highlandscoffeegrowersapp.ui.theme.pages.growerinfo.GrowerInfoScreen
import com.example.highlandscoffeegrowersapp.ui.theme.pages.home.HomeScreen
import com.example.highlandscoffeegrowersapp.ui.theme.pages.index.IndexScreen
import com.example.highlandscoffeegrowersapp.ui.theme.pages.purchaseinfo.PurchaseInfoScreen
import com.example.highlandscoffeegrowersapp.ui.theme.pages.register.Registerscreen
import com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs.RegisterScreen
import com.example.highlandscoffeegrowersapp.ui.theme.pages.splash.SplashScreen
import com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs.ContactUs
import com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs.EditPurchasedetailsScreen
import com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs.EditdetailsScreen
import com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs.PurchaseFertiliser
import com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs.UpdateFertiliserPurchase
import com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs.UpdateGrowerScreen
import com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs.ViewPurchase
import com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs.ViewdetailsScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController = rememberNavController(),
               startDestination: String = ROUTE_SPLASH){

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination){
//        composable(ROUTE_HOME){
//            LoginScreen(navController)
//        }
//        composable(ROUTE_SIGNUP){
//            SignupScreen(navController)
//        }
        composable(ROUTE_SPLASH){
            SplashScreen(navController)
        }
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_REGISTER){
            Registerscreen(navController)
        }
        composable(ROUTE_LOGIN){
            Loginscreen(navController)
        }
        composable(ROUTE_INDEX){
            IndexScreen(navController)
        }
        composable(ROUTE_GROWER_INFO){
            GrowerInfoScreen(navController)
        }
        composable(ROUTE_PURCHASE_INFO){
            PurchaseInfoScreen(navController)
        }
        composable(ROUTE_ENTER_GROWER_DETAILS){
            RegisterScreen(navController)
        }
        composable(ROUTE_VIEW_GROWER_DETAILS){
            ViewdetailsScreen(navController)
        }
        composable(ROUTE_EDIT_GROWER_DETAILS){
            EditdetailsScreen(navController)
        }
        composable(ROUTE_UPDATE_GROWER_DETAILS+"/{id}"){passedData->
            UpdateGrowerScreen(navController,passedData.arguments?.getString("id")!!)
        }
        composable(ROUTE_PURCHASE_FERTILISER){
            PurchaseFertiliser(navController)
        }
        composable(ROUTE_VIEW_FERTILISER_PURCHASE){
            ViewPurchase(navController)
        }
        composable(ROUTE_EDIT_PURCHASE_DETAILS){
            EditPurchasedetailsScreen(navController)
        }
        composable(ROUTE_UPDATE_FERTILISER_PURCHASE+"/{id}"){passedData->
            UpdateFertiliserPurchase(navController,passedData.arguments?.getString("id")!!)
        }
        composable(ROUTE_CONTACT_US){
            ContactUs(navController)

        }
    }
}