package com.bohdan.bot;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;

public class MatrixColumn {
	
	final boolean[] column;
	private LinkedList<Point> points;
	
	MatrixColumn(Point p, boolean[] column) {
		points = new LinkedList<>();
		points.add(p);
		this.column = column;
	}
	
	void add(MatrixColumn mc) {
		points.addAll(mc.points);
	}

	LinkedList<Point> getPoints() {
		return points;
	}
	
	boolean equalsColumn(MatrixColumn matrixColumn) {
		return Arrays.equals(column, matrixColumn.column);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass().equals(this.getClass())) {
			MatrixColumn mc = (MatrixColumn) obj;
			return Arrays.equals(column, mc.column) && points.equals(mc.points);
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		String s = "";
		for (boolean b: column) {
			s += b ? "X" : "-";
		}
		s += ":";
		for (Point p: points) {
			s += p.x + "," + p.y + " ";
		}
		return s;
	}
}