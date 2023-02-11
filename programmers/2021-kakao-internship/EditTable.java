import java.util.*;
import java.io.*;

class Main {
    // https://school.programmers.co.kr/learn/courses/30/lessons/81303
    // 2021 카카오 채용연계형 인턴십 - 표 편집

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(5, 1);
        Stack<Node> removed = new Stack<>();

        linkedList.print();
        linkedList.delete(removed);
        linkedList.print();
        linkedList.moveNext(2);
        linkedList.delete(removed);
        linkedList.print();
        linkedList.restore(removed.pop());
        linkedList.print();
        linkedList.restore(removed.pop());
        linkedList.print();
    }

    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();

        LinkedList linkedList = new LinkedList(n, k);
        Stack<Node> removed = new Stack<>();

        for (int i = 0; i < cmd.length; i++) {
            StringTokenizer st = new StringTokenizer(cmd[i]);
            String command = st.nextToken();

            if (command.equals("U")) {
                linkedList.movePrev(Integer.parseInt(st.nextToken()));
            } else if (command.equals("D")) {
                linkedList.moveNext(Integer.parseInt(st.nextToken()));
            } else if (command.equals("C")) {
                linkedList.delete(removed);
            } else if (command.equals("Z")) {
                linkedList.restore(removed.pop());
            }
        }
        linkedList.print();

        for (int i = 0; i < n; i++) {
            if (linkedList.answerTable.get(i).isDelete) {
                answer.append("X");
            } else {
                answer.append("O");
            }
        }

        return answer.toString();
    }
}

    class LinkedList {

        List<Node> answerTable = new ArrayList<>();
        Node head;
        Node temp;
        Node now;
        int size;

        public LinkedList(int size, int cursor) {
            head = new Node(0, null, null);
            answerTable.add(head);
            temp = head;
            this.size = size;
            for (int i = 1; i < size; i++) {
                addNode(i);
                if (i == cursor) {
                    now = temp;
                }
            }
        }

        public void addNode(int data) {
            Node newNode = new Node(data, temp, null);
            answerTable.add(newNode);
            temp.next = newNode;
            temp = temp.next;
        }

        public void moveNext(int number) {
            for (int i = 0; i < number; i++) {
                now = now.next;
            }
        }

        public void movePrev(int number) {
            for (int i = 0; i < number; i++) {
                now = now.prev;
            }
        }

        public void delete(Stack<Node> removed) {
            now.isDelete = true;
            removed.add(now);
            // n o n 사실 필요없다. 조건에서 안준다고 명시했기 떄문.
            if (now.next == null && now.prev == null) {
                return;
            }
            // o o n
            else if (now.next == null) {
                now.prev.next = null;
                now = now.prev;
            }
            // n o o
            else if (now.prev == null) {
                now.next.prev = null;
                now = now.next;
            }
            // o o o
            else {
                Node temp = now.next;
                now.prev.next = now.next;
                now.next.prev = now.prev;
                now = temp;
            }
        }

        public void restore(Node node) {
            node.isDelete = false;
            if (node.prev != null) {
                node.prev.next = node;
            }
            if (node.next != null) {
                node.next.prev = node;
            }
        }

        public void print() {
            temp = head;
            int count = 0;
            while (temp != null) {
                System.out.println("print" + count + " , " + temp.data);
                temp = temp.next;
                count++;
            }
            System.out.println("now = " + now.data);
        }
    }

class Node {
    Node prev;
    Node next;
    int data;
    boolean isDelete;

    public Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
