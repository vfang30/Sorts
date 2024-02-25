import java.util.Arrays;
public class Sorts{

  public static void bubblesort(int[] data){
    int length = data.length;
    int i = 0;
    int j = 1;
    int swapCount = 0;
    boolean swap = true;
    while (swap && i < length - j){
      while (i < length - j){
        if (data[i] > data[i + 1]){
          int temp = data[i];
          data[i] = data[i + 1];
          data[i + 1] = temp;
          swapCount +=1;
          }
        i +=1;
        if (swapCount == 0){
          swap = false;
        }else{
          swap = true;
          }
        }
      j +=1;
      i = 0;
    }
  }

  public static int smallestIndex(int[] data, int start){
    int smallest = data[start];
    int indexOfSmallest = start;
    for (int i = start + 1; i < data.length; i+=1){
      if (data[i] < smallest){
        smallest = data[i];
        indexOfSmallest = i;
      }
    }
    return indexOfSmallest;
  }

    public static void selectionsort(int[] data){
      int length = data.length;
      int starting = 0;
      while(starting < length){
        int temp = data[starting];
        int smallestIndex = smallestIndex(data, starting);
        data[starting] = data[smallestIndex];
        data[smallestIndex] = temp;
        starting +=1;
      }
    }

    public static void insertionsort(int[]data){
      for (int i = 1; i < data.length; i +=1){
        int iTwo = i - 1;
        int temp = data[i];
        while (iTwo > -1 && temp < data[iTwo]){
          data[iTwo + 1] = data[iTwo];
          iTwo-=1;
        }
        data[iTwo + 1] = temp;
      }
    }
}
