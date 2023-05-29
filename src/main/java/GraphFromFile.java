import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GraphFromFile
{

    public static WeightedGraph readGraphFile(String filePath)
    {
        //TODO: implement this
        return null;
    }

    public static boolean writeGraphToFile(WeightedGraph graph, String filePath)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(new File(filePath + ".txt"));
            fileWriter.write(graph.getNodeAmount() + "\n");
            for (int node : graph.getNodes().stream().toList())
            {
                fileWriter.write(node + " - ");
                for (WeightedGraph.Edge edge : graph.getEdges(node))
                {
                    fileWriter.write(edge.from + " " + edge.to + " " + edge.weight + "|");
                }
                fileWriter.write("\n");

            }
            fileWriter.close();
        }
        catch (IOException e)
        {
            return false;
        }

        return true;
    }

    private GraphFromFile()
    {
    }
}
