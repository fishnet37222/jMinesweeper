/*
 * Copyright (c) 2024 David A. Frischknecht
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.gmail.fishnet37222.jminesweeper;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MainWindow extends JFrame
{
	public MainWindow()
	{
		super("Minesweeper");
		
		var icons = new ArrayList<Image>();
		icons.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("bomb-16.png"))).getImage());
		icons.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("bomb-32.png"))).getImage());
		icons.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("bomb-64.png"))).getImage());
		icons.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("bomb-128.png"))).getImage());
		icons.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("bomb-256.png"))).getImage());
		setIconImages(icons);
		
		var menuBar = new JMenuBar();
		
		var mnuGame = new JMenu("Game");
		mnuGame.setMnemonic('G');
		
		var mnuGameNew = new JMenuItem("New");
		mnuGameNew.setMnemonic('N');
		mnuGameNew.setAccelerator(KeyStroke.getKeyStroke("F2"));
		mnuGame.add(mnuGameNew);
		
		mnuGame.addSeparator();
		
		var mnuGameBeginner = new JCheckBoxMenuItem("Beginner");
		mnuGameBeginner.setMnemonic('B');
		mnuGame.add(mnuGameBeginner);
		
		var mnuGameIntermediate = new JCheckBoxMenuItem("Intermediate");
		mnuGameIntermediate.setMnemonic('I');
		mnuGame.add(mnuGameIntermediate);
		
		var mnuGameExpert = new JCheckBoxMenuItem("Expert");
		mnuGameExpert.setMnemonic('E');
		mnuGame.add(mnuGameExpert);
		
		var mnuGameCustom = new JCheckBoxMenuItem("Custom...");
		mnuGameCustom.setMnemonic('C');
		mnuGame.add(mnuGameCustom);
		
		mnuGame.addSeparator();
		
		var mnuGameBestTimes = new JMenuItem("Best Times...");
		mnuGameBestTimes.setMnemonic('T');
		mnuGame.add(mnuGameBestTimes);
		
		mnuGame.addSeparator();
		
		var mnuGameExit = new JMenuItem("Exit");
		mnuGameExit.setMnemonic('X');
		mnuGameExit.addActionListener(_ -> windowClosing());
		mnuGame.add(mnuGameExit);
		
		menuBar.add(mnuGame);
		
		var mnuHelp = new JMenu("Help");
		mnuHelp.setMnemonic('H');
		
		var mnuHelpHowToPlay = new JMenuItem("How to Play...");
		mnuHelpHowToPlay.setMnemonic('P');
		mnuHelp.add(mnuHelpHowToPlay);
		
		mnuHelp.addSeparator();
		
		var mnuHelpAbout = new JMenuItem("About Minesweeper...");
		mnuHelpAbout.setMnemonic('A');
		mnuHelp.add(mnuHelpAbout);
		
		menuBar.add(mnuHelp);
		
		setJMenuBar(menuBar);
		
		add(Box.createRigidArea(new Dimension(5, 5)), BorderLayout.PAGE_START);
		add(Box.createRigidArea(new Dimension(12, 12)), BorderLayout.LINE_START);
		add(Box.createRigidArea(new Dimension(12, 12)), BorderLayout.LINE_END);
		add(Box.createRigidArea(new Dimension(12, 12)), BorderLayout.PAGE_END);
		
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				MainWindow.this.windowClosing();
			}
		});
	}
	
	private void windowClosing()
	{
		dispose();
	}
}
