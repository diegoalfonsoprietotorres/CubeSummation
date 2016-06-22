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

                }
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

}
