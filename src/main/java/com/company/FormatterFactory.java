package com.company;

public class FormatterFactory {
    final String NORMAL = "Normal";

    Formatter getFormatter(String formatterName) {
        if (NORMAL.equals(formatterName)){
            return new FormatterImpl();
        }
        return null;
    }
}
