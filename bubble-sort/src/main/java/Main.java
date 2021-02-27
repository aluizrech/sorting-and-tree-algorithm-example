import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] list = {5, 4, 3, 2, 1};
        System.out.println("** Initial list: " + Arrays.toString(list));

        System.out.println("** Final list: " + Arrays.toString(bubbleSort(list)));

    }

    public static int[] bubbleSort(int[] list){

        boolean sortedList = false;
        while(!sortedList){
            sortedList = true;
            for(int i = 0; (i < list.length && i+1 < list.length); i++){
                if(list[i] > list[i+1]){
                    int temp = list[i+1];
                    list[i+1] = list[i];
                    list[i] = temp;
                    sortedList = false;
                }
                System.out.println(Arrays.toString(list));
            }
        }

        return list;
    }

}
