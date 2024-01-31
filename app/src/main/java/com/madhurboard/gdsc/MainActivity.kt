package com.madhurboard.gdsc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madhurboard.gdsc.R
import com.madhurboard.gdsc.ui.theme.GDSCTheme
import com.madhurboard.gdsc.ui.theme.Purple1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GDSCTheme {
                MyScreen()

            }
        }
    }

    @Composable
    fun MyScreen() {
        var Amount by remember {
            mutableStateOf("")
        }

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(26.dp)
                    .height(200.dp),
                backgroundColor = Purple1,
                elevation = 10.dp,
                shape = RoundedCornerShape(30.dp)
            ) {
                Column {
                    Myrow1()
                    Myrow2()
                }


            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(26.dp),
                backgroundColor = Purple1,
                elevation = 10.dp,
                shape = RoundedCornerShape(30.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    OutlinedTextField(
                        value = Amount,
                        onValueChange = {
                            if (it.toDoubleOrNull() != null) {
                                Amount = it
                            }
                        },
                        label = { Text(text = "Amount") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp)
        ) {

            val amount = Amount.toDoubleOrNull() ?: 0.0
            val tip = CalculateTip(amount)
            Text(text = "Tip to pay: $tip")
        }

    }

    private fun CalculateTip(Amount: Double): Double {
        val Tip = Amount * 0.15
        return Tip
    }

    @Composable
    fun Myrow1() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Madhur's \nAndroid",
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Image(
                painter = painterResource(id = R.drawable.gdsc_logo),
                contentDescription = "GDSC logo"
            )

        }
    }

    @Composable
    fun Myrow2() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android logo"
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(

                    text = "madhurpatil73@gmail.com\nAndroid Compose Camp\n2024",
                    textAlign = TextAlign.Right,
                    fontSize = 10.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        GDSCTheme {
            MyScreen()
        }
    }
}
