package com.company;

public class NutsAndBolts {
  public static void main(String[] args)
  {
    // Nuts and bolts are represented as array of characters
    char nuts[] = {'@', '#', '$', '%', '^', '&'};
    char bolts[] = {'$', '%', '&', '^', '@', '#'};

    // Method based on quick sort which matches nuts and bolts
    matchPairs(nuts, bolts, 0, 5);

    System.out.println("Matched nuts and bolts are : ");
    printArray(nuts);
    printArray(bolts);
  }

  // Method to print the array
  private static void printArray(char[] arr) {
    for (char ch : arr){
      System.out.print(ch + " ");
    }
    System.out.print("\n");
  }

  private static void matchPairs(char[] nuts, char[] bolts, int low, int high){
    if(low<high){
      int pi = partition(nuts, low, high, bolts[high]);
      partition(bolts, low, high, nuts[pi]);
      matchPairs(nuts, bolts, low, pi-1);
      matchPairs(nuts, bolts, pi+1, high);
    }
  }

  private static int partition2(char[] arr, int low, int high, char pivot)
  {
    int i = low;
    char temp1, temp2;
    for (int j = low; j < high; j++)
    {
      if (arr[j] < pivot){
        temp1 = arr[i];
        arr[i] = arr[j];
        arr[j] = temp1;
        i++;
      } else if(arr[j] == pivot){
        temp1 = arr[j];
        arr[j] = arr[high];
        arr[high] = temp1;
        j--;
      }
    }
    temp2 = arr[i];
    arr[i] = arr[high];
    arr[high] = temp2;

    // Return the partition index of an array based on the pivot
    // element of other array.
    return i;
  }

  private static int partition(char[] arr, int left, int right, char pivotValue){
    while(left<=right){
      while(arr[left]<pivotValue)
        left++;
      while(arr[right]>pivotValue)
        right--;

      if(left<=right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++; right--;
      }

    }

    return left;
  }
}
