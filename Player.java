
public class Player {

	private int rank;
	private String position;
	private String college;
	private int weight;
	private String height;
	private int age;
	private String name;

	public Player() {

	}

	public Player(int rank, String position, int weight, String height, String name, int age, String college) {

		this.rank = rank;
		this.position = position;
		this.college = college;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.name = name;

	}

	public int getAge() {
		return age;
	}

	public int getWeight() {
		return weight;
	}

	public String getHeight() {
		return height;
	}

	public String getCollege() {
		return college;
	}

	public String getPosition() {
		return position;
	}

	public int getRank() {
		return rank;
	}

	public String getName() {
		return name;
	}

}