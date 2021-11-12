package ru.ifmo.rain.maslov.visitor;

import ru.ifmo.rain.maslov.token.BraceToken;
import ru.ifmo.rain.maslov.token.NumberToken;
import ru.ifmo.rain.maslov.token.OperationToken;

public class PrintVisitor implements TokenVisitor {
    @Override
    public void visit(final NumberToken token) {
        System.out.print(token.getName() + " ");
    }

    @Override
    public void visit(final OperationToken token) {
        System.out.print(token.getName() + " ");
    }

    @Override
    public void visit(final BraceToken token) {
        System.out.print(token.getName() + " ");
    }
}
