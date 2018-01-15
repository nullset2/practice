public class BinSearch{
    public static int binSearch(int toFind, int[] array, int low, int high){
        if(low > high) return -1;
        int mid = (high + low)/2;
        if(array[mid] == toFind) return mid;

        if(array[mid] < toFind)
            return binSearch(toFind, array, mid+1, high);
            
        return binSearch(toFind, array, low, mid-1);
    }

    public static void main(String[] args){
        int[] input = {5, 10, 15, 20, 25, 30, 35};
        System.out.println(binSearch(15, input, 0, input.length - 1));
    }
}
