package org.example;

import java.util.*;
import org.antlr.v4.runtime.*;

public class TokenNormalizer {

    public static List<String> normalizeTokens(CommonTokenStream tokens) {
        List<String> result = new ArrayList<>();

        for (Token token : tokens.getTokens()) {
            int type = token.getType();
            String text = token.getText();

            // Пропускаем пробелы, комментарии и служебное
            if (type == Token.EOF || text.trim().isEmpty()) continue;

            if (isIdentifier(type)) {
                result.add("id");
            } else if (isLiteral(type)) {
                result.add("lit");
            } else {
                result.add(text);
            }
        }

        return result;
    }

    // Пример: для Java грамматики
    private static boolean isIdentifier(int type) {
        // Уточни значение у твоего lexer'а
        return type == Java8Lexer.Identifier;
    }

    private static boolean isLiteral(int type) {
        return type == Java8Lexer.IntegerLiteral
                || type == Java8Lexer.FloatingPointLiteral
                || type == Java8Lexer.BooleanLiteral
                || type == Java8Lexer.CharacterLiteral
                || type == Java8Lexer.StringLiteral
                || type == Java8Lexer.NullLiteral;
    }
}

