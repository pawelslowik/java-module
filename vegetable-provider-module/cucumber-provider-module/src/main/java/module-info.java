import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;
import pl.com.psl.java.module.vegetable.provider.cucumber.impl.CucumberProvider;

module cucumber.provider.module {
    requires vegetable.provider.api.module;
    provides VegetableProvider with CucumberProvider;
}