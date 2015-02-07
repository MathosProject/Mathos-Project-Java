package mathoscore.Data.Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * An implementation of a mathematical set.
 *
 * @author Ethan Dagner
 *
 * @param <T> The type of elements that will be stored.
 * @version 2015.02.06
 */
public class Set<T> {
    public List<T> Elements;

    public Set() {
        Elements = new ArrayList<>();
    }

    public Set(Set<T> s) {
        Elements = s.Elements;
    }

    @SafeVarargs
    public Set(T... elems) {
        Elements = new ArrayList<>();
        Elements.addAll(Arrays.asList(elems));
    }

    public void add(T element) {
        Elements.add(element);
    }

    @SafeVarargs
    public final void add(T... elements) {
        Collections.addAll(Elements, elements);
    }

    public boolean isSubset(Set<T> b) {
        return b.Elements.containsAll(Elements);
    }

    public boolean isProperSubset(Set<T> b) {
        boolean proper = false;
        boolean missed = false;

        for(T elem : Elements) {
            if(b.Elements.contains(elem))
                proper = true;
            else if(missed)
                return false;
            else
                missed = true;
        }

        return proper;
    }

    public Set<T> union(Set<T> b) {
        List<T> ret = new ArrayList<>();

        for(T elem : Elements) {
            if(!ret.contains(elem))
                ret.add(elem);
        }

        for(T elem : b.Elements) {
            if(!ret.contains(elem))
                ret.add(elem);
        }

        return new Set<>((T[]) ret.stream().toArray(Object[]::new));
    }

    public Set<T> intersection(Set<T> b) {
        List<T> ret = new ArrayList<>();

        ret.addAll(Elements);
        ret.retainAll(b.Elements);

        return new Set<>((T[]) ret.stream().toArray(Object[]::new));
    }
}
