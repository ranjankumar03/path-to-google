package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxMin{
    public static void main(String[] args){

        int[] input = {1,4,7,2};
        List<Integer> arr = Arrays.stream(input).boxed().collect(Collectors.toList());
        System.out.println(maxmin(2, arr));
    }

    private static int maxmin(int k, List<Integer> arr) {

        Collections.sort(arr);

        int min = Integer.MAX_VALUE;

        for(int i=0; i<(arr.size() - k + 1 ); i++) {
            min = Math.min(min, arr.get(i + k -1) - arr.get(i));
        }
        return min;

    }
}