
from dbservice.recommander.dbaccess import user_features,raw_features,guider_features,read_feature

def parse_user_features(feature_values):
    feature= list(feature_values)
    result = []
    for u in feature:
        u = list(u)
        for i in range(len(user_features)):
            if user_features[i] in raw_features:
                u[i] = u[i].split(',')
        result.append(u)
    return result


def parse_guider_features(feature_values):
    feature = list(feature_values)
    result = []
    for u in feature:
        u = list(u)
        for i in range(len(guider_features)):
            if guider_features[i] in raw_features:
                u[i] = u[i].split(',')
        result.append(u)
    return result

def main():
    print(parse_guider_features(read_feature('26','guider')))


if __name__ == '__main__':
    main()
