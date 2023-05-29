package hello.core.singleton;

public class StateFullService {

    //싱글톤 시 전역 변수 안됨(지역변수로 변경)
    //stateless로 구현해야함
//    private int price;

    public int order(String name, int price) {
        System.out.println("name : " + name + " price : " + price);
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
