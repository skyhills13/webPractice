[0단계]
- MessageRenderer 클래스와 MessageProvider 클래간에 strong coupling 존재하는 상태로 프로젝트 생성
    - 찍고 싶은 내용이 Hello World! 이냐  Hi World! 이냐에 따라 일일이 바꿔줘야 하는 상태  

[1단계]
- setMessageProvider를 MessageRenderer 클래스에 추가
    - 강한 의존관계는 사라짐

[2단계]  
- 1단계에서, 프로그램에서 동적으로 클래스같의 의존관계를 없앴던 것과는 다르게, 설정 파일을 이용해서 없앰
    - 하지만 applicationContext, ClassPathXmlApplicationContext, getBean 등이 생소하고, 알아야하는 API들이 존재.
	- 그래서 spring은 junit으로 이것을 할 수 있게 지원 -> 3단계  

[3단계]
- junit을 이용하여 main 함수에서 여러가지 생소한 api를 쓰지 않고도 테스트 할 수 있도록 변경
    - springtest template을 STS에 추가 