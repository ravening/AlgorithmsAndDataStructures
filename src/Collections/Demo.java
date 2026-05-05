package Collections;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedCollection;

public class Demo {
    public static void main(String[] args) {
        try {
            Demo demo = new Demo();
            demo.hop();
            System.out.println("No Exception");
        } catch (InnerDemo e) {
            System.out.println(e.getMessage());
        }
    }

    public void hop() throws InnerDemo {
        throw new InnerDemo("Exception from hop");
    }

}

class InnerDemo extends Exception {
    public InnerDemo(String message) {
        super(message);
    }
}
