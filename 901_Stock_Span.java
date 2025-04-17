import java.util.Stack;

class StockSpanner {

    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 90, 120, 80};

        int[] spanner = calculateSpanOptimized(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(spanner[i] + " ");
        }
    }

    private static int[] calculateSpanOptimized(int[] arr) {
        int len = arr.length;
        int[] spanner = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            // Pop elements from the stack while the current price is greater than or equal to the price at the stack's top index
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            // If the stack is empty, it means all previous prices are smaller, so span is i + 1
            spanner[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            // Push the current index onto the stack
            stack.push(i);
        }

        return spanner;
    }
}