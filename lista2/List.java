
public interface List {
        public int size();
        public void insert(int index, Object value) throws IndexOutOfBoundsException;
        public Object delete(int index) throws IndexOutOfBoundsException;
        public boolean remove(Object value);
        public Object get(int index) throws IndexOutOfBoundsException;
        public Object set(int index, Object value) throws IndexOutOfBoundsException;
        // zmień wartość elementu z pozycji index, zwróć wartość elementu sprzed zmiany
        public void add(Object value);
        public boolean contains (Object value);
        public int indexOf(Object value); // zwraca indeks pierwszego wystąpienia danej
        // wartości; jeśli brak wartości - zwraca "–1"
        public boolean isEmpty();
        public void clear();
}

