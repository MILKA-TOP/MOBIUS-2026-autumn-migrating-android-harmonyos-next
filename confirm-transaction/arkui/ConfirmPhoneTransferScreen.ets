@ComponentV2
struct ConfirmPhoneTransferScreen {
    @Param
    @Require
    phone: string;

    @Param
    @Require
    recipientName: string;

    @Param
    @Require
    selectedBank: string;

    @Param
    @Require
    amountRub: string;

    @Param
    @Require
    feeRub: string;

    @Param
    @Require
    comment: string;

    @Param
    @Require
    onConfirmClick: () => void;

    @Param
    modifier: CommonModifier = { applyNormalAttribute: (instance: CommonAttribute) => {
    } } as CommonModifier;

    build() {
        Column({ space: 16 }) {
            Text("Подтверждение перевода")
            .fontColor(0xFFEAF0FF)
            .fontSize(22)
            .fontWeight(600)
            PhoneRecipientTile({ phone: this.phone, name: this.recipientName, bank: this.selectedBank, modifier: { applyNormalAttribute: (instance: CommonAttribute) => {
                instance.width("100%")
            } } as CommonModifier })
            AmountBlock({ amountRub: this.amountRub, feeRub: this.feeRub, modifier: { applyNormalAttribute: (instance: CommonAttribute) => {
                instance.width("100%")
            } } as CommonModifier })
            DetailsBlock({ fromAccount: "Зарплатная карта •• 1842", comment: this.comment, modifier: { applyNormalAttribute: (instance: CommonAttribute) => {
                instance.width("100%")
            } } as CommonModifier })
            Button() {
                Text("Перевести деньги 💸")
                .fontSize(16)
                .fontWeight(600)
            }
            .onClick(this.onConfirmClick)
            .borderRadius(18)
            .backgroundColor(new ButtonColors(0xFFFFD166, 0xFF1A1300, 0xFFFFD166, 0xFF1A1300).backgroundColor)
            .fontColor(new ButtonColors(0xFFFFD166, 0xFF1A1300, 0xFFFFD166, 0xFF1A1300).contentColor)
            .width("100%")
            .height(54)
            Text("Нажимая «Перевести», вы подтверждаете перевод по номеру телефона (СБП-ish).")
            .fontColor(0xFF8B93A7)
            .fontSize(12)
        }
        .alignItems(HorizontalAlign.Start)
        .attributeModifier(this.modifier)
        .backgroundColor(0xFF0B0F1A)
        .padding(20)
    }
}
@ComponentV2
struct PhoneRecipientTile {
    @Param
    @Require
    phone: string;

    @Param
    @Require
    name: string;

    @Param
    @Require
    bank: string;

    @Param
    modifier: CommonModifier = { applyNormalAttribute: (instance: CommonAttribute) => {
    } } as CommonModifier;

    build() {
        Row({ space: 12 }) {
            Stack({ alignContent: Alignment.Center }) {
                Text(generated_uppercase(generated_take(this.name, 1)))
                .fontColor(0xFFEAF0FF)
                .fontWeight(600)
            }
            .size({ width: 44, height: 44 })
            .borderRadius(16)
            .clip(true)
            .backgroundColor(0xFF2A3557)
            Column({ space: 2 }) {
                Text(this.name)
                .fontColor(0xFFEAF0FF)
                .fontSize(15)
                .fontWeight(600)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
                .maxLines(1)
                Text(this.phone)
                .fontColor(0xFF9AA6C1)
                .fontSize(12)
                Text(`Банк: ${this.bank}`)
                .fontColor(0xFF9AA6C1)
                .fontSize(12)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
                .maxLines(1)
            }
            .alignItems(HorizontalAlign.Start)
            .layoutWeight(1)
            Text("›")
            .fontColor(0xFF9AA6C1)
            .fontSize(22)
        }
        .alignItems(VerticalAlign.Center)
        .attributeModifier(this.modifier)
        .borderRadius(20)
        .clip(true)
        .backgroundColor(0xFF141A2B)
        .padding(14)
    }
}
@ComponentV2
struct AmountBlock {
    @Param
    @Require
    amountRub: string;

    @Param
    @Require
    feeRub: string;

