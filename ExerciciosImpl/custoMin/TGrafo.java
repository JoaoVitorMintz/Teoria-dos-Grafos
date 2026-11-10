package custoMin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TNo {
    public int w; // Vértice que é adjacente ao elemento da lista
    public TNo prox;
    public float pesoAres;
}

public class TGrafo {
    private int n;
    private int m;
    private TNo adj[];
    private String rotulo[];
    private String pesoVert[];

    // Atributos usados para o PRIM, representam o E'
    // Servem para representar o cunjunto de arestas do PRIM para depois
    // Exibí-los por outra função
    private int EOrigem[];
    private int EDestino[];
    private int qtdArestasPrim;
    private float custoPrim;
    
    // Construtor da classe
    public TGrafo(int n) {
        this.n = n;
        this.m = 0;
        TNo adjac[] = new TNo[n];
        String rotulos[] = new String[n];
        String pesosVert[] = new String[n];

        for (int i = 0; i < n; i++) {
            adjac[i] = null;
            rotulos[i] = null;
            pesosVert[i] = null;
        }
        this.adj = adjac;
        this.rotulo = rotulos;
        this.pesoVert = pesosVert;
    }

    /*

    FUNÇÕES PARA INSERÇÃO E REMOÇÃO DE ARESTAS:

    */
    public void insereA( int v, int w, float peso) {
        TNo noV = new TNo();
        TNo no = adj[v];
        TNo ant = null;

        // TRECHO PARA INSERIR V -> W:

        // Procura w na lista de v
        while (no != null && w >= no.w) {
            if (w == no.w) return;

            ant = no;
            no = no.prox;
        }

        // Cria o novo no para guardar w
        noV.w = w;
        noV.pesoAres = peso;
        noV.prox = no;

        // Atualiza a lista de v
        if (ant == null) {
            // Insere no inicio
            adj[v] = noV;
        } else {
            // Insere em outra posição
            ant.prox = noV;
        }
        TNo noW = new TNo();
        no = adj[w];
        ant = null;

        // TRECHO PARA INSERIR DE W -> V:
        while (no != null && v >= no.w) {
            if (v == no.w) return;

            ant = no;
            no = no.prox;
        }

        noW.w = v;
        noW.pesoAres = peso;
        noW.prox = no;

        if (ant == null) {
            adj[w] = noW;
        } else {
            ant.prox = noW;
        }

        
        // Aresta v-w conta apenas uma vez
        m++;
    }


    /*
    
    FUNÇÕES PARA INSERÇÃO E REMOÇÃO DE VÉRTICES:

    */

    public int insereV(String peso, String rotulo) {
        n++;

        // Recria o tamanho das listas
        TNo novoAdj[] = new TNo[n];
        String novoRotulo[] = new String[n];
        String novoPesoVert[] = new String[n];

        // Re-insere todos os vértices nesse novo array que sobrescreverá os arrays antigos
        for (int i = 0; i < n-1; i++) {
            novoAdj[i] = adj[i];
            novoRotulo[i] = this.rotulo[i];
            novoPesoVert[i] = this.pesoVert[i];
        }

        novoAdj[n-1] = null;
        novoRotulo[n-1] = rotulo;
        novoPesoVert[n-1] = peso;

        this.adj = novoAdj;
        this.rotulo = novoRotulo;
        this.pesoVert = novoPesoVert;

       

        return n-1;
    }

   
    // Caso seja a inserção do arquivo
    private void insereVArquivo(int v, String coordenadas, String rotulo) {
        if (v >= n) {
            insereV(coordenadas, rotulo);
            return;
        }

        this.rotulo[v] = rotulo;
        this.pesoVert[v] = coordenadas;

    }

    // Inicia o algoritmo de Prim
    public void iniciaPrim(int origem) {
        float valor = Float.POSITIVE_INFINITY;
        float custo = 0;

        // Inicializa o conjunto de vértices T
        int T[] = new int[n];
        T[0] = origem;

        // Inicializa o conjunto de arestas E'
        EOrigem = new int[n - 1];
        EDestino = new int[n - 1];
        qtdArestasPrim = 0;
        custoPrim = 0;

        // Inicia o algoritmo de Prim
        PRIM(T, 1, valor, custo);
    }

