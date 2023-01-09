
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

	CheckBox player1CheckBox = new CheckBox("Draft");
	CheckBox player2CheckBox = new CheckBox("Draft");
	CheckBox player3CheckBox = new CheckBox("Draft");
	CheckBox player4CheckBox = new CheckBox("Draft");
	CheckBox player5CheckBox = new CheckBox("Draft");
	CheckBox player6CheckBox = new CheckBox("Draft");
	CheckBox player7CheckBox = new CheckBox("Draft");

	int section1Width = 58;
	int section2Width = 200;
	int section3Width = 125;
	int section4Width = 125;
	int section5Width = 125;
	int section6Width = 125;
	int section7Width = 128;
	int section8Width = 130;

	JLabel player1NameLabel = new JLabel();
	JLabel player2NameLabel = new JLabel();
	JLabel player3NameLabel = new JLabel();
	JLabel player4NameLabel = new JLabel();
	JLabel player5NameLabel = new JLabel();
	JLabel player6NameLabel = new JLabel();
	JLabel player7NameLabel = new JLabel();

	JLabel player1RankLabel = new JLabel();
	JLabel player2RankLabel = new JLabel();
	JLabel player3RankLabel = new JLabel();
	JLabel player4RankLabel = new JLabel();
	JLabel player5RankLabel = new JLabel();
	JLabel player6RankLabel = new JLabel();
	JLabel player7RankLabel = new JLabel();

	JLabel player1PositionLabel = new JLabel();
	JLabel player2PositionLabel = new JLabel();
	JLabel player3PositionLabel = new JLabel();
	JLabel player4PositionLabel = new JLabel();
	JLabel player5PositionLabel = new JLabel();
	JLabel player6PositionLabel = new JLabel();
	JLabel player7PositionLabel = new JLabel();

	JLabel player1CollegeLabel = new JLabel();
	JLabel player2CollegeLabel = new JLabel();
	JLabel player3CollegeLabel = new JLabel();
	JLabel player4CollegeLabel = new JLabel();
	JLabel player5CollegeLabel = new JLabel();
	JLabel player6CollegeLabel = new JLabel();
	JLabel player7CollegeLabel = new JLabel();

	JLabel player1AgeLabel = new JLabel();
	JLabel player2AgeLabel = new JLabel();
	JLabel player3AgeLabel = new JLabel();
	JLabel player4AgeLabel = new JLabel();
	JLabel player5AgeLabel = new JLabel();
	JLabel player6AgeLabel = new JLabel();
	JLabel player7AgeLabel = new JLabel();

	JLabel player1HeightLabel = new JLabel();
	JLabel player2HeightLabel = new JLabel();
	JLabel player3HeightLabel = new JLabel();
	JLabel player4HeightLabel = new JLabel();
	JLabel player5HeightLabel = new JLabel();
	JLabel player6HeightLabel = new JLabel();
	JLabel player7HeightLabel = new JLabel();

	JLabel player1WeightLabel = new JLabel();
	JLabel player2WeightLabel = new JLabel();
	JLabel player3WeightLabel = new JLabel();
	JLabel player4WeightLabel = new JLabel();
	JLabel player5WeightLabel = new JLabel();
	JLabel player6WeightLabel = new JLabel();
	JLabel player7WeightLabel = new JLabel();

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

		JPanel player1PlaceHolder = new JPanel();
		player1PlaceHolder.setLayout(new BorderLayout());
		player1PlaceHolder.add(player1CheckBox, BorderLayout.WEST);
		player1PlaceHolder.setBackground(Color.white);
