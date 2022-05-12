import requests, math, time
import csv, pathlib
import pandas as pd

#Aditya Sreedhar
#194000879

#setting my API and introducing question
url = "https://api.nytimes.com/svc/search/v2/articlesearch.json"
API_KEY = "7VG6T0PaDlesN4Ob61A0Axb8vhAkEnGZ"
print("Using the NYtimes api to determine the popularity of the student loan topics")
print("Results of popularity growth or decrease can indicate the severity of the student loan bubble")
print(" - Will process articles on the subject and return CSV data")
issue = "Student Loans"

#Initializing variables for export raw data 
date_published = []
section = []

article_name = []
article_url = []
article_num = []
num_hold = 1
page_number = []

year_of_publish = []
actual_year_of_publish = []
number_per_year = []
#variable for popularity 
popularity_calculator = ["Popularity ++"]

year_pub = 0

#setting parameters
parameters = {'q':issue, 'fq' : 'document_type:(article)', 'api-key':API_KEY}
response = requests.get(url,params=parameters)
content = response.json()
total_hits = content['response']['meta']['hits']


#States total hits and asks asks user how many they want to analyze
print('\nCurrently,', total_hits, "hits on Student Loans to be processed")
page_request=''
print("How many articles do you want to go through between 0 and", total_hits, " | Lower numbers result in faster load speed") 
user_request = input('Enter: ')
page_count = int(user_request)
print('Sit back and relax. This may take some time.........')




#for loop that goes through pages and collects data in two intervals
for ii in range(0, page_count):
    #looks through pages
    parameters['page']=ii

    #updates parameters 
    response = requests.get(url, params = parameters)
    content = response.json()

    
    for i in content['response']['docs']:

        article_num.append(num_hold)
        date_published.append(i['pub_date'])
        article_name.append(i['headline']['main'])
        section.append(i['section_name'])
        article_url.append(i['web_url'])
        page_number.append(ii)
        

        #gets year for publication date
        line = str(i['pub_date'])
        year_pub = int(line[0:4])
        year_of_publish.append(year_pub)

    time.sleep(10) #allows program to not overwhelm API

for i in year_of_publish:
            if i not in actual_year_of_publish:
                actual_year_of_publish.append(i)
actual_year_of_publish.sort()

article_number = {a:year_of_publish.count(a) for a in year_of_publish}

for x in actual_year_of_publish:
    if x in article_number.keys():
        number_per_year.append(article_number[x])

for i in (range(len(number_per_year)-1)):
    x = i + 1
    if number_per_year[x] - number_per_year[i] > 0:
        popularity_calculator.append("Popularity ++")
    elif(number_per_year)[x] -  number_per_year[i] < 0:
            popularity_calculator.append("Popularity --")
    elif(number_per_year)[x] -  number_per_year[i] == 0:
        popularity_calculator.append("Popularity ==")


raw_data = {'article number' : article_num, 'Article Name' : article_name, 'date published' : date_published,'page num': page_number, }
popularity_data = {'year_of_publish' : actual_year_of_publish, 'articles published this year' : number_per_year, 'popularity' : popularity_calculator}


#exporting data to csv to allow user to determine the data
df = pd.DataFrame(popularity_data, columns = ['Years Published', 'Articles Published this year', 'Popularity'])
dfraw = pd.DataFrame(raw_data, columns = ['Article Num','Page Num', 'Date Published', 'article name', 'section', 'article url'])
df = pd.DataFrame(popularity_data)
dfraw = pd.DataFrame(raw_data)
df.to_csv('popularity.csv',)
dfraw.to_csv('raw_data.csv',  )


print('ETL Pipeline complete! You can now view the CSV files')





