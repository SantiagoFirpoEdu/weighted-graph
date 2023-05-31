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

        graph.addEdge(0, 4, 2);
        graph.addEdge(1, 0, 3);
        graph.addEdge(3, 2, 4);
        graph.addEdge(4, 3, 5);

        var breadthFirst = new BreadthFirstSearch(graph, 0);
        breadthFirst.debugPrintResult();

        var depthFirst = new DepthFirstSearch(graph, 0);
        depthFirst.debugPrintResult();


        GraphFromFile.writeGraphToFile(graph, "./testGraph");
        WeightedGraph readGraph = GraphFromFile.readGraphFile("./testGraph");

        System.out.printf("Read saved graph successfully: %s%n", readGraph.debugPrint());
    }
}