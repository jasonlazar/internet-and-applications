import pandas as pd
import csv

def cleantext(text):
    text = text.replace('.',"")
    return text

data = pd.read_csv('ekloges2014.csv', sep=';', dtype=str)
print(data.head())
with open("districts.csv", 'w', newline='', encoding='utf8') as file1, open("municipalities.csv", 'w', newline='', encoding='utf8') as file2:
    writer1 = csv.writer(file1)
    writer2 = csv.writer(file2)
    writer1.writerow(["id", "name"])
    writer2.writerow(["id", "district_id", "name", "men", "women"])
    last_id =""
    for row in data.itertuples(index=True, name='Pandas'):
        district_id = getattr(row, 'ΚΩΔ')
        district_name = getattr(row, "ΠΕΡΙΦΕΡΕΙΑ")
        if (district_id != last_id):
            writer1.writerow([district_id, district_name])
        last_id = district_id
        mun_id = getattr(row, 'ΚΩΔ1')
        mun_name = getattr(row, "ΔΗΜΟΣ")
        men = cleantext(getattr(row, "ΑΝΔΡΕΣ"))
        women = cleantext(getattr(row, "ΓΥΝΑΙΚΕΣ"))
        writer2.writerow([mun_id, district_id, mun_name, men, women])