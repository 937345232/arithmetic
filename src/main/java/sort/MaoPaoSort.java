package sort;

/**
 * @author jzx
 * @email: jiazhaoxin@ule.com
 * @Date: 2019-04-29 15:39
 */
public class MaoPaoSort {

    public static void main(String[] args) throws Exception {
        int[] arr = {30, 1, 4, 5, 65, 7, 878, 54, 434, 534, 534, 40, 60, 10, 20, 50, 70, 80, 90};
//        int[] arr = {30, 40, 60, 10, 20, 50};
        sort1(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i = " + arr[i]);
        }

    }

    public static void sort1(int arr[], int baseLeft, int baseRight) {
        if (baseLeft < baseRight) {
            int key = arr[baseLeft];
            int left = baseLeft;
            int right = baseRight;
            while (left < right) {
                while (left < right && arr[right] > key) right--;
                arr[left++] = arr[right];
                while (left < right && arr[left] < key) left++;
                arr[right--] = arr[left];
            }
            arr[left] = key;
            sort1(arr,baseLeft,left-1);
            sort1(arr,left+1,baseRight);


        }


    }


    public static void sort(int arr[], int baseLeft, int baseRight) {
        if (baseLeft < baseRight) {

            int key = arr[baseLeft];
            int leftIndex = baseLeft;
            int rightIndex = baseRight;


            while (leftIndex < rightIndex) {
                while (leftIndex < rightIndex && arr[rightIndex] > key) {
                    rightIndex--;
                }
                arr[leftIndex++] = arr[rightIndex];

                while (leftIndex < rightIndex && arr[leftIndex] < key) {
                    leftIndex++;
                }
                arr[rightIndex--] = arr[leftIndex];
            }

            arr[leftIndex] = key;
            sort(arr, baseLeft, leftIndex - 1);
            sort(arr, leftIndex + 1, baseRight);


        }

    }


    public static void quick_sort(int a[], int l, int r) throws InterruptedException {
        if (l < r) {
            int i, j, x;

            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while (i < j && a[j] > x)
                    j--; // 从右向左找第一个小于x的数
                if (i < j)
                    a[i++] = a[j];
                while (i < j && a[i] < x)
                    i++; // 从左向右找第一个大于x的数
                if (i < j)
                    a[j--] = a[i];
            }
            for (int ddd = 0; ddd < a.length; ddd++) {
                System.out.println("");
                System.out.print(a[ddd] + " ,");
            }
            Thread.sleep(5000);
            a[i] = x;
            quick_sort(a, l, i - 1); /* 递归调用 */
            quick_sort(a, i + 1, r); /* 递归调用 */
        }
    }
}
