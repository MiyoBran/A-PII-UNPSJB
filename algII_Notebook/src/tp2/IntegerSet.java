package tp2;

import java.util.Arrays;

/**
 * Represents a set of integers from 0 to 100 using a boolean array.
 * Provides operations such as insertion, deletion, union, intersection,
 * and difference.
 * 
 * @author MiyenBrandolino
 * @version 1.2
 */
public class IntegerSet {
    private static final int SIZE = 101;
    private boolean[] set;

    /**
     * Constructs an empty set (all values set to false).
     */
    public IntegerSet() {
        set = new boolean[SIZE];
    }

    /**
     * Inserts an integer into the set.
     * 
     * @param k The integer to insert (0-100).
     */
    public void insertElement(int k) {
        if (k >= 0 && k < SIZE) {
            set[k] = true;
        }
    }

    /**
     * Deletes an integer from the set.
     * 
     * @param k The integer to delete (0-100).
     */
    public void deleteElement(int k) {
        if (k >= 0 && k < SIZE) {
            set[k] = false;
        }
    }

    /**
     * Returns the union of this set with another set.
     * 
     * @param other The other set.
     * @return A new set containing the union of both sets.
     */
    public IntegerSet union(IntegerSet other) {
        IntegerSet result = new IntegerSet();
        for (int i = 0; i < SIZE; i++) {
            result.set[i] = this.set[i] || other.set[i];
        }
        return result;
    }

    /**
     * Returns the intersection of this set with another set.
     * 
     * @param other The other set.
     * @return A new set containing the intersection of both sets.
     */
    public IntegerSet intersection(IntegerSet other) {
        IntegerSet result = new IntegerSet();
        for (int i = 0; i < SIZE; i++) {
            result.set[i] = this.set[i] && other.set[i];
        }
        return result;
    }

    /**
     * Returns the difference between this set and another set.
     * Logical operation AND
     * 
     * @param other The other set.
     * @return A new set containing elements that are in this set but not in the other.
     */
    public IntegerSet difference(IntegerSet other) {
        IntegerSet result = new IntegerSet();
        for (int i = 0; i < SIZE; i++) {
            result.set[i] = this.set[i] && !other.set[i];
        }
        return result;
    }

    /**
     * Returns a string representation of the set.
     * 
     * @return A string listing the elements in the set.
     */
    public String toSetString() {
        String fullSet = "{ ";
        boolean isEmpty = true;
        for (int i = 0; i < this.set.length; i++) {
            if (this.set[i]) {
                fullSet += i + " ";
                isEmpty = false;
            } 
        }
        
        if (isEmpty) {
            fullSet += "Empty }";
        }   else {
            fullSet += "}";
        }
        return fullSet;
    }

    /**
     * Computes the hash code for this set.
     * 
     * @return The hash code value for this set.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(set);
        return result;
    }

    /**
     * Determines if two sets are equal.
     * 
     * @param obj The object to compare with.
     * @return true if both sets are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        IntegerSet other = (IntegerSet) obj;
        return Arrays.equals(set, other.set);
    }
}
