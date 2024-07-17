package b.os.blurbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import b.os.blurbar.ui.theme.BlurbarTheme
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.setBackgroundDrawableResource(android.R.color.transparent)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BlurbarTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) {
//
//
//                    innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                LOYAL () {}
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BlurbarTheme {
//        Greeting("Android")
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LOYAL(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    val hazeState = remember { HazeState() }
    val scrollState = rememberScrollState()
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            MaterialTheme.colorScheme.background.copy(alpha = 1f),
            MaterialTheme.colorScheme.background.copy(alpha = 0f)
        )
    )

    Scaffold(
        topBar = {


        },
        bottomBar = {
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Color.Transparent,
                onClick = { /* todo */ },
                modifier = Modifier
                    .hazeChild(state = hazeState,shape = RoundedCornerShape(16.dp),tint = MaterialTheme.colorScheme.background.copy(alpha = 0.69f)),
                elevation = FloatingActionButtonDefaults.elevation(0.dp)

            ) {
                Icon(
                    imageVector = Icons.Filled.Add,// Use the plus icon from Material Icons
                    contentDescription = "Add")
            }
                // Handle the button press here

        }

    ) { innerPadding ->

        Box(
            modifier = modifier

                .fillMaxSize()
                .background(Color.Transparent)
                .padding(innerPadding)
                .haze(
                    state = hazeState,
                    style = HazeDefaults.style(
                        tint = Color.White.copy(alpha = 0.1f),
                        blurRadius = 10.dp
                    ),
                ),
        ) {
            Column(modifier = modifier.verticalScroll(scrollState)) {
                for (i in 1..50) {
                    Text(text = "NEVER GONNA GIVE UP I AM THE BEST @ B AI OS", modifier = modifier.padding(1.dp))
                }
            }
        }
        Box(modifier = modifier) {



            Box(modifier = modifier,) {

                for (i in 20 downTo 1) {
                    val mamu = ((21 - i)*0.5).dp
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .offset(y = ((i) * 5).dp)
                            .padding(0.dp)
                            .height(20.dp)
                            .hazeChild(
                                state = hazeState,
                                style = HazeDefaults.style(
                                    tint = MaterialTheme.colorScheme.background.copy(alpha = 0f),
                                    blurRadius = mamu
                                )
                            )
                            // Standard TopAppBar height
                            .background(Color.Transparent)
                    )
                }


            }
            Box(modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(gradientBrush))
            TopAppBar(
                title = { Text("Blurred Title bar") },
                // Need to make app bar transparent to see the content behind
                colors = TopAppBarDefaults.largeTopAppBarColors(Color.Transparent),
                modifier = Modifier
                    //  .hazeChild(state = hazeState,tint = Color.White.copy(alpha = 0.4f))
                    .fillMaxWidth(),
            )

//                Box(
//                    modifier = modifier
//                        .fillMaxWidth()
//
//                        .padding(0.dp)
//                        .height(69.dp)
//                        .hazeChild(
//                            state = hazeState,
//                            style = HazeDefaults.style(
//                                tint = Color.White.copy(alpha = 0.1f),
//                                blurRadius = 24.dp
//                            )
//                        )
//                        // Standard TopAppBar height
//                        .background(Color.Transparent)
//                )
//                Box(
//                    modifier = modifier
//                        .fillMaxWidth()
//                        .offset(y = (-0.85).dp)
//                        .padding(0.dp)
//                        .height(69.dp)
//                        .hazeChild(
//                            state = hazeState,
//                            style = HazeDefaults.style(
//                                tint = Color.White.copy(alpha = 0.1f),
//                                blurRadius = 1.dp
//                            )
//                        )
//                        // Standard TopAppBar height
//                        .background(Color.Transparent)
//                ) {}
//            }



        }
    }
}

