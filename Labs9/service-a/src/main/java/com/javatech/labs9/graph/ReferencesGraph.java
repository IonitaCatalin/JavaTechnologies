package com.javatech.labs9.graph;

import java.util.*;

public class ReferencesGraph {

    private final List<Long> nodeList;
    private final Map<Long, List<Long>> edgeList;

    public ReferencesGraph(Map<Long, List<Long>> entries) {
        nodeList = new ArrayList<>();
        edgeList = new HashMap<>();

        for(Map.Entry<Long,List<Long>> entry : entries.entrySet()) {
            nodeList.add(entry.getKey());
            edgeList.put(entry.getKey(), entry.getValue());
        }

        System.out.println(entries.toString());

    }

    public boolean hasCycle(){
        Map<Long, Boolean> visited = new HashMap<>();

        for(Long node: nodeList){
            visited.put(node, false);
        }

        List<Long> tempListOfNodes = new ArrayList<>(nodeList);
        Queue<Long> queue = new LinkedList<>();

        queue.add(nodeList.get(0));

        while(tempListOfNodes.size() != 0){
            if(queue.isEmpty()){

                queue.add(tempListOfNodes.get(0));
                tempListOfNodes.remove(tempListOfNodes.get(0));
                for(Long node: nodeList){
                    visited.put(node, false);
                }
            }

            Long node = queue.poll();
            tempListOfNodes.remove(node);
            visited.put(node, true);
            for(Long adj: edgeList.get(node)){
                if(visited.get(adj)){
                    return true;
                }
                queue.add(adj);
            }
        }
        return false;
    }

    public List<Long> getNodeList() {
        return nodeList;
    }

    public Map<Long, List<Long>> getEdgeList() {
        return edgeList;
    }

}
