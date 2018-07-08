package pl.com.psl.java.module.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.com.psl.java.module.provider.Provider;

public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    public static void main(String[] args) {
        LOGGER.info("Executing consumer one!");
        LOGGER.info("Trying to execute a provider...");
        Provider.execute();
    }
}
