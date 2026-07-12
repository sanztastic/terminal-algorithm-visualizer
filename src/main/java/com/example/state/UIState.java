package com.example.state;

import java.util.Scanner;

public interface UIState {
    String printScreen(Scanner scanner);
    void handleInput(String input);
}
