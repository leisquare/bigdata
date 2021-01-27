
//this.getInterval(that; this날과 that날 사이의 날짜계산)

Date.prototype.getInterval = function (that) {
    if (this > that) {
        var intervalMili = this.getTime() - that.getTime();
    } else {
        var intervalMili = that.getTime() - this.getTime();
    }
    var intervarDay = intervalMili / (1000 * 60 * 60 * 24);  //함수형언어는 안에 선언한 것도 펑션 안에서 다 사용 가능하다
    return Math.trunc(intervalDay);
}

//var intervalMili = limitday.getTime() - today.getTime();
//intervarDay = intervalMili / (1000 * 60 * 60 * 24);
