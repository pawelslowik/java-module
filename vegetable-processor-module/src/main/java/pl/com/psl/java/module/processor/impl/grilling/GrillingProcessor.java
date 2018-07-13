package pl.com.psl.java.module.processor.impl.grilling;

import pl.com.psl.java.module.processor.VegetableProcessor;
import pl.com.psl.java.module.vegetable.provider.api.Vegetable;

public class GrillingProcessor implements VegetableProcessor {
    @Override
    public Vegetable process(Vegetable vegetable) {
        return () -> "grilled " + vegetable.getName();
    }
}
