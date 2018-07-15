package pl.com.psl.java.module.processor.impl.peeling;

import pl.com.psl.java.module.processor.VegetableProcessor;
import pl.com.psl.java.module.vegetable.provider.api.Vegetable;

public class PeelingProcessor implements VegetableProcessor {
    @Override
    public Vegetable process(Vegetable vegetable) {
        return () -> "peeled " + vegetable.getName();
    }
}
