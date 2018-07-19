package pl.com.psl.java.module.consumer;

import pl.com.psl.java.module.processor.VegetableProcessor;
import pl.com.psl.java.module.processor.impl.VegetableProcessorChain;
import pl.com.psl.java.module.processor.impl.grilling.GrillingProcessor;
import pl.com.psl.java.module.processor.impl.peeling.PeelingProcessor;
import pl.com.psl.java.module.processor.impl.slicing.SlicingProcessor;
import pl.com.psl.java.module.vegetable.provider.api.Vegetable;
import pl.com.psl.java.module.vegetable.provider.api.VegetableProvider;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
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

        Arrays.stream(VegetableProcessorChain.class.getDeclaredFields()).forEach(field -> field.setAccessible(true));
        Optional<Path> pluginsDirectoryPath = getPluginsDirectoryPath(args);

        ScheduledExecutorService vegetableConsumerExecutor = Executors.newSingleThreadScheduledExecutor();
        vegetableConsumerExecutor.scheduleAtFixedRate(() -> pluginsDirectoryPath.ifPresentOrElse(
                    path -> loadPluginsAndConsumeWithServiceProviders(vegetableProcessor, path),
                    () -> consumeWithServiceProviders(vegetableProcessor, Thread.currentThread().getContextClassLoader())),
                0, 5, TimeUnit.SECONDS);
    }

    private static void loadPluginsAndConsumeWithServiceProviders(VegetableProcessor vegetableProcessor, Path pluginsDirectoryPath) {
        URL[] pluginsUrls = new URL[]{};
        if(Files.exists(pluginsDirectoryPath) && Files.isDirectory(pluginsDirectoryPath)) {
            try {
                pluginsUrls = Files.list(pluginsDirectoryPath)
                        .filter(p -> p.toString().endsWith(".jar"))
                        .map(p -> {
                            try {
                                System.out.println("Found plugin " + p);
                                return p.toUri().toURL();
                            } catch (MalformedURLException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .toArray(URL[]::new);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        consumeWithServiceProviders(vegetableProcessor, new URLClassLoader(pluginsUrls));
    }

    private static void consumeWithServiceProviders(VegetableProcessor vegetableProcessor, ClassLoader classLoader) {
        System.out.println("Loading vegetable providers...");
        ServiceLoader<VegetableProvider> serviceLoader =
                ServiceLoader.load(VegetableProvider.class, classLoader);
        System.out.println("Loaded " + serviceLoader.stream().count() + " vegetable providers");
        serviceLoader.forEach(vegetableProvider -> {
            Vegetable processedVegetable = vegetableProcessor.process(vegetableProvider.provide());
            System.out.println("Consuming " + processedVegetable.getName());
        });
    }

    private static Optional<Path> getPluginsDirectoryPath(String[] args) {
        if(args != null && args.length > 0 && args[0] != null) {
            return Optional.of(Paths.get(args[0]));
        }
        return Optional.empty();
    }
}
