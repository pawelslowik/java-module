import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;

module vegetable.consumer.module {
    requires vegetable.processor.module;
    uses VegetableProvider;
}