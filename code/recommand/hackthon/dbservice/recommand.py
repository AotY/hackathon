from dbservice.recommander.dataset import make_test_set_user
from dbservice.recommander.predict import predict
def recommand(id):
	X,ids = make_test_set_user(id)
	proba = predict(X)
	candidate = []
	for i in range(len(ids)):
		if proba[i][1] > 0.5:
			candidate.append(ids[i])
	print(candidate)
	return candidate
if __name__ == '__main__':
	recommand('26')
