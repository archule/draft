import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;

/**
 * This class sets up the user interface for this application. The class extends
 * JFrame.
 *
 *
 * @author Kai Archuleta
 *
 */
public class Console extends JFrame {
	
	
	public Console() {
		super("NFL Draft");

		for(int i = 0; i < 7; i++) {
		checkBoxes[i] = new CheckBox("Draft");
		nameLabels[i] = new JLabel();
		rankLabels[i] = new JLabel();
		positionLabels[i] = new JLabel();
		collegeLabels[i] = new JLabel();
		heightLabels[i] = new JLabel();
		weightLabels[i] = new JLabel();
		ageLabels[i] = new JLabel();
	}
	}

	private JPanel contentPane;
	private int menuSectionHeight = 75;
	int sectionCumulation = 249;

	int pickNum = 1;

	int constantTime = 7;
	static Team[] teams = new Team[32];

	JLabel timerLabel = new JLabel();
	JLabel teamLabel = new JLabel();
	Timer timer = new Timer();

	CheckBox[] checkBoxes = new CheckBox[7];
	JLabel[] nameLabels = new JLabel[7];
	JLabel[] rankLabels = new JLabel[7];
	JLabel[] positionLabels = new JLabel[7];
	JLabel[] collegeLabels = new JLabel[7];
	JLabel[] ageLabels = new JLabel[7];
	JLabel[] heightLabels = new JLabel[7];
	JLabel[] weightLabels = new JLabel[7];


	int section1Width = 58;
	int section2Width = 200;
	int section3Width = 125;
	int section4Width = 125;
	int section5Width = 125;
	int section6Width = 125;
	int section7Width = 128;
	int section8Width = 130;



	Player[] sevenPlayers;
	ArrayList<Player> allPlayers = new ArrayList<>();

	public static void main(String[] args) {

		Console frame = new Console();
		frame.initializePlayers();
		teams = Team.assignPicks();
		frame.eat();
		frame.setVisible(true);
		frame.start();

	}

	private void makeMenuPanel(JPanel panel, int sectionWidth, int current, int num) {
		panel.setBackground(Color.white);
		panel.setBorder(new LineBorder(Color.black, 2));
		panel.setLayout(new BorderLayout());
		sectionCumulation += sectionWidth;
		panel.setBounds(sectionCumulation, num * (menuSectionHeight), current, (menuSectionHeight));
	}

	public void initializePlayers() {

		sevenPlayers = new Player[7];

		sevenPlayers[0] = new Player(1, "QB", 216, "6'4", "Joe Burrow", 23, "LSU");
		sevenPlayers[1] = new Player(2, "QB", 218, "6'1", "Tua Tagovailoa", 22, "Alabama");
		sevenPlayers[2] = new Player(3, "ED", 265, "6'5", "Chase Young", 21, "Ohio State");
		sevenPlayers[3] = new Player(4, "CB", 199, "6'1", "Jeffrey Okudah", 21, "Ohio State");
		sevenPlayers[4] = new Player(5, "WR", 192, "6'1", "Jerry Juedy", 21, "Alabama");
		sevenPlayers[5] = new Player(6, "WR", 191, "6'2", "CeeDee Lamb", 21, "Oklahoma");
		sevenPlayers[6] = new Player(7, "S", 230, "6'4", "Isaiah Simmons", 21, "Clemson");

		for (int index = 0; index < sevenPlayers.length; index++) {
			allPlayers.add(sevenPlayers[index]);
		}

		allPlayers.add(new Player(8, "T", 320, "6'5", "Andrew Thomas", 21, "Georgia"));
		allPlayers.add(new Player(9, "WR", 320, "6'5", "Tristan Wirfs", 21, "Iowa"));
		allPlayers.add(new Player(10, "WR", 190, "6'0", "Henry Ruggs III", 21, "Alabama"));
		allPlayers.add(new Player(11, "T", 320, "6'5", "Jedrick Willis Jr.", 21, "Alabama"));
		allPlayers.add(new Player(12, "CB", 200, "6'0", "Kristian Fulton", 21, "LSU"));
		allPlayers.add(new Player(13, "DI", 310, "6'6", "Javon Kinlaw", 22, "South Carolina"));
		allPlayers.add(new Player(14, "T", 310, "6'7", "Josh Jones", 22, "Houston"));
		allPlayers.add(new Player(15, "S", 203, "6'3", "Grant Delpit", 21, "LSU"));
		allPlayers.add(new Player(16, "DI", 318, "6'5", "Derrick Brown", 22, "Auburn"));
		allPlayers.add(new Player(17, "CB", 191, "6'1", "C.J Henderson", 21, "Florida"));
		allPlayers.add(new Player(18, "WR", 220, "6'2", "Laviska Shenault", 21, "Colorado"));
		allPlayers.add(new Player(19, "S", 200, "6'1", "Xavier McKinney", 21, "Alabama"));
		allPlayers.add(new Player(20, "ED", 277, "6'5", "A.J. Epenesa", 21, "Iowa"));
		allPlayers.add(new Player(21, "WR", 195, "5'11", "Jalen Reagor", 21, "TCU"));
		allPlayers.add(new Player(22, "WR", 220, "6'4", "Michael Pittman", 22, "USC"));
		allPlayers.add(new Player(23, "DI", 315, "6'4", "Jordan Eliott", 22, "Missouri"));
		allPlayers.add(new Player(24, "CB", 195, "6'0", "Jaylon Johnson", 21, "Utah"));
		allPlayers.add(new Player(25, "WR", 215, "6'4", "Tee Higgins", 21, "Clemson"));
		allPlayers.add(new Player(26, "ED", 266, "6'3", "Curtis Weaver", 21, "Boise State"));
		allPlayers.add(new Player(27, "LB", 227, "6'1", "Patrick Queen", 20, "LSU"));
		allPlayers.add(new Player(28, "ED", 241, "6'5", "C.J Julian Okwara", 22, "Notre Dame"));
		allPlayers.add(new Player(29, "CB", 190, "6'1", "A.J. Terrell", 21, "Clemson"));
		allPlayers.add(new Player(30, "QB", 237, "6'6", "Justin Herbert", 22, "Oregon"));
		allPlayers.add(new Player(31, "CB", 207, "6'2", "Trevon Diggs", 22, "Alabama"));
		allPlayers.add(new Player(32, "WR", 192, "6'3", "Justin Jefferson", 20, "LSU"));

	}

