package chapter07.practiceApp;

/*
    Entity 클래스
    - 부모 클래스 1개 생성
    - 자식 클래스 2개 생성
 */

class Weapon {
    private String name;
    private int spec;
    private double buff;

    Weapon(String name, int spec, double buff){
        this.name = name;
        this.spec = spec;
        this.buff = buff;
    }

    String getName() {
        return name;
    }
    int getSpec() {
        return spec;
    }
    double getBuff() {
        return buff;
    }
    double damage() {
        return spec * buff;
    }
}

class Gun extends Weapon  {
    Gun(String name, int spec, double buff){
        super(name,spec,buff);
    }
    @Override
    double damage() {
        return getSpec() * getBuff() + 10;
    }
}

class Cannon extends Weapon  {
    Cannon(String name, int spec, double buff){
        super(name,spec,buff);
    }
    @Override
    double damage() {
        return getSpec() * getBuff() + 100;
    }
}


public class Entity {
    private Weapon weapon;
    private int season;

    Entity(Weapon weapon, int season){
        this.weapon = weapon;
        this.season = season;
    }

    double calcDamage () {
        double total = weapon.damage() * season;
        return total;
    }
    @Override
    public String toString(){
        return "무기이름 : " + weapon.getName() + " | 받은 버프량 : " +  weapon.getBuff() + " | 시즌제도 : " + season
                + " | 총데미지 합계 : " + calcDamage();
    }
}
