import java.io.*;
import java.util.*;
public class Merge{

  /*merge takes two sorted arrays and returns a new array that combines all
  *elements of both arrays in asorted order.
  *@left a sorted array (this is a precondition)
  *@right a sorted array (this is a precondition)
  *@return a sorted array that contains all elements of left and right
  */
  public static int [] merge(int [] left, int[] right){
    int[] resAry = new int[left.length + right.length];
    int i = 0;
    int j = 0;
    int k = 0;
    while (k < resAry.length){
      if (i != left.length && j != right.length){
        if (left[i] == right[j]){
          resAry[k] = left[i];
          i +=1;
          k +=1;
        }else{
          if (left[i] < right[j]){
            resAry[k] = left[i];
            i +=1;
            k +=1;
          }else{
            resAry[k] = right[j];
            j +=1;
            k +=1;
          }
        }
          }else{
            if (i == left.length){
              resAry[k] = right[j];
              j +=1;
              k +=1;
            }else{
              resAry[k] = left[i];
              i +=1;
              k +=1;
            }
          }
    }
    return resAry;
  }

  public static int increment(int[] data){
    if (data.length % 2 != 0){
      return 1;
    }
    return 0;
  }

  /*mergesortH is the actual mergesort method.
  *@data the array to be sorted
  *@return a new array that is the sorted version of data.
  */
  public static int[] left(int[] data){
    int[] left = new int[data.length/2];
    for (int l = 0; l < data.length/2; l +=1){
      left[l] = data[l];
    }
    return left;
  }

  public static int[] right(int[] data){
    int[] right = new int[data.length/2 + increment(data)];
    for (int r = 0; r < right.length; r +=1){
      right[r] = data[r + data.length/2];
    }
    return right;
  }


  public static int[] mergesortH(int [] data){
    if (data.length > 1){
      int[] left = left(data);
      int[] right = right(data);
      left = mergesortH(left);
      right = mergesortH(right);
      return merge(left, right);
    }else{
      return data;
    }
  }


  /*mergesort uses the recursive mergesortH method to create a sorted
  *version of the array. It then copies the data back into the original
  *array. (This is for compatibility with prior sort testers)
  *@param data the array to be sorted, this will be modified by the method
  */
  public static void mergesort(int [] data){
    int [] temp  =  mergesortH(data);
    for(int i = 0; i < data.length; i++){
      data[i] = temp[i];
    }
  }

  //mergesortTester
  public static int random(){
    return (int)(Math.random() * (5001));
  }

  public static void fillInt(int[] arr){
    for (int i = 0; i < arr.length; i +=1){
      if (Math.random() < 0.5){
      arr[i] = -1 * random();
    }else{
      arr[i] = random();
      }
    }
  }

  public static void mergesortTester(int numCases, int size){
    int failed = 0;
    for (int i = 0; i < numCases; i +=1){
      int[]mergesort = new int[size];
      fillInt(mergesort);
        int[]arysort = mergesort.clone();
        int[]unsorted = mergesort.clone();
        mergesort(mergesort);
        Arrays.sort(arysort);
        if (!Arrays.equals(mergesort, arysort)){
          failed +=1;
          System.out.println("Failed case: "+Arrays.toString(unsorted));
          System.out.println("Length: "+unsorted.length);
          System.out.println("mergesort: "+Arrays.toString(mergesort));
          System.out.println("Arrays.sort: "+Arrays.toString(arysort));
        }
      }
      if (failed == 0){
        System.out.println("All cases passed");
      }
  }

public static void main(String[] args) {

  long start = System.currentTimeMillis();
  mergesortTester(1000, 500);
  long millis = System.currentTimeMillis() - start;
  System.out.println(millis + " milliseconds");
  System.out.println();

  long startOne = System.currentTimeMillis();
  mergesortTester(1, 1000000);
  long millisOne = System.currentTimeMillis() - startOne;
  System.out.println(millisOne + " milliseconds");
  System.out.println();

  int[] test = new int[]{38, 27, 43, 3, 9, 82, 10};
  mergesort(test);
  System.out.println(Arrays.toString(test));

  int[] testOne = new int[]{94, -83, 50, -52, 6, 72, -33, -33, 61, 61, 61};
  mergesort(testOne);
  System.out.println(Arrays.toString(testOne));

}
}
