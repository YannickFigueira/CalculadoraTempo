/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculartempo1;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Yannick
 * @version 1.7.11
 */
public interface Funcoes {

    int POSICAO_LARGURA = 20;
    int POSICAO_ALTURA = 20;
    int ALTURA = 20;
    int ESPACAMENTO = 8;
    int LARGURA_EXTRA = 6;
    int ALTURA_EXTRA = 28;
    int DIMENCAO_TEXTO_NUMERICO = 8;
    int DIMENCAO_TEXTO = 46;
    int DIMENCAO_COMBO = 110;
    int DIMENCAO_SPINNER = 40;

    public void setLargura(int valor);

    public int getLargura();

    public void setAltura(int valor);

    public int getAltura();

    public void setSize(JFrame frame);
    
    public int getTamanhoLabel(JLabel label);
    
    public int getTamanhoCheckBox(JCheckBox checkBox);

}
