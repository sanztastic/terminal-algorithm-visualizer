package com.example;

import com.example.state.AlgorithmTypeSelectionState;
import com.example.state.UIState;

public class AlgorithmVisualizer {
    private UIState state;
    
    AlgorithmVisualizer() {
        this.state = new AlgorithmTypeSelectionState(this);
    }

    public void start(){
        String input = state.printScreen();
        state.handleInput(input);
    }

    public UIState getState() {
        return state;
    }

    public void setState(UIState currentState) {
        this.state = currentState;
    }

}
