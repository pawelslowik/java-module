package pl.com.psl.java.module.vegetable.provider.impl.cucumber;

import pl.com.psl.java.module.vegetable.provider.api.Vegetable;
import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;

public class CucumberProvider implements VegetableProvider {
    @Override
    public Vegetable provide() {
        return () -> "cucumber";
    }
}
