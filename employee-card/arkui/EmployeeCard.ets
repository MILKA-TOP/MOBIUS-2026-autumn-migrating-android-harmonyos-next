@ComponentV2
struct EmployeeCard {
  @Param
  @Require
  name: string;

  @Param
  @Require
  role: string;

  @Param
  @Require
  statusLabel: string;

  @Param
  @Require
  statusValue: string;

  @Param
  @Require
  score: string;

  @Param
  modifier: CommonModifier = { applyNormalAttribute: (instance: CommonAttribute) => {
  } } as CommonModifier;

  build() {
    Stack() {
      Stack() {
        Row() {
          Stack({ alignContent: Alignment.Center }) {
            Text(this.name.charAt(0)?.toUpperCase() ?? "?")
              .fontColor(Color.White)
              .fontSize(16)
              .fontWeight(600)
          }
          .size({ width: 44, height: 44 })
          .borderRadius(14)
          .clip(true)
          .backgroundColor(0xFF2F5BFF)
          Blank()
            .width(12)
          Column() {
            Row() {
              Text(this.name)
                .fontColor(0xFF1B2330)
                .fontSize(16)
                .fontWeight(600)
              Blank()
                .layoutWeight(1)
              Stack({ alignContent: Alignment.Center }) {
                Text(this.score)
                  .fontColor(0xFF2F5BFF)
                  .fontSize(12)
                  .fontWeight(600)
              }
              .borderRadius(14)
              .clip(true)
              .backgroundColor(0xFFE9F0FF)
              .padding({ left: 10, right: 10, top: 6, bottom: 6 })
            }
            .alignItems(VerticalAlign.Center)
            .width("100%")
            Blank()
              .height(2)
            Text(this.role)
              .fontColor(0xFF7B8794)
              .fontSize(12)
            Blank()
              .height(10)
            Row() {
              Column() {
                Text(this.statusLabel)
                  .fontColor(0xFFA0A8B3)
                  .fontSize(11)
                Blank()
                  .height(2)
                Text(this.statusValue)
                  .fontColor(0xFF1B2330)
                  .fontSize(13)
                  .fontWeight(FontWeight.Medium)
              }
              .alignItems(HorizontalAlign.Start)
              Blank()
                .layoutWeight(1)
              Stack({ alignContent: Alignment.Center }) {
                Text("Active")
                  .fontColor(0xFF2E7D32)
                  .fontSize(12)
                  .fontWeight(600)
              }
              .borderRadius(18)
              .clip(true)
              .backgroundColor(0xFFDDF7E3)
              .padding({ left: 14, right: 14, top: 8, bottom: 8 })
            }
            .alignItems(VerticalAlign.Center)
            .width("100%")
          }
          .alignItems(HorizontalAlign.Start)
          .layoutWeight(1)
        }
        .alignItems(VerticalAlign.Center)
        .padding({ left: 16, right: 16, top: 14, bottom: 14 })
        .width("100%")
      }
      .padding(14)
      .width("100%")
      .borderRadius(18)
      .clip(true)
      .backgroundColor(0xFFF8FAFF)
    }
    .attributeModifier(this.modifier)
    .width("100%")
    .borderRadius(28)
    .clip(true)
    .backgroundColor(0xFFEFF1F7)
  }
}
@ComponentV2
@Preview
struct Root {
  build() {
    EmployeeCard({ name: "Ivan Milenin", role: "Android Developer • Mobile", statusLabel: "Status", statusValue: "Working", score: "842", modifier: { applyNormalAttribute: (instance: CommonAttribute) => {
      instance.width("100%")
      instance.padding(16)
    } } as CommonModifier })
  }
}
