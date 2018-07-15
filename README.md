# Synopsis

This project provides examples/code snippets of Java Platform Module System.

# Motivation

Learning by doing.

# Usage

mvn clean package

then

java --module-path vegetable-consumer-module/target:vegetable-provider-module/vegetable-provider-api-module/target[:provider implementations path]:vegetable-processor-module/target --module vegetable.consumer.module/pl.com.psl.java.module.consumer.VegetableConsumer

e.g.:

java --module-path vegetable-consumer-module/target:vegetable-provider-module/vegetable-provider-api-module/target:vegetable-provider-module/cucumber-provider-module/target:vegetable-provider-module/potato-provider-module/target:vegetable-processor-module/target --module vegetable.consumer.module/pl.com.psl.java.module.consumer.VegetableConsumer
