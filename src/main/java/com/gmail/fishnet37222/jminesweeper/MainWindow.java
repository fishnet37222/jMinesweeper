/*
 * Copyright (c) 2024 David A. Frischknecht
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.gmail.fishnet37222.jminesweeper;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
