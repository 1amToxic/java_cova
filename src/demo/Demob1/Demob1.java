/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.Demob1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lamit
 */
public class Demob1 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        //Ctrl + Space : gen code
        ArrayList<Animal> list = new ArrayList();
        Cat cat = new Cat();
        Dog dog = new Dog();
        list.add(cat);
        list.add(dog);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof Cat){
                ((Cat)list.get(i)).meoKeu();
            }
            else{
                ((Dog)list.get(i)).choSua();
            }
        }
    }
}
class Animal{
    public int publicInt;
    protected int protectedInt;
    private int soluong;
    String name;
    //constructor : khởi tạo
    public Animal(){
        
    }
    public Animal(int sl){
        soluong = sl;
    }    
}
class Cat extends Animal{
    public void meoKeu(){
        System.out.println("Mèo méo meo mèo meo");
    }
}
class Dog extends Animal{
    public void choSua(){
        System.out.println("Gau gau");
    }
}
//them sua xoa in ra man hinh