package hello;

import java.util.HashSet;
import java.util.Set;

import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.common.graph.Traverser;
import com.google.common.graph.Graphs;

public class GraphCreator {

    public Graph<String> graph;
    public Set<String> roots;
    GraphCreator(){

    }

    public void createGraph()
    {
        MutableGraph<String> mutable_graph = GraphBuilder.directed().allowsSelfLoops(true).build();
        mutable_graph.putEdge("A", "B");
        mutable_graph.putEdge("B", "C");
        mutable_graph.putEdge("B", "D");
        mutable_graph.putEdge("E", "B");
        mutable_graph.putEdge("E", "F");
        mutable_graph.putEdge("F", "G");
        mutable_graph.putEdge("H", "I");
        mutable_graph.putEdge("J", "K");
        graph = (Graph)mutable_graph;
    }

    public int graphSize(){
        return graph.nodes().size();
    }

    public void printGraph(){
        for (String node: graph.nodes())
        {
            System.out.println(node);
        }
    }

    public Set<String> getRoots(){
        roots = new HashSet<>();
        for (String node: graph.nodes())
        {
            if (graph.inDegree(node) == 0 )
            {
                roots.add(node);
            }
        }
        return roots;
    }

    public void printRootTrees(String root){
        for (String node: Traverser.forGraph(graph).depthFirstPreOrder(root))
        {
            if (graph.outDegree(node) == 0)
            {
                System.out.println(node + " END");
            }
            else{
                System.out.println(node);
            }
            
        }
    }

    public String recursiveThing(String node)
    {
        return "";
    }

}
