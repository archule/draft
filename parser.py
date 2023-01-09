import requests

# to be usable
# pip install requests
# pip install beautifulsoup4
# r.text[0:500]
import requests
r = requests.get('https://www.nfl.com/draft/tracker/prospects/all-positions/all-colleges/all-statuses/2022?page=1')

from bs4 import beautifulsoup4
soup = BeautifulSoup(r.text, 'html.parser')
