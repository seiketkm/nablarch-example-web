package com.nablarch.example.app.metrics;

import io.micrometer.core.instrument.binder.MeterBinder;
import io.micrometer.core.instrument.binder.tomcat.TomcatMetrics;
import nablarch.integration.micrometer.MeterBinderListProvider;

import java.util.Arrays;
import java.util.List;

public class CustomMeterBinderListProvider implements MeterBinderListProvider {

    @Override
    public List<MeterBinder> provide() {
        return Arrays.asList(
            new TomcatMetrics(null, Arrays.asList())
        );
    }
}
