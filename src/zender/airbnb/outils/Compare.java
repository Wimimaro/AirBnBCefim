package zender.airbnb.outils;

public class Compare<T extends Comparable<T>> extends Object{

    private T object1;
    private T object2;

    public Compare(T object1, T object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public T getHigher() {

        if (object1.compareTo(object2) > 0)
            return object1;
        else return object2;
    }
}
