import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;
import pl.com.psl.java.module.vegetable.provider.impl.broccoli.BroccoliProvider;

module broccoli.provider.module {
    requires vegetable.provider.api.module;
    provides VegetableProvider with BroccoliProvider;
}