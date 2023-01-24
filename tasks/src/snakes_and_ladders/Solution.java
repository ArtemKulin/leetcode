package snakes_and_ladders;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];
        int label = 1;
        Integer[] columns = new Integer[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }
        for (int row = n - 1; row >= 0; row--) {
            for (int column : columns) {
                cells[label++] = new Pair<>(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                int row = cells[next].getKey(), column = cells[next].getValue();
                int destination = board[row][column] != -1 ? board[row][column] : next;
                if (dist[destination] == -1) {
                    dist[destination] = dist[curr] + 1;
                    q.add(destination);
                }
            }
        }
        return dist[n * n];
    }
}

class Pair<K,V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

