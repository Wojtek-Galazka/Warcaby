import com.panelWidok.OknoStartowe;
import com.panelWidok.PanelStartowy;


import java.awt.*;


public class Main {
    public static void main (String [] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                OknoStartowe oknoStartowe = PanelStartowy.oknoStartowe;
                oknoStartowe.setVisible(true);

            }
        });

    }
}
