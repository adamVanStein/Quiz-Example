package avs.example.quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizGiver {
	private final List<Quiz> quizList = new ArrayList<Quiz>();
	private int currentQuizIndex = -1;
	
	public QuizGiver() {}
	
	public void addQuiz( Quiz quiz ) {
		quizList.add(quiz);
	}
	
	public Quiz nextQuiz() {
		currentQuizIndex++;
		if( currentQuizIndex >= quizList.size() ) {
			currentQuizIndex--;
		}
		
		return currentQuiz();
	}
	
	public Quiz previousQuiz() {
		currentQuizIndex--;
		if( currentQuizIndex < 0 ) {
			currentQuizIndex++;
		}
		
		return currentQuiz();
	}
	
	public Quiz currentQuiz() {
		return quizList.get(currentQuizIndex);
	}
	
	public boolean isCorrectAnswer(int index) {
		if( index == currentQuizIndex ) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getCurrentQuizIndex() {
		return currentQuizIndex;
	}
}