    @Param
    modifier: CommonModifier = { applyNormalAttribute: (instance: CommonAttribute) => {
    } } as CommonModifier;

    build() {
        Column({ space: 10 }) {
            Text("Сумма перевода")
            .fontColor(0xFF9AA6C1)
            .fontSize(12)
            Row({ space: 8 }) {
                Text(this.amountRub)
                .fontColor(0xFFEAF0FF)
                .fontSize(30)
                .fontWeight(600)
                Text("₽")
                .fontColor(0xFF9AA6C1)
                .fontSize(14)
                .fontWeight(FontWeight.Medium)
            }
            .alignItems(VerticalAlign.Bottom)
            Row() {
                Text("Комиссия")
                .fontColor(0xFF9AA6C1)
                .fontSize(12)
                Text(this.feeRub)
                .fontColor(0xFFEAF0FF)
                .fontSize(12)
                .fontWeight(FontWeight.Medium)
            }
            .justifyContent(FlexAlign.SpaceBetween)
            .alignItems(VerticalAlign.Center)
            .borderRadius(16)
            .clip(true)
            .backgroundColor(0xFF141A2B)
            .padding({ left: 12, right: 12, top: 10, bottom: 10 })
        }
        .alignItems(HorizontalAlign.Start)
        .attributeModifier(this.modifier)
        .borderRadius(24)
        .clip(true)
        .backgroundColor(0xFF10162A)
        .padding(18)
    }
}
@ComponentV2
struct DetailsBlock {
    @Param
    @Require
    fromAccount: string;

    @Param
    @Require
    comment: string;

    @Param
    modifier: CommonModifier = { applyNormalAttribute: (instance: CommonAttribute) => {
    } } as CommonModifier;

    build() {
        Column({ space: 12 }) {
            Row() {
                Text("Откуда")
                .fontColor(0xFF9AA6C1)
                .fontSize(12)
                Text(this.fromAccount)
                .fontColor(0xFFEAF0FF)
                .fontSize(12)
                .fontWeight(FontWeight.Medium)
            }
            .justifyContent(FlexAlign.SpaceBetween)
            .alignItems(VerticalAlign.Center)
            .width("100%")
            Row() {
                Text("Комментарий")
                .fontColor(0xFF9AA6C1)
                .fontSize(12)
                Text(this.comment)
                .fontColor(0xFFEAF0FF)
                .fontSize(12)
                .fontWeight(FontWeight.Medium)
                .textOverflow({ overflow: TextOverflow.Ellipsis })
                .maxLines(2)
                .width(220)
            }
            .justifyContent(FlexAlign.SpaceBetween)
            .alignItems(VerticalAlign.Top)
            .width("100%")
        }
        .alignItems(HorizontalAlign.Start)
        .attributeModifier(this.modifier)
        .borderRadius(20)
        .clip(true)
        .backgroundColor(0xFF141A2B)
        .padding(16)
    }
}
@ComponentV2
struct Root {
    build() {
        ConfirmPhoneTransferScreen({ phone: "+7 999 123-45-67", recipientName: "Глеб Пельменьков", selectedBank: "Жабабанк 🐸", amountRub: "3 750", feeRub: "0 ₽ (потому что мы добрые)", comment: "За шаверму и моральный ущерб", onConfirmClick: () => {
            return
        }, modifier: { applyNormalAttribute: (instance: CommonAttribute) => {
            instance.width("100%")
        } } as CommonModifier })
    }
}
class ButtonColors {
    backgroundColor: Color;

    contentColor: Color;

    disabledBackgroundColor: Color;

    disabledContentColor: Color;

    constructor(backgroundColor: Color, contentColor: Color, disabledBackgroundColor: Color, disabledContentColor: Color) {
        this.backgroundColor = backgroundColor
        this.contentColor = contentColor
        this.disabledBackgroundColor = disabledBackgroundColor
        this.disabledContentColor = disabledContentColor
    }
}

function generated_take(receiver: string, n: number): string {
    const result0: string = receiver.substring(0, n);
    return result0
}

function generated_uppercase(receiver: string): string {
    const result0: string = receiver.toUpperCase();
    return result0
}