// x y width height\
		player1PlaceHolder.setBounds(sectionCumulation, (menuSectionHeight), section1Width, (menuSectionHeight));
		player1PlaceHolder.setBorder(new LineBorder(Color.black, 2));
		contentPane.add(player1PlaceHolder);

		JPanel player1Name = new JPanel();
		makeMenuPanel(player1Name, section1Width, section2Width, 1);
		addNameLabel(player1NameLabel, player1Name, 1);

		JPanel player1Rank = new JPanel();
		makeMenuPanel(player1Rank, section2Width, section3Width, 1);
		addRankLabel(player1RankLabel, player1Rank, 1);

		JPanel player1Position = new JPanel();
		makeMenuPanel(player1Position, section3Width, section4Width, 1);
		addPositionLabel(player1PositionLabel, player1Position, 1);

		JPanel player1College = new JPanel();
		makeMenuPanel(player1College, section4Width, section5Width, 1);
		addCollegeLabel(player1CollegeLabel, player1College, 1);

		JPanel player1Age = new JPanel();
		this.makeMenuPanel(player1Age, section5Width, section6Width, 1);
		addAgeLabel(player1AgeLabel, player1Age, 1);

		JPanel player1Height = new JPanel();
		this.makeMenuPanel(player1Height, section6Width, section7Width, 1);
		addHeightLabel(player1HeightLabel, player1Height, 1);

		JPanel player1Weight = new JPanel();
		this.makeMenuPanel(player1Weight, section7Width, section8Width, 1);
		addWeightLabel(player1WeightLabel, player1Weight, 1);

		sectionCumulation = 249;

		JPanel player2PlaceHolder = new JPanel();
		player2PlaceHolder.setLayout(new BorderLayout());
		player2PlaceHolder.add(player2CheckBox, BorderLayout.WEST);
		player2PlaceHolder.setBackground(Color.white);
// x y width height\
		player2PlaceHolder.setBounds(sectionCumulation, 2 * (menuSectionHeight), section1Width, (menuSectionHeight));
		player2PlaceHolder.setBorder(new LineBorder(Color.black, 2));
		contentPane.add(player2PlaceHolder);

		JPanel player2Name = new JPanel();
		makeMenuPanel(player2Name, section1Width, section2Width, 2);
		addNameLabel(player2NameLabel, player2Name, 2);

		JPanel player2Rank = new JPanel();
		makeMenuPanel(player2Rank, section2Width, section3Width, 2);
		addRankLabel(player2RankLabel, player2Rank, 2);

		JPanel player2Position = new JPanel();
		makeMenuPanel(player2Position, section3Width, section4Width, 2);
		addPositionLabel(player2PositionLabel, player2Position, 2);

		JPanel player2College = new JPanel();
		makeMenuPanel(player2College, section4Width, section5Width, 2);
		addCollegeLabel(player2CollegeLabel, player2College, 2);

		JPanel player2Age = new JPanel();
		makeMenuPanel(player2Age, section5Width, section6Width, 2);
		addAgeLabel(player2AgeLabel, player2Age, 2);

		JPanel player2Height = new JPanel();
		makeMenuPanel(player2Height, section6Width, section7Width, 2);
		addHeightLabel(player2HeightLabel, player2Height, 2);

		JPanel player2Weight = new JPanel();
		makeMenuPanel(player2Weight, section7Width, section8Width, 2);
		addWeightLabel(player2WeightLabel, player2Weight, 2);

		sectionCumulation = 249;

		JPanel player3PlaceHolder = new JPanel();
		player3PlaceHolder.setLayout(new BorderLayout());
		player3PlaceHolder.add(player3CheckBox, BorderLayout.WEST);
		player3PlaceHolder.setBackground(Color.white);
// x y width height\
		player3PlaceHolder.setBounds(sectionCumulation, 3 * (menuSectionHeight), section1Width, (menuSectionHeight));
		player3PlaceHolder.setBorder(new LineBorder(Color.black, 2));
		contentPane.add(player3PlaceHolder);

		JPanel player3Name = new JPanel();
		makeMenuPanel(player3Name, section1Width, section2Width, 3);
		addNameLabel(player3NameLabel, player3Name, 3);

		JPanel player3Rank = new JPanel();
		makeMenuPanel(player3Rank, section2Width, section3Width, 3);
		addRankLabel(player3RankLabel, player3Rank, 3);

		JPanel player3Position = new JPanel();
		makeMenuPanel(player3Position, section3Width, section4Width, 3);
		addPositionLabel(player3PositionLabel, player3Position, 3);

		JPanel player3College = new JPanel();
		makeMenuPanel(player3College, section4Width, section5Width, 3);
		addCollegeLabel(player3CollegeLabel, player3College, 3);

		JPanel player3Age = new JPanel();
		makeMenuPanel(player3Age, section5Width, section6Width, 3);
		addAgeLabel(player3AgeLabel, player3Age, 3);

		JPanel player3Height = new JPanel();
		makeMenuPanel(player3Height, section6Width, section7Width, 3);
		addHeightLabel(player3HeightLabel, player3Height, 3);

		JPanel player3Weight = new JPanel();
		makeMenuPanel(player3Weight, section7Width, section8Width, 3);
		addWeightLabel(player3WeightLabel, player3Weight, 3);

		sectionCumulation = 249;

		JPanel player4PlaceHolder = new JPanel();
		player4PlaceHolder.setLayout(new BorderLayout());
		player4PlaceHolder.add(player4CheckBox, BorderLayout.WEST);
		player4PlaceHolder.setBackground(Color.white);
