package pl.com.psl.java.module.consumer;

import pl.com.psl.java.module.processor.VegetableProcessor;
import pl.com.psl.java.module.processor.impl.grilling.GrillingProcessor;
import pl.com.psl.java.module.vegetable.provider.api.Vegetable;
import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;

import java.util.ServiceLoader;

public class VegetableConsumer {

    public static void main(String[] args) {
        ServiceLoader<VegetableProvider> serviceLoader = ServiceLoader.load(VegetableProvider.class);
        VegetableProcessor vegetableProcessor = new GrillingProcessor();
        serviceLoader.forEach(vegetableProvider -> {
            Vegetable processedVegetable = vegetableProcessor.process(vegetableProvider.provide());
            System.out.println("Consuming " + processedVegetable.getName());
        });
    }
}
