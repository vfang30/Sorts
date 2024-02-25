import java.io.*;
import java.util.*;
import java.util.Random;
public class Quick{

   /*@return the position of the pivot index after
    *placing the pivot in the correct location as follows:
    *All values <= pivot are at lower indices than the pivot
    *All values >= pivot are at higher indices than the pivot
    *@param lo is the lower index inclusive
    *@param hi is the upper index inclusive
    *@param data is the array to be partitioned
    *@postcondition The array may be modified.
    */
  public static int randomRange(int start, int end){
      Random rng = new Random();
      int pivot = rng.nextInt(end - start + 1) + start;
      return pivot;
    }

    public static int partition(int[]data ,int lo, int hi){
       int i = lo + 1;
       int j = hi;
       boolean left = true;

       //swap pivot and lo
       int temp = data[lo];
       int pivotLocation = randomRange(lo, hi);
       data[lo] = data[pivotLocation];
       data[pivotLocation] = temp;
       pivotLocation = lo;

       while (i <= j){

         if (data[i] == data[pivotLocation]){
           if (left){
             i +=1;
             left = false;
           }else{
             temp = data[i];
             data[i] = data[j];
             data[j] = temp;
             j-=1;
             left = true;
           }
         }else{
           if (data[i] < data[pivotLocation]){
             i +=1;
           }else{
             if (data[i] > data[pivotLocation]){
               temp = data[i];
               data[i] = data[j];
               data[j] = temp;
               j -=1;
             }
           }
         }



       }
       temp = data[j];
       data[j] = data[pivotLocation];
       data[pivotLocation] = temp;
       return j;
     }

   /*return the value that is the kth smallest value of the array.
    *@param data must have a length > 0
    *@param k is 0 to data.length-1 inclusive
    *@postcondition The array may be modified.
    *@return the value of the kth smallest integer.
    *Note that when k=0 return the smallest.
    */
    public static int quickselect(int []data, int k){
      int lo = 0;
      int hi = data.length - 1;
      int pivot = partition(data, lo, hi);
      while (hi - lo != 1){
        if (k == pivot){
          return data[pivot];
        }
        if (k < pivot){
          hi = pivot - 1;
          pivot = partition(data, lo, hi);
        }
        if (k > pivot){
          lo = pivot + 1;
          pivot = partition(data, lo, hi);
        }
      }
      return data[k];
      }


    /**Quicksort wrapper method, starts the recursion from 0 to len-1 inclusive.
     */
    public static void quicksort(int[]data){
      quicksort(data,0,data.length-1);
    }

    /**Quicksort
     *@param lo is the lower index inclusive
     *@param hi is the upper index inclusive
     *@param data is the array to be sorted
     *@postcondition The array between lo and hi should be sorted.
     */
    public static void quicksort(int[]data,int lo,int hi){
      int partition = partition(data, lo, hi);
      if (partition != lo){
        quicksort(data, lo, partition - 1);
      }
      if (partition != hi){
        quicksort(data, partition + 1, hi);
      }
    }
}
