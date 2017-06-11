import java.util.Arrays;

public class Sort <T extends Comparable>{
    int por,przes =0;

    public Sort() {
    }

    protected int compare(int first, int second) {
        int cmp = first > second? +1 : first < second ? -1 : 0;
        this.por++;
        return cmp;
    }

    protected int[] swap (int[] array, int i, int k) {
        int tmp = array[i];
        array[i] = array[k];
        array[k] = tmp;
        this.przes++;
        return array;
    }

    public int[] bubbleSort(int[] array) {
        this.por=0;
        this.przes=0;
        int size = array.length;
        for (int i=array.length; i>1; i--) {
            boolean sw = false;
            for (int k=0; k<i-1; k++){
                if (this.compare(array[k], array[k + 1]) > 0) {
                    array = this.swap(array, k, k + 1);
                    sw = true;
                }
            }
            if (!sw) {
                break;
            }
        }
        System.out.println(String.format("Bubblesort: \n Porownania: %d, Przesuniecia: %d", this.por, this.przes));
        return array;
    }


    public int[] selectSort(int[] array) {
        this.por = 0;
        this.przes = 0;
        for (int i=0; i<array.length-1; i++) {
            int minIndex = i;
            for (int k=i+1; k<array.length; k++) {
                int cmp = this.compare(array[minIndex], array[k]);
                if (cmp > 0) {
                    minIndex = k;
                }
            }
            array = this.swap(array, minIndex, i);
        }
        System.out.println(String.format("Selectsort: \n Porownania: %d, Przesuniecia: %d", this.por, this.przes));
        return array;
    }

    public int[] insertSort(int[] array) {
        this.por = 0;
        this.przes = 0;
        int i, k;
        for (i=1; i<array.length; i++) {
            int key = array[i];
            for (k=i-1; (k>=0 && this.compare(array[k], key) >= 0); k--) {
                array[k+1] = array[k];
                this.przes++;
            }
            array[k+1] = key;
            this.przes++;
        }
        System.out.println(String.format("Insertsort: \n Porownania: %d, Przesuniecia: %d", this.por, this.przes));
        return array;
    }

    public int[] insertSortWithIncrementation(int[] array, int start, int incrementation) {
        // insert sort zmodyfikowany na potrzeby algorytmu shell sort
        int i, k;
        for (i=start+incrementation; i<array.length; i+=incrementation) {
            int key = array[i];
            for (k=i-incrementation; (k>=0 && this.compare(array[k], key) >= 0); k-=incrementation) {
                array[k+incrementation] = array[k];
            }
            array[k+incrementation] = key;
            this.przes++;
        }
        return array;
    }
    public int calculateIncrement(int h, int max) {
        int hCurrent = 3 * h + 1;
        if (hCurrent < max) {
            return this.calculateIncrement(hCurrent, max);
        }
        else {
            return h;
        }
    }

    public int[] shellSort(int[] array) {
        this.por = 0;
        this.przes = 0;
        int H = this.calculateIncrement(0, array.length);
        while (H >= 1) {
            for (int start = 0; start < H; start++) {
                array = this.insertSortWithIncrementation(array, start, H);
            }
            H = this.calculateIncrement(0, H);

        }
        System.out.println(String.format("Shellsort: \n Porownania: %d, Przesuniecia: %d", this.por, this.przes));
        return array;
    }

    public void actualQuickSort(int[] array, int lo, int hi) {
        int i=lo, j=hi;
        int tmp;
        int key = array[(lo+hi) / 2];
        do {
            while(this.compare(array[i], key) < 0) i++;
            while(this.compare(array[j], key) > 0) j--;
            if (i <= j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
                this.przes++;
            }
        } while (i<=j);
        if (lo < j) actualQuickSort(array, lo, j);
        if (hi > i) actualQuickSort(array, i, hi);
    }

    public int[] quickSort(int[] array) {
        this.por = 0;
        this.przes = 0;
        this.actualQuickSort(array, 0, array.length - 1);
        System.out.println(String.format("Quicksort: \n Porownania: %d, Przesuniecia: %d", this.por, this.przes));
        return array;
    }
    public int[] joinArrays(int[] left, int[] right) {
        int[] merged = new int[left.length+right.length];
        int i = 0,
                j = 0,
                m = 0;
        while(i != left.length && j != right.length) {

            if (this.compare(left[i], right[j]) <= 0) {
                merged[m] = left[i];
                i++;
            } else {
                merged[m] = right[j];
                j++;
            }
            przes++;
            m++;
        }
        while (i != left.length) {
            merged[m] = left[i];
            i++;
            m++;
        }
        while (j != right.length) {
            merged[m] = right[j];
            j++;
            m++;
        }
        return merged;}

    public int[] actualMergesort(int[] array, int lo, int hi) {
        if (lo == hi) {
            int[] copy = Arrays.copyOfRange(array, lo, lo+1);
            copy[0] = array[lo];
            return copy;
        }
        int x = (lo + hi) / 2;
        return this.joinArrays(actualMergesort(array, lo, x),
                actualMergesort(array, x+1, hi));
    }

    public int[] mergeSort(int[] array) {
        this.por = 0;
        this.przes = 0;
        array = this.actualMergesort(array, 0, array.length-1);
        System.out.println(String.format("Mergesort: \n Porownania: %d, Przesuniecia: %d", this.por, this.przes));
        return array;
    }

}

