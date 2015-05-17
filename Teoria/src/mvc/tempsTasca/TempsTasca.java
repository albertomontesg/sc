package mvc.tempsTasca;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

/**
 * Resolucio corresponent a un examen de SC sobre el patro MVC.
 * @author Alberto Montes
 * @version Mar 24, 2014
 */
public class TempsTasca {
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		Model m = new Model();
		final Vista vista = new Vista(m);
		
		// Totes les tasques corresponents a la GUI s'han d'executar des de el thread d'events EDT.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				vista.createAndShowGUI();
			}
		});
	
	}

}