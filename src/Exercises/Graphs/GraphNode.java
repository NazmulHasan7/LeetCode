package Exercises.Graphs;
import java.util.*;

public class GraphNode<Type> {
    Type value;
    GraphNode<Type>[] neighbors;
    public GraphNode (Type value) { this.value = value; }
    public GraphNode(Type value,  GraphNode<Type>[] neighbors) {
        this.value = value;
        this.neighbors = neighbors;
    }
    @Override
    public String toString() {
        return "Value : " + value + " Neighbors: " + Arrays.toString(neighbors);
    }

    public static void depthFirstPrint(GraphNode<Character>[] graph, GraphNode<Character> start) {
        Stack<GraphNode<Character>> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek().value);
            GraphNode<Character>[] neighbors = stack.pop().neighbors;
            for (GraphNode<Character> n : neighbors) stack.push(n);
        }
    }
    public static void depthFirstPrintRec(GraphNode<Character>[] graph, GraphNode<Character> start) {
        System.out.println(start.value);
        for (GraphNode<Character> neighbor : start.neighbors)
            depthFirstPrint(graph, neighbor);
    }
    public static void breadthFirstPrint(GraphNode<Character>[] graph, GraphNode<Character> start) {
        Queue<GraphNode<Character>> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            GraphNode<Character> current = queue.poll();
            System.out.println(current.value);
            // for (GraphNode<Character> neighbor : current.neighbors)
            // queue.add(neighbor);
            queue.addAll(Arrays.asList(current.neighbors));
        }
    }
    public static boolean hasPathDFS(GraphNode<Character>[] graph, GraphNode<Character> source, GraphNode<Character> destination) {
        if (source == destination)
            return true;
        for (GraphNode<Character> neighbor : source.neighbors)
            if (hasPathDFS(graph, neighbor, destination))
                return true;
        return false;
    }
    public static boolean hasPathBFS(GraphNode<Character>[] graph, GraphNode<Character> source, GraphNode<Character> destination) {
        Queue<GraphNode<Character>> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            GraphNode<Character> current = queue.poll();
            if (current == destination) return true;
            Collections.addAll(queue, current.neighbors);
        }
        return false;
    }
    public static void main(String[] args) {
        GraphNode<Character> gn1 = new GraphNode<>('a');
        GraphNode<Character> gn2 = new GraphNode<>('b');
        GraphNode<Character> gn3 = new GraphNode<>('c');
        GraphNode<Character> gn4 = new GraphNode<>('d');
        GraphNode<Character> gn5 = new GraphNode<>('e');
        GraphNode<Character> gn6 = new GraphNode<>('f');

        gn1.neighbors = new GraphNode[] {gn2, gn3};
        gn2.neighbors = new GraphNode[] {gn4};
        gn3.neighbors = new GraphNode[] {gn5};
        gn4.neighbors = new GraphNode[] {gn6};
        gn5.neighbors = new GraphNode[] {};
        gn6.neighbors = new GraphNode[] {};

        GraphNode<Character>[] graph = new GraphNode[6];
        graph[0] = gn1;
        graph[1] = gn2;
        graph[2] = gn3;
        graph[3] = gn4;
        graph[4] = gn5;
        graph[5] = gn6;

        System.out.println("DFS -> Iterative");
        depthFirstPrint(graph, gn1);
        System.out.println("DFS -> Recursive");
        depthFirstPrintRec(graph, gn1);
        System.out.println("BFS ->");
        breadthFirstPrint(graph, gn1);

        System.out.println(hasPathDFS(graph, gn1, gn5));
        System.out.println(hasPathDFS(graph, gn6, gn1));
        System.out.println(hasPathDFS(graph, gn1, gn5));
        System.out.println(hasPathDFS(graph, gn6, gn1));
    }
}
