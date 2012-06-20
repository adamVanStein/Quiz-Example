package avs.example.quiz;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		QuizGiver quizGiver = new QuizGiver();
		
		try {
			new Dao().loadQuizes(new File("quiz.csv"), quizGiver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		UI ui = new UI(quizGiver); 
		ui.setController(new UIController(ui, quizGiver));
		
		JFrame frame = new JFrame();
		frame.setSize(UI.FRAME_WIDTH, UI.FRAME_HEIGHT);
		frame.add(ui);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
