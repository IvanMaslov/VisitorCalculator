package ru.ifmo.rain.maslov.visitor;

import ru.ifmo.rain.maslov.token.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParserVisitor implements TokenVisitor {
    final Stack<Token> stack = new Stack<>();
    final List<Token> result = new ArrayList<>();

    @Override
    public void visit(final NumberToken token) {
        result.add(token);
    }

    @Override
    public void visit(final OperationToken token) {
        while (!stack.empty() && stack.peek() instanceof OperationToken && ((OperationToken) stack.peek()).priority() <= token.priority()) {
            result.add(stack.pop());
        }
        stack.push(token);
    }

    @Override
    public void visit(final BraceToken token) {
        if (token instanceof LeftBraceToken) {
            stack.push(token);
        } else if (token instanceof RightBraceToken) {
            boolean isEmpty = true;
            while (!stack.empty() && !(stack.peek() instanceof LeftBraceToken)) {
                result.add(stack.pop());
                isEmpty = false;
            }
            if (stack.empty()) {
                throw new VisitorException("No left brace");
            }
            if (isEmpty) {
                throw new VisitorException("Incorrect brace expression");
            }
            stack.pop();
        } else {
            throw new VisitorException("Unknown brace type");
        }
    }

    public List<Token> getReversePolishNotation() {
        while (!stack.isEmpty()) {
            final Token token = stack.pop();
            if (!(token instanceof OperationToken)) {
                throw new VisitorException("Incorrect expression");
            }
            result.add(token);
        }
        return result;
    }
}
