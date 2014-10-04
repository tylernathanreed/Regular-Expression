//* Description *//
// Title: Regex
// Author: Tyler Reed
// Used to Tokenize Strings

//* Package *//
package Main;

//* Libraries *//
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//* Regex Test Class *//
public class Regex
{
	//* Regex Methods *//
	// Converts the specified String to a List of Tokens using the specified Pattern
	public static List<Token> match(String input, String pattern)
	{
		// Initialize the Pattern Matcher
		Matcher matcher = Pattern.compile(pattern).matcher(input);

		// Initialize the Token List
		List<Token> tokens = new LinkedList<Token>();

		// Populate the List
		while(matcher.find())
			tokens.add(new Token(matcher.group(), matcher.start(), matcher.end()));

		return new ArrayList<Token>(tokens);
	}

	//* Static Entry Class *//
	public static class Token
	{
		//* Class Variables *//
		// Regex Variables
		protected String token;
		protected int start;
		protected int end;

		//* Constructor *//
		// Creates the specified Instance of the Entry Class
		public Token(String token, int start, int end)
		{
			this.token = token;
			this.start = start;
			this.end = end;
		}

		//* Conversion Methods *//
		// Returns a String Representation of the Token
		public String toString()
		{
			return "[" + token + ", " + start + ", " + end + "]";
		}
	}
}
