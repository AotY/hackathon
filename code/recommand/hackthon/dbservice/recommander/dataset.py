
import numpy as np
import pandas as pd
from dbservice.recommander.dbaccess import read_history,read_feature,user_features,read_all_user
from dbservice.recommander.dataparse import parse_user_features, parse_guider_features

useless_features = ['id', 'longitude', 'latitude']
useful_user_subscript = [i for i in range(len(user_features)) if user_features[i] not in useless_features]
useless_user_subscript = [i for i in range(len(user_features)) if user_features[i] in useless_features]



def make_train_set_user():
    history = np.array(read_history())
    #构造正样本
    user_ids = history[:,1]
    guider_ids = history[:,2]
    ids = pd.DataFrame()
    ids['user_id'] = user_ids
    ids['guider_id'] = guider_ids
    all_guider_ids = ids.groupby(ids['guider_id']).count()
    all_guider_ids = all_guider_ids[all_guider_ids['user_id'] > 1].index.values
    similar_vec = []
    labels = []
    for guider_id in all_guider_ids:
        item = ids[ids['guider_id'] == guider_id]
        user_ids = item.user_id.values
        features = []
        for i in user_ids:
            feature = parse_user_features(read_feature(str(i),role='user'))
            features.append(feature[0])
        similarity = compute_user_similarity(features)
        similar_vec.extend(similarity)
        labels.extend([1]*len(similarity))
    # print(similar_vec)
    # print(len(similar_vec))


    #构造负样本
    user_ids = history[:, 1]
    guider_ids = history[:, 2]
    destination = history[:, 3]
    ids = pd.DataFrame()
    ids['user_id'] = user_ids
    ids['guider_id'] = guider_ids
    ids['destination'] = destination
    destination = list(set(destination))
    for i in destination:
        item = ids[ids['destination'] == i]
        uid = item['user_id'].values
        for i in range(len(uid)-1):
            for j in range(i+1,len(uid)):
                if item['guider_id'].values[i] != item['guider_id'].values[j]:
                    vec1 = parse_user_features(read_feature(str(uid[i]),role='user'))[0]
                    vec2 = parse_user_features(read_feature(str(uid[j]), role='user'))[0]
                    similarity = compute_vec_distance(vec1,vec2)
                    similar_vec.append(similarity)
                    labels.append(0)
    print(similar_vec)
    print(len(similar_vec))
    print(labels)
    return similar_vec,labels


def make_test_set_user(user_id = None):
    feature = parse_user_features(read_feature(user_id))
    reference = parse_user_features(read_all_user())
    similar_vec = []
    X = []
    ref_ids = []
    for i in feature:
        for j in reference:
            if i[0]!=j[0]:
                similar_vec.append(compute_vec_distance(i,j))
                ref_ids.append(j[0])
    return similar_vec,ref_ids

def compute_vec_distance(vec1,vec2):
    vec1_tmp = []
    vec2_tmp = []
    for i in range(len(vec1)):
        if i not in useless_user_subscript:
            vec1_tmp.append(vec1[i])
            vec2_tmp.append(vec2[i])
    similar_vec = np.zeros(shape=len(vec1_tmp))
    if vec2_tmp[0] == vec1_tmp[0]:
        similar_vec[0] = 0
    else:
        similar_vec[0] = 1
    similar_vec[1] = abs(vec1_tmp[1] - vec2_tmp[1])
    similar_vec[2] = int(vec2_tmp[2] == vec1_tmp[2])
    similar_vec[3] = int(vec2_tmp[3] == vec1_tmp[3])
    for i in range(4,len(vec1_tmp)):
        similar_vec[i] = len(set(vec1_tmp[i]) & set(vec2_tmp[i]))
    return list(similar_vec)


#计算用户相似度
def compute_user_similarity(features):
    results = []
    for i in range(len(features)-1):
        for j in range(i+1,len(features)):
            result = compute_vec_distance(features[i], features[j])
            results.append(result)
            print(result)
    return results

#计算导游相似度
def compute_guider_similarity():
    pass






def main():
    # make_train_set_user()
    print(make_test_set_user('26'))

if __name__ == '__main__':
    main()
