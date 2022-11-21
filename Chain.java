import java.util.*;

public interface Chain {
    public abstract void setNext(Chain nextChain);
    public abstract void process(Files request);
    public abstract ArrayList<String> get();
}
