import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    static int shortestChainLen(String start, String target, Set<String> D){
        if (start == target){
            return 0;
        }
        if (!D.contains(target)){
            return 0;
        }
        int level = 0;
        int wordlength = start.length();
        Queue<String> Q = new LinkedList<>();
        Q.add(start);

        while (!Q.isEmpty()){
            ++level;
            int sizeOfQ= Q.size();

            for (int i = 0; i < sizeOfQ; i++) {
                char[] word = Q.peek().toCharArray();
                Q.remove();
                for (int poss = 0; poss < wordlength; ++poss) {
                    char orig_char = word[poss];
                    for (char c = 'a'; c<='z'; ++c){
                        word[poss] = c;
                        if (String.valueOf(word).equals(target)){
                            return level+1;
                        }
                        if (!D.contains(String.valueOf(word))){
                            continue;
                        }
                        D.remove(String.valueOf(word));
                        Q.add(String.valueOf(word));
                    }
                    word[poss] = orig_char;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Set<String> D = new HashSet<>();
        D.add("poon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");
        String start = "toon";
        String target = "plea";
        System.out.println("Length of shortest chain is : "+shortestChainLen(start, target,D));
    }
}
