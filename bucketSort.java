package prac2;

import java.util.Scanner;

public class bucketSort {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    
    int bucket[] = new int[10];
    int sortedNum[] = new int[10];
    int num;
    
    System.out.println("Enter a number from 0-9: ");
    num = input.nextInt();
    
    System.out.println("Please enter " +num+ " numbers");
    
    for (int ctr=0; ctr<num; ctr++) { //this gets inputs from the user
      bucket[ctr] = input.nextInt();
    }
    
    for (int ctr=0; ctr<num;ctr++) { //storing numbers in their
      sortedNum[bucket[ctr]]++;

    }
    
    System.out.println();
    
    for (int x=0; x<10; x++) { //printing sorted numbers
      while(sortedNum[x]!=0) {
        System.out.print((x) + " ");
        sortedNum[x]--;  
      }
    }
    
  }
}
