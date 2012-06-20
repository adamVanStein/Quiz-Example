package avs.example.quiz;

import org.apache.commons.lang3.StringEscapeUtils;


public class RegExpTest {
	public static void main(String[] args) {
		System.out.println(StringEscapeUtils.unescapeJava("ab\\\\cde"));
	}
}
