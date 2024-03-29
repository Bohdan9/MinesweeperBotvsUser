package com.bohdan.player;

import java.awt.Point;

public class Click {
	private  enum ClickType {LEFT, RIGHT}
	
	private final ClickType clickType;
	private final Point point;
	
	public Click(boolean left, Point p) {
		clickType = left ? ClickType.LEFT : ClickType.RIGHT;
		point = p;
	}
	
	public Click(boolean b, int x, int y) {
		this(b, new Point(x, y));
	}

	boolean isLeft() {
		return clickType == ClickType.LEFT;
	}

	Point getPoint() {
		return point;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass().equals(this.getClass())) {
			Click c = (Click) obj;
			return c.point.equals(point) && c.clickType.equals(clickType);
		}
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return clickType.name() + " " + point.x + "," + point.y;
	}
}