package com.lec.ex02_store;

//본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
public interface HeadQuarterStore {

	public void kimchi(); // 추상 메소드

	public void bude();

	public void bibim();

	public void sundae();

	public void bab();

	public String getName(); // 어차피 아래에서 구현은 할 것이고... 위에 두면 헤트쿼터스토어형으로도 사용가능할것이기에 이렇게 두는 게 나을것같다.

}
