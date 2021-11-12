package ru.ifmo.rain.maslov;

import ru.ifmo.rain.maslov.token.Token;
import ru.ifmo.rain.maslov.token.Tokenizer;
import ru.ifmo.rain.maslov.visitor.CalcVisitor;
import ru.ifmo.rain.maslov.visitor.ParserVisitor;
import ru.ifmo.rain.maslov.visitor.PrintVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String expression = scanner.nextLine();
            Tokenizer tokenizer = new Tokenizer(expression);
            List<Token> tokens = new ArrayList<>();
            while (tokenizer.hasToken()) {
                tokens.add(tokenizer.nextToken());
            }

            // parse expression
            ParserVisitor parserVisitor = new ParserVisitor();
            for (final Token token : tokens) {
                token.accept(parserVisitor);
            }
            List<Token> rpn = parserVisitor.getReversePolishNotation();

            // print tokens
            PrintVisitor printVisitor = new PrintVisitor();
            for (final Token token : rpn) {
                token.accept(printVisitor);
            }
            System.out.println();

            // evaluate expression
            CalcVisitor calcVisitor = new CalcVisitor();
            for (final Token token : rpn) {
                token.accept(calcVisitor);
            }
            System.out.println("Result = " + calcVisitor.calculate());

        } catch (final RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
