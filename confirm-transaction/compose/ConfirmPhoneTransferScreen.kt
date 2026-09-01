import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
fun ConfirmPhoneTransferScreen(
    phone: String,
    recipientName: String,
    selectedBank: String,
    amountRub: String,
    feeRub: String,
    comment: String,
    onConfirmClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color(0xFF0B0F1A))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Подтверждение перевода",
            color = Color(0xFFEAF0FF),
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold
        )

        PhoneRecipientTile(
            phone = phone,
            name = recipientName,
            bank = selectedBank,
            modifier = Modifier.fillMaxWidth()
        )

        AmountBlock(
            amountRub = amountRub,
            feeRub = feeRub,
            modifier = Modifier.fillMaxWidth()
        )

        DetailsBlock(
            fromAccount = "Зарплатная карта •• 1842",
            comment = comment,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = onConfirmClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFFFD166),
                contentColor = Color(0xFF1A1300)
            ),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
        ) {
            Text(
                text = "Перевести деньги 💸",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Text(
            text = "Нажимая «Перевести», вы подтверждаете перевод по номеру телефона (СБП-ish).",
            color = Color(0xFF8B93A7),
            fontSize = 12.sp
        )
    }
}

@Composable
private fun PhoneRecipientTile(
    phone: String,
    name: String,
    bank: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF141A2B))
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF2A3557)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name.take(1).uppercase(),
                color = Color(0xFFEAF0FF),
                fontWeight = FontWeight.SemiBold
            )
        }

        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(
                text = name,
                color = Color(0xFFEAF0FF),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = phone,
                color = Color(0xFF9AA6C1),
                fontSize = 12.sp
            )
            Text(
                text = "Банк: $bank",
                color = Color(0xFF9AA6C1),
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Text(
            text = "›",
            color = Color(0xFF9AA6C1),
            fontSize = 22.sp
        )
    }
}

@Composable
private fun AmountBlock(
    amountRub: String,
    feeRub: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFF10162A))
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Сумма перевода",
            color = Color(0xFF9AA6C1),
            fontSize = 12.sp
        )

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = amountRub,
                color = Color(0xFFEAF0FF),
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "₽",
                color = Color(0xFF9AA6C1),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF141A2B))
                .padding(horizontal = 12.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Комиссия",
                color = Color(0xFF9AA6C1),
                fontSize = 12.sp
            )
            Text(
                text = feeRub,
                color = Color(0xFFEAF0FF),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun DetailsBlock(
    fromAccount: String,
    comment: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF141A2B))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Откуда",
                color = Color(0xFF9AA6C1),
                fontSize = 12.sp
            )
            Text(
                text = fromAccount,
                color = Color(0xFFEAF0FF),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "Комментарий",
                color = Color(0xFF9AA6C1),
                fontSize = 12.sp
            )
            Text(
                text = comment,
                color = Color(0xFFEAF0FF),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(220.dp)
            )
        }
    }
}


@Composable
fun Root() {
    ConfirmPhoneTransferScreen(
        phone = "+7 999 123-45-67",
        recipientName = "Глеб Пельменьков",
        selectedBank = "Жабабанк 🐸",
        amountRub = "3 750",
        feeRub = "0 ₽ (потому что мы добрые)",
        comment = "За шаверму и моральный ущерб",
        onConfirmClick = {},
        modifier = Modifier.fillMaxWidth()
    )
}
