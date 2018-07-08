package pl.com.psl.java.module.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Provider {

    private static final Logger LOGGER = LoggerFactory.getLogger(Provider.class);

    public static void main(String[] args) {
        execute();
    }

    public static void execute() {
        LOGGER.info("Executing provider one!");
    }
}
