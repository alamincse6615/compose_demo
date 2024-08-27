import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun AccountingDashboard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Top Bar
        Text(
            text = "Accounting Dashboard",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,

            modifier = Modifier.padding(8.dp)
        )

        // Summary Cards
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            SummaryCard(title = "Income", value = "$12,450")
            SummaryCard(title = "Expenses", value = "$8,230")
            SummaryCard(title = "Net Profit", value = "$4,220")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Graph/Chart Area (Replace with actual chart in a real app)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                // Draw the bar chart as a placeholder
                drawRoundRect(
                    color = Color(0xFF4CAF50),
                    topLeft = Offset(20f, 80f),
                    size = Size(80f, 120f),
                    cornerRadius = CornerRadius(12f, 12f)
                )
                drawRoundRect(
                    color = Color(0xFFF44336),
                    topLeft = Offset(120f, 140f),
                    size = Size(80f, 60f),
                    cornerRadius = CornerRadius(12f, 12f)
                )
            }
        }



    }
}

@Composable
fun SummaryCard(title: String, value: String) {
    Card(
        colors =CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(100.dp)
            .height(100.dp),
       elevation = CardDefaults.cardElevation(5.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountingDashboardPreview() {
    AccountingDashboard()
}
