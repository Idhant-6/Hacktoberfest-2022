//C# program to sort an array in ascending order 
//using Insertion Sort.

using System;

class Sort
{
    static void InsertionSort(ref int []intArr)
    {
        int item = 0;
        int pass = 0;
        int loop = 0;

        for (pass = 1; pass < intArr.Length; pass++)
        {
            item = intArr[pass];
            for (loop = pass - 1; loop >= 0;)
            {
                if (item < intArr[loop])
                {
                    intArr[loop + 1] = intArr[loop];
                    loop--;
                    intArr[loop + 1] = item;
                }
                else
                    break;
            }
        }
    }
    static void Main(string[] args)
    {
        int[] intArry = new int[5] { 65,34,23,76,21 };

        Console.WriteLine("Array before sorting: ");
        for (int i = 0; i < intArry.Length; i++)
        {
            Console.Write(intArry[i]+" ");
        }
        Console.WriteLine();

        InsertionSort(ref intArry);
        
        Console.WriteLine("Array before sorting: ");
        for (int i = 0; i < intArry.Length; i++)
        {
            Console.Write(intArry[i] + " ");
        }
        Console.WriteLine();
    }
}
