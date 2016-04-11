import java.util.*;

/**
 * 131. Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/10/2016.
 */
public class PalindromePartitioning {

    public class Solution {

        public List<List<String>> partition(String s) {
            List<List<String>> results = new ArrayList<>();
            if (s.length() == 0) {
                return results;
            }

            dfs(s, 0, new ArrayList<>(), results);

            return results;
        }

        private void dfs(String s, int start, List<String> palindrome, List<List<String>> results) {


            if (start == s.length() && palindrome.size() > 0) {
                results.add(new ArrayList<>(palindrome));
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    palindrome.add(s.substring(start, i + 1));
                    dfs(s, i + 1, palindrome, results);
                    palindrome.remove(palindrome.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) if (s.charAt(start++) != s.charAt(end--)) return false;
            return true;
        }

    }
}
