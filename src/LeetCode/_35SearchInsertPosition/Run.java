package LeetCode._35SearchInsertPosition;

public class Run {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int src[] = {1,3};

        int dst;

        dst = sol.searchInsert(src, 3);
        System.out.println(dst);

    }
}
