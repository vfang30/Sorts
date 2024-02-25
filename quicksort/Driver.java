import java.io.*;
import java.util.*;
import java.util.Random;
public class Driver{

  //partition tester
  public static boolean correctLocation (int[] data, int num, int location){
    boolean correct = false;
    for (int i = 0; i < data.length; i +=1){
      if (data[i] == num && location == i){
        correct = true;
      }
    }
    return correct;
  }

  public static boolean rightGreater (int[] data, int num, int location){
    boolean correct = true;
    for (int i = location; i < data.length; i +=1){
      if (data[location] < num){
        correct = false;
      }
    }
    return correct;
  }

  public static boolean leftLesser (int[] data, int num, int location){
    boolean correct = true;
    for (int i = location; i < data.length; i +=1){
      if (data[location] > num){
        correct = false;
      }
    }
    return correct;
  }

  public static void testCase(int[] data, int num, int location){
    if (correctLocation(data, num, location) && rightGreater(data, num, location) && leftLesser(data, num, location)){
      System.out.println("Passes test");
    }else{
      System.out.println("Fails test");
    }
  }


  //quickselect tester
    public static void qSelectTester(int size, boolean equal, boolean printAry){
      int[] data = new int[size];
      int k = (int)((Math.random() * (size - 1)));
      System.out.println(k + " smallest");
      if (equal){
        int num = (int)((Math.random() * 10) + 1);
        for (int i = 0; i < size; i +=1){
          data[i] = num;
        }
        if (printAry){
          System.out.println("Original: "+Arrays.toString(data));
        }
        System.out.println(Quick.quickselect(data, k) + " is the k smallest");
      }else{
        for (int i = 0; i < size; i +=1){
          data[i] = i;
        }
        if (printAry){
          System.out.println("Original: "+Arrays.toString(data));
        }
        System.out.println(Quick.quickselect(data, k) + " is the k smallest");
      }
      if (printAry){
        System.out.println("Modified: "+Arrays.toString(data));
      }
    }


  //quicksortTester
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

  public static void quicksortTester(int numCases, int size){
    int failed = 0;
    for (int i = 0; i < numCases; i +=1){
      int[]testAry = new int[size];
      fillInt(testAry);
      int[]testAryCopy = testAry.clone();
      int[]testAryUnsorted = testAry.clone();
      Quick.quicksort(testAry);
      Arrays.sort(testAryCopy);
        if (!Arrays.equals(testAry, testAryCopy)){
          failed +=1;
          System.out.println("Failed case: "+Arrays.toString(testAryUnsorted));
          System.out.println("Length: "+testAryUnsorted.length);
          System.out.println("Arrays.sort: "+Arrays.toString(testAryCopy));
        }
      }
      if (failed == 0){
        System.out.println("All cases passed");
      }
  }

  public static void quicksortSortedValues(int size){
    int[] data = new int[size];
    for (int i = 0; i < size; i +=1){
      data[i] = i;
    }
    int[] dataClone = data.clone();
    Quick.quicksort(data);
    Arrays.sort(dataClone);
    if (Arrays.equals(data, dataClone)){
      System.out.println("Case Passed");
    }
  }

  public static void quicksortSameValues(int size){
    int value = random();
    int[] data = new int[size];
    for (int i = 0; i < size; i +=1){
      data[i] = value;
    }
    int[] dataClone = data.clone();
    Quick.quicksort(data);
    Arrays.sort(dataClone);
    if (Arrays.equals(data, dataClone)){
      System.out.println("Case Passed");
    }
  }

  public static void quicksortReverseSortedValues(int size){
    int[] data = new int[size];
    for (int i = size - 1; i > 0; i -=1){
      data[i] = i;
    }
    int[] dataClone = data.clone();
    Quick.quicksort(data);
    Arrays.sort(dataClone);
    if (Arrays.equals(data, dataClone)){
      System.out.println("Case Passed");
    }
  }


  public static void main(String[] args) {
    int [] data = new int[] {994,995,996,4,3,2,1,0,997,998,999};
    System.out.println("Original: "+Arrays.toString(data));
    int pivot = Quick.partition( data , 3, 7);
    System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
    System.out.println("Modified: "+Arrays.toString(data));
    testCase(data, data[pivot], pivot);
    System.out.println();

    int [] dataOne = new int[]{990, 991, 992, 993, 994, 8, 7, 6, 5, 4, 3, 2, 1, 0, 995, 996, 997};
    System.out.println("Original: "+Arrays.toString(dataOne));
    int pivotOne = Quick.partition( dataOne , 5, 13);
    System.out.println("Pivot value: "+dataOne[pivotOne]+ ", Pivot index: "+pivotOne);
    System.out.println("Modified: "+Arrays.toString(dataOne));
    testCase(dataOne, dataOne[pivotOne], pivotOne);
    System.out.println();

    int [] dataTwo = new int[]{0, 1, 2, 2, 2, 3};
    System.out.println("Original: "+Arrays.toString(dataTwo));
    int pivotTwo = Quick.partition(dataTwo, 0, dataTwo.length - 1);
    System.out.println("Pivot value: "+dataTwo[pivotTwo]+ ", Pivot index: "+pivotTwo);
    System.out.println("Modified: "+Arrays.toString(dataTwo));
    testCase(dataTwo, dataTwo[pivotTwo], pivotTwo);
    System.out.println();

    //
    int [] dataFive = new int[]{9, -3, 5, 2, 6, 8, -6, 1, 3};
    System.out.println(Quick.quickselect(dataFive, 0) + " is the 0 smallest and should be -6");
    System.out.println(Quick.quickselect(dataFive, 1) + " is the 1 smallest and should be -3");
    System.out.println(Quick.quickselect(dataFive, 2) + " is the 2 smallest and should be 1");
    System.out.println(Quick.quickselect(dataFive, 3) + " is the 3 smallest and should be 2");
    System.out.println(Quick.quickselect(dataFive, 4) + " is the 4 smallest and should be 3");
    System.out.println(Quick.quickselect(dataFive, 5) + " is the 5 smallest and should be 5");
    System.out.println(Quick.quickselect(dataFive, 6) + " is the 6 smallest and should be 6");
    System.out.println(Quick.quickselect(dataFive, 7) + " is the 7 smallest and should be 8");
    System.out.println(Quick.quickselect(dataFive, 8) + " is the 8 smallest and should be 9");

    System.out.println();

    //Different values
    long start = System.currentTimeMillis();
    qSelectTester(1000000, false, false);
    long millis = System.currentTimeMillis() - start;
    System.out.println(millis + " milliseconds");
    System.out.println();

    //Same value
    long startSame = System.currentTimeMillis();
    qSelectTester(1000000, true, false);
    long millisSame = System.currentTimeMillis() - startSame;
    System.out.println(millisSame + " milliseconds");
    System.out.println();


    quicksortTester(100, 100);
    quicksortTester(1, 1000000);
    quicksortSameValues(1000000);
    quicksortSortedValues(1000000);
    quicksortReverseSortedValues(1000000);
    }
  }
