import psycopg2

# current year 
year = 2022

# players
players = [{'year': 2022, 'first_name': 'Kyle', 'last_name': 'Hamilton', 'college': 'Notre Dame', 'position': 'SAF', 'class': 'N/A', 'rating': 6.81, 'height': 'N/A', 'weight': 0.0, 'arms': 'N/A', 'hands': 0.0, 'age': 0, 'hometown': 'N/A', 'forty': '4.59', 'bench': '0', 'vertical_jump': '38.0', 'broad_jump': '131', 'three_cone': '6.90', 'twenty_yard_shuttle': '4.32', 'sixty_yard_shuttle': 0.0, 'scout_report': 'N/A', 'class': 'Junior'}]

# Connect to the default database
conn = psycopg2.connect(
    host="localhost",
    user="postgres",
    password="root",
    database="postgres",
)

# Create a cursor object
cursor = conn.cursor()

# Create the database
#database_name = "player_db"
#query = f"CREATE DATABASE IF NOT EXISTS {database_name}"
#cursor.execute(query)

#reconnect
#conn.close
#cursor.close


"""conn = psycopg2.connect(
    host="localhost",
    user="postgres",
    password="root",
    database="player_db",
)"""

# Create a cursor object
cursor = conn.cursor()

# Create players table
query = """
CREATE TABLE IF NOT EXISTS players (
		id serial NOT NULL PRIMARY KEY,
		year int,		
		first_name varchar (15) NOT NULL,
		last_name varchar(20) NOT NULL,
		college varchar(50) NOT NULL,
		position varchar(5) NOT NULL,
		class varchar(15),
		rating numeric(3,2) NOT NULL,
		height varchar(10),
		weight numeric(3,2),
		arms varchar(10),
		hands numeric(5,2),
		age int,
		hometown varchar(30),
		scout_report varchar(150),
		forty numeric(3,2),
		bench int,
		vertical_jump int, 
		broad_jump numeric(6,2), 
		three_cone numeric(3,2),
		twenty_yard_shuttle numeric(3,2),
		sixty_yard_shuttle numeric(3,2)
);
"""
cursor.execute(query)

# remove values of the year we are working with 
query = "DELETE FROM players WHERE year = " + str(year) + ";"
cursor.execute(query)





i = 1
for player in players:

	values = ""
	for k in player:
		values = values + "%(" + str(k) +")s,"

	if values[-1] == ',':
		values = values[0:-1]


	cursor.execute("""
    INSERT INTO players (year,
			first_name,
			last_name, 
			college, 
			position,
			class,
			rating,
			height,
			weight,
			arms,
			hands,
			age,
			hometown,
			scout_report,
			forty,
			bench, 
			vertical_jump,
			broad_jump,
			three_cone, 
			twenty_yard_shuttle,
			sixty_yard_shuttle)
    
    VALUES (""" + values + """);
     """,
	player)

	
	"""
	cursor.execute("INSERT INTO players VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)", 
		[,
		year,
		player['first_name'],
			player['last_name'], 
			player['college'], 
			player['position'],
			player['class'],
			player['rating'],
			player['height'],
			player['weight'],
			player['arms'],
			player['hands'],
			player['age'],
			player['hometown'],
			player['scout_report'],
			player['forty'],
			player['bench'], 
			player['vertical_jump'],
			player['broad_jump'],
			player['three_cone'], 
			player['twenty_yard_shuttle'],
			player['sixty_yard_shuttle']])"""
	
	i = i + 1

# commit changes 
#commit the transaction
conn.commit()

# Close the cursor and connection
cursor.close()
conn.close()
