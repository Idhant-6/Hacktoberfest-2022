public class SelectionSort {
	  
	  public static void sort(int arr[]){
	        int n = arr.length;
	 
	        for (int i=0; i<n-1;i++){
	          
	            int min_idx = i;
	            for (int j = i+1; j < n; j++)
	                if (arr[j] < arr[min_idx])
	                    min_idx = j;

	            int temp = arr[min_idx];
	            arr[min_idx] = arr[i];
	            arr[i] = temp;
	        }
	    }
	 
	    public static void main(String args[]){

	        int arr[] = {53,34,21,15,6};
	        int n=arr.length;
	        System.out.println("Array Before Sorting");
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	        sort(arr);
	        System.out.println("Sorted array");
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }
	}
