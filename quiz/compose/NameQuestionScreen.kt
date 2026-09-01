import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NameQuestionScreen(
    selectedAnswer: String?,
    onAnswerSelected: (String) -> Unit,
    onSubmitClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color(0xFFF4F6FB))
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(
            text = "Как тебя зовут?",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF1B2330)
        )

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

            AnswerItem(
                text = "Данил Колбасенко",
                selected = selectedAnswer == "Данил Колбасенко",
                click = { onAnswerSelected("Данил Колбасенко") }
            )

            AnswerItem(
                text = "Ваня",
                selected = selectedAnswer == "Ваня",
                click = { onAnswerSelected("Ваня") }
            )

            AnswerItem(
                text = "Пу-пу-пу",
                selected = selectedAnswer == "Пу-пу-пу",
                click = { onAnswerSelected("Пу-пу-пу") }
            )
        }

        Button(
            onClick = onSubmitClick,
            enabled = selectedAnswer != null,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF6C63FF),
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.elevation(0.dp)
        ) {
            Text(
                text = "Отправить ответ",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun AnswerItem(
    text: String,
    selected: Boolean,
    click: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.White,
                RoundedCornerShape(14.dp)
            )
            .clickable(onClick = click)
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = click
        )

        Text(
            text = text,
            fontSize = 15.sp,
            color = Color(0xFF1B2330)
        )
    }
}

@Composable
fun Root() {
    NameQuestionScreen(
        selectedAnswer = "Данил Колбасенко",
        onAnswerSelected = {},
        onSubmitClick = {}
    )
}
