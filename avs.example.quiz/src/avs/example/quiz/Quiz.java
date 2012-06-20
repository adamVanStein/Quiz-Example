package avs.example.quiz;

import java.util.Arrays;

public class Quiz {
	public static final int CHOICE_NUM = 4; 
	
	private final String quizText;
	private final String[] choices;
	private final int answerIndex;
	
	public Quiz(String quizText, String[] choices, int answerIndex) {
		if( choices.length != CHOICE_NUM )
			throw new IllegalArgumentException("choices.length : " + choices.length);
		
		this.quizText = quizText;
		this.choices = Arrays.copyOf(choices, CHOICE_NUM);
		this.answerIndex = answerIndex;
	}
	
	public String getQuizText() {
		return quizText;
	}
	
	public String getChoice(int i) {
		return choices[i];
	}
	
	public int getAnswerIndex() {
		return answerIndex;
	}
}
