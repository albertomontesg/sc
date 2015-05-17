package xat.iu.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import xat.iu.InterficieUsuari;
import xat.patrons.mvc.ModelLlista;
import xat.patrons.mvc.Vista;

/**
 *
 * @author marcel
 * @param <T>
 */
public class InterficieUsuariGui<T extends String> extends InterficieUsuari<T> implements Vista {

	protected JFrame frame;
	protected JTextArea conversation;
	protected JTextField message;
	protected JButton sendButton;
	protected JScrollPane scroll;
	
    public InterficieUsuariGui(ModelLlista<T> model) {
    	//completar
    	//Create element of the GUI
    	conversation = new JTextArea();
    	conversation.setEditable(false);
    	scroll = new JScrollPane(conversation);
    	message = new JTextField(30);
    	sendButton = new JButton("Send");
    	
    	
    	modelLlista = model;
    	modelLlista.addObserver(this);
    	
    	sortida = new SortidaDadesGui(conversation);
    	entrada = new EntradaDadesGui(message, sendButton);
    	
    	
    	SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
    			createAndShowGUI();
    		}
    	});
    	
    }
    
    public JFrame createAndShowGUI() {
		JFrame frame = new JFrame("Messenger");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = new JPanel(new BorderLayout());
		frame.setContentPane(container);
		
		container.add(scroll);
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(message);
		panel.add(sendButton);
		container.add(panel, BorderLayout.SOUTH);
		
		frame.setVisible(true);
		
		return frame;
	}
    
	@Override
    public void update(Observable o, Object arg) {
		
    	sortida.escriureDades((String) modelLlista.getUltimAfegit());
    	
    	// When update the content the scroll pane goes to the bottom to see the latest message 
    	SwingUtilities.invokeLater(new Runnable(){
    		public void run() {
    			JScrollBar vertical = scroll.getVerticalScrollBar();
    	    	vertical.setValue(vertical.getMaximum());
    		}
    	});
    	
    }
}
