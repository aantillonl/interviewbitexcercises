package com.interviewbit.exercises;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LovelySentence implements ProblemInterface
{

	private boolean IsValidPermutation(int[] counter){
		for(int j = 0; j < 4; j++){
			if(counter[j] < 1){
				return false;
			}
		}
		return true;
	}
	public void main() throws java.lang.Exception
	{
		java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		int T = Integer.parseInt(r.readLine());
		List<Character> validCharacters = new ArrayList<Character>(Arrays.asList('c','h','e','f'));
		for(int i = 0; i < T; i++){
			int[] letterCounter = new int[4];
			int permutationCounter = 0;
			permutationCounter = 0;
			String s = r.readLine();
			int ptr_tail,ptr_head;
			ptr_head = ptr_tail = 0;            
			while(ptr_head < s.length()){                
				int indexOfLetter = validCharacters.indexOf(s.charAt(ptr_head));
				if( indexOfLetter > -1){
					if(ptr_head - ptr_tail >= 4){
						int tail_letter_index = validCharacters.indexOf(s.charAt(ptr_tail));
						letterCounter[tail_letter_index] = letterCounter[tail_letter_index] - 1;
						ptr_tail++;
					}
					letterCounter[indexOfLetter] = letterCounter[indexOfLetter] + 1;
					if(IsValidPermutation(letterCounter)){
						permutationCounter++;
					}
				}
				else{
					for(int j = 0; j < 4; j++){
						letterCounter[j] = 0;							
					}
					ptr_tail = ptr_head + 1;
				}
				ptr_head++;
			}
			if(permutationCounter > 0){
				System.out.format("lovely %d%n", permutationCounter);
			} 
			else{
				System.out.println("normal");
			}
		}		
	}

	public void Test(){
		try{
			this.main();
		}
		catch(Exception e){

		}
		
	}
}