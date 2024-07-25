package io.github.BGPtII.ch10interfaces;

public interface Filter {

    boolean accept(Object object);

    default boolean reject(Object object) {
        return !accept(object);
    }

    default Filter invert() {
        return this::reject;
    }

    static int countAccepted(Object[] objects, Filter filter) {
        int acceptedCount = 0;
        for (Object object : objects) {
            if (filter.accept(object)) {
                acceptedCount++;
            }
        }
        return acceptedCount;
    }

    static void retainAllAccepted(Object[] objects, Filter filter) {
        int retainedObjectInsertIndex = 0;
        for (int i = 0; i < objects.length; i++) {
            if (filter.accept(objects[i])) {
                objects[retainedObjectInsertIndex++] = objects[i];
            }
        }
        while (retainedObjectInsertIndex < objects.length) {
            objects[retainedObjectInsertIndex++] = null;
        }
    }
}
