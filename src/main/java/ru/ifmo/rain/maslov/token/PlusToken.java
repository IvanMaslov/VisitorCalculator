package ru.ifmo.rain.maslov.token;

public class PlusToken extends OperationToken {
    @Override
    public long calculate(final long a, final long b) {
        return a + b;
    }

    @Override
    public int priority() {
        return 1;
    }

    @Override
    public String getName() {
        return "PLUS";
    }
}
