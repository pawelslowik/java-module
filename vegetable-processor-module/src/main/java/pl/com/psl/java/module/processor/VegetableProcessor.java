package pl.com.psl.java.module.processor;

import pl.com.psl.java.module.vegetable.provider.api.Vegetable;

public interface VegetableProcessor {
    Vegetable process(Vegetable vegetable);
}
