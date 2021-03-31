package companies.interview_questions_facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueRemovals {


    public static void main(String[] args) {
        QueueRemovals queueRemovals = new QueueRemovals();
        int[] arr = {1, 2, 2, 3, 4, 5};
        queueRemovals.findPositions(arr, 5);
    }

    void performOperations(int[] res, int[] arr, Queue<Index> qu, int x) {

        int resIndex = 0;
        while (resIndex != x) {

            List<Index> temp = new ArrayList<>();
            Index maxIndex = new Index();
            maxIndex.setValue(Integer.MIN_VALUE);
            maxIndex.setIndex(-1);
            for (int i = 0; i < x; i++) {

                Index index = qu.poll();
                if (index == null) {
                    break;
                }
                maxIndex = index.getValue() > maxIndex.getValue() ? index : maxIndex;
                temp.add(index);
            }
            boolean removed = false;
            for (Index index : temp) {
                if (index.getValue() == maxIndex.getValue() && !removed) {
                    removed = true;
                    res[resIndex++] = index.getIndex();
                } else {
                    int decrement = index.getValue() == 0 ? index.getValue() : index.getValue() - 1;
                    index.setValue(decrement);
                    qu.offer(index);
                }
            }
        }
    }

    int[] findPositions(int[] arr, int x) {
        // Write your code here

        int[] res = new int[x];

        Queue<Index> qu = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            Index index = new Index();
            index.setValue(arr[i]);
            index.setIndex(i + 1);
            qu.add(index);
        }

        performOperations(res, arr, qu, x);

        return res;
    }

    static class Index {

        int value;
        int index;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

}