// x y width height\
		player4PlaceHolder.setBounds(sectionCumulation, 4 * (menuSectionHeight), section1Width, (menuSectionHeight));
		player4PlaceHolder.setBorder(new LineBorder(Color.black, 2));
		contentPane.add(player4PlaceHolder);

		JPanel player4Name = new JPanel();
		makeMenuPanel(player4Name, section1Width, section2Width, 4);
		addNameLabel(player4NameLabel, player4Name, 4);

		JPanel player4Rank = new JPanel();
		makeMenuPanel(player4Rank, section2Width, section3Width, 4);
		addRankLabel(player4RankLabel, player4Rank, 4);

		JPanel player4Position = new JPanel();
		makeMenuPanel(player4Position, section3Width, section4Width, 4);
		addPositionLabel(player4PositionLabel, player4Position, 4);

		JPanel player4College = new JPanel();
		makeMenuPanel(player4College, section4Width, section5Width, 4);
		addCollegeLabel(player4CollegeLabel, player4College, 4);

		JPanel player4Age = new JPanel();
		makeMenuPanel(player4Age, section5Width, section6Width, 4);
		addAgeLabel(player4AgeLabel, player4Age, 4);

		JPanel player4Height = new JPanel();
		makeMenuPanel(player4Height, section6Width, section7Width, 4);
		addHeightLabel(player4HeightLabel, player4Height, 4);

		JPanel player4Weight = new JPanel();
		makeMenuPanel(player4Weight, section7Width, section8Width, 4);
		addWeightLabel(player4WeightLabel, player4Weight, 4);

		sectionCumulation = 249;

		JPanel player5PlaceHolder = new JPanel();
		player5PlaceHolder.setLayout(new BorderLayout());
		player5PlaceHolder.add(player5CheckBox, BorderLayout.WEST);
		player5PlaceHolder.setBackground(Color.white);
// x y width height\
		player5PlaceHolder.setBounds(sectionCumulation, 5 * (menuSectionHeight), section1Width, (menuSectionHeight));
		player5PlaceHolder.setBorder(new LineBorder(Color.black, 2));
		contentPane.add(player5PlaceHolder);

		JPanel player5Name = new JPanel();
		makeMenuPanel(player5Name, section1Width, section2Width, 5);
		addNameLabel(player5NameLabel, player5Name, 5);

		JPanel player5Rank = new JPanel();
		makeMenuPanel(player5Rank, section2Width, section3Width, 5);
		addRankLabel(player5RankLabel, player5Rank, 5);

		JPanel player5Position = new JPanel();
		makeMenuPanel(player5Position, section3Width, section4Width, 5);
		addPositionLabel(player5PositionLabel, player5Position, 5);

		JPanel player5College = new JPanel();
		makeMenuPanel(player5College, section4Width, section5Width, 5);
		addCollegeLabel(player5CollegeLabel, player5College, 5);

		JPanel player5Age = new JPanel();
		this.makeMenuPanel(player5Age, section5Width, section6Width, 5);
		addAgeLabel(player5AgeLabel, player5Age, 5);

		JPanel player5Height = new JPanel();
		this.makeMenuPanel(player5Height, section6Width, section7Width, 5);
		addHeightLabel(player5HeightLabel, player5Height, 5);

		JPanel player5Weight = new JPanel();
		this.makeMenuPanel(player5Weight, section7Width, section8Width, 5);
		addWeightLabel(player5WeightLabel, player5Weight, 5);

		sectionCumulation = 249;
		JPanel player6PlaceHolder = new JPanel();
		player6PlaceHolder.setLayout(new BorderLayout());
		player6PlaceHolder.add(player6CheckBox, BorderLayout.WEST);
		player6PlaceHolder.setBackground(Color.white);
