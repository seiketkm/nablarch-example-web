package com.nablarch.example.app.web.handler;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.sql.DataSource;

import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.binder.db.PostgreSQLDatabaseMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmCompilationMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmHeapPressureMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.system.FileDescriptorMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import nablarch.core.repository.initialization.Initializable;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpRequestHandler;
import nablarch.fw.web.HttpResponse;

public class MetricsHandler implements HttpRequestHandler, Initializable {

	private PrometheusMeterRegistry registry;

	private final ConcurrentMap<String, Timer> timers = new ConcurrentHashMap<>();

	private DataSource dataSource;

	@Override
	public void initialize() {
		registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
		new JvmGcMetrics().bindTo(registry);
		new JvmHeapPressureMetrics().bindTo(registry);
		new JvmMemoryMetrics().bindTo(registry);
		new JvmThreadMetrics().bindTo(registry);
		new JvmCompilationMetrics().bindTo(registry);
		new PostgreSQLDatabaseMetrics(dataSource, "performance").bindTo(registry);
		new ProcessorMetrics().bindTo(registry);
		new FileDescriptorMetrics().bindTo(registry);
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public HttpResponse handle(HttpRequest request, ExecutionContext context) {
		String requestPath = request.getRequestPath();
		if (requestPath.equals("/api/metrics")) {
			HttpResponse response = new HttpResponse(200)
					.setContentType("text/plain")
					.write(registry.scrape());
			return response;
		}
		Timer timer = timers.get(requestPath);
		if (timer == null) {
			timer = Timer.builder("nablarch" + requestPath)
					.publishPercentiles(0.5, 0.9, 0.95, 0.99, 0.999)
					.serviceLevelObjectives(
							Duration.ofMillis(100),
							Duration.ofMillis(400),
							Duration.ofMillis(500),
							Duration.ofMillis(2000))
					.register(registry);
			Timer already = timers.putIfAbsent(requestPath, timer);
			if (already != null) {
				registry.remove(timer);
				timer = already;
			}
		}
		return timer.record(() -> context.handleNext(request));
	}
}
