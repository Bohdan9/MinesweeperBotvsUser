package com.bohdan.bot;

import java.awt.Point;
import java.util.LinkedList;

import com.bohdan.player.Click;

public class RuleSet {

	private LinkedList<Rule> bases;
	
	public RuleSet(LinkedList<Rule> rules) {
		bases = new LinkedList<>();
		bases.addAll(rules);
		removeDuplicates();
		boolean change = false;
		do {
			change = false;
			for (int i = 0; i < bases.size(); i++) {
				for (int j = 0; j < bases.size(); j++) {
					if (i != j && bases.get(i).contains(bases.get(j))
							&& !bases.get(j).isEmpty()) {
						change = true;
						bases.get(i).subtractBy(bases.get(j));
					}
				}
			}
		} while (change);
		removeEmpty();
	}
	
	LinkedList<Click> solve() {
		LinkedList<Click> clicks = new LinkedList<>();
		
		for (Rule r: bases) {
			if (r.getPoints().size() == r.getMines()) {
				for (Point p: r.getPoints()) {
					Click c = new Click(false, p);
					if (!clicks.contains(c)) {
						clicks.add(c);
					}
				}
			}
			if (r.getMines() == 0) {
				for (Point p: r.getPoints()) {
					Click c = new Click(true, p);
					if (!clicks.contains(c)) {
						clicks.add(c);
					}
				}
			}
		}
		return clicks;
	}

	LinkedList<Rule> getRules() {
		return bases;
	}
	
	private void removeDuplicates() {
		for (int i = 0; i < bases.size(); i++) {
			for (int j = i + 1; j < bases.size(); j++) {
				if (bases.get(i).equals(bases.get(j))) {
					bases.remove(j);
					j--;
				}
			}
		}
	}
	
	private void removeEmpty() {
		for (int i = 0; i < bases.size(); i++) {
			if (bases.get(i).isEmpty()) {
				bases.remove(i);
				i--;
			}
		}
	}
}