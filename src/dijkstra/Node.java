package dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by sikpeng on 4/6/2018.
 */
public class Node {

  private String name;
  // accumulated min distance from source node
  private int distance;

  // collection of airports that can fly directly FROM this airport, with edge length
  private Map<Node,Integer> toNodes;
  // store the best path to reach current node, if A->B->C, for C the shortestPath is {A,B}
  // we can alternatively just store one last viaNode, and in the end just trace back to source node
  private LinkedList<Node> shortestPath;

  public Node(String name) {
    this.name = name;
    this.distance = Integer.MAX_VALUE;
    this.toNodes = new HashMap<>();
    this.shortestPath = new LinkedList<>();
  }

  // a helper method to populate adjacent nodes
  public void addAdjacentDestinationNode(Node node, int length){
    this.toNodes.put(node, length);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public Map<Node, Integer> getToNodes() {
    return toNodes;
  }

  public void setToNodes(Map<Node, Integer> toNodes) {
    this.toNodes = toNodes;
  }

  public LinkedList<Node> getShortestPath() {
    return shortestPath;
  }

  public void setShortestPath(LinkedList<Node> shortestPath) {
    this.shortestPath = shortestPath;
  }

  public String toString(){
    String toNodesString = "";
    for(Map.Entry<Node, Integer> neighbor : this.toNodes.entrySet()){
      toNodesString += neighbor.getKey().name + ":" + neighbor.getValue() + " ";
    }
    String shortestPathString = "";
    for(Node node : this.getShortestPath()){
      shortestPathString += node.getName();
    }
    return String.format("[name=%s, distance=%s, toNodes=%s, shortestPath=%s]", this.name, this.distance, toNodesString, shortestPathString);


  }
}
