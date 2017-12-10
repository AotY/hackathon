import lightgbm as lgb
import pickle
from dbservice.recommander.train import USER_MODEL_NAME,ITEM_MODEL_NAME
from dbservice.recommander.dataset import make_test_set_user
import numpy as np
def predict(X, type = 'user'):
    model = None
    if type == 'user':
        with open(USER_MODEL_NAME,'rb') as f :
            model = pickle.load(f)
    if type == 'item':
        with open(ITEM_MODEL_NAME,'rb') as f :
            model = pickle.load(f)
    y = model.predict_proba(X)
    return y

def acuuracy(X,y):
    accur = y!=predict(X)
    return accur

def main():
    X,ids = make_test_set_user('26')
    proba = predict(X)
    candidate = []
    for i in range(len(ids)):
        if proba[i][1]>0.5:
            candidate.append(ids[i])
    print(candidate)

if __name__ == '__main__':
    main()
