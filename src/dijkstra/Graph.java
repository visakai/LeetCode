package dijkstra;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sikpeng on 4/6/2018.
 */
public class Graph {

  private Set<Node> nodes;

  public Graph(){
    this.nodes = new HashSet<>();
  }

  public void addNode(Node node){
    this.nodes.add(node);
  }

  public Set<Node> getNodes() {
    return nodes;
  }

  public void setNodes(Set<Node> nodes) {
    this.nodes = nodes;
  }
}
