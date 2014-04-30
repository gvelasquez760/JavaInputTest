import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Java Input Problem
//@author Gary Velasquez
//@version 1

class JavaProblemFix
{
	public static void main (String[] args) throws java.lang.Exception
	{
	//stdin try and catch
			try{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input=br.readLine())!=null){
		
			countAsterisks(input);//test input 
		}
 
			}catch(IOException io){
			io.printStackTrace();
			}	
	}
	
	//found how many * are in the input and storage his positions
	static void countAsterisks(String input) 
	{
		char inputArray[] = input.toCharArray();
		int positions[] = new int[input.length()];
		int asterisksTotal = 0;
		int positionMarker = 0;
		int totalOutputs = 0;
		
		for(int i=0;i<inputArray.length;i++)
			{
				if(inputArray[i]=='*')
				{
					positions[positionMarker]=i;
					positionMarker++;
					asterisksTotal++;
				}
			}
		
		totalOutputs=(int)Math.pow(2, asterisksTotal);
		generateOutput(0, totalOutputs, inputArray, positions, asterisksTotal);
	}
	
	//method that uses Java recursion, recieves output details and generate final array 
	static void generateOutput(int n, int totalOutputs, char[]inputArray, int[]positions, int asterisksTotal) 
	{
		if(n == totalOutputs)
		return;
	 
		int padding = asterisksTotal;
		String result = String.format("%"+padding+"s", Integer.toBinaryString(n)).replace(' ', '0');
		char [] binaryArray = result.toCharArray();
	
		for(int i=0;i<binaryArray.length;i++)
			{
				inputArray[positions[i]] = binaryArray[i];
			}
			
			String formatedString = inputArray.toString()
                                  .replace(",", "")  //remove las comas 
                                  .replace("[", "")   //remove left bracket
                                  .replace("]", ""); //remove right bracket
				System.out.println(inputArray);
   
			generateOutput(n + 1, totalOutputs, inputArray, positions, asterisksTotal);
 
	}	
}