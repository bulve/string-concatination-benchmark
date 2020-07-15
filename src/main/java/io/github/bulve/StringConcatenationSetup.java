package io.github.bulve;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@State(Scope.Benchmark)
public class StringConcatenationSetup {

    private static final int WORD_COUNT = 1000;

    private static final String[] WORDS = {"locate", "desert", "pluck", "mutual", "patrol", "nature", "excitement",
            "guerrilla", "variety", "is", "minimize", "season", "cell", "minority", "forestry", "functional",
            "expansion", "indoor", "clash", "spy", "need", "inspire", "vacuum", "waterfall", "swipe", "elbow", "error",
            "get", "slogan", "decoration", "rhetoric", "expression", "return", "cold", "dribble", "degree", "complex",
            "will", "freight", "average", "objective", "dream", "sketch", "rumor", "estimate", "distort", "chest",
            "novel", "course", "pat", "comfortable", "slap", "fee", "magnetic", "broccoli", "paradox", "insure",
            "listen", "censorship", "equip", "mutation", "cattle", "obligation", "temperature", "virtue", "husband",
            "endorse", "god", "budge", "insist", "noise", "loot", "button", "swop", "sick", "momentum", "follow",
            "redeem", "date", "fire", "pull", "admire", "excitement", "beer", "leave", "future", "permission",
            "obstacle", "keep", "loose", "mystery", "fragment", "disappear", "colony", "systematic", "dilemma",
            "cooperation", "publication", "computer", "discriminate"};

    private static Collection<String> RANDOM_WORDS;

    @Setup(Level.Iteration)
    public void setupState() {
        RANDOM_WORDS = getRandomizedWords();
    }

    public Collection<String> wordsToConcatenate() {
        return RANDOM_WORDS;
    }

    private Collection<String> getRandomizedWords() {
        return IntStream.range(0, WORD_COUNT)
                .mapToObj(num -> WORDS[ThreadLocalRandom.current().nextInt(WORDS.length-1)])
                .collect(Collectors.toList());
    }
}
