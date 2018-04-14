class Dijkstra {

    private final int INF = 999999;

    private int[][] array;
    private int[] distance;
    private boolean[] visited;
    private int n, v;

    Dijkstra(int[][] array, int n) {

        this.array = array;
        this.n = n;

        v = array.length;
        distance = new int[v];
        visited = new boolean[v];
        for (int i = 0; i < v; i++) distance[i] = INF;
    }

    public void expression () {
        distance[n] = 0;
        for (int i = 0; i < v; i++) {
            int curPoint = -1;
            for (int j = 0; j < v; j++)
                if (!visited[j] && (curPoint == -1 || distance[j] < distance[curPoint]))
                    curPoint = j;
            if (curPoint == -1) break;
            visited[curPoint] = true;

            for (int j = 0; j < v; j++) {
                if (!visited[j] && distance[curPoint] != INF && distance[curPoint] + array[curPoint][j] < distance[j])
                    distance[j] = distance[curPoint] + array[curPoint][j];
            }
        }
        System.out.println("Minimal distance from start point to other:\n");
        for (int i = 0; i < v; i++) {
            if (distance[i] != INF)
                System.out.printf("%d --> %d = %d\n", n + 1, i + 1, distance[i]);
            else
                System.out.printf("%d --> %d = Connection is not available\n", n + 1, i + 1);
        }
    }
}