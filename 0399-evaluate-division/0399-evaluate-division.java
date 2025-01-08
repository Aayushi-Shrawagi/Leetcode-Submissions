
import java.util.HashMap;

class Solution {
    HashMap<String,HashMap<String,Double>> graph;
    //object is stored in u->(v:w)

    Solution()
    {
        this.graph= new HashMap<>();
    }
    
    void addEdge(String u,String v,Double weight){
        HashMap<String,Double> edge1 = this.graph.getOrDefault(u,new HashMap<String,Double>());
        edge1.put(v, weight);
        graph.put(u, edge1);
        HashMap<String,Double> edge2 = this.graph.getOrDefault(v,new HashMap<String,Double>());
        edge2.put(u, 1/weight);
        graph.put(v, edge2);
    }
    //caller function to create the graph
    void CreateGraph(List<List<String>> equations, double[] values){
        for(int i=0;i<equations.size();i++){
            this.addEdge(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
    }

    //

    double getPathWeight(String start, String end, Set<String> visited, HashMap<String, HashMap<String, Double>> graph) {
        
        /* Rejection case. */
        if (!graph.containsKey(start)) 
            return -1.0;
        
        /* Accepting case. */
        if (graph.get(start).containsKey(end))
            return graph.get(start).get(end);
        
        visited.add(start);
        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                double productWeight = getPathWeight(neighbour.getKey(), end, visited, graph);
                if (productWeight != -1.0)
                    return neighbour.getValue() * productWeight;
            }
        }
        
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        CreateGraph(equations,values);
        double result[]=new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = getPathWeight(queries.get(i).get(0),queries.get(i).get(1), new HashSet<>(), graph);
        }  
        
        return result;

    }
}