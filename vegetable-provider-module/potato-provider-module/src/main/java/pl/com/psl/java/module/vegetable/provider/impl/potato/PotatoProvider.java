package pl.com.psl.java.module.vegetable.provider.impl.potato;

import pl.com.psl.java.module.vegetable.provider.api.Vegetable;
import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;

public class PotatoProvider implements VegetableProvider {
    @Override
    public Vegetable provide() { return () -> "potato"; }
}
