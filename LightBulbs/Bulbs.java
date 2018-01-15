public class Bulbs {
    public int bulbs(ArrayList<Integer> a) {
        int swaps = 0;
        int n = a.size();
        for(int i = 0; i < n; i++){
            if(a.get(i) == 0){
                for(int j = i; j < n; j++){
                    if(a.get(j) == 0) a.set(j, 1);
                    else if (a.get(j) == 1) a.set(j, 0);
                }
                swaps++;
            }
        }
        return swaps;
    }
}
