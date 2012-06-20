package avs.example.quiz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UI extends JPanel {
	
	public static int FRAME_WIDTH = 600;
	public static int FRAME_HEIGHT = 500;
	
	/* UI Components */
	final JTextArea quizText = new JTextArea();
	
	private final JButton[] choiceButtons = new JButton[Quiz.CHOICE_NUM];
	final JLabel[] choiceLabels = new JLabel[Quiz.CHOICE_NUM];
	
	private final JButton nextButton = new JButton("次の問題");
	private final JButton previousButton = new JButton("前の問題");
	
	final JTextArea logText = new JTextArea();
	
	private UIController controller;
	
	public UI(QuizGiver quizGiver) {
		buildUI();
		hookEvents();
	}
	
	private void buildUI() {
		for( int i=0;i<Quiz.CHOICE_NUM;i++) {
			choiceButtons[i] = new JButton(Integer.toString(i+1));
			choiceLabels[i] = new JLabel();
		}
		
		JPanel choicePanel = new JPanel();
		choicePanel.setLayout(new GridLayout(0, 1));
		for( int i=0; i<Quiz.CHOICE_NUM;i++) {
			Box b = Box.createHorizontalBox();
			b.add(choiceButtons[i]);
			b.add(Box.createHorizontalStrut(40));
			b.add(choiceLabels[i]);
			choicePanel.add( b );
		}
		
		Box buttonPanel = new Box( BoxLayout.LINE_AXIS );
		buttonPanel.add(nextButton);
		buttonPanel.add(previousButton);
		
//		quizText.setPreferredSize(new Dimension(0,200));
		quizText.setEditable(false);
		
		JScrollPane quizTextS = new JScrollPane( quizText );
		quizTextS.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
		quizTextS.setPreferredSize(new Dimension(Integer.MAX_VALUE, 150));
		
		JScrollPane logTextS = new JScrollPane( logText );
		logTextS.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		logTextS.setPreferredSize(new Dimension(Integer.MAX_VALUE, 150));
		logText.setEditable(false);
		
		BoxLayout b = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(b);
		add(quizTextS);
		int gap = 5;
		add(Box.createVerticalStrut(gap));
		add(choicePanel);
		add(Box.createVerticalStrut(gap));
		add(buttonPanel);
		add(Box.createVerticalStrut(gap));
		add(logTextS);
	}
	
	private void hookEvents() {
		nextButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.nextQuiz();
			}
		});
		
		previousButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.previousQuiz();
			}
		});
		
		for(int i=0; i<Quiz.CHOICE_NUM; i++) {
			final int index = i;
			
			choiceButtons[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					controller.answer(index);
				}
			});
		}
	}

	public void setController(UIController controller) {
		this.controller = controller;
	}
}
