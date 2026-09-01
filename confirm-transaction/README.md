# Confirm Transaction

Экран подтверждения перевода по номеру телефона: заголовок, карточка
получателя (аватар-инициал + телефон + банк), блок суммы с комиссией, блок
деталей (откуда, комментарий), кнопка перевода и дисклеймер. Собран из
нескольких приватных `@Composable`-подкомпонентов (`PhoneRecipientTile`,
`AmountBlock`, `DetailsBlock`).

> Реальный вывод `android-harmony-transpiler` (`TerminalApplicationKt`) —
> `arkui/ConfirmPhoneTransferScreen.ets` сгенерирован из
> `compose/ConfirmPhoneTransferScreen.kt` транспайлером как есть, без ручной
> правки.

## Скриншоты

<table>
<tr>
<th align="center">Android · Jetpack Compose</th>
<th align="center">HarmonyOS NEXT · ArkUI</th>
</tr>
<tr>
<td><img src="screenshots/android.png" width="380" alt="Confirm Phone Transfer — Android"></td>
<td><img src="screenshots/arkui.png" width="380" alt="Confirm Phone Transfer — HarmonyOS NEXT"></td>
</tr>
</table>

## Код

| Платформа | Файл |
|---|---|
| Android (Jetpack Compose) | [`compose/ConfirmPhoneTransferScreen.kt`](compose/ConfirmPhoneTransferScreen.kt) |
| HarmonyOS NEXT (ArkUI) | [`arkui/ConfirmPhoneTransferScreen.ets`](arkui/ConfirmPhoneTransferScreen.ets) |

## Соответствие концепций

| Compose | ArkUI |
|---|---|
| приватный `@Composable` под-компонент (`PhoneRecipientTile`, `AmountBlock`, `DetailsBlock`) | отдельный `@ComponentV2 struct` с `@Param`/`@Require` полями, вызывается как `PhoneRecipientTile({ ...props })` |
| `Arrangement.SpaceBetween` | `.justifyContent(FlexAlign.SpaceBetween)` |
| `name.take(1).uppercase()` | `generated_uppercase(generated_take(this.name, 1))` — цепочка Kotlin stdlib-вызовов раскладывается в синтезированные топ-левел функции |
| `ButtonDefaults.buttonColors(backgroundColor = ..., contentColor = ...)` | `new ButtonColors(...).backgroundColor` / `.contentColor` — класс `ButtonColors` эмитится один раз на файл, переиспользуется всеми `Button` |
| Kotlin string template `"Банк: $bank"` | JS template-строка `` `Банк: ${this.bank}` `` |
| `Modifier.width(220.dp)` на конкретном `Text` | `.width(220)` в чейне соответствующего `Text` |
