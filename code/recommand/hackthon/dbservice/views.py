from django.shortcuts import render
from django.http import HttpResponse
from dbservice.recommand import recommand as rc
import json
# Create your views here.

def recommand(request):
	result = rc(request.GET['id'])
	return HttpResponse(json.dumps(result),content_type = 'application/json')
