import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. Repeated DNA Sequences
 * https://leetcode.com/problems/repeated-dna-sequences/
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/14/2016.
 */
public class RepeatedDNASequences {

    public class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            if (s.length() <= 10) {
                return new ArrayList<>();
            }
            Set<Integer> patterns = new HashSet<>();
            Set<String> resultSet = new HashSet<>();
            int first = encode(s.substring(0, 10));
            patterns.add(first);
            for (int i = 10; i < s.length(); i++) {
                first = ((first << 2) & 0xFFFFF) + encode(s.substring(i, i + 1));
                if (patterns.contains(first)) {
                    resultSet.add(decode(first));
                } else {
                    patterns.add(first);
                }
            }

            return new ArrayList<>(resultSet);
        }

        private int encode(String s) {
            int i = 0;
            for (char c : s.toCharArray()) {
                switch (c) {
                    case 'A': i += 0;break;
                    case 'C': i += 1;break;
                    case 'G': i += 2;break;
                    case 'T': i += 3;break;
                }
                i <<= 2;
            }
            i >>= 2;
            return i;
        }

        private String decode(int i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 18; j >= 0; j -= 2) {
                char c = '.';
                switch ((i >> j) & 3) {
                    case 0 : c = 'A'; break;
                    case 1 : c = 'C'; break;
                    case 2 : c = 'G'; break;
                    case 3 : c = 'T'; break;
                }
                sb.append(c);
            }

            return sb.toString();
        }
    }
}
