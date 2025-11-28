package org.example;
import java.util.List;

public class Sociopath {

	public int findTheSociopath (int groupSize, List<int []> likeList) {
		int[] likesGiven = new int[groupSize + 1];
		int[] likesReceived = new int[groupSize + 1];
		for (int[] like : likeList) {
			int liker = like[0];
			int liked = like[1];
			likesGiven[liker]++;
			likesReceived[liked]++;
		}
		for (int person = 1; person <= groupSize; person++) {
			if (likesGiven[person] == 0 && likesReceived[person] == groupSize - 1) {
				return person;
			}
		}	
		return -1;
	}
}
