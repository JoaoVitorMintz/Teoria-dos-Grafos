package coloracao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TNo {
    public int w; // Vértice que é adjacente ao elemento da lista
    public TNo prox;
    public float pesoAres;
}

public class TGrafoColoracao {
    private int n;
    private int m;
    private TNo adj[];
    private String rotulo[];
    private String pesoVert[];
    
    // Construtor da classe
    public TGrafoColoracao(int n) {
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

    // Algoritmo de coloração por classe
    public void coloracao_classe() {
        // Criado uma classe de lista ligada para inserir conjuntos de coloração
        // Como o algoritmo é guloso, não precisa de remoção de vértice desta classe
        TColoracao C = new TColoracao(this.n);


        // Criação de W com todos os vértices de V:
        int[] W = new int[this.n];
        for (int i = 0; i < n; i++) {
            W[i] = i;
        }

        // Re-rotulação para garantir maiores graus primeiro
        ordenaPorGrau(W);

        // Indicador da classe atual de cor k, sendo que como usamos uma lista, começar em 0 ao invés de 1,
        // o valor do vértice (1...n) estará no rótulo do vértice
        int k = 0;

        // Enquanto houver vértices em W
        while (temVerticeNaoColorido(W)) {
            // Percorre os vértices ainda não coloridos
            for (int i = 0; i < this.n; i++) {
                int j = W[i]; // Validar se o vértice ja foi lido

                if (j == -1) {
                    continue; // Vértice lido, pula
                }

                // Se algum vértice da classe atual k não fizer parte dos vizinhos de vi
                if (!ehAdjacente(i, C, k)) {
                    C.insereVerticeCor(k, j);
                    W[i] = -1;
                }
            }
            k++; // Avança para a próxima cor
        }

        C.numCores = k;

        // Exibir o resultado da coloração
        for (int cor = 0; cor < C.numCores; cor++) {
            C.exibeCores(cor, this.rotulo);
        }
    }

    // Reordena por grau (Re-rotulação) por método semelhante à selection sort
    private void ordenaPorGrau(int[] W) {

        for (int i = 0; i < W.length - 1; i++) {

            for (int j = i + 1; j < W.length; j++) {

                // Compara os graus dos vertices
                if (grau(W[j]) > grau(W[i])) {

                    // Troca os vertices de posicao
                    int aux = W[i];
                    W[i] = W[j];
                    W[j] = aux;
                }
            }
        }
    }

    // Calcula o grau de cada vértice
    private int grau(int v) {
        int grau = 0;
        TNo no = adj[v];

        while (no != null) {
            grau++;
            no = no.prox;
        }

        return grau;
    }

    private boolean temVerticeNaoColorido(int[] W) {
        for (int i = 0; i < W.length; i++) {
            if (W[i] != -1) { // W recebe -1 para cada valor lido
                return true;
            }
        }
        return false;
    }

    private boolean ehAdjacente(int v, TColoracao C, int k) {
        TNo no = adj[v];
        TNoColoracao noCor = C.getCores(k);

        while (no != null) {
            TNoColoracao atual = noCor;
            while (atual != null) {
                if (no.w == atual.vertice) {
                    return true;
                }
                atual = atual.prox;
            }
            no = no.prox;
        }
        return false;
    }

    // Construir lista com base no grafo.txt
    public static TGrafoColoracao buildGraph(String arq) {
        try (BufferedReader br = new BufferedReader(new FileReader(arq))) {

            String linha;
            int contador = 0;
            int tipoGrafo;
            int verticesLidos = 0;

            int V = 0; // Número de vértices
            int arestasLidas = 0;
            int M = -1; // Número de arestas

            TGrafoColoracao grafo = null;
            

            while ((linha = br.readLine()) != null) {
                if (contador == 0) {
                    // Numero de vertices
                    V = Integer.parseInt(linha.trim());
                    grafo = new TGrafoColoracao(V);
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