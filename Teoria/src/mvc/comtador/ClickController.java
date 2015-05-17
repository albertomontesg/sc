package mvc.comtador;

import java.awt.event.ActionEvent;

/**
 * 
 * @author Alberto Montes
 * @version Mar 7, 2014
 */
public class ClickController extends Controller{
    
    protected Counter model;
    
    public ClickController (Model m, UserInterface iu){
        model = (Counter) m;
        iu.addController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         model.inc();
    }
}
