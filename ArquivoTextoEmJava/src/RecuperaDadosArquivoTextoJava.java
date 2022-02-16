
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import java.io.*;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RecuperaDadosArquivoTextoJava
        extends JFrame implements WindowListener, ActionListener {

    JTextArea texto;
    JTextField caixasTexto[];
    int caractere, vogal;
    String dados, lista[];
    FileInputStream arquivo;
    DataInputStream leitor;

    public RecuperaDadosArquivoTextoJava() {
        setTitle("Arquivo Texto");
        setBounds(100, 100, 640, 480);
        setLayout(null);
        getContentPane().setBackground(Color.orange);
        texto = new JTextArea();
        texto.setEditable(false);
        texto.setBounds(50, 50, 500, 50);
        getContentPane().add(texto);

        // Recuperando dados do arquivo texto
        leArquivoTexto("c:/temp/texto.txt");

        lista = dados.split(";");
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }

        caixasTexto = new JTextField[lista.length];
        for (int i = 0; i < lista.length; i++) {
            caixasTexto[i] = new JTextField(lista[i]);
            caixasTexto[i].setBounds(50, 120 + 30 * i, 200, 25);
            getContentPane().add(caixasTexto[i]);
        }
    }

    public void leArquivoTexto(String nome) {
        try {
            dados = "";
            arquivo = new FileInputStream(nome);
            leitor = new DataInputStream(arquivo);
            caractere = 0;
            vogal = 0;
            while (caractere != -1) {
                caractere = leitor.read();
                if (caractere != -1) {
                    dados = dados + (char) caractere;
                }
                
                if (caractere == 97 | caractere == 101 | caractere == 105 | caractere == 111 | caractere == 117) {
                    vogal++;
                }
            }
            arquivo.close();
            texto.setText(dados);
            int totalLetras = dados.length();
            System.out.println(totalLetras);
            System.out.println(vogal);

        } catch (IOException erro) {
            System.out.println("Arquivo não existe...");
            System.out.println(erro.getMessage());
        }

    }

    public static void main(String args[]) {
        JFrame janela = new RecuperaDadosArquivoTextoJava();
        janela.setVisible(true);

    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        this.dispose();
        System.exit(1);
    }

    @Override
    public void windowClosed(WindowEvent we) {
        //this.dispose();
        //System.exit(1);
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
}
