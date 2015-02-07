package Tests.Data;

import mathoscore.Data.Set.Set;
import org.junit.Test;

public class SetTest {

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
