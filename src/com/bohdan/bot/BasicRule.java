package com.bohdan.bot;

import java.util.LinkedList;

public class BasicRule {
	
	private final int mines;
	private final boolean[] booleans;
	
	BasicRule(boolean[] b, int m) {
		mines = m;
		booleans = b;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(mines + ":");
		for (boolean b: booleans) {
			s.append(b ? "T" : "F");
		}
		
		return s.toString();
	}

	int count(LinkedList<Integer> toBeDone) {
		int count = 0;
		for (int i: toBeDone) {
			if (booleans[i]) {
				count++;
			}
		}
		return count;
	}

	static boolean follows(LinkedList<BasicRule> basicRules, LinkedList<Integer> toBeDone, int[] b) {
		for (BasicRule br: basicRules) {
			if (!br.follows(toBeDone, b)) {
				return false;
			}
		}
		return true;
	}

	private boolean follows(LinkedList<Integer> toBeDone, int[] b) {
		int m = 0;
		for (int i = 0; i < booleans.length; i++) {
			if (booleans[i] && !toBeDone.contains(i)) {
				m += b[i];
			}
		}
		return m <= mines;
	}

	int getDetermineIndex(LinkedList<Integer> toBeDone) {
		for (int i: toBeDone) {
			if (booleans[i]) {
				return i;
			}
		}
		return -1;
	}

	int getMines() {
		return mines;
	}
	
	boolean uses(int i) {
		return booleans[i];
	}
	
	int length() {
		return booleans.length;
	}

	int getMines(LinkedList<Integer> toBeDone, int[] is) {
		int count = 0;
		for (int i = 0; i < booleans.length; i++) {
			if (booleans[i] && !toBeDone.contains(i)) {
				count += is[i];
			}
		}
		return count;
	}

}
