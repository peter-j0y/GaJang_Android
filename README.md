## 프로젝트 구성 안내
- 목적

> 지난 2년동안 코로나와 전쟁으로 인플레이션이 지속되고, 그로 인해 전세계 밥상물가가
지속적으로 상승하고 있습니다. 무섭게 치솟는 물가속에서 조금이라도 싼 생필품을 찾는
고객들이 많습니다. 따라서 서울시에서 제공하는 생필품 농수축산물 가격정보 오픈 API를
활용해서 사용자들이 거주하고 있는 지역구별 마트의 생필품 가격을 한눈에 비교할 수
있는 어플리케이션을 만들고자 합니다.
가격과 장소를 비교해주는 장보기 앱이라는 의미에서 ‘가장’이라는 이름을 지었습니다.

- 사용 언어, 툴 및 라이브러리
> Kotlin, Android Studio

## 프로젝트 설치 및 실행 방법
> 플레이스토어 출시 준비 중입니다. 현재는 깃허브 프로젝트 클론 후 안드로이드 스튜디오를 통해 실행 가능합니다.

## 기술 스택
하나의 액티비티와 여러 개의 프레그먼트를 이용한 single activity multi fragment 아키텍처를 적용하였으며 MVVM 디자인 패턴을 적용하였습니다.
 | Library                                                   | Purpose                                                   |
| ------------------------------------------------------------ | ------------------------------------------------------- |
| [Android Jetpack](https://developer.android.com/jetpack/androidx/releases/compose) |  ViewModel, LiveData, Navigation, RecyclerView, Fragment  |
| [View Binding](https://developer.android.com/topic/libraries/view-binding) | To more easily write code that interacts with views          |
| [Data Binding](https://developer.android.com/jetpack/androidx/releases/databinding) | To bind UI components in layouts to data sources in app using a declarative format          |
| [Firebase](https://firebase.google.com/)                     | To implement social login    |                                           | 

## 프로젝트 사용법 및 기능 설명
![image](https://user-images.githubusercontent.com/39687846/171976819-45e12b12-ba6d-4b45-b714-71710f1e1894.png)<br>
앱을 처음 실행하면 나타나는 스플래시 화면과 로그인 화면 입니다. 로그인은 소셜 로그인으로 파이어베이스를 이용해 구현하였습니다.<br><br>
![image](https://user-images.githubusercontent.com/39687846/171977830-dce88187-54fb-400e-89c6-ad2cb1a961dc.png)<br>
앱의 핵심 기능이 들어가 있는 가격비교 탭과 주변 상점 탭입니다. 가격 비교 탭에서 가격을 비교하고 싶은 식료품을 선택할 수 있고 식료품을 선택한 후에는 리스트 형식으로 다음과 같은 데이터를 나열하도록 했습니다. 각 리스트 안에는 가격, 원산지, 자치구, 해당 식료품을 판매하는 마트가 담겨있습니다.
주변 상점 탭을 선택하면 기본적으로 사용자가 로그인 시 선택한 거주지에 따라 해당 자치구에 위치한 마트들이 나열되며 사용자가 직접 자치구를 선택할 수도 있습니다.<br><br>
![image](https://user-images.githubusercontent.com/39687846/171985608-c4e28d0b-b94c-4f0e-b6cc-9f3633dd69ae.png)<br>
각 마트를 클릭하면 해당 마트에서 판매 중인 상품의 가격, 원산지 등의 정보를 알 수 있습니다. 내 정보 탭에서는 개인정보처리방침을 노션에 작성하여 링크를 연결하였고 로그인 당시 선택한 거주지를 변경할 수 있도록 거주지 변경 기능을 넣었으며 프로젝트 개발에 사용한 오픈소스의 리스트를 보여주는 페이지로 이동하는 기능과 로그아웃을 하는 기능을 구현했습니다. 




- 만든 사람
> 신승민
> 이민석
> 김민구
