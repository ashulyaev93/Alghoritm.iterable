import java.util.Iterator;

//об этом ли речь?
public class KeysIterable<A> implements Iterable<A> {
    A[] elements;
    int nElements;

    private class KeysIterator<A> implements Iterator<A> {
        int nextElement = 0;

        public boolean hasNext() {
            return nextElement < nElements;
        }

        public A next() {
            A result = (A) elements[nextElement];
            nextElement = nextElement + 1;
            return result;
        }

        public void remove() {
            if (nextElement < nElements - 1) {
                System.arraycopy(elements, nextElement + 1,
                        elements, nextElement, nElements - nextElement - 1);
            }
            nElements--;
        }
    }

    public Iterator<A> iterator() {
        return new KeysIterator<A>();
    }

    public KeysIterable() {

    }
}