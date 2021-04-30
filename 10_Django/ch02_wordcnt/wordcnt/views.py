from django.shortcuts import render


# Create your views here.


def wordinput(request):
    return render(request, "wordinput.html")


def result(request):
    full = request.GET['fulltext'] #안녕 방가 안녕
    strlength = len(full)
    words= full.split() # ['안녕', '방가', '안녕']
    words_dic = {} #{'안녕':,'방가':1}
    for word in words:
        if word in words_dic:
            words_dic[word] += 1
        else:
            words_dic[word] = 1
    return render(request, 'result.html',{'full':full,
                                         'strlength':strlength,
                                         'cnt':len(words),
                                         'dic':words_dic.items()})

def about(request):
    return render(request, "about.html")

