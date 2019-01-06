/*******************************************************************************************
*
*  The class SortableArrayListWithQuickSort extends the abstract SortableArrayList class
*   using the Quick Sort Algorithm.
*
*  @author: Corey Hannum
*
**********************************************************************************************/
package QuickSort;

class SortableArrayListWithQuickSort<T extends Comparable<T>>
  extends SortableArrayList<T>
{
   // Constructor
   public SortableArrayListWithQuickSort(int maxLength) {
     super(maxLength);
   }
   
   // Partitions the sublist a[lowIndex]...a[highindex] around a pivot value
   // Returns the index of the pivot value
   public int partition (T[] a, int lowIndex, int highIndex)
   {
      T pivot = a[lowIndex];
      int i = highIndex + 1;
      T temp;
      
      for(int j = highIndex; j >= lowIndex + 1; j--){
         if(a[j].compareTo(pivot) > 0){
            i--;
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
         }
      }
      
      i--;
      temp = a[lowIndex];
      a[lowIndex] = a[i];
      a[i] = temp;
      return i;
   }
   
   // Sorts the sublist a[lowIndex]...a[highIndex] using the quick sort algorithm
   protected void sortSubArray(T[] a, int lowIndex, int highIndex)
   {
      int partIdx;
   
      if(lowIndex < highIndex){
         partIdx = partition(a, lowIndex, highIndex);
         
         sortSubArray(a, lowIndex, partIdx - 1);
         sortSubArray(a, partIdx + 1, highIndex);
      }
   }
}    