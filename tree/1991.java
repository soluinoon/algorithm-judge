import java.io.*;
import java.util.*;

class Main {
    /**
     * 1991
     * 트리순회
     * 22-12-23
     */
    static int n;
    static HashMap<String, Node> nodes;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nodes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String nodeName = st.nextToken();
            Node node = nodes.getOrDefault(nodeName, new Node(nodeName));
//            System.out.println("nodename = " + node.name);

            String left = st.nextToken();
            String right = st.nextToken();

            Node leftNode = nodes.getOrDefault(left, new Node(left));
//            System.out.println("leftname = " + leftNode.name);
            nodes.put(left, leftNode);

            Node rightNode = nodes.getOrDefault(right, new Node(right));
//            System.out.println("rightname = " + rightNode.name);
            nodes.put(right, rightNode);

            node.left = leftNode;
            node.right = rightNode;
            nodes.put(nodeName, node);
        }

//        for (String key : nodes.keySet()) {
//            Node node = nodes.get(key);
//            System.out.println("node : " + node.name);
//            System.out.println("left : " + node.left.name);
//            System.out.println("right : " + node.right.name);
//            System.out.println();
//        }
//        System.out.println(nodes.get("A").name);
        preOrder(nodes.get("A"));
        System.out.println();
        inOrder(nodes.get("A"));
        System.out.println();
        postOrder(nodes.get("A"));

    }

    public static void preOrder(Node node) {
        if (node.name.equals(".")) {
            return;
        }
        System.out.print(node.name);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node.name.equals(".")) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.name);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node.name.equals(".")) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.name);

    }
    static class Node {
        String name;
        Node left;
        Node right;

        public Node(String name) {
            this.name = name;
        }

        public void addLeft(Node node) {
            this.left = node;
        }

        public void addRight(Node node) {
            this.right = node;
        }
    }
}