package com.example;

import java.util.Scanner;
import com.example.state.AlgorithmTypeSelectionState;
import com.example.state.UIState;

public class AlgorithmVisualizer {
    private UIState state;
    private Scanner scanner;
    
    AlgorithmVisualizer(Scanner scanner) {
        this.state = new AlgorithmTypeSelectionState(this);
        this.scanner = scanner;
    }

    public void start(){
        String input = state.printScreen(scanner);
        state.handleInput(input);
    }

    public UIState getState() {
        return state;
    }

    public void setState(UIState currentState) {
        this.state = currentState;
    }

}
