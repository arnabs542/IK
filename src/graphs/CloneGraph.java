package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Definition for a Node.

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {}

  public Node(int _val,List<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
};

//https://leetcode.com/problems/clone-graph/
public class CloneGraph {
  public Node cloneGraphDFS(Node node) {
    return cloneGraph(node, new HashMap<Integer, Node>());
  }

  // DFS
  public Node cloneGraph(Node node, Map<Integer, Node> visited){
    if(visited.containsKey(node.val))
      return visited.get(node.val);

    Node cNode = new Node(node.val, new ArrayList());
    visited.put(node.val, cNode);

    for(Node neighbor : node.neighbors)
      cNode.neighbors.add(cloneGraph(neighbor, visited));

    return cNode;
  }

  // BFS
  public Node cloneGraph(Node node){
    Map<Integer, Node> map = new HashMap<>();
    LinkedList<Node> queue = new LinkedList<>();

    Node cNode = new Node(node.val, new ArrayList<>());
    map.put(node.val, cNode);

    queue.add(node);

    while(!queue.isEmpty()){
      node = queue.pop();
      for(Node neighbor : node.neighbors){
        if(!map.containsKey(neighbor.val)){
          map.put(neighbor.val, new Node(neighbor.val, new ArrayList<>()));
          queue.add(neighbor);
        }
        map.get(node.val).neighbors.add(map.get(neighbor.val));
      }
    }

    return cNode;
  }
}
