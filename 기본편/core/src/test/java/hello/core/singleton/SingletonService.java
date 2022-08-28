package hello.core.singleton;

public class SingletonService {

    //자기 자신을 private static 으로 선언하면 class 레벨에 올라가기 때문에 딱 하나만 올라가게 됨
    //자바 static 과 싱글톤에 대해서 공부해보기
    //JVM이 올라갈 때 내부적으로 자기 자신 인스턴스를 딱 하나 생성해서 변수에 참조값을 넣어둠
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        //생성자를 private으로 막아둬서 다른 곳에서 생성하지 못하게 함
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출출");
   }
}
