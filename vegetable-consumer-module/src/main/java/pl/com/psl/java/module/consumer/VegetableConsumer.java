package pl.com.psl.java.module.consumer;

import pl.com.psl.java.module.processor.VegetableProcessor;
import pl.com.psl.java.module.processor.impl.VegetableProcessorChain;
import pl.com.psl.java.module.processor.impl.grilling.GrillingProcessor;
import pl.com.psl.java.module.processor.impl.peeling.PeelingProcessor;
import pl.com.psl.java.module.processor.impl.slicing.SlicingProcessor;
import pl.com.psl.java.module.vegetable.provider.api.Vegetable;
import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;

import java.util.ServiceLoader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VegetableConsumer {

    public static void main(String[] args) {
        System.out.println("Running vegetable consumer");
        VegetableProcessor vegetableProcessor = VegetableProcessorChain
                .of(new PeelingProcessor())
                .and(new SlicingProcessor())
                .and(new GrillingProcessor());

        ScheduledExecutorService vegetableConsumerExecutor = Executors.newSingleThreadScheduledExecutor();
        vegetableConsumerExecutor.scheduleAtFixedRate(() -> {
            System.out.println("Loading vegetable providers...");
            ServiceLoader<VegetableProvider> serviceLoader = ServiceLoader.load(VegetableProvider.class);
            System.out.println("Loaded " + serviceLoader.stream().count() + " vegetable providers");
            serviceLoader.forEach(vegetableProvider -> {
                Vegetable processedVegetable = vegetableProcessor.process(vegetableProvider.provide());
                System.out.println("Consuming " + processedVegetable.getName());
            });
        }, 0, 5, TimeUnit.SECONDS);
    }
}
