package hello;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Set;

public class LibTest {
    @Test public void testSomeLibraryMethod(){
        Greeter greet = new Greeter();
        assertTrue("Greeter should say `Hello World!`", greet.sayHello() == "Hello World!");
    }

    @Test public void testGraphThing(){
        GraphCreator creator = new GraphCreator();
        creator.createGraph();
        creator.printGraph();
        assertTrue("The graph is created", creator.graph.nodes().size() > 0);
    }

    @Test public void checkForTrees(){
        GraphCreator creator = new GraphCreator();
        creator.createGraph();
        Set<String> roots = creator.getRoots();
        for (String root: roots)
        {
            System.out.println("HIERIARCHY OF: " + root);
            creator.printRootTrees(root);
        }
    }
}
