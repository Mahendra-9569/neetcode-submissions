class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> list = new ArrayList<>();

        int idx = Arrays.binarySearch(arr, x);
        if (idx < 0) {
            idx = -(idx + 1);
        }

        int left = idx - 1;
        int right = idx;

        while (k > 0) {

            if (left < 0) {
                list.add(arr[right++]);
            }
            else if (right >= arr.length) {
                list.add(0, arr[left--]);
            }
            else if (x - arr[left] <= arr[right] - x) {
                list.add(0, arr[left--]);
            }
            else {
                list.add(arr[right++]);
            }

            k--;
        }

        return list;
    }
}