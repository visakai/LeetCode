package dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created by sikpeng on 4/6/2018.
 *
 * http://www.baeldung.com/java-dijkstra
 * https://github.com/eugenp/tutorials/tree/master/algorithms/src/main/java/com/baeldung/algorithms/ga/dijkstra
 * https://github.com/eugenp/tutorials/blob/master/algorithms/src/test/java/algorithms/DijkstraAlgorithmLongRunningUnitTest.java
 *
 */
public class Dijkstra {


  public static Graph findShortestPath(Graph graph, Node sourceNode){
    sourceNode.setDistance(0);
    Set<Node> settledNodes = new HashSet<>();
    Set<Node> unsettledNodes = new HashSet<>();

    unsettledNodes.add(sourceNode);
    while(unsettledNodes.size()!=0){
      Node currentNode = getLowestDistanceNode(unsettledNodes);
      unsettledNodes.remove(currentNode);
      // start evaluate this node, examine all its toNodes neighbors
      for(Map.Entry<Node, Integer> nodeEntry : currentNode.getToNodes().entrySet()){
        Node toNode = nodeEntry.getKey();
        int edgeLength = nodeEntry.getValue();
        // ignore settled nodes
        if(!settledNodes.contains(toNode)){
          updateMinDistanceAndPath(toNode, currentNode, edgeLength);
          // after updating toNodes, put them to unsettledSet, ready for evaluation in future loops
          unsettledNodes.add(toNode);
        }
      }
      // after explore all its toNodes, put currentNode in settledNodes set
      settledNodes.add(currentNode);
    }
    return graph;
  }

  // just loop through passed in set, find the node with min distance
  private static Node getLowestDistanceNode(Set<Node> nodes){
    int distance = Integer.MAX_VALUE;
    Node lowestDistanceNode=null;
    for(Node node : nodes){
      if(node.getDistance() < distance){
        lowestDistanceNode = node;
      }
    }
    return lowestDistanceNode;
  }

  private static void updateMinDistanceAndPath(Node nodeUpdating, Node nodeFrom, int edgeLength){
    int distanceFrom = nodeFrom.getDistance();
    int distancePrevious = nodeUpdating.getDistance();
    if(distanceFrom + edgeLength < distancePrevious){
      // if found a shorter distance, update
      nodeUpdating.setDistance(distanceFrom + edgeLength);
      // also update shortestPath for the nodeUpdating
      // (shortestPath to nodeUpdating) = (shortestPath to nodeFrom) + nodeFrom
      // first need a deep copy of shortestPath to nodeFrom
      LinkedList<Node> shortestPathNodeFrom = new LinkedList<>(nodeFrom.getShortestPath());
      shortestPathNodeFrom.add(nodeFrom);
      nodeUpdating.setShortestPath(shortestPathNodeFrom);
    }
  }

  public static void main(String[] args){

    Node nodeA = new Node("A");
    Node nodeB = new Node("B");
    Node nodeC = new Node("C");
    Node nodeD = new Node("D");
    Node nodeE = new Node("E");
    Node nodeF = new Node("F");

    nodeA.addAdjacentDestinationNode(nodeB, 10);
    nodeA.addAdjacentDestinationNode(nodeC, 15);

    nodeB.addAdjacentDestinationNode(nodeD, 12);
    nodeB.addAdjacentDestinationNode(nodeF, 15);

    nodeC.addAdjacentDestinationNode(nodeE, 10);

    nodeD.addAdjacentDestinationNode(nodeE, 2);
    nodeD.addAdjacentDestinationNode(nodeF, 1);

    nodeF.addAdjacentDestinationNode(nodeE, 5);

    Graph graph = new Graph();
    graph.addNode(nodeA);
    graph.addNode(nodeB);
    graph.addNode(nodeC);
    graph.addNode(nodeD);
    graph.addNode(nodeE);
    graph.addNode(nodeF);

    System.out.println(nodeA);
    System.out.println(nodeB);
    System.out.println(nodeC);
    System.out.println(nodeD);
    System.out.println(nodeE);
    System.out.println(nodeF);

    findShortestPath(graph,nodeA);

    System.out.println(nodeA);
    System.out.println(nodeB);
    System.out.println(nodeC);
    System.out.println(nodeD);
    System.out.println(nodeE);
    System.out.println(nodeF);
  }
}
