package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window {
	protected JFrame frame;
	protected JButton dialogButton;
	
	public Window() {
		createAndShowGUI();
		addButtonController(new ActionButton());
	}
	
	public void createAndShowGUI() {
		JFrame frame = new JFrame("Dialog");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialogButton = new JButton("Click");
		frame.getContentPane().add(dialogButton);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void addButtonController(ActionListener al) {
		dialogButton.addActionListener(al);
	}
	
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() { 
				public void run(){			// Create object runnable to initializates GUI
					new Window();
				}
			});
			/*SwingUtilities.invokeAndWait(new Runnable() {
				public void run()  {
					while(true) {}
				}
			});*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	class ActionButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "Cick the button to close");
		}
		
	}

}

