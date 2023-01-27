import java.util.HashMap;
/*
	Manages Draft session
*/

public class DraftSession {

	/* number of picks in a draft */
	private static final NUM_PICKS = 256;
	private static final NUM_TEAMS = 32;

	/* Map team ids to Team objects*/
	HashMap<Integer, Team> map = new HashMap();

	/* ids */
	private int[] picks = new int[NUM_PICKS];
	

	/* set original draft session */
	public DraftSession() {
		
		/*  Assign picks the id of the team selecting there*/
		for(int i = 0; i < NUM_PICKS; i++) {
			this.picks[i] = i % NUM_TEAMS;
		}

		/* Assign team id's and team selection */
		Random random = new Random();

		/* possible draft selections */
		ArrayList<Int> selections = new ArrayList<Int>();

		/* Get possible id's */
		for(int i = 0; i < NUM_TEAMS; i++) {
			selections.add(i);
		}

		/*  Randomly pick draft pick for each team */
		for(int i = 0; i < NUM_TEAMS; i++) {

			/* get random selection left for the team*/
			int rand = random.nextInt(selections.length);
			
			
			int draftRound = 1;
			int numRounds = 7;

			for(int draftRound = 1; draftRound <= NUM_DRAFT_ROUNDS; draftRound++) {
				teams[i].picks.add(draftRound * selections[rand]);
			}

			/* remove taken selection at location i*/
			selections.remove(i);

		}





	}
}