package ru.ifmo.rain.maslov.token;

import ru.ifmo.rain.maslov.visitor.TokenVisitor;

public interface Token {
    String getName();

    void accept(TokenVisitor visitor);
}
