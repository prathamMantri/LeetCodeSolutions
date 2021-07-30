package companies.interview_questions_microsoft;

import java.util.ArrayList;
import java.util.List;

public class InterviewQuestion {


    List<String> res = new ArrayList<>();

    public static void main(String[] args) {

        InterviewQuestion iq = new InterviewQuestion();
        List<Node> nodes1 = new ArrayList<>();
        Node node1 = new Node('C', new ArrayList<>());
        Node node2 = new Node('B', new ArrayList<>());
        List<Node> nodes2 = new ArrayList<>();
        nodes2.add(node1);
        Node node3 = new Node('B', nodes2);
        nodes1.add(node3);
        nodes1.add(node2);
        Node root = new Node('A', nodes1);
        iq.getValidWord(root);
        System.out.println(iq.res.toString());

    }

    String getValidWord(Node root) {

        if (root == null || root.children == null || root.children.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.ch);
        for (Node child : root.children) {
            sb.append(child.ch);
            String currentString = getValidWord(child);
            sb.append(currentString);
            if (sb.length() >= 2) {
                res.add(sb.toString());
            }
            sb = new StringBuilder();
        }
        return sb.toString();
    }

    static class Node {

        Character ch;
        List<Node> children;

        public Node(Character ch, List<Node> children) {
            this.ch = ch;
            this.children = children;
        }

    }


}
