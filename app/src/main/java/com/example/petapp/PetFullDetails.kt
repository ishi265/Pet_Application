package com.example.petapp

import android.telecom.Call.Details
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petapp.ui.theme.PetAppTheme

@Composable
fun DogPictureTop(modifier: Modifier = Modifier){
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(modifier = modifier
            .fillMaxWidth()
            .height(400.dp)){
            Image(
                modifier = modifier,
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.cat2),
                contentDescription = null,
            )
        }
    }
}

@Preview (showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun DogPicturePreview(){
    PetAppTheme {
        DogPictureTop()
    }
}

@Composable
fun DogDetails(modifier: Modifier = Modifier){

}

@Preview (showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun DogDetailsPreview(){
    PetAppTheme {
        DogDetails()
    }
}

@Composable
fun ExtraDetails(modifier: Modifier = Modifier){

}

@Preview (showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun ExtraDetailsPreview(){
    PetAppTheme {
        ExtraDetails()
    }
}

@Composable
fun OwnerDetails(modifier: Modifier = Modifier){

}

@Preview (showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun OwnerDetailsPreview (){
    PetAppTheme {
        OwnerDetails()
    }
}

@Composable
fun Details(modifier: Modifier = Modifier){

}

@Preview (showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun DetailsPreview(){

}

@Composable
fun AdoptButton(modifier: Modifier = Modifier){

}

@Preview (showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun AdoptButtonPreview(){
    PetAppTheme {
        AdoptButton()
    }
}