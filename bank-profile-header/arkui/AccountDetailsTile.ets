@ComponentV2
struct AccountDetailsTile {
    @Param
    @Require
    accountName: string;

    @Param
    @Require
    maskedNumber: string;

    @Param
    @Require
    balance: string;

    @Param
    @Require
    currency: string;

    @Param
    @Require
    available: string;

    @Param
    @Require
    statusText: string;

    @Param
    @Require
    statusBg: ResourceColor;

    @Param
    @Require
    statusFg: ResourceColor;

    @Param
    @Require
    lastOperationTitle: string;

    @Param
    @Require
    lastOperationSubtitle: string;

    @Param
    modifier: CommonModifier = { applyNormalAttribute: (instance: CommonAttribute) => {
    } } as CommonModifier;

    build() {
        Stack() {
            Column({ space: 14 }) {
                Row({ space: 12 }) {
                    Column() {
                        Text(this.accountName)
                        .fontColor(0xFF3A2F2A)
                        .fontSize(16)
                        .fontWeight(600)
                        .textOverflow({ overflow: TextOverflow.Ellipsis })
                        .maxLines(1)
                        Text(this.maskedNumber)
                        .fontColor(0xFF9B8F86)
                        .fontSize(12)
                    }
                    .alignItems(HorizontalAlign.Start)
                    .layoutWeight(1)
                    Stack({ alignContent: Alignment.Center }) {
                        Text(this.statusText)
                        .fontColor(this.statusFg)
                        .fontSize(12)
                        .fontWeight(600)
                    }
                    .borderRadius(18)
                    .clip(true)
                    .backgroundColor(this.statusBg)
                    .padding({ left: 12, right: 12, top: 7, bottom: 7 })
                }
                .alignItems(VerticalAlign.Center)
                .width("100%")
                Stack() {
                    Column({ space: 8 }) {
                        Text("Balance")
                        .fontColor(0xFFFBE9E2)
                        .fontSize(12)
                        Row({ space: 6 }) {
                            Text(this.balance)
                            .fontColor(Color.White)
                            .fontSize(26)
                            .fontWeight(600)
                            Text(this.currency)
                            .fontColor(0xFFFBE9E2)
                            .fontSize(14)
                        }
                        .alignItems(VerticalAlign.Bottom)
                        Text(`Available: ${this.available} ${this.currency}`)
                        .fontColor(0xFFFBE9E2)
                        .fontSize(12)
                    }
                    .alignItems(HorizontalAlign.Start)
                }
                .width("100%")
                .borderRadius(18)
                .clip(true)
                .backgroundColor(0xFFC46A3A)
                .padding(16)
                Row({ space: 12 }) {
                    Stack({ alignContent: Alignment.Center }) {
                        Text("↻")
                        .fontColor(0xFF8A4B2A)
                        .fontSize(16)
                        .fontWeight(600)
                    }
                    .size({ width: 36, height: 36 })
                    .borderRadius(12)
                    .clip(true)
                    .backgroundColor(0xFFE6D5C6)
                    Column({ space: 2 }) {
                        Text(this.lastOperationTitle)
                        .fontColor(0xFF3A2F2A)
                        .fontSize(13)
                        .fontWeight(FontWeight.Medium)
                        .textOverflow({ overflow: TextOverflow.Ellipsis })
                        .maxLines(1)
                        Text(this.lastOperationSubtitle)
                        .fontColor(0xFF9B8F86)
                        .fontSize(12)
                        .textOverflow({ overflow: TextOverflow.Ellipsis })
                        .maxLines(1)
                    }
                    .alignItems(HorizontalAlign.Start)
                    .layoutWeight(1)
                    Text("›")
                    .fontColor(0xFFB5A79C)
                    .fontSize(20)
                }
                .alignItems(VerticalAlign.Center)
                .width("100%")
                .borderRadius(18)
                .clip(true)
                .backgroundColor(0xFFF1E7DD)
                .padding({ left: 14, right: 14, top: 12, bottom: 12 })
            }
            .alignItems(HorizontalAlign.Start)
            .width("100%")
            .borderRadius(20)
            .clip(true)
            .backgroundColor(0xFFFFFBF6)
            .padding(16)
        }
        .attributeModifier(this.modifier)
        .borderRadius(28)
        .clip(true)
        .backgroundColor(0xFFF4EFEA)
        .padding(14)
    }
}
@ComponentV2
struct Root {
    build() {
        AccountDetailsTile({ accountName: "Salary account", maskedNumber: "•••• 1842 • Checking", balance: "128 450", currency: "₽", available: "126 970", statusText: "Active", statusBg: 0xFFDDF7E3, statusFg: 0xFF2E7D32, lastOperationTitle: "Last operation", lastOperationSubtitle: "Card payment • Coffee Shop • −420 ₽", modifier: { applyNormalAttribute: (instance: CommonAttribute) => {
            instance.width("100%")
            instance.padding(16)
        } } as CommonModifier })
    }
}
