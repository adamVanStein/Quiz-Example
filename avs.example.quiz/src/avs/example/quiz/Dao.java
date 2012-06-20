package avs.example.quiz;

import static org.apache.commons.lang3.StringEscapeUtils.unescapeCsv;
import static org.apache.commons.lang3.StringEscapeUtils.unescapeJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Dao {
	private final Pattern COMMA = Pattern.compile(","); 
	
	private Quiz loadQuiz(String line) {
		String[] data = COMMA.split(unescapeJava(unescapeCsv(line)));
		
		System.out.println(Integer.parseInt(data[Quiz.CHOICE_NUM + 1]));
		
		return new Quiz(
				data[0],
				Arrays.copyOfRange(data, 1, Quiz.CHOICE_NUM + 1),
				Integer.parseInt(data[Quiz.CHOICE_NUM + 1]) - 1);
	}
	
	public void loadQuizes(File file, QuizGiver quizGiver) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( new FileInputStream( file ) ) );
		
		String line;
		while( (line = reader.readLine()) != null ) {
			quizGiver.addQuiz( loadQuiz(line) );
		}
		
		reader.close();
	}
}
