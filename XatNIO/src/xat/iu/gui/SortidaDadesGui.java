package xat.iu.gui;

import javax.swing.JTextArea;

import xat.iu.SortidaDades;

public class SortidaDadesGui implements SortidaDades{

	protected JTextArea conversation; 
	
	public SortidaDadesGui(JTextArea c) {
		conversation = c;
	}
    @Override
    public void escriureDades(String str) {
    	conversation.append(str + "\n");
    }

}
