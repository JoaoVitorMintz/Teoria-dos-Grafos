# Resumo da Matéria — Teoria dos Grafos

A **Teoria dos Grafos** é uma área da matemática que estuda as relações entre entidades (objetos) que possuem características ou relações relevantes entre si.

Essas entidades são representadas por **vértices** (ou nós), enquanto suas relações são representadas por **arestas**.

Um grafo pode ser representado pelo par:

**G(V, E)**

Onde:

- **V** representa o conjunto de vértices;
- **E** representa o conjunto de arestas que conectam os vértices.

## Tipos de Grafos

| Tópico | Descrição |
|---|---|
| **Grafo Direcionado (Dígrafo)** | É um grafo representado pelo par **G(V, E)**. Uma aresta **(v, w) ∈ E** pode ser representada por **v → w**, sendo **v** o **vértice de origem** do arco e **w** o **vértice de destino**. A ordem dos vértices é importante: **v → w** não é necessariamente igual a **w → v**. |
| **Grafo Direcionado Acíclico (GDA)** | É um grafo direcionado que não contém ciclos. Isso significa que não é possível seguir as direções das arestas e retornar ao vértice de origem. Todas as árvores são GDA, entretanto, nem todo GDA é uma árvore. |
| **Grafo Não Direcionado** | É um grafo representado pelo par **G(V, E)** onde os vértices estão conectados por arestas que não possuem direção. Diferentemente de um dígrafo, a ordem dos vértices não importa, pois uma conexão entre **v** e **w** é equivalente à conexão entre **w** e **v**. |
| **Grafos Rotulados (Ponderados/Valorados)** | Em aplicações práticas, podem ser utilizados valores ou rótulos associados aos vértices e/ou às arestas. Esses valores podem representar diferentes informações, dependendo do problema analisado. |

## Representação de Grafos

Para a representação de grafos, é comum utilizar **Matriz de Adjacência** ou **Lista de Adjacência**. Entretanto, a utilização dessas representações depende de determinadas características do grafo:

- Se o grafo contém poucas arestas, isso indica que a maioria dos elementos da matriz de adjacência possui valor **0** (ou **∞**, dependendo da representação utilizada em grafos ponderados).
- Uma matriz onde a maioria dos elementos possui valor **0** (ou **∞**) é chamada de **matriz esparsa**.
- Um grafo `G = (V, E)` é considerado **esparso** quando a quantidade de arestas cresce na ordem da quantidade de vértices, ou seja:

$$
|E| = O(|V|)
$$

Onde:

- `|V|` representa a quantidade de vértices;
- `|E|` representa a quantidade de arestas;
- `O(|V|)` representa uma **ordem de crescimento linear**, indicando que a quantidade de arestas cresce proporcionalmente à quantidade de vértices.

- Um grafo `G = (V, E)` é considerado **denso** quando a quantidade de arestas cresce aproximadamente na ordem quadrática da quantidade de vértices:

$$
|E| = O(|V|^2)
$$

Isso significa que, conforme a quantidade de vértices aumenta, a quantidade de arestas pode crescer proporcionalmente ao quadrado da quantidade de vértices.

### Resumo

- **Grafo esparso** → poucas arestas → crescimento próximo de `O(|V|)`.
- **Grafo denso** → muitas arestas → crescimento próximo de `O(|V|²)`.

| Tópico | Descrição | Grafo Direcionado | Grafo Não Direcionado |
|---|---|---|---|
| **Matriz de Adjacência** | É uma representação de um grafo utilizando uma matriz. Cada linha e coluna representa um vértice. O valor presente na posição **M[i][j]** indica se existe uma aresta ligando o vértice **i** ao vértice **j**. Em grafos simples, geralmente utiliza-se **1** para indicar que existe uma conexão e **0** para indicar que não existe. | É mais comum haver mais espaços vazios na matriz, pois uma conexão de i → j não implica necessariamente a existência de j → i. | É menos comum haver espaços ocupados em apenas uma direção, pois, se existe uma conexão entre i e j, a matriz também deve indicar a conexão entre j e i. Por isso, a matriz de adjacência de um grafo não direcionado é simétrica (espelhada) em relação à diagonal. |
| **Lista de Adjacência** | É uma representação de um grafo utilizando uma **lista encadeada para cada vértice**, onde cada lista **armazena os vértices adjacentes a ele**. É especialmente **eficiente para representar grafos esparsos**. | Costuma formar listas menores, pois cada vértice armazena apenas os vértices para os quais possui uma conexão direcionada. | Costuma formar listas maiores, pois uma conexão entre dois vértices deve ser representada na lista de adjacência de ambos os vértices. |
| **Matriz de Incidência** | Outra abordagem para representação de grafos, onde as **linhas da matriz representam os nós (vértices)** e as **colunas representam as arestas/arcos**. Cada elemento da matriz indica a relação entre um vértice e uma determinada aresta. | Seja um grafo `G = (V, E)`, onde uma aresta `k` sai do nó `i` e incide no nó `j`. A matriz de incidência é dada por: **-1** se a aresta `k` sai do nó `i`, **1** se a aresta `k` chega (incide) no nó `j` e **0** caso contrário. | Seja um grafo `G = (V, E)`, onde uma aresta `k` conecta os nós `i` e `j`. A matriz de incidência é dada por: **1** se a aresta `k` incide no nó `i` ou no nó `j` e **0** caso contrário. |

**Importante**: Para Matriz de Incidência em **grafo direcionado ponderado**, troca-se **0** por **∞** e **1/-1** por **p/-p**, sendo **p** o peso dado. Proporcional para a Matriz de incidência em **grafo não-direcionado ponderado**.

## Análise de Grafos

| Tópico | Descrição |
|---|---|
| **Percurso/Cadeia** | É uma sequência de ligações sucessivamente adjacentes, onde cada ligação possui uma extremidade adjacente à ligação anterior e outra extremidade adjacente à ligação subsequente. |