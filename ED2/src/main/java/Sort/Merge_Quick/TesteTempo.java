package Sort.Merge_Quick;

import java.util.Arrays;
import java.util.Random;

public class TesteTempo {

    // Método de ordenação Merge Sort
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (end - start > 1) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start];
        int i = start, j = mid, k = 0;

        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i < mid) {
            temp[k++] = arr[i++];
        }
        while (j < end) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, start, temp.length);
    }

    // Método de ordenação Quick Sort
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (end - start > 1) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end - 1];
        int i = start - 1;
        for (int j = start; j < end - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end - 1];
        arr[end - 1] = temp;
        return i + 1;
    }

    // Método para gerar array aleatório de tamanho especificado
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000); // Números aleatórios até 999
        }
        return arr;
    }

    // Método principal para testar os algoritmos de ordenação
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};

        for (int size : sizes) {
            int[] arrMergeSort = generateRandomArray(size);
            int[] arrQuickSort = Arrays.copyOf(arrMergeSort, arrMergeSort.length);

            long startTimeMergeSort = System.currentTimeMillis();
            mergeSort(arrMergeSort);
            long endTimeMergeSort = System.currentTimeMillis();
            System.out.println("Merge Sort para " + size + " elementos: " + (endTimeMergeSort - startTimeMergeSort) + "ms");

            long startTimeQuickSort = System.currentTimeMillis();
            quickSort(arrQuickSort);
            long endTimeQuickSort = System.currentTimeMillis();
            System.out.println("Quick Sort para " + size + " elementos: " + (endTimeQuickSort - startTimeQuickSort) + "ms");

            // Verificar se os arrays estão realmente ordenados
            // System.out.println(Arrays.toString(arrMergeSort));
            // System.out.println(Arrays.toString(arrQuickSort));
        }
    }
}