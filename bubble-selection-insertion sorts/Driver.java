import java.util.Arrays;
public class Driver{

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

//Runs a loop to automatically create and run numCases amount of test cases of
//elements length and random values
public static void testCases(int numCases, int elements, String sort){
  int failed = 0;
  for (int i = 0; i < numCases; i +=1){
    int[]testAry = new int[elements];
    fillInt(testAry);
    int[]testAryCopy = testAry.clone();
    int[]testAryUnsorted = testAry.clone();
      if (sort.equals("bubble")){
        Sorts.bubblesort(testAry);
        }
      if (sort.equals("selection")){
        Sorts.selectionsort(testAry);
      }
      if (sort.equals("insertion")){
       Sorts.insertionsort(testAry);
      }
    Arrays.sort(testAryCopy);
      if (!Arrays.equals(testAry, testAryCopy)){
        failed +=1;
        System.out.println("Failed case: "+Arrays.toString(testAryUnsorted));
        System.out.println("Length: "+testAryUnsorted.length);
        System.out.println("" + sort + ":" + "" + Arrays.toString(testAry));
        System.out.println("Arrays.sort: "+Arrays.toString(testAryCopy));
      }
    }
    if (failed == 0){
      System.out.println("All cases passed");
    }
  }

  public static void main(String[] args) {

  /*args[0] is the number of test cases generated
    args[1] is the number of elements in each test case
    args[2] is the type of sort
  */

  //bubblesort test cases
  if (args.length > 0){
    if(args[2].equals("bubble")){
      testCases(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
      }
    }

  //selectionsort test cases
  if (args.length > 0){
    if(args[2].equals("selection")){
      testCases(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
      }
    }

    //selectionsort test cases
    if (args.length > 0){
      if(args[2].equals("insertion")){
        testCases(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
        }
      }


      /*Speed Testing Results
      Sort            Size    Time
      bubblesort      10,000  0.249s
                      40,000  2.954s

      selectionsort   10,000  0.203s
                      40,000  0.426s

      insertionsort   10,000  0.202s
                      40,000  0.376s
      */

  }
}
