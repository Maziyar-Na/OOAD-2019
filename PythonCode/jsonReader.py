import json
import pprint
import pickle
import os

FILENAME='ol_dump_2019-02-28.txt'
AUTHORFILE='ol_dump_authors_2019-02-28.txt'
MY_PATH='/Users/djb/Downloads/OOAD'
JSON_POS = 4
AUTH_POS = 0
AUTHOR = '/type/author'
PAGE='/type/page'
WORK='/type/work'
DATETIME='/type/datetime'
DELETE='/type/delete'

authorDict = {}


def getVal(dct):
    inp = dct['key']

    if type(inp) is list:
        item = inp[0]
    else:
        item = inp

    xx = item.split('/')[2]
    return xx

def parseJson(inp):
    dd ={}
    if 'authors' in inp:
        authKey = getVal(inp['authors'][0])
        if authKey in authorDict:
            dd['author']=authorDict[authKey]
        else:
            return None
    else:
        return  None

    if 'isbn_10' in inp:
        dd['isbn_10']=inp['isbn_10'][0]
    else:
        return None

    if 'isbn_13' in inp:
        dd['isbn_13']=inp['isbn_13'][0]
    dd['type']=getVal(inp['type'])
    if 'number_of_pages' in inp:
        dd['pageCount']=inp['number_of_pages']
    if 'publish_date' in inp:
        dd['pubDate']=inp['publish_date']
    if 'language' in inp:
        dd['language']=getVal(inp['languages'][0])
    else:
        dd['language']='en'
    dd['title']=inp['title']
    if 'subtitle' in inp:
        dd['subtitle']=inp['subtitle']

    if 'physical_format' in inp:
        dd['format']=inp['physical_format']

    if 'url' in inp:
        dd['url'] = inp['url'][0]
    if 'publishers' in inp:
        dd['publisher']=inp['publishers'][0]

    if 'subjects' in inp:
        dd['subjects'] = inp['subjects']

    return dd


def bookFilter(jsonInp):
    has_title = 'title' in jsonInp
    valid_type =False

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
        else:
            valid_type = True

    return has_title&valid_type

def getAuthors():
    pickleString = "%s/authorPickle.pkl"%(MY_PATH)
    if os.path.exists(pickleString):
        f=open(pickleString,'rb')
        dd = pickle.load(f)
        for k,v in dd.items():
            authorDict[k]=v
        f.close()
        return
    fileString = "%s/%s" % (MY_PATH, AUTHORFILE)
    with open(fileString,mode='r') as ff:
        for line in ff:
            kk = line.split('\t')

            if kk[AUTH_POS] == AUTHOR:
                g = json.loads(kk[JSON_POS])
                ky = g['key'].split('/')[2]
                if 'name' in g:
                    val = g['name']
                    authorDict[ky]=val


    print("processed %d authors\n"%(len(authorDict)))

    f = open(pickleString,'wb')
    pickle.dump(authorDict,f,-1)
    f.close()



def mainReader():
    getAuthors()
    fileString = "%s/%s"%(MY_PATH,FILENAME)
    pp = pprint.PrettyPrinter(indent=4)
    outString = "%s/%s"%(MY_PATH,'books.json')
    fj = open(outString,'w')
    lineCount = 0
    bookCount = 0
    with open(fileString,mode='r') as ff:
        for line in ff:
            kk = line.split('\t')
            lineCount +=1
            #print("%d\n"%(lineCount))
            #if lineCount == 170285:
            #    print("9999")

            g =json.loads(kk[JSON_POS])
            filt = bookFilter(g)
            if filt ==True:
                xx = parseJson(g)
                if xx:
                    json.dump(xx, fj)
                    bookCount +=1
    fj.close()

    print("wrote %d books\n"%(bookCount))




if __name__ == '__main__':
    mainReader()