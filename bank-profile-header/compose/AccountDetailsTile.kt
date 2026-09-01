import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AccountDetailsTile(
    accountName: String,
    maskedNumber: String,
    balance: String,
    currency: String,
    available: String,
    statusText: String,
    statusBg: Color,
    statusFg: Color,
    lastOperationTitle: String,
    lastOperationSubtitle: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(28.dp))
            .background(Color(0xFFF4EFEA)) // warm background
            .padding(14.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFFFFBF6))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = accountName,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF3A2F2A),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = maskedNumber,
                        fontSize = 12.sp,
                        color = Color(0xFF9B8F86)
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(18.dp))
                        .background(statusBg)
                        .padding(horizontal = 12.dp, vertical = 7.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = statusText,
                        color = statusFg,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            // Balance block — terracotta accent
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFFC46A3A))
                    .padding(16.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

                    Text(
                        text = "Balance",
                        color = Color(0xFFFBE9E2),
                        fontSize = 12.sp
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = balance,
                            color = Color.White,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = currency,
                            color = Color(0xFFFBE9E2),
                            fontSize = 14.sp
                        )
                    }

                    Text(
                        text = "Available: $available $currency",
                        color = Color(0xFFFBE9E2),
                        fontSize = 12.sp
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFFF1E7DD))
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFE6D5C6)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "↻",
                        color = Color(0xFF8A4B2A),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = lastOperationTitle,
                        color = Color(0xFF3A2F2A),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = lastOperationSubtitle,
                        color = Color(0xFF9B8F86),
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Text(
                    text = "›",
                    color = Color(0xFFB5A79C),
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun Root() {
    AccountDetailsTile(
        accountName = "Salary account",
        maskedNumber = "•••• 1842 • Checking",
        balance = "128 450",
        currency = "₽",
        available = "126 970",
        statusText = "Active",
        statusBg = Color(0xFFDDF7E3),
        statusFg = Color(0xFF2E7D32),
        lastOperationTitle = "Last operation",
        lastOperationSubtitle = "Card payment • Coffee Shop • −420 ₽",
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}
