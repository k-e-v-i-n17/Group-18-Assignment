import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Group18Calculator implements ActionListener{

	JFrame frame;

	JTextField textfield;
	JButton[] functionButtons = new JButton[8];
	JButton delButton,clrButton;
	JPanel panel;
	
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

		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");

		functionButtons[5] = delButton;
		functionButtons[6] = clrButton;

		delButton.setBounds(50, 430, 145, 50);
		clrButton.setBounds(205, 430, 145, 50);
		
		frame.add(delButton);
		frame.add(clrButton); 
		frame.add(textfield);
		
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Group18Calculator calc = new Group18Calculator();
	}

	public void actionPerformed(ActionEvent e) {
		
		
		
		
	}

}