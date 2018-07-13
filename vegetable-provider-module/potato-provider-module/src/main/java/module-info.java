import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;
import pl.com.psl.java.module.vegetable.provider.impl.potato.PotatoProvider;

module potato.provider.module {
    requires vegetable.provider.api.module;
    provides VegetableProvider with PotatoProvider;
}