	public void eat() {

		/**
		 * Set up basic frame details
		 */
		setBackground(new Color(47, 79, 79));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 1280, 640);
		this.setResizable(false);

		/**
		 * Set up Draft Titles
		 */

// set the content pane for the main menu
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton up = new UpButton("Up");
		JButton down = new DownButton("Down");

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 128, 128));
		panelMenu.setBounds(0, 0, 249, 320 - 196);
		contentPane.add(panelMenu);
		panelMenu.setLayout(new BorderLayout());

		JPanel panelMenu1 = new JPanel();
		panelMenu1.setBackground(Color.white);
		panelMenu1.setBounds(0, 320 - 196, 249, 100);
		panelMenu1.setLayout(new BorderLayout());
		contentPane.add(panelMenu1);

		JPanel panelMenu2 = new JPanel();
		panelMenu2.setBackground(new Color(0, 128, 128));
		panelMenu2.setBounds(0, 320 - 196, 249, 416);
		panelMenu2.setLayout(new BorderLayout());
		contentPane.add(panelMenu2);
		panelMenu2.add(teamLabel);

		up.setPreferredSize(new Dimension(124, 40));
		down.setPreferredSize(new Dimension(125, 40));
		panelMenu.add(up, BorderLayout.WEST);
		panelMenu.add(down, BorderLayout.EAST);
		panelMenu1.add(timerLabel);

		JPanel menuTitle1 = new JPanel();
		menuTitle1.setBackground(Color.WHITE);
