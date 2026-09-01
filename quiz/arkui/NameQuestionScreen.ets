@ComponentV2
struct NameQuestionScreen {
	@Param
	selectedAnswer: string | null;

	@Param
	@Require
	onAnswerSelected: (p0: string) => void;

	@Param
	@Require
	onSubmitClick: () => void;

	@Param
	modifier: CommonModifier = { applyNormalAttribute: (instance: CommonAttribute) => {
	} } as CommonModifier;

	build() {
		Column({ space: 20 }) {
			Text("Как тебя зовут?")
			.fontColor(0xFF1B2330)
			.fontSize(22)
			.fontWeight(600)
			Column({ space: 12 }) {
				AnswerItem({ text: "Данил Колбасенко", selected: this.selectedAnswer == "Данил Колбасенко", click: () => {
					return this.onAnswerSelected("Данил Колбасенко")
				} })
				AnswerItem({ text: "Ваня", selected: this.selectedAnswer == "Ваня", click: () => {
					return this.onAnswerSelected("Ваня")
				} })
				AnswerItem({ text: "Пу-пу-пу", selected: this.selectedAnswer == "Пу-пу-пу", click: () => {
					return this.onAnswerSelected("Пу-пу-пу")
				} })
			}
			.alignItems(HorizontalAlign.Start)
			Button() {
				Text("Отправить ответ")
				.fontSize(16)
				.fontWeight(FontWeight.Medium)
			}
			.onClick(this.onSubmitClick)
			.enabled(this.selectedAnswer != null)
			.borderRadius(16)
			.backgroundColor(new ButtonColors(0xFF6C63FF, Color.White, 0xFF6C63FF, Color.White).backgroundColor)
			.fontColor(new ButtonColors(0xFF6C63FF, Color.White, 0xFF6C63FF, Color.White).contentColor)
			.width("100%")
			.height(52)
		}
		.alignItems(HorizontalAlign.Start)
		.attributeModifier(this.modifier)
		.backgroundColor(0xFFF4F6FB)
		.padding(24)
	}
}
@ComponentV2
struct AnswerItem {
	@Param
	@Require
	text: string;

	@Param
	@Require
	selected: boolean;

	@Param
	@Require
	click: () => void;

	build() {
		Row({ space: 12 }) {
			Radio({ group: '', value: '' })
			.checked(this.selected)
			.onClick(this.click)
			Text(this.text)
			.fontColor(0xFF1B2330)
			.fontSize(15)
		}
		.alignItems(VerticalAlign.Center)
		.width("100%")
		.backgroundColor(Color.White)
		.borderRadius(14)
		.onClick(this.click)
		.padding({ left: 16, right: 16, top: 14, bottom: 14 })
	}
}
@ComponentV2
struct Root {
	build() {
		NameQuestionScreen({ selectedAnswer: "Данил Колбасенко", onAnswerSelected: () => {
			return
		}, onSubmitClick: () => {
			return
		} })
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
