class LazyInnerClassSingleton {

    /** private constructor to prevent others from instantiating this class */
    private LazyInnerClassSingleton() {}

    /** This inner class is loaded only after getInstance() is called for the first time. */
    private static class SingletonHelper {
        private static final LazyInnerClassSingleton INSTANCE = new LazyInnerClassSingleton();
    }

    public static LazyInnerClassSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}


public class SingletonPattern {
    public static void main(String[] args) {
        LazyInnerClassSingleton instance1 = LazyInnerClassSingleton.getInstance();
        System.out.println(instance1);
        LazyInnerClassSingleton instance2 = LazyInnerClassSingleton.getInstance();
        System.out.println(instance2);

    }
}
