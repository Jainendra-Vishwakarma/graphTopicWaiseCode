import java.util.*;
public class PrerequisitesCode {
    static class pair{
        int first;
        int second;
        public  pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static ArrayList<ArrayList<Integer>> make_graph(int numTask, Vector<pair> prerequisites){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numTask);
        for (int i = 0; i < numTask; i++) {
            graph.add(new ArrayList<>());
        }
        for (pair pre : prerequisites) {
            graph.get(pre.second).add(pre.first);
        }
        return graph;
    }

    static int [] compute_indgree(ArrayList<ArrayList<Integer>> graph){

        int degrees[] = new int[graph.size()];

        for (ArrayList<Integer> neighbors : graph){
            for (int neigh : neighbors){
                degrees[neigh]++;
            }
        }
        return degrees;
    }

    static boolean canFinish(int numTask, Vector<pair> prerequisites){
        ArrayList<ArrayList<Integer>> graph = make_graph(numTask, prerequisites);
        int degrees[] = compute_indgree(graph);

        for (int i = 0; i < numTask; i++){
            int j =0;
            for (; j <numTask; i++){
                if (degrees[j] == 0){
                    break;
                }
            }
            if (j == numTask){
                return false;
            }
            degrees[j] = -1;
            for (int neigh : graph.get(j)){
                degrees[neigh]--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int numTasks = 4;

        Vector<pair> prerequisites = new Vector<>();

        prerequisites.add(new pair(1, 0));
        prerequisites.add(new pair(2,1));
        prerequisites.add(new pair(3,2));

        if (canFinish(numTasks, prerequisites)){
            System.out.println("Possible to finish all tasks");
        } else {
            System.out.println("Impossible to finish all tasks");
        }
    }
}
