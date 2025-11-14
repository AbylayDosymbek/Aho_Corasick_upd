# Aho-Corasick Automaton Project
## What I did
I implemented the Aho-Corasick automaton from scratch in Java. The implementation contains full construction of the trie, failure links, and an efficient search engine capable of matching multiple patterns simultaneously in linear time. The project includes test executions on three different text sizes to observe behavior under varying input lengths. 
## Project structure
```
Aho_Corasick_upd/
├─ src/
│  ├─ AhoCorasick.java
│  └─ Main.java
└─ README.md
```

## How to run
Open the project in IntelliJ and run `Main.java`, or from command line:
```
javac src/*.java
java -cp src Main
```

## Testing and output
The program prints detected occurrences of each pattern with their starting positions for:
- short text
- medium text
- long generated text

## Complexity analysis
**Time Complexity**
- Build phase: O(sum of pattern lengths + number_of_nodes × alphabet_size)
- Search phase: O(n + output) where n is text length

**Space Complexity**
- Trie nodes: O(sum of pattern lengths)
- Transition table per node: 256 pointers
- Additional: failure links + match output lists

This ensures scalable performance for large inputs and many patterns.

## Additional Notes on the Implementation

The implementation focuses on preserving the essential structure of the Aho–Corasick automaton while keeping the code compact and easy to integrate into any Java project. I structured the solution so that the automaton remains fully deterministic, ensuring that every state always has a valid transition for any incoming character. This allows the search procedure to operate without conditional checks, which simplifies the logic and keeps performance stable even for large inputs.

During development, I tested several variations of the automaton, especially around failure-function construction. The final version uses a BFS approach that guarantees consistent propagation of fallback transitions across the trie. This helps maintain linear-time performance during pattern matching and ensures that no characters in the text lead to undefined behavior.

## Why Aho–Corasick

I chose the Aho–Corasick algorithm because it represents one of the most efficient approaches for multi-pattern string matching. Compared to running multiple individual searches with algorithms like KMP, the automaton handles all patterns simultaneously with a single pass through the text. This makes it ideal for applications such as text analysis, plagiarism detection, intrusion detection systems, or any domain where multiple keywords must be matched at scale.

## Observations from Testing

The behavior of the automaton remained consistent across all input sizes. Even the long generated text—containing tens of thousands of characters—was processed almost instantly, which highlights the advantage of a linear-time matching approach. Increasing the number or size of patterns also did not degrade performance significantly, confirming the scalability of the implementation.
## Student: Abylay Dosymbek  
## Group: SE-2435  
## Course Instructor: Aidana Aidynkyzy
