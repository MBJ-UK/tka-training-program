package com.aliahmed.training
//deleting two of Tony's comments
//Tony is here
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliahmed.training.ui.theme.TrainingTheme

//another comment from MBJ

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // MainScreen("Android", Modifier, this)
                    MainScreen(context = this)
                }
            }
        }

    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        var counter = remember { mutableStateOf(0) }
        Text(
            text = "Counter: ${counter.value}",
            modifier = modifier,
            style = TextStyle(fontSize = 16.sp, color = Color.Black)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            counter.value = counter.value + 1
        }) {
            val intent = Intent(context, AnotherActivity::class.java)
            intent.putExtra("Value", "Main Activity")
            context.startActivity(intent)
        }
    }
}

@Composable
fun CreateList() {
    LazyColumn() {
        val list = listOf("One", "Two", "Three")
        items(list) {
            ListItem(text = it)
        }
    }
}

@Composable
fun ListItem(text: String) {
    Text(
        text = text, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Gray)
    )
}


//this is my addition

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrainingTheme {
        //ShowText("Android", Modifier.padding(16.dp))
    }
}