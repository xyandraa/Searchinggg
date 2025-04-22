import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static int exponentialSearch(int[] arr, int target) {
        if (arr[0] == target)
            return 0;

        int i = 1;
        while (i < arr.length && arr[i] <= target) {
            i *= 2;
        }

        return Arrays.binarySearch(arr, i / 2, Math.min(i, arr.length), target);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a searching algorithm to perform:");
        System.out.println("1. Linear ");
        System.out.println("2. Binary");
        System.out.println("3. Jump");
        System.out.println("4. Exponential");
        System.out.print("\nEnter your choice(1-4): ");
        int choice = scanner.nextInt();

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        bubbleSort(arr);
        int index = -1;

        switch (choice) {
            case 1:
                index = linearSearch(arr, target);
                break;
            case 2:
                index = binarySearch(arr, target);
                break;
            case 3:
                index = jumpSearch(arr, target);
                break;
            case 4:
                index = exponentialSearch(arr, target);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (index >= 0)
            System.out.println("Search result: Element found at index " + index + ".");
        else
            System.out.println("Search result: Element not found.");
    }
}