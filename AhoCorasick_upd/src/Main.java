import java.util.Map;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        AhoCorasick ac = new AhoCorasick();
        String[] patterns = {"he","she","his","hers","aba","abab"};
        for (String p : patterns) ac.addPattern(p);
        ac.build();

        String shortText = "ushers";
        String mediumText = "abacababcababababacababa";
        String longText = generateLongText();

        runTest("Short text", shortText, ac);
        runTest("Medium text", mediumText, ac);
        runTest("Long text", longText, ac);
    }

    private static void runTest(String title, String text, AhoCorasick ac) {
        System.out.println("=== " + title + " ===");
        Map<String, List<Integer>> out = ac.search(text);
        if (out.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            for (Map.Entry<String, List<Integer>> e : out.entrySet()) {
                System.out.println("Pattern: \"" + e.getKey() + "\" Positions: " + e.getValue());
            }
        }
        System.out.println();
    }

    private static String generateLongText() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20000; i++) {
            if (i % 5 == 0) sb.append("abab");
            else if (i % 7 == 0) sb.append("aba");
            else sb.append((char)('a' + (i % 3)));
        }
        return sb.toString();
    }
}
