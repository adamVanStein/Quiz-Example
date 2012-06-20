package avs.example.quiz;


public class UIController {
	private final QuizGiver quizGiver;
	private final UI ui;
	
	public UIController(UI ui, QuizGiver quizGiver) {
		this.ui = ui;
		this.quizGiver = quizGiver;
	}
	
	public void answer( int index ) {
		if( quizGiver.isCorrectAnswer(index) ) {
			logLine("正解！");
		} else {
			logLine("不正解！");
		}
	}
	
	public void nextQuiz() {
		quizGiver.nextQuiz();
		refreshUI();
	}
	
	public void previousQuiz() {
		quizGiver.previousQuiz();
		refreshUI();
	}
	
	private void refreshUI() {
		Quiz quiz = quizGiver.currentQuiz();
		
		ui.quizText.setText( quiz.getQuizText() );
		
		for( int i=0; i < ui.choiceLabels.length; i++ ) {
			ui.choiceLabels[i].setText(quiz.getChoice(i));
		}
		
		logLine( "■ 第" + (quizGiver.getCurrentQuizIndex() + 1) + "問 ■" + System.lineSeparator());
	}
	
	private void logLine( String line ) {
		ui.logText.append( line + System.lineSeparator() );
	}
}
