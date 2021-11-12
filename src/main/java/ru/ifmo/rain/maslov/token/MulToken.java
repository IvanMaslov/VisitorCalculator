package ru.ifmo.rain.maslov.token;

public class MulToken extends OperationToken {
    @Override
    public long calculate(final long a, final long b) {
        return a * b;
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public String getName() {
        return "MUL";
    }
}
