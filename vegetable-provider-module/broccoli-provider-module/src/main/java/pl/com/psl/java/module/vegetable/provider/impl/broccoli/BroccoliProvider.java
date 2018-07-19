package pl.com.psl.java.module.vegetable.provider.impl.broccoli;

import pl.com.psl.java.module.vegetable.provider.api.Vegetable;
import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;

public class BroccoliProvider implements VegetableProvider {
    @Override
    public Vegetable provide() {
        return () -> "broccoli";
    }
}
