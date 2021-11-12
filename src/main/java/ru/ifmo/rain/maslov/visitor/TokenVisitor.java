package ru.ifmo.rain.maslov.visitor;

import ru.ifmo.rain.maslov.token.BraceToken;
import ru.ifmo.rain.maslov.token.NumberToken;
import ru.ifmo.rain.maslov.token.OperationToken;

public interface TokenVisitor {
    void visit(NumberToken token);

    void visit(OperationToken token);

    void visit(BraceToken token);
}
