package examples.practice;

import java.util.HashSet;
import java.util.LinkedList;

/*
 * Word Ladder (Length of shortest chain to reach a target word)
Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). Find length of the smallest chain 
from ‘start’ to ‘target’ if it exists, such that adjacent words in the chain only differ by one character and each word in the 
chain is a valid word i.e., it exists in the dictionary. 
It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.

Example:

Input:  Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
             start = TOON
             target = PLEA
Output: 7
Explanation: TOON - POON - POIN - POIE - PLIE - PLEE - PLEA

The idea is to use BFS. We start from the given start word, traverse all words that adjacent (differ by one character) 
to it and keep doing so until we find the target word or we have traversed all words.
 */

public class WordLadderSample {

	static class WordHolder {
		public int wordStep;

		public String word;

		public WordHolder(String _word, int _step) {
			this.word = _word;
			this.wordStep = _step;
		}
	}

	static int findWordLadderSteps(String beginWord, String endWord, HashSet<String> wordDict) {
		LinkedList<WordHolder> wordList = new LinkedList<>();
		int totalSteps = 1;

		wordList.add(new WordHolder(beginWord, 1));
		// wordList.add(new WordHolder(endWord, 1));

		while (!wordList.isEmpty()) {
			WordHolder wh = wordList.remove();

			char[] arr = wh.word.toCharArray();

			for (int i = 0; i < arr.length; i++) {
				boolean found = false;

				for (char c = 'a'; c <= 'z'; c++) {

					char temp = arr[i];

					if (arr[i] != c) {
						arr[i] = c;
					}

					if (wordDict.contains(new String(arr))) {
						System.out.println(new String(arr));
						wordList.add(new WordHolder(new String(arr), wh.wordStep + 1));
						wordDict.remove(new String(arr));
						totalSteps++;
						found = true;
						break;

					}

					arr[i] = temp;

				}
				if (found)
					break;
			}
		}

		return totalSteps;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String bword = "hit";
		String eword = "cog";

		HashSet<String> hs = new HashSet<>();
		hs.add("hot");
		hs.add("dot");
		hs.add("dog");
		hs.add("lot");
		hs.add("log");
		hs.add("cog");
		System.out.println(findWordLadderSteps(bword, eword, hs));

	}

}
