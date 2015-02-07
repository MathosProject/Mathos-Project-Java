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
    public final List<T> Elements;

    /**
     * Creates an empty set
     */
    public Set() {
        Elements = new ArrayList<>();
    }

    /**
     * Creates a set from another set
     * @param s Set to copy from
     */
    public Set(Set<T> s) {
        Elements = s.Elements;
    }

    /**
     * Creates a set that contains the given elements
     * @param elems Elements to contain
     */
    @SafeVarargs
    public Set(T... elems) {
        Elements = new ArrayList<>();
        Elements.addAll(Arrays.asList(elems));
    }

    /**
     * Add an element to the set
     * @param element Element to add
     */
    public void add(T element) {
        Elements.add(element);
    }

    /**
     * Add multiple elements to the set
     * @param elements Elements to add
     */
    @SafeVarargs
    public final void add(T... elements) {
        Collections.addAll(Elements, elements);
    }

    /**
     * Is the current set a subset of b
     * @param b Parent set
     * @return Current Set ⊆ b
     */
    public boolean isSubset(Set<T> b) {
        return b.Elements.containsAll(Elements);
    }

    /**
     * Is the current set a proper subset of b
     * @param b Parent set
     * @return Current Set ⊂ b
     */
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

    /**
     * Get the union of the current set and b
     * @param b Second set
     * @return Current Set ∪ b
     */
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

    /**
     * Get the intersection of the current set and b
     * @param b Second set
     * @return Current Set ∩ b
     */
    public Set<T> intersection(Set<T> b) {
        List<T> ret = new ArrayList<>();

        ret.addAll(Elements);
        ret.retainAll(b.Elements);

        return new Set<>((T[]) ret.stream().toArray(Object[]::new));
    }
}
