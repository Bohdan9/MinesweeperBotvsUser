package com.bohdan.player;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatPanel extends JPanel {

	private final Field field;
	private final Game game;
	private JLabel winRate;
	private JLabel minesLeft;
	
	StatPanel(Field field, Game game) {
		this.field = field;
		this.game = game;

		setMinimumSize(new Dimension(100, 50));
		winRate = new JLabel();
		add(winRate);
		add (new JLabel("                             "));
		minesLeft = new JLabel();
		add(minesLeft);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		winRate.setText(game.getScore());
		minesLeft.setText("Mines Left : " + field.getMinesLeft() + "");
	}
}