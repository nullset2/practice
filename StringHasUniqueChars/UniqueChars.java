class UniqueChars{
    static boolean hasUniqueChars(String s){
        int[] counts = new int[256];
        for(char c : s.toCharArray()){
            if(counts[c] == 1) return false;
            counts[c] = 1;
        }

        return true;
    }
    public static void main(String[] args){
        System.out.println(hasUniqueChars(args[0]));
    }
}

