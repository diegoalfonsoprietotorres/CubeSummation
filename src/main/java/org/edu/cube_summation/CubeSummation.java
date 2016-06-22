package org.edu.cube_summation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class CubeSummation {

    public static void main(String[] args) {
        int T, N, M;
        Scanner in = new Scanner(System.in);

        T = in.nextInt();
        while (T > 0) {
            Map<Integer, Long> map = new HashMap<>();
            N = in.nextInt();
            M = in.nextInt();
            while (M > 0) {
                String str = in.next();
                if (str.equals("UPDATE")) {
                    update(map, in.nextInt(), in.nextInt(), in.nextInt(), in.nextLong(), N);
                } else {
                    query(map, N, in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
                }
                M--;
            }
            T--;
        }

    }

    public static void update(Map<Integer, Long> map, int x, int y, int z, long value, int N) {
        x--;
        y--;
        z--;
        map.put(x + (y * N) + (z * N * N), value);
    }

    public static void query(Map<Integer, Long> map, int N, int x1, int y1, int z1, int x2, int y2, int z2) {
        long sum = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            int key = entry.getKey();
            int x = (key % N) + 1;
            int y = ((key / N) % N) + 1;
            int z = (key / (N * N)) + 1;
            if (x1 <= x && x <= x2 && y1 <= y && y <= y2 && z1 <= z && z <= z2) {
                sum += entry.getValue();
            }
        }
        System.out.println(sum);
    }

}
