/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculartempo1;

import java.awt.event.ActionEvent;
import java.util.Date;

/**
 *
 * @author Yannick
 */
public class Janela extends Componentes {

    String texto;
    String text = "";
    float dividir = 0f;
    long multiplicar = 0;
    long subtrair = 0;
    long soma = 0;
    long resultado = 0;
    int sinal = 0;
    String registro = "";
    //SimpleDateFormat formatar = new SimpleDateFormat("HH:mm");
    //protected final int TEMPO_EXTRA = 21 * 60 * 60 * 1000;

    public Janela() {
        
        executar();
    }

    private void executar() {

        // Botoes
        this.btn1.addActionListener((ActionEvent ae) -> {
            this.txtTempo.setText(montarTexto("1", true, false));
            this.txtTempo.grabFocus();
        });
        this.btn2.addActionListener((ActionEvent ae) -> {
            this.txtTempo.setText(montarTexto("2", true, false));
            this.txtTempo.grabFocus();
        });
        this.btn3.addActionListener((ActionEvent ae) -> {
            this.txtTempo.setText(montarTexto("3", true, false));
            this.txtTempo.grabFocus();
        });
        this.btn4.addActionListener((ActionEvent ae) -> {
            this.txtTempo.setText(montarTexto("4", true, false));
            this.txtTempo.grabFocus();
        });
        this.btn5.addActionListener((ActionEvent ae) -> {
            this.txtTempo.setText(montarTexto("5", true, false));
            this.txtTempo.grabFocus();
        });
        this.btn6.addActionListener((ActionEvent ae) -> {
            this.txtTempo.setText(montarTexto("6", true, false));
            this.txtTempo.grabFocus();
        });
        this.btn7.addActionListener((ActionEvent ae) -> {
            this.txtTempo.setText(montarTexto("7", true, false));
            this.txtTempo.grabFocus();
        });
        this.btn8.addActionListener((ActionEvent ae) -> {
            this.txtTempo.setText(montarTexto("8", true, false));
            this.txtTempo.grabFocus();
        });
        this.btn9.addActionListener((ActionEvent ae) -> {
            this.txtTempo.setText(montarTexto("9", true, false));
            this.txtTempo.grabFocus();
        });
        this.btn0.addActionListener((ActionEvent ae) -> {
            this.txtTempo.setText(montarTexto("0", true, false));
            this.txtTempo.grabFocus();
        });

        this.btnLimpar.addActionListener((ActionEvent ae) -> {
            this.txtTempo.setText("");
            this.texto = "";
            dividir = 0f;
            multiplicar = 0;
            subtrair = 0;
            soma = 0;
            resultado = 0;
            this.txtTempo.grabFocus();
        });

        this.btnDividir.addActionListener((ActionEvent ae) -> {
            if (!this.txtTempo.getText().trim().equals("")) {
                resultado = dividir(this.txtTempo.getText());
                registrar();
                this.txtTempo.setText("");
                sinal = 1;
                this.txtTempo.grabFocus();
            } else {
                this.txtTempo.grabFocus();
            }
        });
        this.btnMultiplicar.addActionListener((ActionEvent ae) -> {
            if (!this.txtTempo.getText().trim().equals("")) {
                resultado = multiplicar(this.txtTempo.getText());
                registrar();
                this.txtTempo.setText("");
                sinal = 2;
                this.txtTempo.grabFocus();
            } else {
                this.txtTempo.grabFocus();
            }
        });
        this.btnSubtrair.addActionListener((ActionEvent ae) -> {
            if (!this.txtTempo.getText().trim().equals("")) {
                resultado = subtrair(this.txtTempo.getText());
                registrar();
                this.txtTempo.setText("");
                sinal = 3;
                this.txtTempo.grabFocus();
            } else {
                this.txtTempo.grabFocus();
            }
        });
        this.btnSomar.addActionListener((ActionEvent ae) -> {
            if (!this.txtTempo.getText().trim().equals("")) {
                resultado = somar(this.txtTempo.getText());
                registrar();
                this.txtTempo.setText("");
                sinal = 4;
                this.txtTempo.grabFocus();
            } else {
                this.txtTempo.grabFocus();
            }

        });
        this.btnResultado.addActionListener((ActionEvent ae) -> {
            if (resultado == 0) {
                sinal = 5;
                resultado();
            } else {
                registrar();
                resultado();
                registrar();
                txtCalculo.append(funcao.sep(8, "-") + "\n");
            }

        });

        // Visor
        this.txtCalculo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                txtTempo.grabFocus();
            }
        });
        this.txtTempo.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String caractere = evt.getKeyChar() + "";

                if (((evt.getKeyCode() >= 48) && (evt.getKeyCode() <= 57))
                        || ((evt.getKeyCode() >= 96) && (evt.getKeyCode() <= 105))) {
                    txtTempo.setText(montarTexto(caractere, true, false));
                }
                if (evt.getKeyCode() == 8) {
                    limparLetra();
                }
            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {

                if ((evt.getKeyChar() + "").equals("/")) {
                    if (!txtTempo.getText().trim().equals("")) {
                        resultado = dividir(txtTempo.getText());
                        registrar();
                        txtTempo.setText("");
                        sinal = 1;
                        txtTempo.grabFocus();
                    } else {
                        txtTempo.grabFocus();
                    }
                }

                if ((evt.getKeyChar() + "").equals("*")) {
                    if (!txtTempo.getText().trim().equals("")) {
                        resultado = multiplicar(txtTempo.getText());
                        registrar();
                        txtTempo.setText("");
                        sinal = 2;
                        txtTempo.grabFocus();
                    } else {
                        txtTempo.grabFocus();
                    }
                }

                if ((evt.getKeyChar() + "").equals("-")) {
                    if (!txtTempo.getText().trim().equals("")) {
                        resultado = subtrair(txtTempo.getText());
                        registrar();
                        txtTempo.setText("");
                        sinal = 3;
                        txtTempo.grabFocus();
                    } else {
                        txtTempo.grabFocus();
                    }
                }

                if ((evt.getKeyChar() + "").equals("+")) {
                    if (!txtTempo.getText().trim().equals("")) {
                        resultado = somar(txtTempo.getText());
                        registrar();
                        txtTempo.setText("");
                        sinal = 4;
                        txtTempo.grabFocus();
                    } else {
                        txtTempo.grabFocus();
                    }
                }

                if (evt.getKeyCode() == 10) {
                    if (resultado == 0) {
                        sinal = 5;
                        resultado();
                    } else {
                        registrar();
                        resultado();
                        registrar();
                        txtCalculo.append(funcao.sep(8, "-") + "\n");
                    }
                }
            } // Fim de KeyPressed
        });

        this.txtTempo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTempo.setCaretPosition(txtTempo.getText().length());
            }
        });
    }

    public String montarTexto(String tex, boolean verificar, boolean limpar) {
        

        if (verificar) {
            int tot = 4;
            if (tex.equals("")) {
                tot = 5;
            }
            texto = txtTempo.getText();
            if (limpar) {
                tot = 5;
            }
            if (texto.length() <= tot) {
                texto = texto.replace(":", "");
                if (limpar) {
                } else {
                    tex = texto + tex;
                }

                String[] separar;
                String[] montar = new String[20];
                int cont = 0;

                switch (tex.length()) {
                    case 3:
                        for (int i = 0; i < montar.length; i++) {
                            montar[i] = "";
                        }
                        separar = tex.split("");
                        for (int i = 0; i < tex.length(); i++) {
                            montar[cont++] = separar[i];
                            if (cont == 1) {
                                montar[cont++] = ":";
                            }
                        }
                        tex = "";
                        for (String montar1 : montar) {
                            tex += montar1;
                        }
                        break;
                    case 4:
                        for (int i = 0; i < montar.length; i++) {
                            montar[i] = "";
                        }
                        separar = tex.split("");
                        for (int i = 0; i < tex.length(); i++) {
                            montar[cont++] = separar[i];
                            if (cont == 2) {
                                montar[cont++] = ":";
                            }
                        }
                        tex = "";
                        for (String montar1 : montar) {
                            tex += montar1;
                        }
                        break;
                    case 5:
                        for (int i = 0; i < montar.length; i++) {
                            montar[i] = "";
                        }
                        separar = tex.split("");
                        for (int i = 0; i < tex.length(); i++) {
                            montar[cont++] = separar[i];
                            if (cont == 1) {
                                montar[cont++] = ":";
                            } else if (cont == 4) {
                                montar[cont++] = ":";
                            }
                        }
                        tex = "";
                        for (String montar1 : montar) {
                            tex += montar1;
                        }
                        break;
                    case 6:
                        for (int i = 0; i < montar.length; i++) {
                            montar[i] = "";
                        }
                        separar = tex.split("");
                        for (int i = 0; i < tex.length(); i++) {
                            montar[cont++] = separar[i];
                            if (cont == 2) {
                                montar[cont++] = ":";
                            } else if (cont == 5) {
                                montar[cont++] = ":";
                            }
                        }
                        tex = "";
                        for (String montar1 : montar) {
                            tex += montar1;
                        }
                        break;
                    default:
                        break;
                }

                text = tex;
                return tex;
            } else {
                return texto;
            }
        } else {
            return text;
        }
    } // fim de montarTexto

    public void limparLetra() {
        String limpar = "";
        String[] separar = txtTempo.getText().replace(":", "").split("");
        for (int i = 0; i < separar.length - 1; i++) {
            limpar += separar[i];
        }
        txtTempo.setText(montarTexto(limpar, true, true));
    } // Fim de limparLetra

    public long dividir(String tex) {

        String[] separarTempo = tex.split(":");

        switch (separarTempo.length) {
            case 1:
                if (dividir == 0) {
                    dividir += Long.parseLong(separarTempo[0]);
                } else {
                    dividir /= Long.parseLong(separarTempo[0]);
                }
                break;
            case 2:
                if (dividir == 0) {
                    dividir += Long.parseLong(separarTempo[1]);
                    dividir += Long.parseLong(separarTempo[0]) * 60;
                } else {
                    dividir /= Long.parseLong(separarTempo[1]);
                    dividir /= Long.parseLong(separarTempo[0]) * 60;
                }

                break;
            case 3:
                if (dividir == 0) {
                    dividir += Long.parseLong(separarTempo[2]);
                    dividir += Long.parseLong(separarTempo[1]) * 60;
                    dividir += Long.parseLong(separarTempo[0]) * 60 * 60;
                } else {
                    dividir /= Long.parseLong(separarTempo[2]);
                    dividir /= Long.parseLong(separarTempo[1]) * 60;
                    dividir /= Long.parseLong(separarTempo[0]) * 60 * 60;
                }

                break;
            default:
                throw new AssertionError();
        }

        return (long)dividir;
    } //fim de dividir

    public long multiplicar(String tex) {

        String[] separarTempo = tex.split(":");

        switch (separarTempo.length) {
            case 1:
                if (multiplicar == 0) {
                    multiplicar += Long.parseLong(separarTempo[0]);
                } else {
                    multiplicar *= Long.parseLong(separarTempo[0]);
                }
                break;
            case 2:
                if (multiplicar == 0) {
                    multiplicar += Long.parseLong(separarTempo[1]);
                    multiplicar += Long.parseLong(separarTempo[0]) * 60;
                } else {
                    multiplicar *= Long.parseLong(separarTempo[1]);
                    multiplicar *= Long.parseLong(separarTempo[0]) * 60;
                }

                break;
            case 3:
                if (multiplicar == 0) {
                    multiplicar += Long.parseLong(separarTempo[2]);
                    multiplicar += Long.parseLong(separarTempo[1]) * 60;
                    multiplicar += Long.parseLong(separarTempo[0]) * 60 * 60;
                } else {
                    multiplicar *= Long.parseLong(separarTempo[2]);
                    multiplicar *= Long.parseLong(separarTempo[1]) * 60;
                    multiplicar *= Long.parseLong(separarTempo[0]) * 60 * 60;
                }

                break;
            default:
                throw new AssertionError();
        }

        return multiplicar;
    } //fim de multiplicar

    public long subtrair(String tex) {

        String[] separarTempo = tex.split(":");

        switch (separarTempo.length) {
            case 1:
                if (subtrair == 0) {
                    subtrair += Long.parseLong(separarTempo[0]);
                } else {
                    subtrair -= Long.parseLong(separarTempo[0]);
                }
                break;
            case 2:
                if (subtrair == 0) {
                    subtrair += Long.parseLong(separarTempo[1]);
                    subtrair += Long.parseLong(separarTempo[0]) * 60;
                } else {
                    subtrair -= Long.parseLong(separarTempo[1]);
                    subtrair -= Long.parseLong(separarTempo[0]) * 60;
                }

                break;
            case 3:
                if (subtrair == 0) {
                    subtrair += Long.parseLong(separarTempo[2]);
                    subtrair += Long.parseLong(separarTempo[1]) * 60;
                    subtrair += Long.parseLong(separarTempo[0]) * 60 * 60;
                } else {
                    subtrair -= Long.parseLong(separarTempo[2]);
                    subtrair -= Long.parseLong(separarTempo[1]) * 60;
                    subtrair -= Long.parseLong(separarTempo[0]) * 60 * 60;
                }

                break;
            default:
                throw new AssertionError();
        }

        return subtrair;
    } //fim de subtrair

    public long somar(String tex) {

        String[] separarTempo = tex.split(":");

        switch (separarTempo.length) {
            case 1:
                soma += Long.parseLong(separarTempo[0]);
                break;
            case 2:
                soma += Long.parseLong(separarTempo[1]);
                soma += Long.parseLong(separarTempo[0]) * 60;
                break;
            case 3:
                soma += Long.parseLong(separarTempo[2]);
                soma += Long.parseLong(separarTempo[1]) * 60;
                soma += Long.parseLong(separarTempo[0]) * 60 * 60;
                break;
            default:
                throw new AssertionError();
        }
        
        return soma;
    } //fim de somar

    public void registrar() {
        String[] separarTempo = this.txtTempo.getText().split(":");

        switch (separarTempo.length) {
            case 1:
                if(Integer.parseInt(separarTempo[0]) < 10){
                    separarTempo[0] = "0" + separarTempo[0];
                }
                registro = "00:" + separarTempo[0];
                break;
            case 2:
                if(Integer.parseInt(separarTempo[0]) < 10){
                    separarTempo[0] = "0" + Integer.parseInt(separarTempo[0]);
                }
                registro = separarTempo[0] + ":" + separarTempo[1];
                break;
            case 3:
                registro += separarTempo[2];
                registro += separarTempo[1];
                registro += separarTempo[0];
                break;
            default:
                throw new AssertionError();
        }
        
        this.txtCalculo.append(registro + "\n");

        registro = "";

    } //fim de registrar

    public void resultado() {
        switch (sinal) {
            case 1:
                resultado = dividir(this.txtTempo.getText());
                break;
            case 2:
                resultado = multiplicar(this.txtTempo.getText());
                break;
            case 3:
                resultado = subtrair(this.txtTempo.getText());
                break;
            case 4:
                resultado = somar(this.txtTempo.getText());
                break;
            case 5:
                //resultado = 0 - this.TEMPO_EXTRA;
                resultado = 0;
                break;
            default:
                break;
        }

        this.txtTempo.setText(formatar(resultado));
        dividir = 0f;
        multiplicar = 0;
        subtrair = 0;
        soma = 0;
        resultado = 0;
        this.txtTempo.grabFocus();
    } // Fim de resultado
    
    // Metodos
    
    private String formatar(long valor){
        String visor;
        int hora;
        String horaS;
        float minuto;
        String minutoS;
        
        hora = (int) valor / 60;
        minuto = ((float)valor / 60 - hora) * 60;
        //System.out.println(valor);
        if (hora < 10){
            horaS = "0" + hora;
        }else{
            horaS = "" + hora;
        }
        if (minuto < 10){
            minutoS = "0" + Math.round(minuto);
        }else{
            minutoS = "" + Math.round(minuto);
        }
        visor = horaS + ":" + minutoS;
        
        return visor;
    }

}
