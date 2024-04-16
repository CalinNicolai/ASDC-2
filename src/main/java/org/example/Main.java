package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Введите количество вершин: ");
//        int V = scanner.nextInt();
//        Graph graph = new Graph(V);
//
//        System.out.print("Введите количество рёбер: ");
//        int E = scanner.nextInt();
//        System.out.println("Введите рёбра в формате 'откуда куда': ");
//        for (int i = 0; i < E; ++i) {
//            int u = scanner.nextInt();
//            int v = scanner.nextInt();
//            graph.addEdge(u, v);
//        }
//
//        graph.representation();
        Graph graph = new Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 6);
        graph.addEdge(2, 7);
        graph.addEdge(3, 8);
        graph.addEdge(3, 9);
        graph.addEdge(4, 5);
        graph.addEdge(6, 7);
        graph.addEdge(8, 9);
        graph.addEdge(0, 4);
        graph.addEdge(1, 6);
        graph.addEdge(2, 8);
        graph.addEdge(3, 7);


        System.out.println("DFS:");
        graph.DFS(2); // Поиск в глубину, начиная с вершины 2

        System.out.println("BFS:");
        graph.BFS(2); // Поиск в ширину, начиная с вершины 2
    }
}