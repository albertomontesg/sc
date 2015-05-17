package mvc.tempsTasca;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que correspon a la vista, la qual esta observant possibles canvis
 * en les resolucions de les tasques, i actualitza la GUI quan aixo es produeix.
 * @author Alberto Montes
 * @version Mar 24, 2014
 */
public class Vista implements Observer{
	
	protected Model m;
	protected JFrame frame;
    protected JButton button;
    protected JLabel numTasques;
    protected JLabel tempsTasca;
    protected JLabel tempsAcumulat;
    protected Model model;

	public Vista(Model m) {
		this.m = m;
		/* Es necessari subscriure's com observador al model per que
		 * se't notifiqui quan aquest canvii. */
		m.addObserver(this);
		button = new JButton("Crear tasca");
        numTasques = new JLabel("Numero tasques: ");
        tempsTasca = new JLabel("Temps tasca: ");
        tempsAcumulat = new JLabel("Temps acumulat: ");
        
        Controlador controlador = new Controlador(m);
        button.addActionListener(controlador);

	}
	
	/**
	 * Metode que crea tota la GUI
	 * @return Retorna el {@code frame} de la finestra
	 */
	public void createAndShowGUI() {
		//Crear i montar la finestra
        frame = new JFrame("Temps Tasques");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        
        // Creem el panel en fem la distribucio en el layout.
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            
        panel.setBorder(BorderFactory.createEmptyBorder(5,20,10,20));

        //Afegim una separacio vertical
        panel.add(Box.createRigidArea(new Dimension(40,10)));
        panel.add(numTasques);
        panel.add(Box.createRigidArea(new Dimension(40,10)));
        panel.add(tempsTasca);
        panel.add(Box.createRigidArea(new Dimension(40,10)));
        panel.add(tempsAcumulat);
        panel.add(Box.createRigidArea(new Dimension(40,30)));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(40,10)));
        
  // Els panells de contingut ha de ser opacs
        panel.setOpaque(true);

        frame.setContentPane(panel);

        // Fer visualitzable
        frame.pack();
        
        // Fer visible
        frame.setVisible(true);
		
	}
	
	/**
	 * Actualitza la GUI quan s'han actualitzat els diferents valors
	 */
	@Override
	public synchronized void update(Observable o, Object arg) {
		
		final int numTasc = m.getNumTasques();
        final int tempsTasc = m.getTempsUltima();
        final int tempsAcum = m.getTempsTotal();
        // Crear tasca
        Runnable task = new Runnable(){
            public void run() {
                numTasques.setText("Numero tasques: " + (new Integer(numTasc)).toString());
                tempsTasca.setText("Temps tasca: " + (new Integer(tempsTasc)).toString());
                tempsAcumulat.setText("Temps acumulat: " + (new Integer(tempsAcum)).toString());
            }            
        };
        //  Executar tasca en EDT
        javax.swing.SwingUtilities.invokeLater(task);

		
	}
	
}
