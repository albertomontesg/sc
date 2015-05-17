package mvc.comtador;

import mvc.comtador.View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

/**
 * 
 * @author Alberto Montes
 * @version Mar 7, 2014
 */
public class Text implements View {
    
    protected Counter model;
    protected JLabel marcador;  //etiqueta que mostra el numero de clicks
    
    public Text (Counter m){
        model = m;
        marcador = new JLabel(String.valueOf(m.getValor()));
        model.addObserver((Observer) this); //Important! afegir la vista com a observador.       
    }
    
    public void update(Observable ignorarObs, Object ignorarObj){
        marcador.setText(String.valueOf(model.getValor())); //actualitza el numero de clicks
    }
}
