package possible_bipartition;

public class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        boolean[][] g = new boolean[n][n];
        for (int[] d : dislikes) {
            g[d[0] - 1][d[1] - 1] = true;
            g[d[1] - 1][d[0] - 1] = true;
        }
        int[] colors = new int[n];
        for (int i = 0; i < n; i++)
            if (colors[i] == 0 && paint(i, 1, colors, g))
                return false;
        return true;
    }

    private boolean paint(int u, int color, int[] colors, boolean[][] g) {
        if (colors[u] != 0)
            return colors[u] != color;
        colors[u] = color;
        for (int v = 0; v < colors.length; v++)
            if (g[u][v] && paint(v, -color, colors, g))
                return true;
        return false;
    }
}
