package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bj4307 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalTestCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < totalTestCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int antCount = Integer.parseInt(st.nextToken());

            ArrayList<Integer> antPoint = new ArrayList<>();
            for (int j = 0; j < antCount; j++) {
                antPoint.add(Integer.parseInt(br.readLine()));
            }

            Collections.sort(antPoint);

            int max;
            int min = 0;
            max = Math.max(length - antPoint.get(0), antPoint.get(antCount - 1));

            for (int t = 0; t < antCount; t++) {
                if (antPoint.get(t) < length / 2) {
                    min = Math.max(min, antPoint.get(t));
                } else {
                    min = Math.max(min, length - antPoint.get(t));
                }
            }

            System.out.println(min + " " + max);
        }
    }
}
