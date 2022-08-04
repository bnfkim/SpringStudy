package hello.core.singleton;

public class StatefulService {

    //private int price; //상태를 유지하는 필드 -> 이걸 유지하지 말고 바로 반환하는 식으로 변경

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        //this.price = price; //여기가 문제!
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
