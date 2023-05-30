// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    public static void main(String[] args)
    {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addNode(7);
        graph.addNode(8);
        graph.addNode(9);
        graph.addNode(10);
        graph.addNode(11);
        graph.addNode(12);
        graph.addNode(13);

        graph.addEdge(0, 4, 2);
        graph.addEdge(1, 0, 3);
        graph.addEdge(3, 2, 4);
        graph.addEdge(4, 3, 5);
        graph.addEdge(1, 11, 6);
        graph.addEdge(12, 3, 1);
        graph.addEdge(5, 9, 9);
        graph.addEdge(9, 1, 2);
        graph.addEdge(12, 8, 7);

        var breadthFirst = new BreadthFirstSearch(graph, 0);
        breadthFirst.debugPrintResult();

        var depthFirst = new DepthFirstSearch(graph, 0);
        depthFirst.debugPrintResult();


        GraphFromFile.writeGraphToFile(graph, "./testGraph");
    }
}