// x y width height\
		player6PlaceHolder.setBounds(sectionCumulation, 6 * (menuSectionHeight), section1Width, (menuSectionHeight));
		player6PlaceHolder.setBorder(new LineBorder(Color.black, 2));
		contentPane.add(player6PlaceHolder);

		JPanel player6Name = new JPanel();
		makeMenuPanel(player6Name, section1Width, section2Width, 6);
		addNameLabel(player6NameLabel, player6Name, 6);

		JPanel player6Rank = new JPanel();
		makeMenuPanel(player6Rank, section2Width, section3Width, 6);
		addRankLabel(player6RankLabel, player6Rank, 6);

		JPanel player6Position = new JPanel();
		makeMenuPanel(player6Position, section3Width, section4Width, 6);
		addPositionLabel(player6PositionLabel, player6Position, 6);

		JPanel player6College = new JPanel();
		makeMenuPanel(player6College, section4Width, section5Width, 6);
		addCollegeLabel(player6CollegeLabel, player6College, 6);

		JPanel player6Age = new JPanel();
		makeMenuPanel(player6Age, section5Width, section6Width, 6);
		addAgeLabel(player6AgeLabel, player6Age, 6);

		JPanel player6Height = new JPanel();
		makeMenuPanel(player6Height, section6Width, section7Width, 6);
		addHeightLabel(player6HeightLabel, player6Height, 6);

		JPanel player6Weight = new JPanel();
		makeMenuPanel(player6Weight, section7Width, section8Width, 6);
		addWeightLabel(player6WeightLabel, player6Weight, 6);

		sectionCumulation = 249;
		JPanel player7PlaceHolder = new JPanel();
		player7PlaceHolder.setLayout(new BorderLayout());
		player7PlaceHolder.add(player7CheckBox, BorderLayout.WEST);
		player7PlaceHolder.setBackground(Color.white);
