import lightgbm as lgb
import pickle
import numpy as np
from dbservice.recommander.dataset import make_train_set_user
from dbservice.recommander.dataset import make_test_set_user
from lightgbm.sklearn import LGBMClassifier

USER_MODEL_NAME = './dbservice/recommander/recommand_model_user.pickle'
ITEM_MODEL_NAME = './dbservice/recommander/recommand_model_item.pickle'

# params = {
# 'task': 'train',
# 'objective': 'binary',
# 'metric': {'l2', 'auc'},
# 'num_leaves': 31,
# 'learning_rate': 0.05,
# 'feature_fraction': 0.9,
# 'bagging_fraction': 0.8,
# 'bagging_freq': 5,
# 'verbose': 0
# }

def train(X, y, type = 'user'):
    model = LGBMClassifier( num_leaves = 50, # cv调节50是最优值
        max_depth = 13,
        learning_rate =0.1,
        n_estimators = 1000,
        objective = 'regression',
        min_child_weight = 1,
        subsample = 0.8,
        colsample_bytree=0.8,
        nthread = 7 ,min_data=1)
    model.fit(np.array(X),np.array(y))
    if type == 'user':
        with open(USER_MODEL_NAME,'wb') as f:
            pickle.dump(model,f)
    if type == 'item':
        with open(ITEM_MODEL_NAME,'wb') as f:
            pickle.dump(model,f)

def main():
    X,y = make_train_set_user()
    # X,id = make_test_set_user()
    train(X,y,type='user')
if __name__ == '__main__':
    main()
