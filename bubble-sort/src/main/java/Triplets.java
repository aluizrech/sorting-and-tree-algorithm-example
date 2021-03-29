import java.time.LocalDateTime;
import java.util.*;

public class Triplets {

    public static void main(String[] args) {
        List<Integer> d = new ArrayList<>();
        for(int i = 1; i < 4000; i++){
            d.add(i);
        }
        int t = 1000;


        System.out.println("Primeiro: "+ triplets(t, d));

        System.out.println("Segundo: "+triplets2(t, d));
    }

   public static int triplets2(long t, List<Integer> d) {
        int result = 0;
        for (int i = 0; i <= d.size() - 3; i++){
            int low = i + 1, high = d.size() - 1;

            while (low < high){
                if (d.get(i) + d.get(low) + d.get(high) > t) {
                    high--;
                }
                else {
                    for (int x = low + 1; x <= high; x++){
                        result++;
                    }
                    low++;
                }
            }
        }
        return result;
   }

    public static long triplets(long t, List<Integer> d){
        LocalDateTime inicio = LocalDateTime.now();
        System.out.println(inicio);

        long result = 0;

        for(int i = 0; i < d.size(); i++){
            for(int j = i; j < d.size(); j++){
                for(int k = j; k < d.size(); k++){
                    if (i != j && j != k && (d.get(i) + d.get(j) + d.get(k) <= t)){
                        result++;
                    }
                }
            }
        }
        System.out.println(LocalDateTime.now());
        return result;
    }

}
