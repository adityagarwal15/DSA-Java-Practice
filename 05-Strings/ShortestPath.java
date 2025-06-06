public class ShortestPath {

    public static void getPath(String path) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            if (dir == 'N') {
                y++;
            } else if (dir == 'S') {
                y--;
            } else if (dir == 'W') {
                x--;
            } else if (dir == 'E') {
                x++;
            }
        }

        //euclidean distance
        int xSquared = x * x;
        int ySquared = y * y;
        double shortestDistance = Math.sqrt(xSquared + ySquared);

        System.out.println("Final coordinates: (" + x + ", " + y + ")");
        System.out.println("Shortest path is: " + shortestDistance);
    }

    public static void main(String[] args) {
        String path = "WNEENESENNN";
        getPath(path);
    }
}
