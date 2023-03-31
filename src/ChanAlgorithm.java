
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class ChanAlgorithm {
    private static long iterations;

    public static List<Point> findConvexHull(List<Point> points) {
        iterations = 0;
        int n = points.size();
        if (n <= 3) {
            return points;
        }

        int minPointIndex = 0;
        for (int i = 1; i < n; i++) {
            if (points.get(i).y < points.get(minPointIndex).y ||
                    (points.get(i).y == points.get(minPointIndex).y && points.get(i).x < points.get(minPointIndex).x)) {
                minPointIndex = i;
            }
        }

        Point minPoint = points.get(minPointIndex);
        points.remove(minPointIndex);

        points.sort(Comparator.comparingDouble(p -> Math.atan2(p.y - minPoint.y, p.x - minPoint.x)));

        int m = 1;
        for (int i = 1; i < n - 2; i++) {
            while (i < n - 1 && areCollinear(minPoint, points.get(i), points.get(i + 1))) {
                i++;
                iterations++;
            }
            points.set(m++, points.get(i));
        }
        points.add(minPoint);

        if (m < 3) {
            return new ArrayList<>();
        }

        Stack<Point> hull = new Stack<>();
        hull.push(points.get(0));
        hull.push(points.get(1));
        hull.push(points.get(2));

        for (int i = 3; i <= m; i++) {
            while (hull.size() >= 2 && !isLeftTurn(hull.elementAt(hull.size() - 2), hull.peek(), points.get(i))) {
                hull.pop();
                iterations++;
            }
            hull.push(points.get(i));
        }

        return hull;
    }

    public static long getIterations() {
        return iterations;
    }

    private static boolean areCollinear(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) == (r.y - q.y) * (q.x - p.x);
    }

    private static boolean isLeftTurn(Point p, Point q, Point r) {
        return (q.x - p.x) * (r.y - p.y) - (r.x - p.x) * (q.y - p.y) > 0;
    }
}
