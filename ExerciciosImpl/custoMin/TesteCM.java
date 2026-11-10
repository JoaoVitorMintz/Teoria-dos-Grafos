package custoMin;

import java.util.Scanner;

public class TesteCM {
    public static void main(String[] args) {
        TGrafo grafo = null;
        TGrafo grafo2 = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nRealizando teste dos grafos do exercício:");
        System.out.println("""
        
        OBS: Os vértices são representados internamente por índices iniciando em 0.
        Assim, índice 0 = Vértice 1, índice 1 = Vértice 2,
        índice 2 = Vértice 3, etc.
        """);

        grafo = TGrafo.buildGraph("grafo.txt");
        grafo2 = TGrafo.buildGraph("grafo2.txt");

        System.out.println("\n=== Algoritmo de PRIM - Grafo 1 (Material da Aula) ===");
        System.out.print("Insira o vértice de ORIGEM: ");
        int origem = sc.nextInt();

        grafo.iniciaPrim(origem);
        grafo.exibePrim();

        System.out.println("\n=== Algoritmo de PRIM - Grafo 2 (Atividade solicitada anteriormente) ===");
        System.out.print("Insira o vértice de ORIGEM: ");
        int origem2 = sc.nextInt();

        grafo2.iniciaPrim(origem2);
        grafo2.exibePrim();

        sc.close();
    }
}
