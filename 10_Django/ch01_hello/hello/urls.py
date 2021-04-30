
from django.contrib import admin
from django.urls import path
from hello import views
from django.urls import include


urlpatterns =[
    path("",views.home, name="home")
]