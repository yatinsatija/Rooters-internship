from django.shortcuts import render
from .models import Post

# Create your views here.
from django.shortcuts import render
from django.http import HttpResponse
'''
posts=[
    {
        'author':'corey',
        'title':'post1',
        'content':'first post',
        'date':'august 21'
    },
     {
        'author':'yatin',
        'title':'post2',
        'content':'second post',
        'date':'august 22'
    }
]
'''
def home(request):
    context={'posts':Post.objects.all()}
    return render(request,'blog/home.html',context)
def about(request):
    return render(request,'blog/about.html',{'title':'about'})