// x y width height
		menuTitle1.setBounds(sectionCumulation, 0, section1Width, (menuSectionHeight));
		menuTitle1.setLayout(new BorderLayout());
		menuTitle1.setBorder(new LineBorder(Color.black, 2));
		contentPane.add(menuTitle1);

		JPanel menuTitle2 = new JPanel();
		menuTitle2.setBackground(Color.white);
		menuTitle2.setBorder(new LineBorder(Color.black, 2));
		sectionCumulation += section1Width;
		menuTitle2.setBounds(sectionCumulation, 0, section2Width, (menuSectionHeight));
		JLabel title2Label = new JLabel("Name");
		menuTitle2.add(title2Label);
		contentPane.add(menuTitle2);

		JPanel menuTitle3 = new JPanel();
		menuTitle3.setBackground(Color.white);
		menuTitle3.setBorder(new LineBorder(Color.black, 2));
		sectionCumulation += section2Width;
		menuTitle3.setBounds(sectionCumulation, 0, 125, (menuSectionHeight));
		JLabel title3Label = new JLabel("Rank");
		menuTitle3.add(title3Label);
		contentPane.add(menuTitle3);

		JPanel menuTitle4 = new JPanel();
		menuTitle4.setBackground(Color.white);
		menuTitle4.setBorder(new LineBorder(Color.black, 2));
		sectionCumulation += section3Width;
		menuTitle4.setBounds(sectionCumulation, 0, 125, (menuSectionHeight));
		JLabel title4Label = new JLabel("Position");
		menuTitle4.add(title4Label);
		contentPane.add(menuTitle4);

		JPanel menuTitle5 = new JPanel();
		menuTitle5.setBackground(Color.white);
		menuTitle5.setBorder(new LineBorder(Color.black, 2));
		sectionCumulation += section4Width;
		menuTitle5.setBounds(sectionCumulation, 0, 125, (menuSectionHeight));
		JLabel title5Label = new JLabel("University");
		menuTitle5.add(title5Label);
		contentPane.add(menuTitle5);

		JPanel menuTitle6 = new JPanel();
		menuTitle6.setBackground(Color.white);
		menuTitle6.setBorder(new LineBorder(Color.black, 2));
		sectionCumulation += section5Width;
		menuTitle6.setBounds(sectionCumulation, 0, 125, (menuSectionHeight));
		JLabel title6Label = new JLabel("Age");
		menuTitle6.add(title6Label);
		contentPane.add(menuTitle6);

		JPanel menuTitle7 = new JPanel();
		menuTitle7.setBackground(Color.white);
		menuTitle7.setBorder(new LineBorder(Color.black, 2));
		sectionCumulation += section6Width;
		menuTitle7.setBounds(sectionCumulation, 0, 128, (menuSectionHeight));
		JLabel title7Label = new JLabel("Height");
		menuTitle7.add(title7Label);
		contentPane.add(menuTitle7);

		JPanel menuTitle8 = new JPanel();
		menuTitle8.setBackground(Color.white);
		menuTitle8.setBorder(new LineBorder(Color.black, 2));
		sectionCumulation += section7Width;
		menuTitle8.setBounds(sectionCumulation, 0, 130, (menuSectionHeight));
		JLabel title8Label = new JLabel("Weight");
		menuTitle8.add(title8Label);
		contentPane.add(menuTitle8);

		sectionCumulation = 249;

		JPanel[] playerPlaceHolders = new JPanel[7];
		JPanel[] playerNames = new JPanel[7];
		JPanel[] playerRanks = new JPanel[7];
		JPanel[] playerPositions = new JPanel[7];
		JPanel[] playerColleges = new JPanel[7];
		JPanel[] playerAges = new JPanel[7];
		JPanel[] playerHeights = new JPanel[7];
		JPanel[] playerWeights = new JPanel[7];

		for(int i=0;i<7;i++) {
			sectionCumulation = 249;
			playerPlaceHolders[i] = new JPanel();
			playerPlaceHolders[i].setLayout(new BorderLayout());
			playerPlaceHolders[i].add(checkBoxes[i], BorderLayout.WEST);
			playerPlaceHolders[i].setBackground(Color.white);
			// x y width height\
			playerPlaceHolders[i].setBounds(sectionCumulation, (i+1) * (menuSectionHeight), section1Width, (menuSectionHeight));
			playerPlaceHolders[i].setBorder(new LineBorder(Color.black, 2));
			contentPane.add(playerPlaceHolders[i]);

			playerNames[i] = new JPanel();
			makeMenuPanel(playerNames[i], section1Width, section2Width, i+1);
			addNameLabel(nameLabels[i], playerNames[i], i+1);

			playerRanks[i] = new JPanel();
			makeMenuPanel(playerRanks[i], section2Width, section3Width, i+1);
			addRankLabel(rankLabels[i], playerRanks[i], i+1);

			playerPositions[i] = new JPanel();
			makeMenuPanel(playerPositions[i], section3Width, section4Width, i+1);
			addPositionLabel(positionLabels[i], playerPositions[i], i+1);

			playerColleges[i] = new JPanel();
			makeMenuPanel(playerColleges[i], section4Width, section5Width, i+1);
			addCollegeLabel(collegeLabels[i], playerColleges[i], i+1);

			playerAges[i] = new JPanel();
			makeMenuPanel(playerAges[i], section5Width, section6Width, i+1);
			addAgeLabel(ageLabels[i], playerAges[i], i+1);

			playerHeights[i] = new JPanel();
			makeMenuPanel(playerHeights[i], section6Width, section7Width, i+1);
			addHeightLabel(heightLabels[i], playerHeights[i], i+1);

			playerWeights[i] = new JPanel();
			makeMenuPanel(playerWeights[i], section6Width, section7Width, i+1);
			addWeightLabel(weightLabels[i], playerWeights[i], i+1);
		}

		

	}

	private class DownButton extends JButton implements ActionListener {

		public DownButton(String name) {
			super("Down");
			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

// take 7th rank
// find in all players
			boolean isGood = false;

			int count = 0;
			while (!isGood) {

				if (count + 1 >= allPlayers.size()) {
					break;
				}
				if (allPlayers.get(count).equals(sevenPlayers[6])) {
					isGood = true;
				} else {
					count++;
				}
			}

			if (isGood && !allPlayers.get(count + 1).equals(null)) {
				sevenPlayers[0] = sevenPlayers[1];
				sevenPlayers[1] = sevenPlayers[2];
				sevenPlayers[2] = sevenPlayers[3];
				sevenPlayers[3] = sevenPlayers[4];
				sevenPlayers[4] = sevenPlayers[5];
				sevenPlayers[5] = sevenPlayers[6];
				sevenPlayers[6] = allPlayers.get(count + 1);

// update names
				updateLabels();
			}
		}
	}

	private class UpButton extends JButton implements ActionListener {

		public UpButton(String name) {
			super("Up");
			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

// take 1st rank
// find in all players
			boolean isGood = false;

			if (allPlayers.size() > 6) {

				int count = 0;
				while (!isGood) {

// count + 1 ??
					if (count + 1 >= allPlayers.size()) {
						break;
					}
					if (allPlayers.get(count).equals(sevenPlayers[0])) {
						isGood = true;
					} else {
						count++;
					}
				}

				if (count >= 1 && isGood && !allPlayers.get(count - 1).equals(null)) {
					sevenPlayers[6] = sevenPlayers[5];
					sevenPlayers[5] = sevenPlayers[4];
					sevenPlayers[4] = sevenPlayers[3];
					sevenPlayers[3] = sevenPlayers[2];
					sevenPlayers[2] = sevenPlayers[1];
					sevenPlayers[1] = sevenPlayers[0];
					sevenPlayers[0] = allPlayers.get(count - 1);

// update names
					updateLabels();
				}

				if (!isGood) {
					teamLabel.setText("Draft is over!");
				}
			}
		}
	}

	int s = constantTime;
	TimerTask task = new TimerTask() {

		@Override
		public void run() {

			if (pickNum == 1 && s == constantTime) {
				Team team = Team.getTeam(pickNum, teams);
				teamLabel.setText("Pick #" + pickNum + ": The " + team.getName() + " are on the clock");

			}

			if (s < 0) {
				timerLabel.setText("Time is up!");
				pickNum++;
				if (pickNum >= 32) {
					timer.cancel();
				} else {
					Team team = Team.getTeam(pickNum, teams);

					teamLabel.setText("The " + team.getName() + " are on the clock");
					s = constantTime;

				}
			} else {
				/**
				 * if(s < 0) { s = constantTime; }
				 */

				if (s % 60 < 10) {
					timerLabel.setText("CLOCK: " + s / 60 + ": 0" + (s % 60));
				} else {
					timerLabel.setText("CLOCK: " + s / 60 + ": " + (s % 60));
				}

				s--;
			}

		}

	};

	public void start() {
		timer.scheduleAtFixedRate(task, 1000, 1000);
	}

	public class CheckBox extends JCheckBox implements ActionListener {

		public CheckBox(String text) {
			super(text);
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			Player p = new Player();
			if (equals(checkBoxes[0])) {
				p = sevenPlayers[0];
			} else if (equals(checkBoxes[1])) {
				p = sevenPlayers[1];
			} else if (equals(checkBoxes[2])) {
				p = sevenPlayers[2];
			} else if (equals(checkBoxes[3])) {
				p = sevenPlayers[3];
			} else if (equals(checkBoxes[4])) {
				p = sevenPlayers[4];
			} else if (equals(checkBoxes[5])) {
				p = sevenPlayers[5];
			} else if (equals(checkBoxes[6])) {
				p = sevenPlayers[6];
			}
			int input = JOptionPane.showInternalConfirmDialog(null,
					("Are you sure you want to draft " + p.getName() + "\nType: Yes/No"));

			if (input == JOptionPane.YES_OPTION) {
				if (p.getRank() + 3 < pickNum) {
					JOptionPane.showMessageDialog(null, p.getName() + " was a steal!");

				} else if ((p.getRank() - 4) > pickNum) {
					JOptionPane.showMessageDialog(null, p.getName() + " was a reach!");

				} else {
					JOptionPane.showMessageDialog(null, p.getName() + " was a solid pick");

				}

				boolean isGood = false;

				int count = 0;
				while (!isGood) {

					if (count >= allPlayers.size()) {
						break;
					}
// find count!!!
					if (allPlayers.get(count).equals(p)) {
						isGood = true;
					} else {
						count++;
					}
				}

// all players index

				int numb = 0;
				for (numb = 0; numb < sevenPlayers.length; numb++) {
					if (sevenPlayers[numb] == allPlayers.get(count)) {
						break;
					}

					//numb++;
				}

				allPlayers.remove(count);
				sevenPlayers[numb] = null;
				if (isGood && !allPlayers.get(7).equals(null)) {

					while (numb < 7) {
						if (numb < 6) {
							sevenPlayers[numb] = sevenPlayers[numb + 1];
						} else {
// last one
							sevenPlayers[numb] = allPlayers.get(count);
						}
						numb++;
						count++;
					}

				}
				updateLabels();

				pickNum++;
			} else if (input == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, p.getName() + " was not drafted");
			} else {
				JOptionPane.showMessageDialog(null, "The draft selection has been cancelled!");
			}

			this.setSelected(false);
		}
	}

	public void updateLabels() {
		



		// update names
		for(int i = 0; i < 7; i++) {
			nameLabels[i].setText(" " + sevenPlayers[i].getName());
			rankLabels[i].setText(" " + sevenPlayers[0].getRank());
			positionLabels[i].setText(" " + sevenPlayers[0].getPosition());
			collegeLabels[i].setText(" " + sevenPlayers[0].getCollege());
			ageLabels[i].setText(" " + sevenPlayers[0].getAge());
			heightLabels[i].setText(" " + sevenPlayers[0].getHeight());
			weightLabels[i].setText(" " + sevenPlayers[0].getWeight() + " Pounds");
		}

	}

	/**
	 * 
	 * @param label
	 * @param panel
	 * @param num
	 */
	void addWeightLabel(JLabel label, JPanel panel, int num) {
		panel.add(label, BorderLayout.WEST);
		label.setText(" " + sevenPlayers[num - 1].getWeight() + " Pounds");
		contentPane.add(panel);
	}

	/**
	 * 
	 * @param label
	 * @param panel
	 * @param num
	 */
	void addHeightLabel(JLabel label, JPanel panel, int num) {
		panel.add(label, BorderLayout.WEST);
		label.setText(" " + sevenPlayers[num - 1].getHeight());
		contentPane.add(panel);
	}

	/**
	 * 
	 * @param label
	 * @param panel
	 * @param num
	 */
	void addAgeLabel(JLabel label, JPanel panel, int num) {
		panel.add(label, BorderLayout.WEST);
		label.setText(" " + sevenPlayers[num - 1].getAge());
		contentPane.add(panel);
	}

	/**
	 * 
	 * @param label
	 * @param panel
	 * @param num
	 */
	void addCollegeLabel(JLabel label, JPanel panel, int num) {
		panel.add(label, BorderLayout.WEST);
		label.setText(" " + sevenPlayers[num - 1].getCollege());
		contentPane.add(panel);
	}

	/**
	 * 
	 * @param label
	 * @param panel
	 * @param num
	 */
	void addPositionLabel(JLabel label, JPanel panel, int num) {
		panel.add(label, BorderLayout.WEST);
		label.setText(" " + sevenPlayers[num - 1].getPosition());
		contentPane.add(panel);
	}
	
	
	/**
	 * 
	 * @param label
	 * @param panel
	 * @param num
	 */
	void addRankLabel(JLabel label, JPanel panel, int num) {
		panel.add(label, BorderLayout.WEST);
		label.setText(" " + sevenPlayers[num - 1].getRank());
		contentPane.add(panel);
	}

	/**
	 * 
	 * @param label
	 * @param panel 
	 * @param num
	 */
	void addNameLabel(JLabel label, JPanel panel, int num) {
		panel.add(label, BorderLayout.WEST);
		label.setText(" " + sevenPlayers[num - 1].getName());
		contentPane.add(panel);
	}

}