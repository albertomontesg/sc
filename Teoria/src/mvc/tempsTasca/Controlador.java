package mvc.tempsTasca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador que al produir-se l'event especificat (en aquest cas
 * clickar un boto) executara una tasca.
 * @author Alberto Montes
 * @version Mar 24, 2014
 */
public class Controlador implements ActionListener {
	
	protected Model model;
	
	/**
	 * @param m
	 * S'afegeix el model per passar-s'ho a cada tasca creada i aquesta,
	 * al finalitzar afegeixi els ultims resultats.
	 */
	public Controlador (Model m) {
		model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Tasca t = new Tasca(model);
		new Thread(t).start();
	}
}
