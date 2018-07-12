package pl.com.psl.java.module.consumer;

import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;

import java.util.ServiceLoader;

public class VegetableConsumer {

    public static void main(String[] args) {
        System.out.println("Loading vegetable providers...");
        ServiceLoader<VegetableProvider> serviceLoader = ServiceLoader.load(VegetableProvider.class);
        serviceLoader.forEach(vegetableProvider -> System.out.println("Consuming " + vegetableProvider.provide()));
    }
}
