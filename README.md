# Synopsis

This project provides examples/code snippets of Java Platform Module System.

# Motivation

Learning by doing.

# Usage

mvn clean package

then run the module:

java --module-path vegetable-consumer-module/target:vegetable-provider-module/vegetable-provider-api-module/target[:provider implementations path]:vegetable-processor-module/target --module vegetable.consumer.module/pl.com.psl.java.module.consumer.VegetableConsumer

e.g.:

java --module-path vegetable-consumer-module/target:vegetable-provider-module/vegetable-provider-api-module/target:vegetable-provider-module/cucumber-provider-module/target:vegetable-provider-module/potato-provider-module/target:vegetable-processor-module/target --module vegetable.consumer.module/pl.com.psl.java.module.consumer.VegetableConsumer

or build custom runtime image:

jlink --module-path $JAVA_HOME/jmods:vegetable-consumer-module/target:vegetable-provider-module/vegetable-provider-api-module/target:vegetable-provider-module/cucumber-provider-module/target:vegetable-provider-module/potato-provider-module/target:vegetable-processor-module/target --add-modules vegetable.consumer.module,cucumber.provider.module,potato.provider.module --output target/jlink-output/ --launcher launch=vegetable.consumer.module/pl.com.psl.java.module.consumer.VegetableConsumer

and run the launcher:

./target/jlink-output/bin/launch [plugins directory path]

optionally copy/remove jar containing a mapping file in [plugins directory path] to observe dynamic loading of service providers in runtime:

cp vegetable-provider-module/broccoli-provider-module/target/broccoli-provider-module-1.0-SNAPSHOT.jar [plugins directory path]