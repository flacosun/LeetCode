import java.util.Arrays;

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 5/1/2016.
 */
public class SurroundedRegions {

    public class Solution {

        int m;
        int n;
        private int[] ids;
        // Weight (size) of each union set
        private int[] sizes;
        // The id of union set for 'O's on edge
        private int OOnEdge;

        public void solve(char[][] board) {
            if ((m = board.length) == 0 || (n = board[0].length) == 0) return;

            ids = new int[m * n];
            sizes = new int[m * n];
            Arrays.fill(sizes, 1);
            OOnEdge = -1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'X') {
                        continue;
                    }
                    int index = i * n + j;
                    ids[index] = index;
                    // Nodes on edges
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        if (OOnEdge == -1) {
                            // Set OOnEdge if it has not been set yet
                            OOnEdge = index;
                        } else {
                            // If OOnEdge is already set, unite it with index
                            unite(OOnEdge, index);
                        }
                    }
                    // Unite node with its upper neighbor
                    if (i > 0 && board[i - 1][j] == 'O') {
                        unite(index, index - n);
                    }
                    // Unite node with its left neighbor
                    if (j > 0 && board[i][j - 1] == 'O') {
                        unite(index, index - 1);
                    }
                }
            }

            // Find
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (board[i][j] == 'X') {
                        continue;
                    }
                    int index = i * n + j;
                    if (OOnEdge == -1 || !find(index, OOnEdge)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        private void unite(int a, int b) {
            int i = findRoot(a);
            int j = findRoot(b);

            // Weighted quick union
            if (sizes[i] < sizes[j]) {
                ids[i] = j;
                sizes[j] += sizes[i];
            } else {
                ids[j] = i;
                sizes[i] += sizes[j];
            }
        }

        private boolean find(int a, int b) {
            return findRoot(a) == findRoot(b);
        }

        private int findRoot(int i) {
            while (i != ids[i]) {
                // Path compression
                ids[i] = ids[ids[i]];
                i = ids[i];
            }

            return i;
        }
    }
}
