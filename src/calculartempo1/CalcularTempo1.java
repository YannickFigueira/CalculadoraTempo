/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculartempo1;

import java.awt.Image;
import java.net.URL;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Yannick
 * @version 1.0.3
 */
public class CalcularTempo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            //UIManager.put("ProgressBar.background", Color.orange);
            //UIManager.put("ProgressBar.foreground", Color.decode(cor.tonsCinza(1)));
            //UIManager.put("ProgressBar.selectionBackground", Color.decode(cor.tonsAzul(0)));
            //UIManager.put("ProgressBar.selectionForeground", Color.green);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CalcularTempo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Janela janela = new Janela();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.setIconImage(createImage("imagens/IconeCalculadora.gif", "icone"));
        janela.setVisible(true);
        janela.txtTempo.grabFocus();
    }
    
    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = CalcularTempo1.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }

}
