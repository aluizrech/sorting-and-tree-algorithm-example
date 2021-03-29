import java.util.Arrays;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] list = {8, 22, 7, 9, 31, 19, 5, 13};
        System.out.println("** Initial list: " + Arrays.toString(list));

        System.out.println("** Final list: " + Arrays.toString(bubbleSort(list)));

    }

    public static int[] bubbleSort(int[] list){

        int numberOperations = 0;

        boolean sortedList = false;
        while(!sortedList){
            sortedList = true;
            for(int i = 0; (i < list.length && i+1 < list.length); i++){
                if(list[i] > list[i+1]){
                    int temp = list[i+1];
                    list[i+1] = list[i];
                    list[i] = temp;
                    sortedList = false;
                    numberOperations++;
                    System.out.println(Arrays.toString(list));
                }
            }
        }

        System.out.println("Number of operations: "+numberOperations);

        return list;
    }

    public static int LCSLength(String X, String Y, int m, int n, Map<String, Integer> lookup){
        if (m == 0 || n == 0) {
            return 0;
        }

        String key = m + "|" + n;

        if (!lookup.containsKey(key)){
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                lookup.put(key, LCSLength(X, Y, m - 1, n - 1, lookup) + 1);
            }
            else {
                lookup.put(key, Integer.max(LCSLength(X, Y, m, n-1, lookup),
                        LCSLength(X, Y, m - 1, n, lookup)));
            }
        }

        return lookup.get(key);
    }

    public static int longestSubsequence(String x, String y) {
        char charArrayX[] = x.toCharArray();
        char charArrayY[] = y.toCharArray();

        int n = charArrayX.length, m = charArrayY.length;

        int matrix[][] = new int[2000][2000];

        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                matrix[i][j] = 0;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (charArrayX[j - 1] == charArrayY[i - 1]){
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                }

                else {
                    matrix[i][j] = matrix[i][j - 1];
                }
            }
        }

        int amount = 0;
        for (int i = 1; i <= m; i++){
            amount = Math.max(amount, matrix[i][n]);
        }

        return amount;
    }

}
