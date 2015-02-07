package Tests.Data;

import mathoscore.Data.Set.Set;
import org.junit.Test;

public class SetTest {

    @Test
    public void subsetTest() {
        Set<Integer> a = new Set<>(1, 2, 3, 4);
        Set<Integer> b = new Set<>(1, 3, 5, 6);
        Set<Integer> c = new Set<>(4, 3, 2, 1);

        System.out.println("B subset of A: " + b.isSubset(a));
        System.out.println("C subset of A: " + c.isSubset(a));
    }

    @Test
    public void properSubsetTest() {
        Set<Integer> a = new Set<>(1, 2, 3, 4);
        Set<Integer> b = new Set<>(1, 2, 5, 6);
        Set<Integer> c = new Set<>(1, 2, 3);

        System.out.println("B proper subset of A: " + b.isProperSubset(a));
        System.out.println("C proper subset of A: " + c.isProperSubset(a));
    }

    @Test
    public void unionTest() {
        Set<Integer> a = new Set<>(1, 2, 3, 4);
        Set<Integer> b = new Set<>(1, 3, 5, 6);

        a.union(b).Elements.forEach(System.out::println);
    }

    @Test
    public void intersectionTest() {
        Set<Integer> a = new Set<>(1, 2, 3, 4);
        Set<Integer> b = new Set<>(1, 3, 5, 6);

        a.intersection(b).Elements.forEach(System.out::println);
    }
}
