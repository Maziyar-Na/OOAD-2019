import json
import pprint
import pickle
import os
import sys

# data from https://openlibrary.org/developers/dumps
FILENAME = 'ol_dump_2019-02-28.txt'
AUTHORFILE = 'ol_dump_authors_2019-02-28.txt'
MY_PATH = '/Users/djb/Downloads/OOAD'
JSON_POS = 4
AUTH_POS = 0
AUTHOR = '/type/author'
PAGE = '/type/page'
WORK = '/type/work'
DATETIME = '/type/datetime'
DELETE = '/type/delete'
REDIRECT = '/type/redirect'

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


def getVal(dct):
    inp = dct['key']

    if type(inp) is list:
        item = inp[0]
    else:
        item = inp

    xx = item.split('/')[2]
    return xx


def insertDouble(inp):
    y = inp.split("'")
    k = ""
    for x in y:
        k += x + "''"
    k = k[:-2]
    return k


def parseJson(inp):
    dd = {}
    if 'authors' in inp:
        if len(inp['authors']) == 0:  # Migh be an edition
            return None
        if type(inp['authors'][0]) != dict:
            return None
        authKey = getVal(inp['authors'][0])
        if authKey in authorDict:
            dd['author'] = authorDict[authKey]
        else:
            return None
    else:
        return None

    if 'isbn_10' in inp:
        if len(inp['isbn_10']) != 0:
            dd['isbn_10'] = inp['isbn_10'][0]
    else:
        return None

    if 'isbn_13' in inp:
        if len(inp['isbn_13']) != 0:
            dd['isbn_13'] = inp['isbn_13'][0]
    dd['type'] = getVal(inp['type'])

    if 'number_of_pages' in inp:
        dd['pageCount'] = inp['number_of_pages']
    else:
        return None

    if 'publish_date' in inp:
        dd['pubDate'] = inp['publish_date']
    else:
        return None

    if 'language' in inp:
        dd['language'] = getVal(inp['languages'][0])
    else:
        dd['language'] = 'en'

    dd['title'] = inp['title']
    if 'subtitle' in inp:
        dd['subtitle'] = inp['subtitle']

    if 'physical_format' in inp:
        dd['format'] = inp['physical_format']

    if 'url' in inp:
        dd['url'] = inp['url'][0]
    if 'publishers' in inp:
        if len(inp['publishers']) == 0:
            dd['publisher'] = 'Unknown'
        else:
            dd['publisher'] = inp['publishers'][0]
    else:
        return None

    if 'subjects' in inp:
        dd['subjects'] = inp['subjects']
    else:
        return None

    return dd


def bookFilter(jsonInp):
    has_title = 'title' in jsonInp
    valid_type = False

    if 'type' in jsonInp:
        type = jsonInp['type']['key']
        if type == AUTHOR:
            valid_type = False
        elif type == PAGE:
            valid_type = False
        elif type == WORK:
            valid_type = False
        elif type == DATETIME:
            valid_type = False
        elif type == DELETE:
            valid_type = False
        elif type == REDIRECT:
            valid_type = False
        else:
            valid_type = True

    return has_title & valid_type


def getAuthors():
    pickleString = "%s/authorPickle.pkl" % (MY_PATH)
    if os.path.exists(pickleString):
        f = open(pickleString, 'rb')
        dd = pickle.load(f)
        for k, v in dd.items():
            authorDict[k] = v
        f.close()
        return
    fileString = "%s/%s" % (MY_PATH, AUTHORFILE)
    with open(fileString, mode='r') as ff:
        for line in ff:
            kk = line.split('\t')
            if kk[AUTH_POS] == AUTHOR:
                g = json.loads(kk[JSON_POS])
                ky = g['key'].split('/')[2]
                if 'name' in g:
                    val = g['name']
                    authorDict[ky] = val

    print("processed %d authors\n" % (len(authorDict)))

    f = open(pickleString, 'wb')
    pickle.dump(authorDict, f, -1)
    f.close()


def addtoDict(id, dta, dataDict):
    dataDict[id] = {}

    author = dta[AUTH]
    if "'" in author:
        author = insertDouble(author)

    dataDict[id][AUTH] = author
    title = dta[TITLE]
    if "'" in title:
        title = insertDouble(title)
    if len(title) > 256:
        title = title[:256]

    isbn_10 = dta[I10]

    dataDict[id][I10]= isbn_10
    isbn_13 = ''
    if I13 in dta:
        isbn_13 = dta[I13]

    dataDict[id][I13] = isbn_13

    language = dta[LANG]
    dataDict[id][LANG] = language

    pageCount = int(dta[PC])
    dataDict[id][PC] = pageCount

    pubdate = dta[PD]
    dataDict[id][PD] = pubdate

    publisher = dta[PUB]
    if len(publisher) > 96:
        publisher = publisher[:96]

    if "'" in publisher:
        publisher = insertDouble(publisher)

    dataDict[id][PUB] = publisher

    format = dta[PT]

    dataDict[id][PT] = format

    url = ''
    subtitle = ''
    if 'subtitle' in dta:
        subtitle = dta['subtitle']
        if "'" in subtitle:
            subtitle = insertDouble(subtitle)
        if len(subtitle) > 256:
            subtitle = subtitle[:256]
    if 'url' in dta:
        url = dta['url']

    dataDict[id]['url'] = url
    dataDict[id][SUBT] = subtitle

    subs = dta[SUB]

    sub = ''
    sub2 = ''

    x = len(subs)
    if x == 1:
        sub = subs[0]
    if x >= 2:
        sub = subs[0]
        sub2 = subs[1]
    if "'" in sub:
        sub = insertDouble(sub)
    if "'" in sub2:
        sub2 = insertDouble(sub2)

    dataDict[id][SUB1] = sub
    dataDict[id][SUB2] = sub2

def dumpDict(dataDict):
    pickleString = "%s/Library.pkl" % (MY_PATH)
    f = open(pickleString, 'wb')
    pickle.dump(dataDict, f, -1)
    f.close()


def mainReader():
    getAuthors()
    dataDict = {}
    fileString = "%s/%s" % (MY_PATH, FILENAME)
    pp = pprint.PrettyPrinter(indent=4)
    outString = "%s/%s" % (MY_PATH, 'books.json')
    fj = open(outString, 'w')
    lineCount = 0
    bookCount = 0
    id = 0
    with open(fileString, mode='r') as ff:
        for line in ff:
            kk = line.split('\t')
            lineCount += 1

            # print("%d\n"%(lineCount))
            # if lineCount == 14762419:
            #     print("9999")

            g = json.loads(kk[JSON_POS])
            filt = bookFilter(g)
            if filt == True:
                xx = parseJson(g)
                if xx:
                    id += 1
                    if 'url' in xx:
                        addtoDict(id, xx, dataDict)
                        bookCount += 1
                        print("bookcount {} id {}".format(bookCount,id))

            if bookCount > 3000:
                dumpDict(dataDict)
                fj.close()
                sys.exit(0)

    fj.close()

    print("wrote %d books\n" % (bookCount))

if __name__ == '__main__':
    mainReader()
