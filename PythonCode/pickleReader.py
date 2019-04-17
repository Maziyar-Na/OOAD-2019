import pickle
import os
import sys
import mysql

assert sys.version_info >= (3, 6)



"""
CREATE SCHEMA 'Library';
CREATE TABLE `Library`.`items2` (
  `ID` INT NULL,
  `Author` VARCHAR(256) NULL,
  `ISBN10` VARCHAR(17) NULL,
  `ISBN13` VARCHAR(17) NULL,
  `Title` VARCHAR(256) NULL,
  `PubDate` VARCHAR(64) NULL,
  `PageCount` INT NULL,
  `Lang` VARCHAR(8) NULL,
  `Format` VARCHAR(45) NULL,
  `SubTitle` VARCHAR(256) NULL,
  `url` VARCHAR(512) NULL,
  `Publisher` VARCHAR(96) NULL,
  `Subject` VARCHAR(256) NULL,
  `SubSubject` VARCHAR(256) NULL,
  PRIMARY KEY (`ID`));
  
  
CREATE TABLE 'Library'.'Person' (
`ID` INT NOT NULL,
`Name` VARCHAR(128) NULL,
`password` VARCHAR(128) NULL,
`type` INT NULL,
`DOB` DATETIME NULL,
`gender` VARCHAR(64) NULL,
`email` VARCHAR(256) NULL,
`phone` VARCHAR(24) NULL, 
`fees` DOUBLE NULL,
  PRIMARY KEY (`ID`));
  
"""


# data from https://openlibrary.org/developers/dumps

MY_PATH = '/Users/djb/Downloads/OOAD'

USER = 'admin'
PW = 'ooad2019'
HOST = 'localhost'
DATABASENAME = 'Library'
DATABASEPORT = 3306

AUTH = 'author'
I10 = 'isbn_10'
I13 = 'isbn_13'
LANG = 'language'
PC = 'pageCount'
PD = 'pubDate'
PUB = 'publisher'
SUB = 'subjects'
TITLE = 'title'
PT = "type"
SUBT = 'subtitle'
URL = 'url'
SUB1 = 'sub'
SUB2 = 'sub2'

authorDict = {}

dbConnection = None


def dbConn():
    user = AUTH
    password = PW
    host = HOST
    database = DATABASENAME
    port = DATABASEPORT

    config = {
        'user': user,
        'password': password,
        'host': host,
        'database': database,
        'port': port,
        'raise_on_warnings': True,
        'auth_plugin': 'mysql_native_password'
    }
    cnx = mysql.connector.connect(**config)

    return cnx


def dumpToDb(id, dataDict, dbConnection):
    cursor = dbConnection.cursor()

    author = dataDict[AUTH]
    isbn_10 = dataDict[I10]
    isbn_13 = dataDict[I13]
    title = dataDict[TITLE]
    pubdate = dataDict[PUB]
    pageCount = dataDict[PC]
    language = dataDict[LANG]
    format = dataDict[PT]
    subtitle = dataDict[SUBT]
    url = dataDict[URL]
    publisher = dataDict[PUB]
    sub = dataDict[SUB1]
    sub2 = dataDict[SUB2]

    insertString = "Insert into items  (ID, Author, ISBN10, ISBN13, Title, PubDate, PageCount, Lang,Format, SubTitle, url,Publisher,Subject, SubSubject) VALUES({:d}, '{}', '{}'," \
                   "'{}', '{}','{}', {:d}, '{}', '{}','{}' ,'{}', '{}' ,'{}' , '{}')".format(id, author, isbn_10,
                                                                                             isbn_13, title, pubdate,
                                                                                             pageCount, language,
                                                                                             format, subtitle, url,
                                                                                             publisher, sub, sub2)
    cursor.execute(insertString)
    dbConnection.commit()


def mainReader():
    pickleString = "%s/Library.pkl.pkl" % (MY_PATH)
    dbConnection = dbConn();
    if os.path.exists(pickleString):
        f = open(pickleString, 'rb')
        dd = pickle.load(f)
        for k, v in dd.items():
            dumpToDb(k, v, dbConnection)


if __name__ == '__main__':
    mainReader()
