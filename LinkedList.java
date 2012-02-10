package linkedlist;

/*
 * This is a very generic linked list, it can work with
 * every class you have, the most important thing is that
 * every object has a Comparable unique ID, or a key.
 * "info" will get the information of your object
 * "key" will get a comparable value
 */
public class LinkedList {
    private Record list = null;

    private final class Record {
        public Object info;
        public Comparable key;
        public Record next;
        public Record prev;

        public Record(Object e, Comparable k) {
            info = e ;
            key = k;
            next = prev = null;
        }
    }

    public void insert(Object e, Comparable k) {
        Record p = new Record(e,k);
        if (list == null)
            list = p.prev = p.next = p;
        else {
            p.next = list.next;
            list.next.prev = p;
            list.next = p;
            p.prev = list;
        }
    }

    public Object search(Comparable k) {
        if (list == null) return null;
        for (Record p = list.next; ; p = p.next) {
            if (p.key.equals(k)) return p.info;
            if (p == list) return null;
        }
    }

    public void delete(Comparable k) throws KeyNotValidException {
        Record p= null;
        if (list != null)
            for (p = list.next; ; p = p.next) {
                if (p.key.equals(k)) break;
                if (p == list) { p=null; break; }
            }
        if (p == null)
            throw new KeyNotValidException();
        if (p.next == p) list = null; // empty list
        else // there are some elements
        {
            if (list == p) list = p.next;
            p.next.prev = p.prev;
            p.prev.next = p.next;
        }
    }
}
