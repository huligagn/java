package com.huligang.bishi.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpatialRelationUtil {

    public static boolean isPolygonContainsPoint(List<Point> mPoints, Point point) {
        int nCross = 0;
        for (int i = 0; i < mPoints.size(); i++) {
            Point p1 = mPoints.get(i);
            Point p2 = mPoints.get((i + 1) % mPoints.size());
            if (p1.y == p2.y)
                continue;
            if (point.y < Math.min(p1.y, p2.y))
                continue;
            if (point.y >= Math.max(p1.y, p2.y))
                continue;
            double x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
            if (x > point.x)
                nCross++;
        }
        return (nCross % 2 == 1);
    }

    public static boolean isPointInPolygonBoundary(List<Point> mPoints, Point point) {
        for (int i = 0; i < mPoints.size(); i++) {
            Point p1 = mPoints.get(i);
            Point p2 = mPoints.get((i + 1) % mPoints.size());
            if (point.y < Math.min(p1.y, p2.y))
                continue;
            if (point.y > Math.max(p1.y, p2.y))
                continue;
            if (p1.y == p2.y) {
                double minX = Math.min(p1.x, p2.x);
                double maxX = Math.max(p1.x, p2.x);
                if ((point.y == p1.y) && (point.x >= minX && point.x <= maxX)) {
                    return true;
                }
            } else { // 求解交点
                double x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
                if (x == point.x) // 当x=point.x时,说明point在p1p2线段上
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(",");
        Point target = new Point(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        List<Point> points = new ArrayList<>();
        tmp = sc.nextLine().split(",");
        for (int i = 0; i < tmp.length; i+=2) {
            points.add(new Point(Integer.parseInt(tmp[i]), Integer.parseInt(tmp[i+1])));
        }

        if (isPointInPolygonBoundary(points, target) || isPolygonContainsPoint(points, target))
            System.out.println("yes,0");
        else {
            int d = Integer.MAX_VALUE;
            for (Point p : points) {
                if (target.distance(p) < d) {
                    d = target.distance(p);
                }
            }
            System.out.println("no," + d);
        }

    }

}

class Point {
    double x;
    double y;
    Point(int a, int b) {
        x = a;
        y = b;
    }
    public int distance(Point that) {
        return (int)Math.sqrt((x-that.x)*(x-that.x) + (y-that.y)*(y-that.y));
    }
}
