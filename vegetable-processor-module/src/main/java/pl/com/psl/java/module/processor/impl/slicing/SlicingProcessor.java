package pl.com.psl.java.module.processor.impl.slicing;

import pl.com.psl.java.module.processor.VegetableProcessor;
import pl.com.psl.java.module.vegetable.provider.api.Vegetable;

public class SlicingProcessor implements VegetableProcessor {
    @Override
    public Vegetable process(Vegetable vegetable) {
        return () -> "sliced " + vegetable.getName();
    }
}
