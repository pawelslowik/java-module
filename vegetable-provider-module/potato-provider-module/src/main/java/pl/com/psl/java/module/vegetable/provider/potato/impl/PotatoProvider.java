package pl.com.psl.java.module.vegetable.provider.potato.impl;

import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;

public class PotatoProvider implements VegetableProvider {
    @Override
    public String provide() {
        return "potato";
    }
}