    private void PRIM(int T[], int tamanho, float valor, float custo) {
        int vint = -1;
        int vext = -1;

        // Para todo vértice k pertencente à árvore T (subárvore interna)
        for (int pos = 0; pos < tamanho; pos++) {
            int k = T[pos];

            // Para todo vértice i pertencente a V - T (subárvore externa),
            // percorre os vértices adjacentes a k por meio da lista de adjacência
            TNo no = adj[k];

            while (no != null) {
                int i = no.w;

                // Verifica se i pertence a T, isto é, se o nó adjacente do
                // vértice k já faz parte da sub-árvore interna. Se não pertence,
                // i está em V-T
                boolean pertence = false;

                for (int j = 0; j < tamanho; j++) {
                    if (T[j] == i) {
                        pertence = true;
                        break;
                    }
                }

                // Se i estiver fora de T e o peso da aresta (k, i) for menor que o menor peso
                // encontrado até o momento, atualiza o peso e registra os vértices da aresta:
                // vint é o vértice interno e vext o vértice externo
                if (!pertence && no.pesoAres < valor) {
                    valor = no.pesoAres;
                    vint = k;
                    vext = i;
                }

                // Avança para o próximo vértice adjacente a k para buscar aresta de menor peso
                no = no.prox;
            }
        }

        // Após análisar arestas que ligam a subárvore interna à externa, soma ao custo total
        // o peso da menor aresta encontrada
        custo = custo + valor;

        // Insere em T o vértice externo que passa a fazer parte da subárvore interna
        T[tamanho] = vext;
        tamanho++;

        // Armazena em E' a aresta escolhida, que liga o vértice
        // externo vext ao vértice interno vint
        EOrigem[qtdArestasPrim] = vint;
        EDestino[qtdArestasPrim] = vext;
        qtdArestasPrim++;

        // Reinicia o peso para infinito para que possa procurar a menor aresta na próxima chamada
        // recursiva, até porque a passamos como parâmetro
        valor = Float.POSITIVE_INFINITY;

        // Se T != V, chama PRIM novamente
        if (tamanho != n) {
            PRIM(T, tamanho, valor, custo);
        } else {
            custoPrim = custo;
        }
    }

    // Função apenas para EXIBIR o Prim
    public void exibePrim() {
        System.out.println("Arestas da árvore geradora mínima:");

        for (int i = 0; i < qtdArestasPrim; i++) {
            System.out.println(
                "(" + EOrigem[i] + ", " + EDestino[i] + ")"
            );
        }

        System.out.println("Custo total: " + custoPrim);
    }

    // Construir lista com base no grafo.txt
    public static TGrafo buildGraph(String arq) {
        try (BufferedReader br = new BufferedReader(new FileReader(arq))) {

            String linha;
            int contador = 0;
            int tipoGrafo;
            int verticesLidos = 0;

            int V = 0; // Número de vértices
            int arestasLidas = 0;
            int M = -1; // Número de arestas

            TGrafo grafo = null;
            

            while ((linha = br.readLine()) != null) {
                if (contador == 0) {
                    // Numero de vertices
                    V = Integer.parseInt(linha.trim());
                    grafo = new TGrafo(V);
                    contador++;
                } else if (verticesLidos < V) {
                    String[] valores = linha.split("\""); // Separa por "

                    // Parte antes da primeira aspas: numero do vértice
                    String[] numero = valores[0].trim().split(" ");
                    int v = Integer.parseInt(numero[0]);

                    // Primeira string entre aspas: rótulo
                    String rotulo = valores[1];

                    // Segunda string entre aspas: latitude e longitude
                    String coordenadas = valores[3];

                    grafo.insereVArquivo(v, coordenadas, rotulo);

                    verticesLidos++;

                 } else if (M == -1) {

                     // Logo após os vértices vem a linha com o número de arestas (m)
                     M = Integer.parseInt(linha.trim()); 

                } else if (arestasLidas < M) {

                     // Linha de aresta no formato "v w peso"
                    String[] valores = linha.trim().split("\\s+");
                    int v = Integer.parseInt(valores[0]);
                    int w = Integer.parseInt(valores[1]);
                    float peso = Float.parseFloat(valores[2]);

                    grafo.insereA(v, w, peso);


                    arestasLidas++;
                }
            }


            return grafo;

        } catch (IOException e) {
            System.out.print("Erro ao abrir o arquivo: " + e.getMessage());
        }

        return null;
    }

}