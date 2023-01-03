package org.example;

import io.micronaut.context.ApplicationContext;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Fork(100)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.SingleShotTime)
public class StartupBenchmark {

    @Benchmark
    public void startup(Blackhole bh) {
        ApplicationContext context = ApplicationContext.builder().deduceEnvironment(false).start();
        HelloWorldController controller = context.getBean(HelloWorldController.class);
        bh.consume(controller);
    }
}