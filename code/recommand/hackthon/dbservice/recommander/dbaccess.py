# encoding=utf-8
import pymysql
import pandas as pd
import pickle
IP = '192.168.137.214'
PORT = 3306
USERNAME = 'hackathon'
DATABASE = 'hackathon'
PASSWORD = 'hackathon'

user_features = [ 'id', 'sex', 'age', 'hometown',
                 'industry', 'longitude', 'latitude',
                 'personality', 'travel', 'book', 'movie',
                 'music', 'food', 'sport']

guider_features = user_features + ['guide_count', 'rating']

raw_features = ['personality', 'travel', 'book', 'movie',
                  'music', 'food', 'sport']

def conn(IP=IP, PORT=PORT, USERNAME=USERNAME, DATABASE=DATABASE, PASSWORD=PASSWORD):
    return pymysql.connect(host = IP,
                           user = USERNAME,
                           password = PASSWORD,
                           port = PORT,
                           database = DATABASE, charset = 'utf8')


def read_feature(user_id, role = 'user'):
    db = conn()
    cursor = db.cursor()
    sql = 'SELECT '
    if role == 'user':
        for i in user_features:
            sql += i+','
        sql = sql[:-1] + ' FROM user WHERE id='+user_id
    if role == 'guider':
        for i in guider_features:
            sql += i+','
        sql = sql[:-1] + ' FROM user WHERE id='+user_id

    feature_values = None
    try:
        cursor.execute(sql)
        result = cursor.fetchall()
        feature_values = result
    except Exception as e:
        print(e)
    cursor.close()
    db.close()
    return feature_values

def read_all_user():
    db = conn()
    sql = 'SELECT '
    for i in user_features:
        sql += i + ','
    sql = sql[:-1] + ' FROM user'
    cursor = db.cursor()
    result = None
    try:
        cursor.execute(sql)
        result = cursor.fetchall()
    except:
        pass
    return result

def read_all_guider():
    db = conn()
    sql = 'SELECT '
    for i in guider_features:
        sql += i + ','
    sql = sql[:-1] + ' FROM user'
    cursor = db.cursor()
    result = None
    try:
        cursor.execute(sql)
        result = cursor.fetchall()
    except:
        pass
    return result

def read_history():
    db = conn()
    sql = 'SELECT * from history'
    cursor = db.cursor()
    result = None
    try:
        cursor.execute(sql)
        result = cursor.fetchall()
    except:
        pass
    return result

def read_label(item = 'movie'):
    filename = '{}.pickle'.format(item)
    with open(filename,'rb') as  f:
        labels = pickle.load(f)
    return labels