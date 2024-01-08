package leetcode.toposort;

import java.util.LinkedList;

/**
 * 拓扑排序算法
 */
public class TopoSort {


    public class Graph {
        private int v;
        // 顶点的个数
        private LinkedList<Integer>[] adj;
        // 邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // s 先于 t，边 s->t
            adj[s].add(t);
        }

        /**
         * Kahn算法，贪心算法的本质，也可以理解为广度优先算法
         */
        public void topoSortByKahn() {
            int[] inDegree = new int[v]; // 统计每个顶点的入度
            for (int i = 0; i < v; ++i) {
                for (int j = 0; j < adj[i].size(); ++j) {
                    int w = (int) adj[i].get(j); // i->w
                    inDegree[w]++;
                }
            }
            // 队列中记录入度为0的点
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < v; ++i) {
                if (inDegree[i] == 0)
                    queue.add(i);
            }
            while (!queue.isEmpty()) {
                int i = queue.remove();
                System.out.print("->" + i);
                for (int j = 0; j < adj[i].size(); ++j) {
                    int k = (int) adj[i].get(j);
                    inDegree[k]--;
                    if (inDegree[k] == 0)
                        queue.add(k);
                }
            }
        }


        /*-------------------------------------------------------------------------*/


        /**
         * 深度优先搜索的拓扑排序
         */
        public void topoSortByDFS() {
            // 先构建逆邻接表，边 s->t 表示，s 依赖于 t，t 先于 s
            LinkedList<Integer> inverseAdj[] = new LinkedList[v];
            for (int i = 0; i < v; ++i) { // 申请空间
                inverseAdj[i] = new LinkedList<>();
            }
            for (int i = 0; i < v; ++i) { // 通过邻接表生成逆邻接表
                for (int j = 0; j < adj[i].size(); ++j) {
                    int w = adj[i].get(j); // i->w
                    inverseAdj[w].add(i); // w->i
                }
            }
            boolean[] visited = new boolean[v];
            for (int i = 0; i < v; ++i) { // 深度优先遍历图
                if (visited[i] == false) {
                    visited[i] = true;
                    dfs(i, inverseAdj, visited);
                }
            }
        }

        private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
            for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
                int w = inverseAdj[vertex].get(i);
                if (visited[w] == true) continue;
                visited[w] = true;
                dfs(w, inverseAdj, visited);
            }
            // 先把 vertex 这个顶点可达的所有顶点都打印出来之后，再打印它自己
            System.out.print("->" + vertex);
        }
    }
}
