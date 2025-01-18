import java.util.Arrays;

public class MergeSort {
// static ArrayList<Integer> temp=new ArrayList<>();

    public static void merge(int[] arr,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int left=low;
        int right=mid+1,k=0;
        while (left<=mid && right<=high) {
            if (arr[left]<=arr[right]) {
                temp[k++]=arr[left];
                left++;
            }else{
                temp[k++]=arr[right];
                right++;
            }
        }

        while (left<=mid) {
            temp[k++]=arr[left];
            left++;
        }
        while (right<=high) {
            temp[k++]=arr[right];
            right++;
        }

        
        System.arraycopy(temp, 0, arr, low, temp.length);
    
    

    }

    public static void mergeSort(int[] arr,int low, int high){
        if (low<high) {
        int mid=(low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr,low,mid,high);
        }

            
    
    }


    public static void main(String[] args) {
        int[] arr={1,5,3,2,9,5,6};
        mergeSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));

    
    }
}
