package org.example;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class SociopathTest {
    private final Sociopath sociopath = new Sociopath();

    @Test
    public void example1() {
        int groupSize = 2;
        List<int[]> likes = Arrays.asList(
                new int[] {1, 2}
        ); 

        assertEquals(2, sociopath.findTheSociopath(groupSize, likes));
    }

    @Test
    public void example2() {
        int groupSize = 3;
        List<int[]> likes = Arrays.asList(
                new int[] {1, 3},
                new int[] {2, 3}
        );

        assertEquals(3, sociopath.findTheSociopath(groupSize, likes));
    }

    @Test
    public void example3() {
        int groupSize = 3;
        List<int[]> likes = Arrays.asList(
                new int[] {1, 3},
                new int[] {2, 3},
                new int[] {3, 1} 
        );

        assertEquals(-1, sociopath.findTheSociopath(groupSize, likes));
    }

    @Test
    public void example4() {
        int groupSize = 3;
        List<int[]> likes = Arrays.asList(
                new int[] {1, 2},
                new int[] {2, 3}
        );

        assertEquals(-1, sociopath.findTheSociopath(groupSize, likes));
    }

    @Test
    public void example5() {
        int groupSize = 4;
        List<int[]> likes = Arrays.asList(
                new int[] {1, 3},
                new int[] {1, 4},
                new int[] {2, 3},
                new int[] {2, 4},
                new int[] {4, 3}
        );

        assertEquals(3, sociopath.findTheSociopath(groupSize, likes));
    }

    @Test
    public void findsSociopathWhenEveryoneElseLikesThem() {
        int groupSize = 4;
        List<int[]> likes = Arrays.asList(
                new int[] {1, 4},
                new int[] {2, 4},
                new int[] {3, 4}
        );

        assertEquals(4, sociopath.findTheSociopath(groupSize, likes));
    }

    @Test
    public void returnsMinusOneWhenNotLikedByAllOthers() {
        int groupSize = 3;
        List<int[]> likes = Arrays.asList(
                new int[] {1, 3}
        ); // person 2 does not like 3

        assertEquals(-1, sociopath.findTheSociopath(groupSize, likes));
    }

    @Test
    public void handlesSinglePersonGroup() {
        int groupSize = 1;
        List<int[]> likes = Collections.emptyList();

        assertEquals(1, sociopath.findTheSociopath(groupSize, likes));
    }

    @Test
    public void findsSociopathInLargerGroup() {
        int groupSize = 10;
        List<int[]> likes = new ArrayList<>();
        for (int i = 1; i <= groupSize; i++) {
            if (i != 6) {
                likes.add(new int[] {i, 6});
            }
        }

        assertEquals(6, sociopath.findTheSociopath(groupSize, likes));
    }

    @Test
    public void findsSociopathInComplexGroup() {
        int groupSize = 10;
        List<int[]> likes = new ArrayList<>();
        for (int i = 1; i <= groupSize; i++) {
            if (i == 6) {
                continue;
            }
            for (int j = 1; j <= groupSize; j++) {
                if (i != j) {
                    likes.add(new int[] {i, j});
                }
            }
        }

        assertEquals(6, sociopath.findTheSociopath(groupSize, likes));
    }
}

