package com.javatech.labs8.acyclic;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.graph.DefaultEdge;

import javax.inject.Named;

@Named("CyclicFinder")
public class GraphCyclesFinder implements CyclesFinder {
    @Override
    public boolean isAcyclic(DirectedGraph<String, DefaultEdge> graph) {
        CycleDetector<String, DefaultEdge> cycleDetector
                = new CycleDetector<>(graph);
        return !cycleDetector.detectCycles();
    }
}
