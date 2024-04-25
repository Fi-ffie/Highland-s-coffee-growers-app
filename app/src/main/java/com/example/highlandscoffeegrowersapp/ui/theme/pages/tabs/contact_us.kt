package com.example.highlandscoffeegrowersapp.ui.theme.pages.tabs

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun ContactUs(navController: NavHostController) {
    val context = LocalContext.current
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth().background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Contact Us",
                color = Color.Black ,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "We value your inquiries and feedback.\n" +
                    "Please feel free to reach out to us using any of the following methods:",
            color = Color.Black,
            modifier = Modifier.padding(10.dp),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))


        OutlinedButton(
            onClick = {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254719713965"))

                if (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        1
                    )
                } else {
                    context.startActivity(intent)
                }

            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(text = "Call",
                fontSize = 15.sp)
        }
        OutlinedButton(onClick = {
            val uri = Uri.parse("smsto:0710423445")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("Hello", "Welcome Highlands Coffee Growers App.")

            context.startActivity(intent)
        },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(text = "SMS",
                fontSize = 15.sp)
        }
        OutlinedButton(
            onClick = {
                val emailIntent =
                    Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "info@highlandsco-opgmail.com", null))

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

                context.startActivity(Intent.createChooser(emailIntent, "Send email..."))
            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(text = "Email",
                fontSize = 15.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "You can also share this app to prospective coffee growers in the region." +
                    " \n Welcome to Highlands CO-OP.",
            color = Color.Black,
            modifier = Modifier.padding(10.dp),
            fontSize = 20.sp
        )

        OutlinedButton(
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)

                shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                shareIntent.type = "text/plain"

                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

                context.startActivity(shareIntent)
            },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(text = "Share",
                fontSize = 15.sp)
        }

    }
}
@Preview
@Composable
fun ContactUsPreview() {
    ContactUs(rememberNavController())
}