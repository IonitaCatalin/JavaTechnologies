package com.javatech.labs8.acyclic;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public interface CyclesFinder {

    boolean isAcyclic(DirectedGraph<String, DefaultEdge> graph);
}
