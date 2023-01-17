package com.example.petapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petapp.ui.theme.*
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun LocationItem(
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ){
        Row() {
            Surface(
                modifier = modifier
                    .clip(RoundedCornerShape(50.dp))
                    .background(color = MyGray)
            ) {
                Image(
                    modifier = modifier
                        .padding(5.dp)
                        .size(30.dp)
                    ,
                    painter = painterResource(id = R.drawable.dots),
                    contentDescription = null
                )
            }
            Column(
                modifier = modifier.padding(horizontal = 15.dp)
            ) {
                Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Location")
                    Image(
                        modifier = modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.chevron),
                        contentDescription = null
                    )
                }
                Text(text = "Lilongwe, Malawi")
            }
        }
        Surface(
            modifier = modifier
                .clip(RoundedCornerShape(50.dp))
                .background(color = MyGray),
        ) {
            Image(
                modifier = modifier
                    .padding(5.dp)
                    .size(30.dp),
                painter = painterResource(id = R.drawable.filter),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun LocationItemPreview(){
    PetAppTheme {
        LocationItem()
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
){
    TextField(
        value = "",
        onValueChange = {},
        maxLines = 1,
        placeholder = {
            Text( text = "Search..")
                      },
        leadingIcon = {
            Icon(
                modifier = modifier
                    .padding(horizontal = 10.dp)
                    .width(25.dp),
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = ""
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(70.dp)
            .padding(15.dp)
//            .background(color = MyGray)
            .clip(shape = RoundedCornerShape(25.dp)),
    )
}

@Preview(showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun searchBarPreview(){
    PetAppTheme {
        SearchBar()
    }
}

@Composable
fun PetDiscount(
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Row(
            modifier = modifier
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = modifier) {
                Text(
                    modifier = Modifier,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontSize = 22.sp)
                    ,text = "40% Off on all \nBird Adoption"
                )
                
                Spacer(modifier = modifier.padding(18.dp))

                Box(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = Blue)
                        .padding(horizontal = 25.dp, vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Explore", color = Tabwhite)
                }
            }
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.home_background),
                contentDescription = "null",
                modifier = modifier
                    .size(150.dp),)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun PetDiscountPreview(){
    PetAppTheme {
        PetDiscount()
    }
}

@Composable
fun PetCategory(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(20.dp))
    ) {
        Column(
            modifier = modifier.padding(horizontal = 15.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = drawable),
                contentDescription = null,
                modifier = modifier.size(20.dp)
            )
            Spacer(modifier = modifier.padding(bottom = 5.dp))
            Text(stringResource(id = text))
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun PetCategoryPreview(){
    PetAppTheme {
        PetCategory(
            R.drawable.cat,
            R.string.cat_cat
        )
    }
}

@Composable
fun PetCategoryGrid(
    modifier: Modifier = Modifier
){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 15.dp),
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ){
        items(petCategory) { item ->
            PetCategory(drawable = item.drawable, text = item.text)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun PetCategoryGridPreview(){
    PetAppTheme {
        PetCategoryGrid()
    }
}


@Composable
fun PetFoundInApp(
    @DrawableRes catImage:Int,
    @StringRes catName: Int,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier
            .padding(10.dp)
            .clip(
                RoundedCornerShape(15.dp)
            )
            .fillMaxWidth()
    ) {
        Column(
            modifier = modifier
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = catImage),
                contentDescription = null,
                modifier = modifier
                    .size(200.dp)
            )
            Column(
                modifier = modifier
                    .padding(horizontal = 6.dp, vertical = 6.dp)
            ) {
                Row(modifier = modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(stringResource(id = catName), modifier = modifier.weight(1f))
                    Text(text = "male")
                }
                Text(text = "Breed: Persian")
                Row(modifier = modifier) {
                    Box(
                        modifier = modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(color = Pink)
                            .padding(vertical = 2.dp, horizontal = 10.dp)

                    ) {
                        Text(text = "Female")
                    }
                    Spacer(modifier = modifier.padding(horizontal = 2.dp))
                    Box(
                        modifier = modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(color = MyGray)
                            .padding(vertical = 2.dp, horizontal = 10.dp)) {
                        Text(text = "1 Year")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun PetFoundInAppPreview(){
    PetAppTheme {
        PetFoundInApp(catImage = R.drawable.cat2, catName = R.string.pet_fluffy)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PetFoundInAppGrid(
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 15.dp),
        cells = GridCells.Fixed(2))
    {
        items(myPetListApp) { item ->
            PetFoundInApp(catImage = item.drawable, catName = item.dogName)
        }
    }
}

@Preview(showBackground = true, backgroundColor =0XFFECF2F1)
@Composable
fun PetFoundInAppGridPreview(){
    PetAppTheme {
        PetFoundInAppGrid()
    }
}

@Composable
fun HomeScreenMain(
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier
            .background(color = Background)
    ) {
        LocationItem()
        SearchBar()
        PetDiscount()
        PetCategoryGrid()
        Spacer(modifier = modifier.padding(top = 20.dp))
        PetFoundInAppGrid()
    }


}

@Preview (showBackground = true, backgroundColor = 0XFFECF2F1)
@Composable
fun HomeScreenPreview(){
    PetAppTheme {
        HomeScreenMain()
    }
}

//data for category in app
private val petCategory = listOf(
    R.drawable.cat to R.string.cat_cat,
    R.drawable.dog to R.string.cat_dog,
    R.drawable.horse to R.string.cat_horse,
    R.drawable.fish to R.string.cat_fish,
    R.drawable.cat to R.string.cat_cat,
    R.drawable.dog to R.string.cat_dog,
    R.drawable.horse to R.string.cat_horse,
    R.drawable.fish to R.string.cat_fish,
).map { CategoryStringPair(it.first, it.second) }

private data class CategoryStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

//data for the pets in the app
private val myPetListApp = listOf(
    R.drawable.cat1 to R.string.pet_black,
    R.drawable.cat2 to R.string.pet_bucking,
    R.drawable.cat3 to R.string.pet_cathy,
    R.drawable.cat5 to R.string.pet_kitty,
    R.drawable.fish1 to R.string.pet_monday,
    R.drawable.fish2 to R.string.pet_monu,
    R.drawable.fish3 to R.string.pet_munchkin,
    R.drawable.fish4 to R.string.pet_peach,
    R.drawable.horse1 to R.string.pet_puppy,
    R.drawable.horse2 to R.string.pet_tuesday,
    R.drawable.horse3 to R.string.pet_symon,
    R.drawable.horse4 to R.string.pet_sunday
).map { PetListOutlined(it.first, it.second) }

private data class PetListOutlined(
    @DrawableRes val drawable: Int,
    @StringRes val dogName: Int,
)
