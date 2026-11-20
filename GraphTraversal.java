/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package array.array1;

/**
 *
 * @author kanus
 */

import java.util.*;

public class GraphTraversal {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static boolean[] visited;

    static void BFS(int start, int v) {

        Queue<Integer> q = new LinkedList<>();

        visited = new boolean[v];

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            System.out.print(node + " ");

            for (int next : list.get(node)) {

                if (!visited[next]) {

                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    static void DFS(int node) {

        visited[node] = true;

        System.out.print(node + " ");

        for (int next : list.get(node)) {

            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }

        System.out.println("Enter edges:");

        for (int i = 0; i < e; i++) {

            int u = sc.nextInt();
            int w = sc.nextInt();

            list.get(u).add(w);
            list.get(w).add(u);
        }

        System.out.print("Enter starting node: ");
        int start = sc.nextInt();

        System.out.println("BFS Traversal:");
        BFS(start, v);

        System.out.println();

        System.out.println("DFS Traversal:");

        visited = new boolean[v];

        DFS(start);
    }
}
