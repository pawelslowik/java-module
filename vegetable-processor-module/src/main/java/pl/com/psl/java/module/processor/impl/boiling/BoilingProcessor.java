package pl.com.psl.java.module.processor.impl.boiling;

import pl.com.psl.java.module.processor.VegetableProcessor;
import pl.com.psl.java.module.vegetable.provider.api.Vegetable;

public class BoilingProcessor implements VegetableProcessor {
    @Override
    public Vegetable process(Vegetable vegetable) {
        return () -> "boiled " + vegetable.getName();
    }
}
