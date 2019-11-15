package hobs;
import java.util.concurrent.CyclicBarrier;

public class Barrier {
    public static final CyclicBarrier BARRIER = new CyclicBarrier(8, new Cook());
}
