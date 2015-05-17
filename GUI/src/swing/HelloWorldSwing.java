package swing;

import javax.swing.*;

public class HelloWorldSwing {
	
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Hello World");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel text = new JLabel("Hello World");
		frame.getContentPane().add(text);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){ 
			public void run(){			// Create object runnable to initializates GUI
				createAndShowGUI();
			}
		});
	}
}
