import java.util.*;

public class ExampleMain {
    public static void main(String[] args){
        int[] num = {5, 1, -3, 9, 0, 4};

        int sumOfTwoLargest = sumOfTwoLargestElements(num);
        System.out.println("Sum of two largest number: " +sumOfTwoLargest);

        int closestToZero = getClosestToZero(num);
        System.out.println("Number closest to zero is: " +closestToZero);

        List<Integer> numbers = getNumbersWithFactors(1500);
        System.out.println("First 1500 natural numbers whose factors are only 2, 3, or 5"+ numbers);
    }

    public static int sumOfTwoLargestElements(int[] a) {
        if (a == null || a.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        // Sort the array in descending order
        Arrays.sort(a);

        // Sum of the two largest elements
        return a[a.length - 1] + a[a.length - 2];
    }

    public static int getClosestToZero(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        // Sort the array by absolute values
        Arrays.sort(a);

        // Check if the first element is positive or negative
        // If positive, return the first element; if negative, return its opposite
        return a[0] >= 0 ? a[0] : -a[0];
    }

    public static List<Integer> getNumbersWithFactors(int n) {
        List<Integer> result = new ArrayList<>();
        if (n <= 0) return result;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        pq.offer(1);
        set.add(1);

        while (result.size() < n) {
            int current = pq.poll();
            result.add(current);
            int[] factors = {2, 3, 5};
            for (int factor : factors) {
                int next = current * factor;
                if (!set.contains(next)) {
                    pq.offer(next);
                    set.add(next);
                }
            }
        }
        return result;
    }
}
