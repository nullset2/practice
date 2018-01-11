public class Main {

    public static void main(String[] args) {
        int[] data = {-7, -6, -5, -4, 0, 4, 5, 6, 7};

        System.out.println(binsearch(data, -7, 0, data.length-1));
        System.out.println(binsearch(data, -7));
    }

    private static int binsearch(int[] data, int toFind) {
        int low = 0;
        int high = data.length-1;

        while(high >= low){
            int mid = (low + high)/2;

            if(data[mid] > toFind)
                high = mid-1;
            else if(data[mid] < toFind)
                low = mid+1;
            else if(data[mid] == toFind)
                return mid;
        }
        return -1;
    }

    private static int binsearch(int[] data, int toFind, int low, int high){
        if(high < low) return -1;

        int mid = (low + high)/2;

        if(data[mid] == toFind)
            return mid;
        else if(toFind > data[mid]){
            return binsearch(data, toFind, mid+1, high);
        }
        return binsearch(data, toFind, low, mid-1);
    }
}
