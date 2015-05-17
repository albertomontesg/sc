package basic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class ChangeColorButton {
	public static JFrame createAndShowGUI() {
		JFrame frame = new JFrame("ChangeColorButton");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = new JPanel(new BorderLayout());
		frame.setContentPane(container);

		JButton button = new JButton("Click!");
		
		container.add(button);
		
		ButtonHandler handler = new ButtonHandler(button);
		button.addActionListener(handler);
		frame.pack();
		frame.setVisible(true);
		
		return frame;
	}

	public static void main(String[] args) {
		ChangeColorButton.createAndShowGUI();
	}
	
}

class ButtonHandler implements ActionListener {
	private JButton button;
	
	public ButtonHandler(JButton button) {
		this.button = button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Es EDT: " + SwingUtilities.isEventDispatchThread());
		button.setForeground(new Color(100,0,255));
		
	}
	
}
