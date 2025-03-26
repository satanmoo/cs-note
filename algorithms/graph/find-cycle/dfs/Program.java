import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        {
            final Node a = new Node(0, 0, new ArrayList<>());
            final Node b = new Node(1, 1, new ArrayList<>());
            final Node c = new Node(2, 2, new ArrayList<>());
            final Node d = new Node(3, 3, new ArrayList<>());

            a.children.add(b);
            a.children.add(c);
            b.children.add(c);
            c.children.add(a);
            c.children.add(d);
            d.children.add(d);

            if (isCyclic(List.of(a, b, c, d))) {
                System.out.println("Contains cycle");
            } else {
                System.out.println("No Cycle");
            }
        }

        System.out.println("-".repeat(30));

        {
            final Node a = new Node(0, 0, new ArrayList<>());
            final Node b = new Node(1, 1, new ArrayList<>());
            final Node c = new Node(2, 2, new ArrayList<>());
            final Node d = new Node(3, 3, new ArrayList<>());

            a.children.add(b);
            b.children.add(c);
            c.children.add(d);

            if (isCyclic(List.of(a, b, c, d))) {
                System.out.println("Contains cycle");
            } else {
                System.out.println("No Cycle");
            }
        }
    }

    private static boolean isCyclic(final List<Node> adj) {
        int nodeCount = adj.size();
        boolean[] visited = new boolean[nodeCount];
        boolean[] recStack = new boolean[nodeCount];

        for (var node : adj) {
            if (!visited[node.index] && isCyclicRecursive(node, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isCyclicRecursive(final Node current, final boolean[] visited, final boolean[] recursiveStack) {
        recursiveStack[current.index] = true;
        visited[current.index] = true;

        for (var child : current.children) {
            if (!visited[child.index] && isCyclicRecursive(child, visited, recursiveStack)) {
                return true;
            } else if (recursiveStack[child.index]) {
                return true;
            }
        }
        recursiveStack[current.index] = false;

        return false;
    }

    private static class Node {
        final int index;
        final int data;
        final ArrayList<Node> children;

        Node(final int index, final int data, final ArrayList<Node> children) {
            this.index = index;
            this.data = data;
            this.children = children;
        }
    }
}