// x y width height\
		player7PlaceHolder.setBounds(sectionCumulation, 7 * (menuSectionHeight), section1Width, (menuSectionHeight));
		player7PlaceHolder.setBorder(new LineBorder(Color.black, 2));
		contentPane.add(player7PlaceHolder);

		JPanel player7Name = new JPanel();
		makeMenuPanel(player7Name, section1Width, section2Width, 7);
		addNameLabel(player7NameLabel, player7Name, 7);

		JPanel player7Rank = new JPanel();
		makeMenuPanel(player7Rank, section2Width, section3Width, 7);
		addRankLabel(player7RankLabel, player7Rank, 7);

		JPanel player7Position = new JPanel();
		makeMenuPanel(player7Position, section3Width, section4Width, 7);
		addPositionLabel(player7PositionLabel, player7Position, 7);

		JPanel player7College = new JPanel();
		makeMenuPanel(player7College, section4Width, section5Width, 7);
		addCollegeLabel(player7CollegeLabel, player7College, 7);

		JPanel player7Age = new JPanel();
		makeMenuPanel(player7Age, section5Width, section6Width, 7);
		addAgeLabel(player7AgeLabel, player7Age, 7);

		JPanel player7Height = new JPanel();
		makeMenuPanel(player7Height, section6Width, section7Width, 7);
		addHeightLabel(player7HeightLabel, player7Height, 7);

		JPanel player7Weight = new JPanel();
		makeMenuPanel(player7Weight, section7Width, section8Width, 7);
		addWeightLabel(player7WeightLabel, player7Weight, 7);

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
			if (equals(player1CheckBox)) {
				p = sevenPlayers[0];
			} else if (equals(player2CheckBox)) {
				p = sevenPlayers[1];
			} else if (equals(player3CheckBox)) {
				p = sevenPlayers[2];
			} else if (equals(player4CheckBox)) {
				p = sevenPlayers[3];
			} else if (equals(player5CheckBox)) {
				p = sevenPlayers[4];
			} else if (equals(player6CheckBox)) {
				p = sevenPlayers[5];
			} else if (equals(player7CheckBox)) {
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
		player1NameLabel.setText(" " + sevenPlayers[0].getName());
		player2NameLabel.setText(" " + sevenPlayers[1].getName());
		player3NameLabel.setText(" " + sevenPlayers[2].getName());
		player4NameLabel.setText(" " + sevenPlayers[3].getName());
		player5NameLabel.setText(" " + sevenPlayers[4].getName());
		player6NameLabel.setText(" " + sevenPlayers[5].getName());
		player7NameLabel.setText(" " + sevenPlayers[6].getName());

		// update ranks
		player1RankLabel.setText(" " + sevenPlayers[0].getRank());
		player2RankLabel.setText(" " + sevenPlayers[1].getRank());
		player3RankLabel.setText(" " + sevenPlayers[2].getRank());
		player4RankLabel.setText(" " + sevenPlayers[3].getRank());
		player5RankLabel.setText(" " + sevenPlayers[4].getRank());
		player6RankLabel.setText(" " + sevenPlayers[5].getRank());
		player7RankLabel.setText(" " + sevenPlayers[6].getRank());

		// update positions
		player1PositionLabel.setText(" " + sevenPlayers[0].getPosition());
		player2PositionLabel.setText(" " + sevenPlayers[1].getPosition());
		player3PositionLabel.setText(" " + sevenPlayers[2].getPosition());
		player4PositionLabel.setText(" " + sevenPlayers[3].getPosition());
		player5PositionLabel.setText(" " + sevenPlayers[4].getPosition());
		player6PositionLabel.setText(" " + sevenPlayers[5].getPosition());
		player7PositionLabel.setText(" " + sevenPlayers[6].getPosition());

		// update colleges
		player1CollegeLabel.setText(" " + sevenPlayers[0].getCollege());
		player2CollegeLabel.setText(" " + sevenPlayers[1].getCollege());
		player3CollegeLabel.setText(" " + sevenPlayers[2].getCollege());
		player4CollegeLabel.setText(" " + sevenPlayers[3].getCollege());
		player5CollegeLabel.setText(" " + sevenPlayers[4].getCollege());
		player6CollegeLabel.setText(" " + sevenPlayers[5].getCollege());
		player7CollegeLabel.setText(" " + sevenPlayers[6].getCollege());

		// update ages
		player1AgeLabel.setText(" " + sevenPlayers[0].getAge());
		player2AgeLabel.setText(" " + sevenPlayers[1].getAge());
		player3AgeLabel.setText(" " + sevenPlayers[2].getAge());
		player4AgeLabel.setText(" " + sevenPlayers[3].getAge());
		player5AgeLabel.setText(" " + sevenPlayers[4].getAge());
		player6AgeLabel.setText(" " + sevenPlayers[5].getAge());
		player7AgeLabel.setText(" " + sevenPlayers[6].getAge());

		// update heights 
		player1HeightLabel.setText(" " + sevenPlayers[0].getHeight());
		player2HeightLabel.setText(" " + sevenPlayers[1].getHeight());
		player3HeightLabel.setText(" " + sevenPlayers[2].getHeight());
		player4HeightLabel.setText(" " + sevenPlayers[3].getHeight());
		player5HeightLabel.setText(" " + sevenPlayers[4].getHeight());
		player6HeightLabel.setText(" " + sevenPlayers[5].getHeight());
		player7HeightLabel.setText(" " + sevenPlayers[6].getHeight());

		// update weights 
		player1WeightLabel.setText(" " + sevenPlayers[0].getWeight() + " Pounds");
		player2WeightLabel.setText(" " + sevenPlayers[1].getWeight() + " Pounds");
		player3WeightLabel.setText(" " + sevenPlayers[2].getWeight() + " Pounds");
		player4WeightLabel.setText(" " + sevenPlayers[3].getWeight() + " Pounds");
		player5WeightLabel.setText(" " + sevenPlayers[4].getWeight() + " Pounds");
		player6WeightLabel.setText(" " + sevenPlayers[5].getWeight() + " Pounds");
		player7WeightLabel.setText(" " + sevenPlayers[6].getWeight() + " Pounds");
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