package ru.ifmo.rain.maslov.token;

import ru.ifmo.rain.maslov.visitor.TokenVisitor;

public abstract class BraceToken implements Token {
    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
