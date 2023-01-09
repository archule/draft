
import java.util.ArrayList;

public class Team {

	String name;
	ArrayList<Integer> picks;

	public Team(String name, ArrayList<Integer> picks) {
		this.name = name;
		this.picks = picks;
	}

	static Team[] assignPicks() {
		Team[] teams = new Team[32];
		ArrayList<Integer> localPicks = new ArrayList<Integer>();

// AFC West
		ArrayList<Integer> localPicks1 = new ArrayList<Integer>();
		localPicks1.add(0, 12);
		localPicks1.add(1, 19);
		teams[0] = new Team("Las Vegas Raiders", localPicks1);

		ArrayList<Integer> localPicks2 = new ArrayList<Integer>();
		localPicks2.add(0, 6);
		teams[1] = new Team("Los Angeles Chargers", localPicks2);

		ArrayList<Integer> localPicks3 = new ArrayList<Integer>();
		localPicks3.add(0, 15);
		teams[2] = new Team("Denver Broncos", localPicks3);

		ArrayList<Integer> localPicks4 = new ArrayList<Integer>();
		localPicks4.add(0, 32);
		teams[3] = new Team("Kansas City Chiefs", localPicks4);

// AFC North
		ArrayList<Integer> localPicks5 = new ArrayList<Integer>();
		teams[4] = new Team("Pittsburg Steelers", localPicks5);

		ArrayList<Integer> localPicks6 = new ArrayList<Integer>();
		localPicks6.add(0, 28);
		teams[5] = new Team("Baltimore Ravens", localPicks6);

		ArrayList<Integer> localPicks7 = new ArrayList<Integer>();
		localPicks7.add(0, 10);
		teams[6] = new Team("Cleaveland Browns", localPicks7);

		ArrayList<Integer> localPicks8 = new ArrayList<Integer>();
		localPicks8.add(0, 1);
		teams[7] = new Team("Cincinnatti Bengals ", localPicks8);

// AFC South
		ArrayList<Integer> localPicks9 = new ArrayList<Integer>();
		localPicks9.add(0, 29);
		teams[8] = new Team("Tennesee Titans", localPicks9);

		ArrayList<Integer> localPicks10 = new ArrayList<Integer>();
		teams[9] = new Team("Houston Texans", localPicks10);

		ArrayList<Integer> localPicks11 = new ArrayList<Integer>();
		teams[10] = new Team("Indianaoplis Colts", localPicks11);

		ArrayList<Integer> localPicks12 = new ArrayList<Integer>();
		localPicks12.add(0, 9);
		localPicks12.add(1, 20);
		teams[11] = new Team("Jacksonville Jaguars ", localPicks12);

// AFC East
		ArrayList<Integer> localPicks13 = new ArrayList<Integer>();
		localPicks13.add(0, 23);
		teams[12] = new Team("New England Patriots", localPicks13);

		ArrayList<Integer> localPicks14 = new ArrayList<Integer>();
		teams[13] = new Team("Buffalo Bills", localPicks14);

		ArrayList<Integer> localPicks15 = new ArrayList<Integer>();
		localPicks15.add(0, 5);
		localPicks15.add(1, 18);
		localPicks15.add(2, 26);
		teams[14] = new Team("Miami Dolphins", localPicks15);

		ArrayList<Integer> localPicks16 = new ArrayList<Integer>();
		localPicks16.add(0, 11);
		teams[15] = new Team("New York Jets", localPicks16);

// NFC East
		ArrayList<Integer> localPicks17 = new ArrayList<Integer>();
		localPicks17.add(0, 2);
		teams[16] = new Team("Washington Redskins", localPicks17);

		ArrayList<Integer> localPicks18 = new ArrayList<Integer>();
		localPicks18.add(0, 17);
		teams[17] = new Team("Dallas Cowboys", localPicks18);

		ArrayList<Integer> localPicks19 = new ArrayList<Integer>();
		localPicks19.add(0, 4);
		teams[18] = new Team("New York Giants", localPicks19);

		ArrayList<Integer> localPicks20 = new ArrayList<Integer>();
		localPicks20.add(0, 21);
		teams[19] = new Team("Philidelphia Eagles", localPicks20);

// NFC WEST
		ArrayList<Integer> localPicks21 = new ArrayList<Integer>();
		localPicks21.add(0, 8);
		teams[20] = new Team("Arizona Cardinals", localPicks21);

		ArrayList<Integer> localPicks22 = new ArrayList<Integer>();
		localPicks22.add(0, 24);
		teams[21] = new Team("New Orlean Saints", localPicks22);

		ArrayList<Integer> localPicks23 = new ArrayList<Integer>();
		localPicks23.add(0, 27);
		teams[22] = new Team("Seattle Seahawks", localPicks23);

		ArrayList<Integer> localPicks24 = new ArrayList<Integer>();
		localPicks24.add(0, 13);
		localPicks24.add(1, 31);
		teams[23] = new Team("San Francisco 49ers", localPicks24);

// NFC North
		ArrayList<Integer> localPicks25 = new ArrayList<Integer>();
		localPicks25.add(0, 30);
		teams[24] = new Team("Green Bay Packers", localPicks25);

		ArrayList<Integer> localPicks26 = new ArrayList<Integer>();
		localPicks26.add(0, 3);
		teams[25] = new Team("Detroit Lions", localPicks26);

		ArrayList<Integer> localPicks27 = new ArrayList<Integer>();
		teams[26] = new Team("Chicago Bears", localPicks27);

		ArrayList<Integer> localPicks28 = new ArrayList<Integer>();
		localPicks28.add(0, 22);
		localPicks28.add(1, 25);
		teams[27] = new Team("Minnisota Vikings", localPicks28);

// NFC South
		ArrayList<Integer> localPicks29 = new ArrayList<Integer>();
		localPicks29.add(0, 14);
		teams[28] = new Team("Tampa Bay Bucaneers", localPicks29);

		ArrayList<Integer> localPicks30 = new ArrayList<Integer>();
		localPicks30.add(0, 24);
		teams[29] = new Team("New Orlean Saints", localPicks30);

		ArrayList<Integer> localPicks31 = new ArrayList<Integer>();
		localPicks31.clear();
		localPicks31.add(0, 7);
		teams[30] = new Team("Carolina Panthers", localPicks31);

		ArrayList<Integer> localPicks32 = new ArrayList<Integer>();
		localPicks32.add(0, 16);
		teams[31] = new Team("Atlanta Falcons", localPicks32);

		return teams;
	}

	static Team getTeam(Integer pick, Team[] teams) {
		Team aTeam = null;
		Team theTeam = null;
		for (int index = 0; index < teams.length; index++) {
			aTeam = teams[index];

			for (int counter = 0; counter < aTeam.picks.size(); counter++) {
				if (aTeam.picks.get(counter) == pick) {
					theTeam = aTeam;
					break;
				}
			}
		}

		return theTeam;
	}

	String getName() {
		return name;
	}

}