# Resumo da Matéria — 2° Bimestre

## Algoritmo de Kruskal

Algoritmo de Árvore parcial de Custo Mínimo, sendo um algoritmo guloso, ordenando as arestas da menor para a maior.

Seleciona arestas que se inicie pela aresta de menor valor e prossegue em ordem não decrescente, de modo a não fechar ciclos com as arestas já selecionadas, sendo encerrado quando tiver escolhido n-1 arestas.

Pseudocódigo:

```text
Início <dados: Grafo G = (V, E)>
    para todo i = 1, ..., n fazer:
        v(i) ← i; <vetor que auxilia na investigação de ciclos >
    k ← 0; <contador de iterações>
    t ← 0; <contabiliza o total de arestas da árvore>
    T ← ∅; <T conjunto de arestas>
    chama Procedimento de ordenação
    chama Procedimento KRUSKAL .
Fim.
```

Complexidade: O(m logm), sendo bastante interfirido pela eficiência do `procedimento de ordenação`

Pseudocódigo `Procedimento Kruskal`:

```text
procedimento de ordenação de E por valor não decrescente, gerando E = { ek }, ek = (i, j);
procedimento KRUSKAL;
    enquanto t < n -1 faça < t: contador de Arestas da árvore>
    k ← k + 1; < k: contador de iterações >
    i ← ek[k][0]; j ek[k][1]; < ek = (i, j) >
        se v(i) ≠ v(j) então < se a aresta não forma ciclo com as já selecionadas>
            val = max(v(i), v(j)); < atualiza vetor v para indicar que a aresta (i, j) será inserida >
            para cont de 1 até n faça < e, com isso, não permitir ciclos >
                se (v(cont) = val) v(cont) ← min(v(i), v(j));
            fim-para
            T ← T ∪ { (i, j) }; < insere a aresta (i, j) na árvore >
            t ← t + 1;
        fim-se
    fim-enquanto
fim-procedimento;
```

## Algoritmo de PRIM

Algoritmo de Árvore parcial de Custo Mínimo, sendo um algoritmo guloso, ordenando as arestas da menor para a maior.

Inicialmente, obtém-se ua única aresta (que é uma árvore) e, a cada nova iteração, uma nova aresta é acrescida com umm novo vértice à subárvore parcial, até que se obtenha uma árvore parcial.

Portanto, como monta subárvores parciais até chegar na árvore parcial finalizada, a estrutura obtida não terá ciclos

Pseudocódigo:

```text
Algoritmo de PRIM
    Início <dados: Grafo G = (V, E) >
    valor ← ∞; / / auxiliar na troca da melhor aresta
    custo ← 0; / / armazena o custo total da árvore
    T ← { 1 }; / / Começa a montar a árvore a partir do vértice 1
    E’ ← ∅; / / A árvore não possui nenhuma aresta
    PRIM( T ); / / Inicia o algoritmo de Prim
Fim.
```

Complexidade: O(n²), mas pode ser melhorada para O(m+n logn) com estuturas de dados apropriadas.

Pseudocódigo `Procedimento PRIM(T)`:

```text
Procedimento PRIM (T);
    para todo k ∈ T faça / / para todo vértice k pertencente a árvore T
        para todo i ∈ V - T faça / / procura a aresta menor aresta em V-T
            / / Se alguma aresta é menor do que a encontrada até o momento
            se vki < valor então
                / / atualiza o valor, o vértice interno a árvore (vint) e externo (vext)
                valor ← vki ; vint ← k; vext ← i;
            fim-se
        fim-para
    fim-para / / atualiza o custo, insere o novo vértice vext em T
    custo ← custo + valor; T ← T ∪ { vext };
    E’ ← E’ ∪ { (vext, vint ) }; valor ← ∞; / / insere a nova aresta
    se T != V então PRIM (T); / / se a árvore não está completa chama PRIM novamente
fim-procedimento
```

Para grafos esparsos, o ideal é se utilizar o Kruskal enquanto para gráfos não-esparsos, o idela é se utilizar do Prim. Ambos são gulosos e exatos (não heurísticos).

A ideia de se utilizar o que parece melhor é a origem do nome dado a esses algoritmos, cuja estratégia é eficente na busca de ótimos locais.

Se o ótimmo local é também o global, então a solução é ótima; mas isso não pode ser garantido para qualquer problema.