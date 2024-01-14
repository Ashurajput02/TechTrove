package com.example.jetpackbusinesscard

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackbusinesscard.ui.theme.JetpackbusinesscardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackbusinesscardTheme {
                // A surface container using the 'background' color from the theme
                Surface() {
                    createcard()
                }
            }
        }
    }
}

@Composable
fun createcard(){
    val buttonclickedstate=remember{
        mutableStateOf(false)
    }

    Surface(
        modifier=Modifier
            .fillMaxSize(),


    ) {
        Card(modifier= Modifier
            .width(20.dp)
            .padding(12.dp)
            .height(390.dp),
            shape= RoundedCornerShape(corner = CornerSize(15.dp)),
            )
         {
             Column(modifier=Modifier.fillMaxSize())
             {

                 Column(modifier=Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Top,
                     horizontalAlignment =Alignment.CenterHorizontally ) {
                     imageprofile(modifier=Modifier.size(150.dp),R.drawable.profile_img2)
                     dividerandname()
                 }
                 introfull()
                 Column(modifier= Modifier
                     .fillMaxWidth()
                     .padding(start = 10.dp)
                     , horizontalAlignment =Alignment.CenterHorizontally ) {
Button(onClick = {
    buttonclickedstate.value=!(buttonclickedstate.value)
}) {

    Text(text = "PROJECTS")

}
    if(buttonclickedstate.value){content()
                     }
    else{
        Box(){

        }
    }
}
                 }
             }
        }
        }

@Composable
fun Portfolio(data: List<String>) {
LazyColumn{
    items(data){
        item ->
        Card(modifier= Modifier
            .fillMaxWidth()
            .padding(13.dp),
            shape= RectangleShape) {

            Row (modifier= Modifier
                .padding(8.dp)
                .background(color = Color.Gray)
                .padding(16.dp)){
                imageprofile(modifier=Modifier.size(100.dp),R.drawable.iconimg)
                Column(modifier=Modifier.padding(7.dp)
                    .align(alignment = Alignment.CenterVertically)) {
                    Text(text = item, fontWeight = FontWeight.Bold, color = Color.Red)

                }
            }

        }
    }
}

}

@Preview
@Composable
fun content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp))
    {
        Surface(modifier= Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape=RoundedCornerShape(corner =CornerSize(6.dp)),
            border=BorderStroke(width =2.dp,color=Color.Gray)){

            Portfolio(data= listOf("BeatMe","LoginPage","Attendance Humsafar"))
        }
    }
}
@Composable
private fun introfull() {
    Column() {
        Text(
            text = "A man who loves to explore the realms of Life.",
            modifier = Modifier.padding(start = 12.dp, top = 8.dp)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )

        Text(
            text = "An Android Programmer."
        )
        Text(
            text = "https://www.linkedin.com/in/ashu-rajput-14334a24b",
            color=Color.Blue)
    }
}

@Composable
private fun dividerandname() {
    Divider(
        modifier = Modifier
            .width(400.dp)

            .padding(4.dp)
            .padding(start = 15.dp),
        thickness = 4.dp,
        color = Color.Green,

        )
    Text(
        text = "Ashu Rajput",
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Cursive,
        modifier = Modifier.padding(top = 12.dp)
    )
}

@Composable
private fun imageprofile(modifier: Modifier=Modifier,a:Int) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(4.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.Yellow),
        shadowElevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = a), contentDescription = "Author image",
            modifier = modifier.size(135.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackbusinesscardTheme {
        Portfolio(data= listOf("Project1","Project2","Project3"))
    }
}