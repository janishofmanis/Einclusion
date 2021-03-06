package org.einclusion.GUI;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import java.awt.Font;

public class AppFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	CardLayout cardLayout = new CardLayout();
	JPanel cardPanel;
	JMenuBar menuBar;
	JButton importSurvey, viewTable;
	JPanel panel;

	public AppFrame() {
		setTitle("Einclusion"); // sets title of the Jframe
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets close opration
		getContentPane().setLayout(new BorderLayout()); // adds layout to JFrame
		setMinimumSize(new Dimension(1000, 500)); // sets the minimum size of
													// the frame
		setLocationRelativeTo(this); // sets frame location middle of screen

		importSurvey = new JButton("Import Survey"); // creates a button for
														// importing file
		importSurvey.setFont(new Font("Arial", Font.PLAIN, 11));
		importSurvey.addActionListener(this);
		viewTable = new JButton("View table"); // creates a button for viewing
												// database
		viewTable.setFont(new Font("Arial", Font.PLAIN, 11));
		viewTable.addActionListener(this);

		menuBar = new JMenuBar(); // creates a new JMenuBar with buttons
		menuBar.add(importSurvey);
		menuBar.add(viewTable);
		this.setJMenuBar(menuBar);

		cardPanel = new JPanel(); // creates a JPanel with cardLayout (to switch
									// between panels)
		cardPanel.setLayout(cardLayout);
		ImportPanel survey = new ImportPanel(); // creates new ImportPanel
		ViewStudentsPanel students = new ViewStudentsPanel(); // creates new
																// VievStudentsPanel
		cardPanel.add(survey, "survey"); // adds importpanel to cardpanel
		cardPanel.add(students, "students"); // adds studentspanel to cardpanel
		cardPanel.setVisible(false);
		this.add(cardPanel);

		pack();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(importSurvey)) { // if importSurvey button
													// pressed
			cardPanel.setVisible(true);
			cardLayout.show(cardPanel, "survey"); // show ImportPanel
		} else if (e.getSource().equals(viewTable)) { // if importSurvey button
														// pressed
			cardPanel.setVisible(true);
			cardLayout.show(cardPanel, "students"); // show VievStudentsPanel
		}
	}
}