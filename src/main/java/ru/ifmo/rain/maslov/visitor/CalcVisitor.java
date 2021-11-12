package ru.ifmo.rain.maslov.visitor;

import ru.ifmo.rain.maslov.token.BraceToken;
import ru.ifmo.rain.maslov.token.NumberToken;
import ru.ifmo.rain.maslov.token.OperationToken;

import java.util.Stack;

public class CalcVisitor implements TokenVisitor {
    final Stack<Long> stack = new Stack<>();

    @Override
    public void visit(final NumberToken token) {
        stack.push(token.getValue());
    }

    @Override
    public void visit(final OperationToken token) {
        if (stack.size() < 2) {
            throw new VisitorException("Incorrect expression");
        }
        final long rhs = stack.pop();
        final long lhs = stack.pop();
        stack.push(token.calculate(lhs, rhs));
    }

    public long calculate() {
        if (stack.size() != 1) {
            throw new VisitorException("Incorrect expression");
        }
        return stack.pop();
    }

    @Override
    public void visit(final BraceToken token) {
        throw new VisitorException("Can not visit BraceToken");
    }
}
