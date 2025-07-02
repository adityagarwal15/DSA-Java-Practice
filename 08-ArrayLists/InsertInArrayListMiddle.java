import java.util.ArrayList;

public class InsertInArrayListMiddle {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        int elementToAdd = 25;
        int middleIndex = list.size() / 2;

        list.add(middleIndex, elementToAdd);

        System.out.println("Updated ArrayList: " + list);
    }
}
