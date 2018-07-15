open module vegetable.processor.module {
    requires transitive vegetable.provider.api.module;
    exports pl.com.psl.java.module.processor;
    exports pl.com.psl.java.module.processor.impl;
    exports pl.com.psl.java.module.processor.impl.grilling;
    exports pl.com.psl.java.module.processor.impl.slicing;
    exports pl.com.psl.java.module.processor.impl.peeling;
}