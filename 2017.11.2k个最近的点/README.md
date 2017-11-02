# K个最近的点

[TOC]

## 问题描述

给定一些 `points` 和一个 `origin`，从 `points` 中找到 `k` 个离 `origin` 最近的点。按照距离由小到大返回。如果两个点有相同距离，则按照x值来排序；若x值也相同，就再按照y值排序。

样例:

给出 points = `[[4,6],[4,7],[4,4],[2,5],[1,1]]`, origin = `[0, 0]`, k = `3`
返回 `[[1,1],[2,5],[4,4]]`

## 解答

~~~~JAVA
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


public class Solution {
    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        Point[] fin = new Point[k];
        //把points按照距离origin从小到大排列
        for(int i = 0 ; i < points.length ; i++){
            for(int j = i ; j < points.length ; j++){
                if(pointLength(points[i],origin) > pointLength(points[j],origin)){
                    Point temp = points[i];
                    points[i] = points[j];
                    points[j] = temp;
                }else if(pointLength(points[i],origin) == pointLength(points[j],origin)){
                    if(points[i].x > points[j].x ){
                        Point temp = points[i];
                        points[i] = points[j];
                        points[j] = temp;
                    }else if(points[i].x == points[j].x){
                        if(points[i].y > points[j].y){
                            Point temp = points[i];
                            points[i] = points[j];
                            points[j] = temp;
                        }
                    }
                }
            }
        }
      //拿到k个距离origin最近的点
        for(int m = 0 ; m < fin.length ; m++){
            fin[m] = points[m];
            }
        return fin;
    }
    public double pointLength(Point start , Point end){
        double xLength = Math.abs(start.x - end.x);
        double yLength = Math.abs(start.y - end.y);
        double length = Math.sqrt(xLength * xLength + yLength * yLength);
        return length;
    }
}
~~~~

