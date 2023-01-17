package com.example.petapp.ui.theme

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petapp.R

@Composable
fun SlashScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.girl_dog),
            contentDescription = null
        )
        Column(
            modifier = modifier
                .padding(15.dp)
        ) {
            Text(
                modifier = modifier
                    .paddingFromBaseline(top = 20.dp, bottom = 10.dp),
                style = Typography.h3,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                text = "Make a new \nFriend"
            )
            Text(
                modifier = modifier
                    .paddingFromBaseline(top = 30.dp, 15.dp)
                ,
                fontSize = 22.sp,
                text = "Adopt a dog and make a new home for them to be happy."
            )
            
            Spacer(modifier = modifier.padding(20.dp))

            Box(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(Blue)
                    .padding(vertical = 15.dp, horizontal = 50.dp)
            ){
                Text(
                    modifier = modifier,
                    fontSize = 23.sp,
                    color = Color.White,
                    text = "Welcome"
                )
            }
        }


    }
}

@Preview (showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun SplashScreenPreview(){
    PetAppTheme {
        SlashScreen()
    }
}