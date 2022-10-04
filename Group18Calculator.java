import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Group18Calculator implements ActionListener{

	JFrame frame;

	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButotns = new JButton[8];
	JButton addButton,subButton, mulButton,clrButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free", Font.BOLD,30);
	
	char operator;

	Group18Calculator (){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		
		
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Group18Calculator calc = new Group18Calculator();
	}

	public void actionPerformed(ActionEvent e) {
		
		
		
		
	}

}
