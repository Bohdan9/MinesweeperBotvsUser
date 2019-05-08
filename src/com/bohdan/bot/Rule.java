package com.bohdan.bot;

import java.awt.Point;
import java.util.LinkedList;

public class Rule {
	
	private int mines;
	private LinkedList<Point> points;
	
	public Rule(LinkedList<Point> points, int mines) {
		this.points = points;
		this.mines = mines;
	}
	

	
	void subtractBy(Rule rule) {
		points.removeAll(rule.points);
		mines -= rule.mines;
	}
	
	boolean contains(Point p) {
		return points.contains(p);
	}

	boolean contains(Rule r) {
		return points.containsAll(r.points);
	}
	
	boolean isEmpty() {
		return points.isEmpty();
	}
	
	LinkedList<Point> getPoints() {
		return points;
	}

	int getMines() {
		return mines;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass().equals(this.getClass())) {
			Rule c = (Rule) obj;
			if (c.mines == mines) {
				if (c.points.containsAll(points) && points.containsAll(c.points)) {
					return true;
				}
			}
		}
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		String s = mines + ":";
		for (Point p: points) {
			s += "\t" + p.x + "," + p.y;
		}
		return s;
	}
}