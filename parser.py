import requests
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.options import Options
from bs4 import BeautifulSoup
import sys

options = Options()
options.add_argument('--headless')

curr_page = 1

year = int(sys.argv[1])

if year < 2014:
	print("This year is too early")
elif year > 2022:
	print("This year is too late")


url = 'https://www.nfl.com/draft/tracker/prospects/all-positions/all-colleges/all-statuses/' + str(year) + '?page=' + str(curr_page)

#chrome_options = Options()
#chrome_options.add_argument("--disable-extensions")
#chrome_options.add_argument("--disable-gpu")
#chrome_options.add_argument("--no-sandbox") # linux only
#chrome_options.add_argument("--headless")
# chrome_options.headless = True # also works
browser = webdriver.Chrome() #options=chrome_options

browser.get(url)

#html_source = browser.page_source


WebDriverWait(browser, 30).until(EC.visibility_of_all_elements_located((By.TAG_NAME, "tbody")))

soup = BeautifulSoup(browser.page_source, "html.parser")

# Get table
table = soup.find('tbody')

# get table rows
y = soup.find_all('tr')

i = 1

players = []
while len(y[i].text) > 0 and i < len(y):
	data = y[i].find_all('td')


	# Name
	name = data[0].a.text

	# college 
	college = data[0].find('div', class_="css-1ol443x").text

	# position
	position = data[2].text

	# class 
	class_ = data[4].text

	# rating 
	rating = data[5].text

	players.append([name, college, position, class_, rating])
	print("Appended" + str(name))
	i = i + 1

print("1 Done!")

# get page numbers 
x = soup.find('div', class_="css-13k5oh6").text.split()
page_num = int(x[3])


while curr_page < page_num:

	curr_page = curr_page + 1
	print("start page" + str(curr_page))
	url = 'https://www.nfl.com/draft/tracker/prospects/all-positions/all-colleges/all-statuses/' + str(year) + '?page=' + str(curr_page)
	browser.get(url)
	WebDriverWait(browser, 30).until(EC.visibility_of_all_elements_located((By.TAG_NAME, "tbody")))
	soup = BeautifulSoup(browser.page_source, "html.parser")

	# Get table
	table = soup.find('tbody')

	# get table rows
	y = soup.find_all('tr')

	i = 1

	players = []
	while len(y[i].text) > 0 and i < len(y):
		data = y[i].find_all('td')


		# Name
		name = data[0].a.text

		# college 
		college = data[0].find('div', class_="css-1ol443x").text

		# position
		position = data[2].text

		# class 
		class_ = data[4].text

		# rating 
		rating = data[5].text

		players.append([name, college, position, class_, rating])
		print("Appended" + str(name))
		i = i + 1

	# get page numbers 
	x = soup.find('div', class_="css-13k5oh6").text.split()
	curr_page = int(x[1])
	page_num = int(x[3])



print(players)