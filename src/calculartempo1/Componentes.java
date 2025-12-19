/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculartempo1;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Yannick
 */
public class Componentes extends JFrame {

    // Metodos
    Metodos funcao;
    // Componentes
    Container con = new Container();
    JTextArea txtCalculo = new JTextArea();
    JTextField txtTempo = new JTextField();
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");
    JButton btn0 = new JButton("0");
    JButton btnLimpar = new JButton("C");
    JButton btnResultado = new JButton("=");
    JButton btnDividir = new JButton("/");
    JButton btnMultiplicar = new JButton("*");
    JButton btnSubtrair = new JButton("-");
    JButton btnSomar = new JButton("+");

    public Componentes() {
        super("Calculadora de Tempo");
        this.funcao = new Metodos();

        inicializar();
    }

    private void inicializar() {
        
        int tmnLT = 30;
        int tmnLB = 16;

        // Visor dos calculos
        FontsExclusivas fonts = new FontsExclusivas();
        
        this.txtCalculo.setFont(fonts.arialBold(22));
        this.txtCalculo.setEditable(false);
        JScrollPane scrCalculo = new JScrollPane(txtCalculo);
        scrCalculo.setLocation(Funcoes.POSICAO_LARGURA, Funcoes.POSICAO_ALTURA);
        scrCalculo.setSize(200, 37 * 3);
        
        this.funcao.setAltura(scrCalculo.getHeight() + Funcoes.ESPACAMENTO);
        
        this.txtTempo.setLocation(Funcoes.POSICAO_LARGURA, Funcoes.POSICAO_ALTURA + this.funcao.getAltura());
        this.txtTempo.setSize(200, 30);
        this.txtTempo.setHorizontalAlignment(JTextField.RIGHT);
        this.txtTempo.setFont(fonts.arialBold(tmnLT));
        this.txtTempo.setEditable(false);
        
        int aH = this.txtTempo.getWidth() / 4 - 6;

        this.funcao.setLargura(Funcoes.POSICAO_LARGURA * 2 + this.txtTempo.getWidth());
        this.funcao.setAltura(Funcoes.POSICAO_ALTURA  + this.txtTempo.getHeight() + Funcoes.ESPACAMENTO);

        // Botoes
        this.btn7.setLocation(Funcoes.POSICAO_LARGURA, this.funcao.getAltura());
        this.btn7.setSize(aH, aH);
        this.btn7.setFont(fonts.arialBold(tmnLB));
        
        this.btn8.setLocation(Funcoes.POSICAO_LARGURA + Funcoes.ESPACAMENTO + aH, this.funcao.getAltura());
        this.btn8.setSize(aH, aH);
        this.btn8.setFont(fonts.arialBold(tmnLB));
        
        this.btn9.setLocation(Funcoes.POSICAO_LARGURA + Funcoes.ESPACAMENTO * 2 + aH * 2, this.funcao.getAltura());
        this.btn9.setSize(aH, aH);
        this.btn9.setFont(fonts.arialBold(tmnLB));
        
        this.btnDividir.setLocation(Funcoes.POSICAO_LARGURA + Funcoes.ESPACAMENTO * 3 + aH * 3, this.funcao.getAltura());
        this.btnDividir.setSize(aH, aH);
        this.btnDividir.setFont(fonts.arialBold(tmnLB));
        
        this.funcao.setAltura(aH + Funcoes.ESPACAMENTO);
        
        this.btn4.setLocation(Funcoes.POSICAO_LARGURA, this.funcao.getAltura());
        this.btn4.setSize(aH, aH);
        this.btn4.setFont(fonts.arialBold(tmnLB));
        
        this.btn5.setLocation(Funcoes.POSICAO_LARGURA + Funcoes.ESPACAMENTO + aH, this.funcao.getAltura());
        this.btn5.setSize(aH, aH);
        this.btn5.setFont(fonts.arialBold(tmnLB));
        
        this.btn6.setLocation(Funcoes.POSICAO_LARGURA + Funcoes.ESPACAMENTO * 2 + aH * 2, this.funcao.getAltura());
        this.btn6.setSize(aH, aH);
        this.btn6.setFont(fonts.arialBold(tmnLB));
        
        this.btnMultiplicar.setLocation(Funcoes.POSICAO_LARGURA + Funcoes.ESPACAMENTO * 3 + aH * 3, this.funcao.getAltura());
        this.btnMultiplicar.setSize(aH, aH);
        this.btnMultiplicar.setFont(fonts.arialBold(tmnLB));
        
        this.funcao.setAltura(aH + Funcoes.ESPACAMENTO);
        
        this.btn1.setLocation(Funcoes.POSICAO_LARGURA, this.funcao.getAltura());
        this.btn1.setSize(aH, aH);
        this.btn1.setFont(fonts.arialBold(tmnLB));
        
        this.btn2.setLocation(Funcoes.POSICAO_LARGURA + Funcoes.ESPACAMENTO + aH, this.funcao.getAltura());
        this.btn2.setSize(aH, aH);
        this.btn2.setFont(fonts.arialBold(tmnLB));
        
        this.btn3.setLocation(Funcoes.POSICAO_LARGURA + Funcoes.ESPACAMENTO * 2 + aH * 2, this.funcao.getAltura());
        this.btn3.setSize(aH, aH);
        this.btn3.setFont(fonts.arialBold(tmnLB));
        
        this.btnSubtrair.setLocation(Funcoes.POSICAO_LARGURA + Funcoes.ESPACAMENTO * 3 + aH * 3, this.funcao.getAltura());
        this.btnSubtrair.setSize(aH, aH);
        this.btnSubtrair.setFont(fonts.arialBold(tmnLB));
        
        this.funcao.setAltura(aH + Funcoes.ESPACAMENTO);
        
        this.btnLimpar.setLocation(Funcoes.POSICAO_LARGURA, this.funcao.getAltura());
        this.btnLimpar.setSize(aH, aH);
        this.btnLimpar.setFont(fonts.arialBold(tmnLB));
        
        this.btn0.setLocation(Funcoes.POSICAO_LARGURA + Funcoes.ESPACAMENTO + aH, this.funcao.getAltura());
        this.btn0.setSize(aH, aH);
        this.btn0.setFont(fonts.arialBold(tmnLB));
        
        this.btnResultado.setLocation(Funcoes.POSICAO_LARGURA + Funcoes.ESPACAMENTO * 2 + aH * 2, this.funcao.getAltura());
        this.btnResultado.setSize(aH, aH);
        this.btnResultado.setFont(fonts.arialBold(tmnLB));
        
        this.btnSomar.setLocation(Funcoes.POSICAO_LARGURA + Funcoes.ESPACAMENTO * 3 + aH * 3, this.funcao.getAltura());
        this.btnSomar.setSize(aH, aH);
        this.btnSomar.setFont(fonts.arialBold(tmnLB));
        
        this.funcao.setAltura(aH);
        
        this.funcao.setAltura(Funcoes.POSICAO_ALTURA);

        //Adiciona os componentes
        this.con.add(scrCalculo);
        this.con.add(this.txtTempo);
        this.con.add(this.btn1);
        this.con.add(this.btn2);
        this.con.add(this.btn3);
        this.con.add(this.btn4);
        this.con.add(this.btn5);
        this.con.add(this.btn6);
        this.con.add(this.btn7);
        this.con.add(this.btn8);
        this.con.add(this.btn9);
        this.con.add(this.btn0);
        this.con.add(this.btnLimpar);
        this.con.add(this.btnResultado);
        this.con.add(this.btnDividir);
        this.con.add(this.btnMultiplicar);
        this.con.add(this.btnSubtrair);
        this.con.add(this.btnSomar);

        this.add(con);

        this.funcao.setSize(this);
    }

}
