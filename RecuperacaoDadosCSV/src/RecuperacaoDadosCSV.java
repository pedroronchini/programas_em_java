
import javax.swing.*;
import java.io.*;

public class RecuperacaoDadosCSV extends JFrame {

    JTable tabela;
    JScrollPane painel;
    FileInputStream arquivo;
    DataInputStream leitor;
    String[][] dados;
    String[] nomesColunas;
    JTextField vendido;

    public RecuperacaoDadosCSV() {
        setLayout(null);
        setTitle("Recuperação CSV");
        setBounds(0, 0, 640, 480);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getData("planilha.csv");

        tabela = new JTable(dados, nomesColunas);
        painel = new JScrollPane(tabela);
        painel.setBounds(0, 0, 640, 400);
        
        vendido = new JTextField("0");
        vendido.setBounds(10,420,100,25);

        getContentPane().add(painel);
        getContentPane().add(vendido);  
        vendido.setText(somaValoresVendidos(dados));
    }

    public void getData(String planilha) {
        int caractere = 0, linha = 0;
        boolean cabecalho = true;
        String buffer = "";

        dados = new String[7][5];
        nomesColunas = new String[5];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                dados[i][j] = "";
            }
        }
        for (int i = 0; i < 5; i++) {
            nomesColunas[i] = "";
        }

        try {
            arquivo = new FileInputStream(planilha);
            leitor = new DataInputStream(arquivo);

            while (caractere != -1) {
                caractere = leitor.read();
                
                if (caractere != 10 && caractere != -1)
                    buffer += (char) caractere;
            
                if (caractere == 10)
                {
                   System.out.println(buffer);
                   if (cabecalho)
                   {
                       nomesColunas = buffer.split(";");
                       cabecalho = false;
                       buffer = "";
                   }
                   else
                   {
                       dados[linha] = buffer.split(";");
                       linha++;
                       buffer = "";
                   }
                }
            }
            arquivo.close();
        } catch (IOException erro) {
            System.out.println("Arquivo nao existe...");
        }
    }
    
    String somaValoresVendidos(String[][] valores)
    {
        int i;
        float valorVendido = 0;
        for (i=0; i < 7; i++)
        {
             String troca = dados[i][2].replace(',', '.');
             valorVendido += Float.parseFloat(troca);
        }
        return Float.toString(valorVendido);
    }
    
    public static void main(String args[]) {
        JFrame janela = new RecuperacaoDadosCSV();
        janela.setVisible(true);
    }
}