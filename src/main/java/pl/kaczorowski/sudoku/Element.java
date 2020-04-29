package pl.kaczorowski.sudoku;

import java.util.List;
import java.util.Objects;

public class Element {
    public static final int EMPTY = -1;
    public int value;
    public List<Integer> listToSolve;

    public Element(int value, List<Integer> listToSolve) {
        this.value = value;
        this.listToSolve = listToSolve;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getListToSolve() {
        return listToSolve;
    }


    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element that = (Element) o;
        return getValue() == that.getValue() &&
                Objects.equals(getListToSolve(), that.getListToSolve());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getListToSolve());
    }
}
