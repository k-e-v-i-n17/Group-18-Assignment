import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Stack;

public class Group18Calculator implements ActionListener{

	JFrame frame;

	static JTextField textfield;
	JButton[] functionButtons = new JButton[8];
	JButton equButton,clrButton;
	JPanel panel;
	static String input;
	static String output;
	static int finalresult;
	static String exp;
	static int result;
	static boolean falseinput = false;

	Font myFont = new Font("Ariel", Font.BOLD,30);

	char operator;

	Group18Calculator (){

		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);

		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);



		equButton = new JButton("=");
		clrButton = new JButton("Clear");

		functionButtons[0] = equButton;
		functionButtons[1] = clrButton;

		functionButtons[0].addActionListener(this);
		functionButtons[1].addActionListener(this);

		equButton.setBounds(50, 430, 145, 50);
		clrButton.setBounds(205, 430, 145, 50);

		frame.add(equButton);
		frame.add(clrButton); 
		frame.add(textfield);

		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Group18Calculator calc = new Group18Calculator();
	}



	public static int evaluate(String expression)
	{
		char[] tokens = expression.toCharArray();

		// Stack for numbers: 'values'
		Stack<Integer> values = new
				Stack<Integer>();

		// Stack for Operators: 'ops'
		Stack<Character> ops = new
				Stack<Character>();

		for (int i = 0; i < tokens.length; i++)
		{

			// Current token is a
			// whitespace, skip it
			if (tokens[i] == ' ')
				continue;

			// Current token is a number,
			// push it to stack for numbers
			if (tokens[i] >= '0' &&
					tokens[i] <= '9')
			{
				StringBuffer sbuf = new
						StringBuffer();

				// There may be more than one
				// digits in number
				while (i < tokens.length &&
						tokens[i] >= '0' &&
						tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				values.push(Integer.parseInt(sbuf.
						toString()));

				// right now the i points to
				// the character next to the digit,
				// since the for loop also increases
				// the i, we would skip one
				//  token position; we need to
				// decrease the value of i by 1 to
				// correct the offset.
				i--;
			}

			// Current token is an opening brace,
			// push it to 'ops'
			else if (tokens[i] == '(')
				ops.push(tokens[i]);

			// Closing brace encountered,
			// solve entire brace
			else if (tokens[i] == ')')
			{
				while (ops.peek() != '(')
					values.push(applyOp(ops.pop(),
							values.pop(),
							values.pop()));
				ops.pop();
			}

			// Current token is an operator.
			else if (tokens[i] == '+' ||
					tokens[i] == '-' ||
					tokens[i] == '*')
			{
				// While top of 'ops' has same
				// or greater precedence to current
				// token, which is an operator.
				// Apply operator on top of 'ops'
				// to top two elements in values stack
				while (!ops.empty() &&
						hasPrecedence(tokens[i],
								ops.peek()))
					values.push(applyOp(ops.pop(),
							values.pop(),
							values.pop()));

				// Push current token to 'ops'.
				ops.push(tokens[i]);
			}
			//If the input is none of the above, then it is not valid
			else
			{
				falseinput = true;      
				return 0;

			}
		}

		// Entire expression has been
		// parsed at this point, apply remaining
		// ops to remaining values
		while (!ops.empty())
			values.push(applyOp(ops.pop(),
					values.pop(),
					values.pop()));

		// Top of 'values' contains
		// result, return it
		return values.pop();
	}



	// Returns true if 'op2' has higher
	// or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(
			char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' ) &&
				(op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	// A utility method to apply an
	// operator 'op' on operands 'a'
	// and 'b'. Return the result.
	public static int applyOp(char op,
			int b, int a)
	{
		switch (op)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		}
		return 0;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==equButton)
		{
			input = textfield.getText();

			exp = input;
			result = evaluate(exp);
			if(falseinput)
			{
				textfield.setText("Invalid input");
			}
			else
			{
				System.out.println(result);
				textfield.setText(String.valueOf(result));
			}

		}
		if(e.getSource()==clrButton)
		{
			textfield.setText("");
		}

	}


}