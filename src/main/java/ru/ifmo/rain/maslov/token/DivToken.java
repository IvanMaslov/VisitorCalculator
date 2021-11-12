package ru.ifmo.rain.maslov.token;

public class DivToken extends OperationToken {
    @Override
    public long calculate(final long a, final long b) {
        if (b == 0) {
            throw new TokenException("Division by zero");
        }
        return a / b;
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public String getName() {
        return "DIV";
    }
}
