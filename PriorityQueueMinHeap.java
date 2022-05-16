import java.util.ArrayList;

public class PriorityQueueMinHeap implements PriorityQueue {

    private static ArrayList a = new ArrayList<Comparable>();

    @Override
    public void addElement(Comparable elem) {
        DecreaseKey(a,a.size(),elem);
    }

    @Override
    public Comparable getFirst() {
        return (Comparable) a.get(0);
    }

    @Override
    public void deleteFirst() {
        a.set(0,a.get(a.size()-1));
        a.remove(a.size()-1);
        MinHeapify(a,0);
    }

    public void MinHeapify(ArrayList a, int i) {
        int min = 0;
        Comparable I = (Comparable) a.get(i);
        if ((i*2+1) < a.size()) {
            int l = i*2+1;
            Comparable L = (Comparable) a.get(l);
            if (l <= (a.size() - 1) && (L.compareTo(I) < 0)) {
                min = l;
            }
            else {
                min = i;
            }
        } else {
            min = i;
        }
        Comparable MIN = (Comparable) a.get(min);
        if ((i*2+2) < a.size()) {
            int r = i*2+2;
            Comparable R = (Comparable) a.get(r);
            if (r <= (a.size() - 1) && (R.compareTo(MIN) < 0)) {
                min = r;
            }
        }
        MIN = (Comparable) a.get(min);
        if (min != i) {
            Comparable X = (Comparable) a.get(i);
            a.set(i,MIN);
            a.set(min,X);
            MinHeapify(a,min);
        }
    }

    public void DecreaseKey (ArrayList a, int i, Comparable elem) {
        if (i >= a.size()) {
            a.add(elem);
        } else {
            a.set(i, elem);
        }
        Comparable I = (Comparable) a.get(i);
        if (elem.compareTo(I) > 0) {
            // ERROR
        }
        Comparable MASTER = (Comparable) a.get((i-1)/2);
        while (i > 0 && MASTER.compareTo(I) > 0) {
            Comparable X = (Comparable) a.get(i);
            a.set(i,MASTER);
            a.set((i-1)/2,X);
            i = (i-1)/2;
            MASTER = (Comparable) a.get((i-1)/2);
        }
    }

}
