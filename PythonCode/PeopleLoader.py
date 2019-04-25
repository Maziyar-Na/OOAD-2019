import json
import pprint
import pickle
import os
import mysql.connector

# data from https://openlibrary.org/developers/dumps

ID = 'id'
USR = 'username'
PWD = 'password'
NAME = 'name'
DOB = 'dob'
GEN = 'gender'
EM = 'email'
PH = 'phone'
TYP = 'type'

DWIGHT = {ID: 1, USR: 'dbrowne', PWD: '12345', NAME: 'Dwight J. Browne', DOB: "1996-01-01", GEN: "M",
          EM: 'dwight.browne@colorado.edu', PH: '917-999-1234', TYP: 1}
SEPIDEH = {ID: 2, USR: 'sgoodardzy', PWD: '12345', NAME: 'Sepideh Goodarzy', DOB: "1997-02-02", GEN: "F",
           EM: 'sepideh.goodarzy@colorado.edu', PH: '303-999-1234', TYP: 1}
MAZIAR = {ID: 3, USR: 'mnazari', PWD: '12345', NAME: 'Maziyar Nazari', DOB: "1998-03-03", GEN: "M",
          EM: 'maziyar.nazari@colorado.edu', PH: '303-999-1234', TYP: 1}

MARAM = {ID: 4, USR: 'mkurdi', PWD: '12345', NAME: 'Maram Kurdi', DOB: "1999-04-04", GEN: "F",
         EM: 'maku7108@colorado.edu', PH: '303-999-1234', TYP: 1}


ADMIN = {ID: 5, USR: 'admin', PWD: '12345', NAME: 'false admin ', DOB: "2000-05-05", GEN: "F",
         EM: 'me@libary.com', PH: '303-999-1234', TYP: 2}
ADMIN2 = {ID: 6, USR: 'admin2', PWD: '12345', NAME: 'false admin ', DOB: "2000-05-05", GEN: "M",
         EM: 'metoo@libary.com', PH: '303-999-1234', TYP: 2}

LIBRARIAN ={ID: 7, USR: 'librarian', PWD: '12345', NAME: 'false admin ', DOB: "2000-05-05", GEN: "M",
         EM: 'metoo@libary.com', PH: '303-999-1234', TYP: 2}

LIBRARIAN1 ={ID: 8, USR: 'librarian1', PWD: '12345', NAME: 'false admin ', DOB: "2000-05-05", GEN: "M",
         EM: 'metoo@libary.com', PH: '303-999-1234', TYP: 2}

LIBRARIAN2 ={ID: 9, USR: 'librarian2', PWD: '12345', NAME: 'false admin ', DOB: "2000-05-05", GEN: "M",
         EM: 'metoo@libary.com', PH: '303-999-1234', TYP: 2}

LIBRARIAN3 ={ID: 10, USR: 'librarian3', PWD: '12345', NAME: 'false admin ', DOB: "2000-05-05", GEN: "M",
         EM: 'metoo@libary.com', PH: '303-999-1234', TYP: 2}


USERS = [DWIGHT, SEPIDEH, MAZIAR, MARAM, ADMIN, ADMIN2, LIBRARIAN, LIBRARIAN1, LIBRARIAN2, LIBRARIAN3]


dbConnection = None


def dbConn():
    user = 'admin'
    password = 'ooad2019'
    host = 'localhost'
    database = 'Library2'
    port = 3306

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


def persistRecord(conn, dta):
    cursor = conn.cursor()

    id = dta[ID]
    username = dta[USR]
    password = dta[PWD]
    name = dta[NAME]
    dob = dta[DOB]
    gender = dta[GEN]
    email =dta[EM]
    phone = dta[PH]
    type = dta[TYP]



    insertString = "insert into user (ID, username, password, name, dob, gender, email, phoneNumber, type) values ({:d}, '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}')".format(
        id, username, password, name, dob, gender, email, phone, type)

    print(insertString)

    try:
        cursor.execute(insertString)
    except mysql.connector.errors.IntegrityError:
        print("dupe\n")
        return
    except mysql.connector.errors.ProgrammingError:
        print("ERROR\n")
        return
    conn.commit()


def mainReader():
    dbConnection = dbConn()

    for val in USERS:
        persistRecord(dbConnection, val)


if __name__ == '__main__':
    mainReader()
