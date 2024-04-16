package org.example;

import java.util.ArrayList;
import java.util.List;

public class TSPNearestNeighbor {

    private int numberOfCities;
    private int[][] distances;
    private List<Integer> tour;

    // Конструктор класса, принимает матрицу расстояний между городами
    public TSPNearestNeighbor(int[][] distances) {
        this.distances = distances;
        this.numberOfCities = distances.length;
        this.tour = new ArrayList<>();
    }

    // Метод для получения тура (последовательности посещения городов)
    public List<Integer> getTour() {
        return tour;
    }

    // Метод для получения общего расстояния по маршруту
    public int getTotalDistance() {
        int totalDistance = 0;
        for (int i = 0; i < numberOfCities - 1; i++) {
            totalDistance += distances[tour.get(i)][tour.get(i + 1)];
        }
        totalDistance += distances[tour.get(numberOfCities - 1)][tour.get(0)];
        return totalDistance;
    }

    // Метод для выполнения алгоритма "ближайшего соседа" для поиска оптимального маршрута
    public void nearestNeighbor() {
        boolean[] visited = new boolean[numberOfCities];
        tour.add(0); // Начинаем с первого города
        visited[0] = true;

        for (int i = 0; i < numberOfCities - 1; i++) {
            int currentCity = tour.get(i);
            int nearestCity = -1;
            int nearestDistance = Integer.MAX_VALUE;

            // Поиск ближайшего непосещенного города
            for (int j = 0; j < numberOfCities; j++) {
                if (!visited[j] && distances[currentCity][j] < nearestDistance) {
                    nearestCity = j;
                    nearestDistance = distances[currentCity][j];
                }
            }

            // Добавление ближайшего города в маршрут и пометка его как посещенного
            tour.add(nearestCity);
            visited[nearestCity] = true;
        }
    }

    public static void main(String[] args) {
        int[][] distances = {
                {0, 29, 20, 21},
                {29, 0, 15, 17},
                {20, 15, 0, 28},
                {21, 17, 28, 0}
        };

        // Создание объекта и выполнение алгоритма
        TSPNearestNeighbor tsp = new TSPNearestNeighbor(distances);
        tsp.nearestNeighbor();

        // Вывод результатов
        List<Integer> tour = tsp.getTour();
        System.out.println("Путь: " + tour);
        System.out.println("Общее расстояние: " + tsp.getTotalDistance());
    }
}
