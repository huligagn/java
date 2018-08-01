package com.huligang.bishi.ali;

import java.util.Scanner;

public class Delivery {

    private static class Point{
        int px;
        int py;
        boolean visited;

        Point(int px, int py) {
            this.px = px;
            this.py = py;
            this.visited = false;
        }

        int getLength(Point p){
            return Math.abs(px - p.px) + Math.abs(py - p.py);
        }
    }

    private static final Point START = new Point(0,0);
    private static int shortestPath = Integer.MAX_VALUE;

    private static int calculate(Point start, Point[] points, int sum, int count){

        if(count == points.length){
            shortestPath = Math.min(shortestPath, sum + start.getLength(START));
            return shortestPath;
        }
        for (Point point : points) {
            if (!point.visited) {
                sum += point.getLength(start);
                if (sum < shortestPath) {
                    point.visited = true;
                    calculate(point, points, sum, count + 1);
                }
                sum -= point.getLength(start);
                point.visited = false;
            }
        }
        return shortestPath;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = Integer.parseInt(input.nextLine().trim());
        Point[] points = new Point[N];
        for(int i = 0; i<N; i++){
            String[] locations = input.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        int min = calculate(START, points, 0, 0);
        System.out.println(min);
    }
}
