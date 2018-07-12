package pl.com.psl.java.module.vegetable.provider.cucumber.impl;

import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;

public class CucumberProvider implements VegetableProvider {
    @Override
    public String provide() {
        return "cucumber";
    }
}
