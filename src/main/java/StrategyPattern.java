interface Strategy {
    public void sort(int[] numbers);
}

class BubbleSort implements Strategy {

    @Override
    public void sort(int[] numbers) {
        System.out.println("sorting array using bubble sort strategy");

    }

}

class InsertionSort implements Strategy {

    @Override
    public void sort(int[] numbers) {
        System.out.println("sorting array using insertion sort strategy");

    }
}

class QuickSort implements Strategy {

    @Override
    public void sort(int[] numbers) {
        System.out.println("sorting array using quick sort strategy");

    }
}

class MergeSort implements Strategy {

    @Override
    public void sort(int[] numbers) {
        System.out.println("sorting array using merge sort strategy");

    }
}

class Context {
    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void arrange(int[] input) {
        strategy.sort(input);
    }
}


public class StrategyPattern {

    public static void main(String[] args) {
        // we can provide any strategy to do the sorting
        int[] var = {1, 2, 3, 4, 5 };
        Context ctx = new Context(new BubbleSort());
        ctx.arrange(var);

        // we can change the strategy without changing Context class
        ctx = new Context(new QuickSort());
        ctx.arrange(var);
    }
}
