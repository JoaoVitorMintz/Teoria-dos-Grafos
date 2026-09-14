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
| **Caminho** | É uma cadeia de um grafo orientado o qual a orientação dos arcos é sempre a mesma a partir do vértice inicial e consegue alcançar até o vértice final. No caso não orientado, percurso = caminho. |
| **Percurso/Cadeia** | É uma sequência de ligações sucessivamente adjacentes, onde cada ligação possui uma extremidade adjacente à ligação anterior e outra extremidade adjacente à ligação subsequente. |

## Conexidade - Grafos

| Tópico | Descrição |
|---|---|
| **Conexidade** | possibilidade de passagem de um vértice a outra em um grafo através das ligações existentes, traduzindo o **estado de ligação** e adquirindo aspectos diferentes conforme o grafo sendo **orientado ou não**, voltado para atingibilidade especialmente em **grafos orientados**. Nos grafos não orientados as noções de atingibilidade (relacionada a pares de vértices) e de conexidade (relacionado a grafos como um todo) são correspondentes. |

Um **grafo não-direcionado G = (V, E)** é **conexo** se existe um caminho G entre todo o part de vértices de V.

Um **grafo direcionado G = (V, E)**, são definidos quatro tipos de conexidade: **desconexo**, simplesmente conexo (**s-conexo**), semi-fortemente conexo (**sf-conexo**) e fortemente conexo (**f-conexo**).

Um **grafo direcionado G = (V, A)** é **desconexo** se nele existir ao menos um part de vértices não unidos por uma cadeia.

Um **grafo direcionado G = (V, A)** é **simplesmente conexo (s-conexo)** no qual todo par de vértices é unido por ao menos uma cadeia.

Um **grafo direcionado G = (V, A)** é **semi-fortemente conexo (sf-conexo)** quando, em todo o part de vértices ao menos um deles é atingível a partir do outro (logo, entre eles, existe em ao menos um dos dois sentidos possíveis)

Um **grafo direcionado G = (V, A)** é **fortemente conexo (f-conexo)** é sempre também sf-conexo e s-conexo, e que tdo grafo sf-conexo é s conexo. Para evitar dúvidas, utiliza-se classificação em **categorias de conexidade**.

Diz-se então que um grafo orientado pertence a categoria:
 - C3, se é f-conexo
 - C2, se é sf-conexo e não é f-conexo
 - C1, se é s-conexo e não é sf-conexo
 - C0, se é desconexo

Em um grafo f-conexo G - (V, A):
 - Todo vértice é atingível de si mesmo: relação reflexiva
 - Se x é atingível de y, então y é atingível de x: relação simétrica
 - Se z é atingível de y e y é atingível de x, então z é atingível de x: relação transitiva.

A atingibilidade é uma relação reflexiva, simétrica e transitiva dizemos então que é uma **relação de equivalência**

### Grafo direcionado - Componentes f-conexas

Sobre o conjunto de vértices de um grafo orientado qualquer G = (V, A) definimos uma **partição S**:

Sejam os subgrafos correspondentes aos $$\mid S_i$$ como sendo partição contendo componentes f-conexas.

$$
S = \left\{ S_i \mid S_i \subset V,\; S_i \cap S_j = \varnothing,\; i,j=1,\ldots,r,\; i\neq j \right\}
$$

Sendo este, do conjuento de vértices **V**.

Defini-se **grafo reduzido** um Grafo G = (V, A), obtido de um grafo G (orientado ou não) através de uma sequência de contrações de vértices, feitas segundo um critério pré-definido.

Podemos reduzir um grafo orientado G por meio de suas componentes f-conexas.

Um grafo orientado G = (V,A) originará um grafo reduzido Gr = (S, W), onde S é a partição de Gr, em componentes f-conexas e W sendo:

$$
W = \left\{ (S_i, S_j) \mid \exists (x,y),\; x \in S_i,\; y \in S_j \right\}
$$

Sendo W um conjunto dos arcos que unem essas componentes.

## Grau

### Grau de Entrada

Em grafos, utiliza-se grau de entrada **d-(x)** para representar o número de vértices que apontam para um vértice **x**.

### Grau de Saída

Em grafos, utiliza-se grau de saída **d+(x)** para representar o número de vértices que o vértice **x** aponta.

## Ordenação de Grafos

Considere uma situação em que é necessário rearranjar com base nas dependências do grafo para ordenar o mesmo.

### Topológica

Nesta ordenação, pega-se os vértices que não possuem dependência (d-() = 0\grau de entrada = 0) e inicialmente insere em uma fila e altera o valor do grau de entrada antes 0 para -1 e remove da fila. O vértice antes dependente deste vértice tem seu grau de entrada decrementado, sendo estes agora, inseridos dentro da fila e realizando o ciclo novamente.