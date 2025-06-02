import java.util.*;

public class LISO_nlogn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = sc.nextInt();
        }
        List<Integer> lis = new ArrayList<>();

        for(int num : a){
            int ind = Collections.binarySearch(lis, num);
            if(ind < 0){
                ind = -ind - 1;
            }

            if(ind == lis.size()){
                lis.add(num);
            }
            else{
                lis.set(ind, num);
            }

        }

        System.out.println(lis.size());
    }
}
