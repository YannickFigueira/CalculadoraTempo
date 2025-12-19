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
 */
public class Metodos extends Funcionalidades implements Funcoes {

    // Variáveis
    private int largura, altura;
    private int coluna2;
    private float tamanhoArquivo;
    private float tamanhoPasta;

    @Override
    public void setLargura(int valor) {
        this.largura += valor;
    }

    @Override
    public int getLargura() {
        return this.largura;
    }

    @Override
    public void setAltura(int valor) {
        this.altura += valor;
    }

    @Override
    public int getAltura() {
        return this.altura;
    }

    @Override
    public void setSize(JFrame frame) {
        frame.setSize(this.getLargura() + Funcoes.LARGURA_EXTRA, this.getAltura() + Funcoes.ALTURA_EXTRA);
    }

    @Override
    public int getTamanhoLabel(JLabel label) {
        label.setSize(label.getPreferredSize());
        int tamanho = label.getWidth();

        return tamanho;
    }

    public int getColuna2() {
        return coluna2;
    }

    public void setColuna2(int coluna2) {
        this.coluna2 = (int) (coluna2 / 2f);
    }


    public float getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(float tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public float getTamanhoPasta() {
        return tamanhoPasta;
    }

    public void setTamanhoPasta(float tamanhoPasta) {
        this.tamanhoPasta = tamanhoPasta;
    }

    @Override
    public int getTamanhoCheckBox(JCheckBox checkBox) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
