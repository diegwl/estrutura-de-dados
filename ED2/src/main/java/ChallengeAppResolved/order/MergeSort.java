package ChallengeAppResolved.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MergeSort {

    private static <E extends Comparable<? super E>> List<E> sort(List<E> unsorted) {
        var size = unsorted.size();

        if (size <= 2) {
            // simple reordering, behind the scenes is a merge sort
            return unsorted.stream()
                    .sorted()
                    .collect(Collectors.toList());
        }

        var halfSize = size / 2;

        var firstHalfSorted = sort(unsorted.subList(0, halfSize));
        var secondHalfSorted = sort(unsorted.subList(halfSize, size));

        var finalList = new ArrayList<E>();

        for (int i = 0; i < size; i++) {
            if (firstHalfSorted.isEmpty()) {
                finalList.addAll(secondHalfSorted);
                break;
            } else if (secondHalfSorted.isEmpty()) {
                finalList.addAll(firstHalfSorted);
                break;
            } else if (firstHalfSorted.get(0).compareTo(secondHalfSorted.get(0)) < 0) {
                finalList.add(firstHalfSorted.remove(0));
            } else {
                finalList.add(secondHalfSorted.remove(0));
            }
        }

        return finalList;
    }

    public static <E extends Comparable<? super E>> E[] sort(E[] unsorted) {
        var list = Arrays.stream(unsorted).collect(Collectors.toList());
        var sortedList = sort(list);

        return sortedList.toArray(Arrays.copyOf(unsorted, sortedList.size()));
    }

    public static void main(String[] args) {
        Integer[] array = {5, 3, 8, 4, 2};
        Integer[] sortedArray = MergeSort.sort(array);
        System.out.println(Arrays.toString(sortedArray));

        String[] stringArray = {"apple", "orange", "banana", "pear"};
        String[] sortedStringArray = MergeSort.sort(stringArray);
        System.out.println(Arrays.toString(sortedStringArray));
    }
}