package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int V;
    private ArrayList<ArrayList<Integer>> adjList;
    private HashSet<Integer> edges;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; ++i) {
            adjList.add(new ArrayList<>());
        }
        edges = new HashSet<>();
    }

    public void addEdge(int u, int v) {
        if (u < 0 || u >= V || v < 0 || v >= V) {
            System.out.println("Один из введенных номеров вершин некорректен. Пожалуйста, введите ребро заново.");
            return;
        }

        int hash1 = u * V + v;
        int hash2 = v * V + u;
        if (edges.contains(hash1) || edges.contains(hash2)) {
            System.out.println("Это ребро уже было добавлено ранее. Пожалуйста, введите другое ребро.");
            return;
        }

        adjList.get(u).add(v);
        edges.add(hash1);
    }

    public void representation() {
        System.out.println("Представление графа в виде списка смежности:");
        for (int i = 0; i < V; ++i) {
            System.out.print(i + ": ");
            for (int j : adjList.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public void DFS(int start) {
        // Массив для отслеживания посещенных вершин
        boolean[] visited = new boolean[V];
        // Стек для хранения вершин, которые нужно посетить
        Stack<Integer> stack = new Stack<>();
        // Начальную вершину помещаем в стек
        stack.push(start);

        // Пока стек не пуст
        while (!stack.isEmpty()) {
            // Извлекаем вершину из стека
            int u = stack.pop();
            // Если вершина не была посещена
            if (!visited[u]) {
                // Помечаем вершину как посещенную
                visited[u] = true;
                // Выводим вершину на экран
                System.out.print(u + " ");

                // Для всех смежных вершин
                for (int v : adjList.get(u)) {
                    // Если смежная вершина не была посещена
                    if (!visited[v]) {
                        // Помещаем ее в стек для дальнейшего обхода
                        stack.push(v);
                    }
                }
            }
        }
        // Переход на новую строку после завершения обхода
        System.out.println();
    }


    public void BFS(int start) {
        // Массив для отслеживания посещенных вершин
        boolean[] visited = new boolean[V];
        // Очередь для хранения вершин, которые нужно посетить
        Queue<Integer> queue = new LinkedList<>();
        // Добавляем начальную вершину в очередь и помечаем как посещенную
        queue.add(start);
        visited[start] = true;

        // Пока очередь не пуста
        while (!queue.isEmpty()) {
            // Извлекаем вершину из очереди
            int u = queue.poll();
            // Выводим вершину на экран
            System.out.print(u + " ");

            // Для всех смежных вершин
            for (int v : adjList.get(u)) {
                // Если смежная вершина не была посещена
                if (!visited[v]) {
                    // Помечаем ее как посещенную и добавляем в очередь
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        // Переход на новую строку после завершения обхода
        System.out.println();
    }


}