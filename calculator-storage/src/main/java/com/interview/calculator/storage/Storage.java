package com.interview.calculator.storage;

public interface Storage {

    void store(String op);

    String[] pop(String op);

    void undo();

    void clear();

    String out();

    void capture();
}
