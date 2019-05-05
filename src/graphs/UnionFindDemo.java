package graphs;

public class UnionFindDemo {

  int[]  nodes;

  UnionFindDemo(int n){
    nodes = new int[n];
    for(int i = 0; i < nodes.length; ++i)
      nodes[i] = i;
  }

  int find(int n){

    while(n != nodes[n]){
      //n = nodes[nodes[n]];
      n = nodes[n] = nodes[nodes[n]];
    }

    return n;
  }

  void union(int i, int j){

    int p_i = find(i);
    int p_j = find(j);
    if(p_i != p_j)
      nodes[p_i] = p_j;
  }


}
