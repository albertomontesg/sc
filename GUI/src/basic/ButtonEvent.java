package basic;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * ButtonEvent
 * @author Alberto
 * @date 3 mar 2014
 * Create a counter of clicks into a button
 */
public class ButtonEvent {
	public static JFrame createAndShowGUI() {
		JFrame frame = new JFrame("ButtonEvent");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = new JPanel(new BorderLayout());
		frame.setContentPane(container);

		JLabel textInfo = new JLabel("Number of Clicks");
		JLabel textClick = new JLabel("0");
		JButton button = new JButton("Click!");
		
		container.add(textInfo, BorderLayout.NORTH);
		container.add(textClick, BorderLayout.CENTER);
		container.add(button, BorderLayout.SOUTH);
		
		ButtonHandlerEvent handler = new ButtonHandlerEvent(textClick);
		button.addActionListener(handler);
		frame.pack();
		frame.setVisible(true);
		
		return frame;
	}
	
	public static void main(String[] args) {
		ButtonEvent.createAndShowGUI();
	}
	
	
}

class ButtonHandlerEvent implements ActionListener {
	private JLabel text;
	private int clicks;
	
	public ButtonHandlerEvent(JLabel txt) {
		text = txt;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		text.setText(String.valueOf(++clicks));
	}
	
}

