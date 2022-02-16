
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EstruturaColecaoArrayList {

    // Instanciação de um objeto coleção ArrayList
    static ArrayList<String> listaNomes;
    static Scanner entradaPadrao;
    static String novoNome;
    static int indice, totalNos;

    public static void main(String[] args) {
        entradaPadrao = new Scanner(System.in);
        listaNomes = new ArrayList();
        
        // Adicionando elementos à lista ArrayList
        listaNomes.add("Joaquim");
        listaNomes.add("Maria");
        listaNomes.add("José");
        listaNomes.add("Beatriz");
        listaNomes.add(0, "Francisco");

        // Apresentando os elementos da lista ArrayList
        System.out.println("\nApresentando os elementos da lista [for]");
        totalNos = listaNomes.size();
        for (indice = 0; indice < totalNos; indice++) {
            System.out.printf("Nó = %d Valor = %s\n", indice, listaNomes.get(indice));
            //System.out.println("Nó = " + indice + " Valor = " + listaNomes.get(indice));
        }

        // Excluindo um elemento da lista ArrayList
        System.out.print("\nInforme a posição a ser excluída = ");
        indice = entradaPadrao.nextInt();
        try {
            listaNomes.remove(indice);
        } catch (IndexOutOfBoundsException erro) {
            System.out.println("\nErro: posição inválida na lista = "
                    + erro.getMessage());
        }

        // Apresentando os elementos da lista ArrayList - instrução for-each
        System.out.println("\nApresentando os elementos da lista [for-each]");
        for (String s : listaNomes) {
            System.out.printf("Valor = %s\n", s);
        }

        // Inserindo novos elementos na lista ArrayList
        // Apresentando os elementos da lista ArrayList - mecanismo iterator
        System.out.println("\nApresentando os elementos da lista [iterator]");
        Iterator<String> observador = listaNomes.iterator();
        while (observador.hasNext()) {
            System.out.printf("Valor = %s\n", observador.next());
        }
    }
}
