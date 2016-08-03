package mathos.notation;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * An implementation of a mathematical set.
 *
 *  - Subsets need work.
 *  - Needs cartesian product.
 *  - Needs power set.
 *
 * @param <T> The type of elements that will be stored.
 * @author Ethan Dagner (napen123@gmail.com), Mathos Project
 */
public class Set<T> {
    /**
     * The contents of the set.
     */
    public final HashSet<T> Elements;

    /**
     * Create an empty set.
     */
    public Set() {
        Elements = new HashSet<>();
    }

    /**
     * Create a set from an already existing set.
     * @param s The base set to copy from.
     */
    public Set(Set<T> s) {
        Elements = s.Elements;
    }

    /**
     * Create a set from a list of elements.
     * @param elems The elements the set will contain.
     */
    @SafeVarargs
    public Set(T... elems) {
        this();

        Elements.addAll(Arrays.asList(elems));
    }

    /**
     * Add an element to the set.
     * @param element The element to add.
     * @return This set with the given element added.
     */
    public Set<T> add(T element) {
        Elements.add(element);

        return this;
    }

    /**
     * Add multiple elements to the set.
     * @param elements The elements to add.
     * @return The elements to add.
     */
    @SafeVarargs
    public final Set<T> add(T... elements) {
        Collections.addAll(Elements, elements);

        return this;
    }

    /**
     * Add the contents of another set into this one.
     * @param set The base set.
     * @return This set alongside set b combined.
     */
    public Set<T> add(Set<T> set) {
        Elements.addAll(set.Elements.stream().collect(Collectors.toList()));

        return this;
    }

    /**
     * Remove the given item from the set.
     * @param item The item to remove.
     * @return This set with the given item removed.
     */
    public Set<T> remove(T item) {
        Elements.remove(item);

        return this;
    }

    /**
     * Remove the item that matches the given expression.
     * @param match The expression to match to.
     * @return This set with the matched item removed.
     */
    public Set<T> removeMatch(Predicate<T> match) {
        Elements.removeIf(match);

        return this;
    }

    /**
     * NumberUtility the union of this set and b.
     * @param b The second set
     * @return this ∪ b.
     */
    public Set<T> union(Set<T> b) {
        List<T> ret = new ArrayList<>();
        HashSet<T> tmp = Elements;

        tmp.addAll(b.Elements);
        tmp.stream().filter(element -> !ret.contains(element)).forEach(ret::add);

        return new Set<>((T[])ret.stream().toArray(Object[]::new));
    }

    /**
     * NumberUtility the intersection of this set and b.
     * @param b The second set.
     * @return this ∩ b.
     */
    public Set<T> intersection(Set<T> b) {
        List<T> ret = Elements.stream().filter(b.Elements::contains).collect(Collectors.toList());

        return new Set<>((T[]) ret.stream().toArray(Object[]::new));
    }

    /**
     * NumberUtility the difference of this set and b.
     * @param b The second set.
     * @return this \ b.
     */
    public Set<T> difference(Set<T> b) {
        List<T> ret = Elements.stream().filter(element -> !b.Elements.contains(element)).collect(Collectors.toList());

        return new Set<>((T[]) ret.stream().toArray(Object[]::new));
    }

    /**
     * NumberUtility the symmetric difference of this set and b.
     * @param b The second set.
     * @return Either (this △ b) or (this ⊖ b).
     */
    public Set<T> symmetric(Set<T> b) {
        Set<T> union = union(b);
        Set<T> inter = intersection(b);

        return union.difference(inter);
    }

    /**
     * Is this set a subset of b?
     * @param b The base set.
     * @return this ⊆ b.
     */
    public boolean isSubset(Set<T> b) {
        return b.Elements.containsAll(Elements);
    }

    /**
     * Is this set a proper subset of b?
     * @param b The base set.
     * @return this ⊂ b.
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

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Set))
            return false;

        for(T element : ((Set<T>)o).Elements) {
            if(!Elements.contains(element))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (Elements != null) ? Elements.hashCode() : 0;
    }

    @Override
    public String toString() {
        String str = "{";

        for(T element : Elements) {
            str += element.toString() + ",";
        }

        if(str.endsWith(","))
            str = str.substring(0, str.length() - 1);

        return str + "}";
    }
}
