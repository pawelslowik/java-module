import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;

module vegetable.consumer.module {
    requires vegetable.provider.api.module;
    uses VegetableProvider;
}