import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmployeeCard(
    name: String,
    role: String,
    statusLabel: String,
    statusValue: String,
    score: String,
    modifier: Modifier = Modifier
) {
    // Внешняя "подложка"
    Box(
        modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(28.dp))
                .background(Color(0xFFEFF1F7)),
    ) {
        // Внутренняя карточка
        Box(
            modifier = Modifier
                .padding(14.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(Color(0xFFF8FAFF)),
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 14.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Avatar
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color(0xFF2F5BFF)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = name.firstOrNull()?.uppercase() ?: "?",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                }

                Spacer(Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = name,
                            color = Color(0xFF1B2330),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )

                        Spacer(Modifier.weight(1f))

                        // Badge (842)
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(14.dp))
                                .background(Color(0xFFE9F0FF))
                                .padding(horizontal = 10.dp, vertical = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = score,
                                color = Color(0xFF2F5BFF),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                        }
                    }

                    Spacer(Modifier.height(2.dp))

                    Text(
                        text = role,
                        color = Color(0xFF7B8794),
                        fontSize = 12.sp
                    )

                    Spacer(Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = statusLabel,
                                color = Color(0xFFA0A8B3),
                                fontSize = 11.sp
                            )
                            Spacer(Modifier.height(2.dp))
                            Text(
                                text = statusValue,
                                color = Color(0xFF1B2330),
                                fontWeight = FontWeight.Medium,
                                fontSize = 13.sp
                            )
                        }

                        Spacer(Modifier.weight(1f))

                        // Pill "Active"
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(18.dp))
                                .background(Color(0xFFDDF7E3))
                                .padding(horizontal = 14.dp, vertical = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Active",
                                color = Color(0xFF2E7D32),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Root() {
    EmployeeCard(
        name = "Ivan Milenin",
        role = "Android Developer • Mobile",
        statusLabel = "Status",
        statusValue = "Working",
        score = "842",
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}
