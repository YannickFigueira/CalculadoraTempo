/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculartempo1;

import java.awt.Component;
import java.awt.Container;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Yannick
 * @version 1.3.4
 */
public class Funcionalidades {

    // Variáveis
    private boolean cancelar = true;
    private float carregando = 0;
    private boolean cronometro;
    private final int TIME = 11;
    private final int TIME_COPIA = 1;
    // Constantes
    protected final SimpleDateFormat TEMPO_DECORRIDO = new SimpleDateFormat("HH:mm:ss.SSS");
    protected final int TEMPO_EXTRA = 21 * 60 * 60 * 1000;

    public boolean isCancelar() {
        return cancelar;
    }

    public void setCancelar(boolean cancelar) {
        this.cancelar = cancelar;
    }

    public float getCarregando() {
        return carregando;
    }

    public void setCarregando(float carregando) {
        this.carregando += carregando;
    }

    public void setCarregandoInicio(float carregando) {
        this.carregando = carregando;
    }

    public int getTimeCopia() {
        return TIME_COPIA;
    }

    // Criar repetições de caracteres
    public final String sep(int valor, String separar) {
        String sep = "";
        for (int i = 1; i <= valor; i++) {
            sep += separar;
        }
        return sep;
    }

    // Formatar tamanho
    public String getTamanhoArquivo(float valor) {
        float kiloBytes = 1024f;
        float megaBytes = 1f;
        float gigaBytes = 1f;
        float teraBytes = 1f;
        String tama;

        for (int j = 0; j < 2; j++) {
            megaBytes *= kiloBytes;
        }
        for (int j = 0; j < 3; j++) {
            gigaBytes *= kiloBytes;
        }
        for (int j = 0; j < 4; j++) {
            teraBytes *= kiloBytes;
        }
        if (valor > teraBytes) {
            tama = String.format("%.2f TB", (((valor / 1024f) / 1024f) / 1024f) / 1024f);
        } else if (valor >= gigaBytes) {
            tama = String.format("%.2f GB", ((valor / 1024f) / 1024f) / 1024f);
        } else if (valor >= megaBytes) {
            tama = String.format("%.2f MB", (valor / 1024f) / 1024f);
        } else if (valor >= kiloBytes) {
            tama = String.format("%.2f KB", valor / 1024f);
        } else {
            tama = String.format("%.2f  B", valor);
        }
        return tama;
    }

    // Verificar tamanho da pasta
    public float getFolderSize(String path, JLabel label) {
        float size = 0;
        if (path != null) {
            if (!isCancelar()) {
                File folder = new File(path);
                String hd = folder.getAbsolutePath();

                if (folder.isDirectory() && !folder.isHidden() || folder.isDirectory() && (hd.length() == 3)) {
                    String[] dirList = folder.list();
                    if (dirList != null) {
                        for (String fileName : dirList) {
                            File f = new File(path, fileName);
                            if (f.isDirectory()) {
                                String filePath = f.getPath();
                                size += getFolderSize(filePath, label);
                                continue;
                            }
                            size += f.length();
                            setCarregando(f.length());
                            label.setText(getTamanhoArquivo(getCarregando()));
                        }
                    }
                }
            }
            try {
                sleep(TIME);
            } catch (InterruptedException ex) {
                Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
            }
            return size;
        } else {
            return size;
        }
    }

    // Gerar número aleatório
    public int getAleatorio(int i, int a) {
        double ale;

        do {
            ale = i + Math.random() * a;
        } while (ale >= (a + 1));

        return ((int) ale);
    }

    // Calcular porcentagem
    public float porcentagem(float valor, float porcento) {
        float porcentagem = (valor * porcento / 100);

        return porcentagem;
    }

    public float restoPorcentagem(float valor, float porcento) {
        float resto = (valor * ((100 - porcento) / 100));

        return resto;
    }

    // Gerar tempo de execução
    public void tempoDecorrido(long inicio, JLabel label, int combo, Component con) {
        Timer decorrido = new Timer();
        decorrido.schedule(new TimerTask() {
            @Override
            public void run() {
                long fim;
                while (true) {

                    fim = System.currentTimeMillis();
                    label.setText("Tempo decorrido: " + TEMPO_DECORRIDO.format(fim - inicio - TEMPO_EXTRA));
                    if (isCronometro()) {
                        //String arquivo = "C:\\temp\\CopiaDeArquivos\\" + TEMPO_DECORRIDO.format(fim - inicio - (TEMPO_EXTRA)).replace(":", ";").replace(":", ";") + "_" + getTamanhoArquivo(combo) + ".log";
                        //gravar("", new File(arquivo), con);
                        break;
                    }
                    try {
                        sleep(TIME);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                decorrido.cancel();
            }
        }, 1);
    }

    public boolean isCronometro() {
        return cronometro;
    }

    public void setCronometro(boolean cronometro) {
        this.cronometro = cronometro;
    }

    // Gravar em arquivo
    public void gravar(String tex, File arquivo, Component janela) {
        try {
            arquivo.getParentFile().mkdirs();
            try (FileWriter fileWriter = new FileWriter(arquivo)) {
                OutputStream gravar = new FileOutputStream(arquivo);
                OutputStreamWriter gravando = new OutputStreamWriter(gravar);
                try (BufferedWriter gravarArquivo = new BufferedWriter(gravando)) {
                    gravarArquivo.write(tex);
                    gravarArquivo.close();
                }
            }
        } catch (IOException ex) {
            JFrame relatorio = new JFrame("ERRO");
            relatorio.setResizable(false);
            relatorio.setSize(300, 100);
            relatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            relatorio.setLocationRelativeTo(janela);
            relatorio.setVisible(true);

            Container con = new Container();
            JTextArea txtRelatorio = new JTextArea();
            txtRelatorio.append(ex.toString());
            JScrollPane scrRelatorio = new JScrollPane(txtRelatorio);
            scrRelatorio.setLocation(5, 5);
            scrRelatorio.setSize(250, 150);

            con.add(scrRelatorio);

            relatorio.add(con);
        }
    }

}
