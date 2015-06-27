package tests.data;

import mathoscore.data.set.Set;
import org.junit.Test;

public class SetTest {

    @Test
    public void addRemoveElements() {
        Set<Integer> a = new Set<>(2, 4, 6, 8, 10);

        System.out.println(a);

        a.add(1, 3, 5, 7, 9);

        System.out.println(a);
    }

    @Test
    public void addSets() {
        Set<Integer> a = new Set<>(1, 2, 3, 4, 5);
        Set<Integer> b = new Set<>(6, 7, 8, 9, 10);

        System.out.println(a.add(b));
    }

    @Test
    public void unionTest() {
        Set<Integer> a = new Set<>(1, 2, 3);
        Set<Integer> b = new Set<>(2, 3, 4);

        System.out.println(a.union(b));
    }

    @Test
    public void intersectionTest() {
        Set<Integer> a = new Set<>(1, 2, 3);
        Set<Integer> b = new Set<>(2, 3, 4);

        System.out.println(a.intersection(b));
    }

    @Test
    public void differenceTest() {
        Set<Integer> a = new Set<>(1, 2, 3);
        Set<Integer> b = new Set<>(2, 3, 4);

        System.out.println(a.difference(b));
        System.out.println(b.difference(a));
    }

    @Test
    public void symmetricTest() {
        Set<Integer> a = new Set<>(1, 2, 3);
        Set<Integer> b = new Set<>(2, 3, 4);

        System.out.println(a.symmetric(b));
        System.out.println(b.symmetric(a));
    }

    @Test
    public void subsetTest() {
        Set<Integer> a = new Set<>(1, 2, 3);
        Set<Integer> b = new Set<>(1, 2, 3);
        Set<Integer> c = new Set<>(1, 2, 3, 4);

        System.out.println(a + " ? " + b + " = " + a.isSubset(b));
        System.out.println(a + " ? " + c + " = " + a.isSubset(c));

        System.out.println(a + " ? " + b + " = " + a.isProperSubset(b));
        System.out.println(a + " ? " + c + " = " + a.isProperSubset(c));
    }

    @Test
    public void technicalTest() {
        Set<Integer> set = new Set<>(1, 2, 3, 4);

        System.out.println(set.toString());
        System.out.println(set.hashCode());
        System.out.println(set.equals(new Set<Integer>(1, 2, 3, 4)));
    }
}
