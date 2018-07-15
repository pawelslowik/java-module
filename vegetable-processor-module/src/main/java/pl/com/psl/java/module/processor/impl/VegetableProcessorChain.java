package pl.com.psl.java.module.processor.impl;

import pl.com.psl.java.module.processor.VegetableProcessor;
import pl.com.psl.java.module.vegetable.provider.api.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class VegetableProcessorChain implements VegetableProcessor {

    private List<VegetableProcessor> vegetableProcessors = new ArrayList<>();

    public static VegetableProcessorChain of(VegetableProcessor vegetableProcessor) {
        return new VegetableProcessorChain(vegetableProcessor);
    }

    private VegetableProcessorChain(VegetableProcessor vegetableProcessor) {
        vegetableProcessors.add(vegetableProcessor);
    }

    public VegetableProcessorChain and(VegetableProcessor vegetableProcessor) {
        vegetableProcessors.add(vegetableProcessor);
        return this;
    }

    @Override
    public Vegetable process(Vegetable vegetable) {
        return vegetableProcessors.stream()
                .reduce((vproc1, vproc2) -> (Vegetable veg1) -> vproc1.process(vproc2.process(veg1)))
                .orElse((veg2) -> veg2)
                .process(vegetable);
    }
}
