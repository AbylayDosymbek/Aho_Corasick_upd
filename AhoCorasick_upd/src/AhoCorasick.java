import java.util.*;

public class AhoCorasick {
    static class Node {
        Node[] next = new Node[256];
        Node fail;
        List<String> out = new ArrayList<>();
    }

    private final Node root = new Node();

    public void addPattern(String s) {
        Node cur = root;
        for (char ch : s.toCharArray()) {
            int idx = ch;
            if (cur.next[idx] == null) cur.next[idx] = new Node();
            cur = cur.next[idx];
        }
        cur.out.add(s);
    }

    public void build() {
        Queue<Node> q = new LinkedList<>();
        for (int c = 0; c < 256; c++) {
            if (root.next[c] != null) {
                root.next[c].fail = root;
                q.add(root.next[c]);
            } else {
                root.next[c] = root;
            }
        }
        while (!q.isEmpty()) {
            Node r = q.remove();
            for (int c = 0; c < 256; c++) {
                Node u = r.next[c];
                if (u != null && u != root) {
                    q.add(u);
                    Node v = r.fail;
                    u.fail = v.next[c];
                    u.out.addAll(u.fail.out);
                } else {
                    r.next[c] = r.fail.next[c];
                }
            }
        }
    }

    public Map<String, List<Integer>> search(String text) {
        Map<String, List<Integer>> res = new HashMap<>();
        Node state = root;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            state = state.next[ch];
            for (String pat : state.out) {
                res.computeIfAbsent(pat, k -> new ArrayList<>()).add(i - pat.length() + 1);
            }
        }
        return res;
    }
}
