package basic;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

/**
 * TextEditor
 * @author Alberto
 * @date 3 mar 2014
 * Class which creates an scrollable editor into a window with three buttons
 */
public class TextEditor {
	public static JFrame createGUI() {
		JFrame frame = new JFrame("TextEditor");
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		
		//container.add(new JTextArea() , BorderLayout.CENTER);
		container.add(new JScrollPane(new JTextArea()));
		
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(new JButton("B1"));
		panel.add(new JButton("B2"));
		panel.add(new JButton("B3"));
		container.add(panel, BorderLayout.SOUTH);
		return frame;
	}
	
	public static void main(String[] args) {
		JFrame f = TextEditor.createGUI();
		f.setVisible(true);
	}
}
