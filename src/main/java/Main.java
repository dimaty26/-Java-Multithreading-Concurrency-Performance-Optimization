import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        ForkJoinPool customThreadPool = new ForkJoinPool(2);
        int sum = customThreadPool.submit(
                () -> listOfNumbers.parallelStream().reduce(0, Integer::sum)).get();
        customThreadPool.shutdown();
        System.out.println(sum);
    }
}
