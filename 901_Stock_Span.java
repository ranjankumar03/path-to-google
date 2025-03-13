class StockSpanner {

    public static void main(String [] args) {

        int[] arr = {10, 4, 5, 90, 120, 80};

        int[] spanner = calculateSpanBrute(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(spanner[i] + " ");
        }
        
    }

    private static int[] calculateSpanBrute(int[] arr ) {
        int len = arr.length;

        int[] spanner  = new int[len];

        for(int i = 0; i < len; i++) {
            spanner[i] = 1;
        }

        for(int i = 1; i < len; i++) {
            for(int j = i-1; j>=0 && arr[i] >= arr[j]; j--) {
                spanner[i] = spanner[i] + 1;
            }

        }
        return spanner;
    }
    
}