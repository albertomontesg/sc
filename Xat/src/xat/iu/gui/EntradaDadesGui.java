package xat.iu.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import xat.iu.EntradaDades;

/**
 *
 * @author marcel
 */
public class EntradaDadesGui implements EntradaDades {

	protected JTextField message;
	protected JButton sendButton;
	protected String mess;
	
	public EntradaDadesGui(JTextComponent m, JButton sb) {
		message = (JTextField) m;
		sendButton = sb;
		ButtonHandler handler = new ButtonHandler(this);
		sendButton.addActionListener(handler);
		message.addActionListener(handler);
	}

    public synchronized String obtenirEntradaUsuari() {
		try {wait();} catch (InterruptedException e) {e.printStackTrace();}
        return mess;
    }
    
    public synchronized void missatgeEnviat(String str) {
    	mess = str;
		notify();
    }

}

class ButtonHandler implements ActionListener {
	private JTextComponent message;
	private EntradaDadesGui entrada;
	
	public ButtonHandler(EntradaDadesGui e) {
		this.message = e.message;
		this.entrada = e;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		final String mes = message.getText();
		message.setText("");
		new Thread(new Runnable() {
			public void run() {
				entrada.missatgeEnviat(mes);
			}
		}).start();
	}
	
}