import java.util.*;

class ElevatorRides {

    static class State implements Comparable<State> {
        int rides;
        int lastWeight;

        State(int rides, int lastWeight){
            this.rides = rides;
            this.lastWeight = lastWeight;
        }

        @Override
        public int compareTo(State other){
            if(this.rides != other.rides){
                return Integer.compare(this.rides, other.rides);
            }
            return Integer.compare(this.lastWeight, other.lastWeight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        State[] dp = new State[1<<n];
        dp[0] = new State(1, 0);

        for(int xx = 1; xx<(1<<n) ; xx++){
            dp[xx] = new State(n+1, 0); //;arge initial value


            for(int per = 0; per<n ; per++){
                if((xx & (1<<per)) != 0){ //if the person is not already in the set
                    int prevxx = xx ^ (1<<per); //removing the current person
                    State prevState = dp[prevxx];

                    int rides = prevState.rides;
                    int lastWeight = prevState.lastWeight;

                    if(lastWeight + arr[per] > x){
                        //new ride required;
                        rides++;
                        lastWeight = arr[per];
                    }
                    else{
                        lastWeight += arr[per];
                    }
                    State newState = new State(rides, lastWeight);
                    if(newState.compareTo(dp[xx]) < 0){
                        dp[xx] = newState;
                    }
                }
            }
        } 
        System.out.println(dp[(1<<n) - 1].rides);
    }
}