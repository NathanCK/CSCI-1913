/**
 * CSCI 1913
 *Lab 6
 * @author nathanchan
 * Lab Partner: Changmeng Xu
 */
class BinaryVsLinear
{

  private static int linearSearch(int key, int[] array)
  {
      int count = 0;
    for (int index=0; index<array.length; index+=1)
    {
        count ++;
        if (array[index] == key)
        {
            return count; 
        }     
        
    }
    return count;
  }

  private static int binarySearch(int key, int[] array)
  {
    int left = 0;
    int mid;
    int right = array.length-1;
    
    int count =0;

    while(true)        
    {
        if (left > right)
        {
            mid = -1;
            break;          
        }
        else
        {
            
            mid = (left + right) / 2;     
            if (key < array[mid])
            {
                count ++;
                right = mid - 1;
            }
            else if (key > array[mid])
            {
                count ++;
                count ++;
                left = mid +1;
            }
            else    
            {
                count ++;
                count ++;
                break;    
            }
        }
    }
    return count;
  }

  public static void main(String[] args)
  {
    for (int length = 1; length <= 30; length += 1)
    {
      int[] array = new int[length];
      for (int index = 0; index < length; index += 1)
      {
        array[index] = index;
      }

      double linearTotal = 0.0;
      double binaryTotal = 0.0;
      for (int element = 0; element < length; element += 1)
      {
        linearTotal += linearSearch(element, array);
        binaryTotal += binarySearch(element, array);
      }

      double linearAverage = linearTotal / length;
      double binaryAverage = binaryTotal / length;
      System.out.println(length + " " + linearAverage + " " + binaryAverage);
    }
  }
}

//Outputs:
//1 1.0 2.0
//2 1.5 3.0
//3 2.0 3.0
//4 2.5 3.75
//5 3.0 4.0
//6 3.5 4.166666666666667
//7 4.0 4.142857142857143
//8 4.5 4.625
//9 5.0 4.888888888888889
//10 5.5 5.1
//11 6.0 5.181818181818182
//12 6.5 5.333333333333333
//13 7.0 5.384615384615385
//14 7.5 5.428571428571429
//15 8.0 5.4
//16 8.5 5.6875
//17 9.0 5.882352941176471
//18 9.5 6.055555555555555
//19 10.0 6.157894736842105
//20 10.5 6.3
//21 11.0 6.380952380952381
//22 11.5 6.454545454545454
//23 12.0 6.478260869565218
//24 12.5 6.583333333333333
//25 13.0 6.64
//26 13.5 6.6923076923076925
//27 14.0 6.703703703703703
//28 14.5 6.75
//29 15.0 6.758620689655173
//30 15.5 6.766666666666667