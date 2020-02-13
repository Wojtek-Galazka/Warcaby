import com.panelWidok.oknoStartowe;
import com.panelWidok.panelStartowy;
import com.panelWidok.oknoGry;

import java.awt.*;


public class Main {
    public static void main (String [] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                oknoStartowe oknoStartowe = panelStartowy.oknoStartowe;
                oknoStartowe.setVisible(true);

            }
        });

    }
}
