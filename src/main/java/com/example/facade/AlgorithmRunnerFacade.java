package com.example.facade;

import com.example.AlgorithmVisualizer;
import com.example.algorithms.Algorithm;

public class AlgorithmRunnerFacade {
    private Algorithm algorithm;
    private AlgorithmVisualizer algorithmVisualizer;

    public AlgorithmRunnerFacade(Algorithm algorithm, AlgorithmVisualizer algorithmVisualizer) {
        this.algorithm = algorithm;
        this.algorithmVisualizer = algorithmVisualizer;
    }

    public void runAlgorithm() {
        try {
            algorithm.visualize();
        }catch(InterruptedException ex){
            ex.printStackTrace();
            System.out.println(ex);
        }finally {
            algorithmVisualizer.start();
        }
    }
}
