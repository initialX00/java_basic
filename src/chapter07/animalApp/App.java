package chapter07.animalApp;


import java.util.ArrayList;

//동물관리 시스템
public class App {
    public static void main(String[] args) {
        //서비스 계층 생성
        AnimalService service = new AnimalService();
        //객체 생성 및 처리
        Animal cat = new Cat(); //업캐스팅
        Animal dog = new Dog();

        service.handleAnimal(cat);
        service.handleAnimal(dog);

        //cat.eat(); 업캐스팅은 자식클래스의 고유특성은 사용불가
        if(cat instanceof Cat) {
            Cat onlyCat = (Cat) cat; //다운캐스팅
            onlyCat.eat();
        }

        //동물을 관리하는 List 생성
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Cat()); //업캐스팅
        animals.add(new Dog());
        animals.add(new Cat());
        //동적 배열의 모든 동물들을 service로 처리
        for (Animal animal : animals){  //클래스명은 데이터타입처럼 클래스타입으로서 사용할 수 있다
            service.handleAnimal(animal);
        }
    }
}
