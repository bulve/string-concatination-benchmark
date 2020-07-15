package io.github.bulve;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class StringConcatenationBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String concatenationWithStringBuilder(StringConcatenationSetup setup) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String word : setup.wordsToConcatenate()) {
            stringBuilder.append(word);
        }
        return stringBuilder.toString();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String concatenationWithStringBuffer(StringConcatenationSetup setup) {
        StringBuffer stringBuffer = new StringBuffer();
        for(String word : setup.wordsToConcatenate()) {
            stringBuffer.append(word);
        }
        return stringBuffer.toString();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String concatenationWithAdditionOperator(StringConcatenationSetup setup) {
        String finalWord = "";
        for(String word : setup.wordsToConcatenate()) {
            finalWord = finalWord + word;
        }
        return finalWord;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String concatenationWithConcatMethod(StringConcatenationSetup setup) {
        String finalWord = "";
        for(String word : setup.wordsToConcatenate()) {
            finalWord.concat(word);
        }
        return finalWord;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String concatenationWithStringJoiner(StringConcatenationSetup setup) {
        StringJoiner stringJoiner = new StringJoiner("");
        for(String word : setup.wordsToConcatenate()) {
            stringJoiner.add(word);
        }
        return stringJoiner.toString();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String concatenationWithArraysToString(StringConcatenationSetup setup) {
        return Arrays.toString(setup.wordsToConcatenate().toArray());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String concatenationWithCollectionJoining(StringConcatenationSetup setup) {
        return setup.wordsToConcatenate().stream()
                .collect(Collectors.joining());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String concatenationWithStringJoin(StringConcatenationSetup setup) {
        return String.join("", setup.wordsToConcatenate());
    }
}
