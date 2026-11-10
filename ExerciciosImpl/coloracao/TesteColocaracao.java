package coloracao;

public class TesteColocaracao {
    public static void main(String[] args) {
        TGrafoColoracao grafo = null;
        TGrafoColoracao grafo2 = null;

        System.out.println("\nRealizando teste dos grafos do exercício:");
        System.out.println("""
        
        OBS: Os vértices são representados internamente por índices iniciando em 0.
        Assim, índice 0 = Vértice 1, índice 1 = Vértice 2,
        índice 2 = Vértice 3, etc.
        """);

        grafo = TGrafoColoracao.buildGraph("coloracao/grafo1.txt");
        grafo2 = TGrafoColoracao.buildGraph("coloracao/grafo2.txt");

        System.out.println("\n=== Algoritmo de Coloracao por Classe - Grafo 1 (Material da Aula) ===");

        grafo.coloracao_classe();

        System.out.println("\n=== Algoritmo de Coloracao por Classe - Grafo 2 (Atividade solicitada anteriormente) ===");

        grafo2.coloracao_classe();
    }
}
