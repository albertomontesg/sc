package basic;

import javax.swing.JFrame;

/**
 * FirstWindow
 * @author Alberto
 * @date 3 mar 2014
 * Class that cretes a window
 */
public class FirstWindow {
	public static JFrame createGUI() {
		JFrame frame = new JFrame("First Window");
		frame.setSize(400,400);
		return frame;
	}
	
	public static void main(String[] args) {
		JFrame f = FirstWindow.createGUI();
		//f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application when close window
		f.setVisible(true);
	}
}
