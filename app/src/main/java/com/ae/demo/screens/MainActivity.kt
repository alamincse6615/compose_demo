package com.ae.demo.screens

import AccountingDashboard
import SampleData
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ae.demo.R
import com.ae.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            //AccountingDashboard()
            DemoTheme{
                Conversation(SampleData.conversationSample)
               /* Surface(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.padding(all = 8.dp)) {
                        Text(text = "")
                        MessageCard(Message("AlAmin", "hello preview from compose"))
                        MessageCard(Message("AlAmin", "hello preview from compose"))
                        MessageCard(Message("AlAmin", "hello preview from compose"))
                        MessageCard(Message("AlAmin", "hello preview from compose"))
                        MessageCard(Message("AlAmin", "hello preview from compose"))
                    }
                }*/
            }



            /*Box {
                Alignment.Center
                Counter()
            }*/
        }
    }
}
data class Message(val author:String, val body:String)

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages){
            message-> MessageCard(msg = message)
        }
    }
}

@Preview
@Composable
fun PreViewConversation(modifier: Modifier = Modifier) {
    Conversation(messages = SampleData.conversationSample)
}

@Composable
fun MessageCard(msg:Message) {
   Card(modifier = Modifier.padding(all = 4.dp)) {
       Row(modifier = Modifier.padding(all = 8.dp)){
           Image(
               painter = painterResource(id = R.drawable.profile),
               contentDescription = "Al Amin Pic",
               modifier = Modifier
                   .size(40.dp)
                   .clip(CircleShape)
                   .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)

           )
           Spacer(modifier = Modifier.width(8.dp))
           var isExpanded by remember {
               mutableStateOf(false)
           }
           // surfaceColor will be updated gradually from one color to the other
           val surfaceColor by animateColorAsState(
               if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
           )
           Column(modifier = Modifier.clickable { isExpanded = ! isExpanded }){
               Text(
                   text = msg.author,
                   color = MaterialTheme.colorScheme.secondary,
                   style = MaterialTheme.typography.titleSmall

                   )
               Spacer(modifier = Modifier.height(5.dp))
               Surface(
                   shape = MaterialTheme.shapes.medium,
                   shadowElevation = 1.dp,
                   color = surfaceColor,
                   modifier = Modifier.animateContentSize().padding(1.dp)

               ) {
                   Text(
                       text = msg.body,
                       modifier = Modifier.padding(all = 4.dp),
                       maxLines = if(isExpanded) Int.MAX_VALUE else 1,
                       style = MaterialTheme.typography.bodyMedium

                   )
               }
           }
       }
   }
}
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessage(){
    MessageCard(Message("Al Amin","hello preview from compose"))
    MessageCard(Message("Al Amin","hello preview from compose"))
}