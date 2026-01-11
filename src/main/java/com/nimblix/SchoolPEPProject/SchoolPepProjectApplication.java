package com.nimblix.SchoolPEPProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SchoolPepProjectApplication {

	public static void main(String[] args) {

        /*
        Without java 8
         */
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Hello");
            }
        };
        /*
        With Java 8
         */
        Runnable runnable=()->{
            System.out.println("Hello");
        };


        /*
        ClassName::staticMethodName
         */

//        Runnable runnable1 = Printer::"P";


        List<Integer> evenNumber2=List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> evenNumber = new ArrayList<>();
        for(Integer n: evenNumber2){
            if(n%2==0){
                evenNumber.add(n);
            }
        }
        System.out.println("Even number: "+evenNumber);

        List<Integer> evenNumber3= evenNumber2.parallelStream().filter(n->n%2==0).toList();
        System.out.println("Even number: "+evenNumber3);

        List<String>  stringList= List.of("Hello","Akshay","Akash","Abhi","Pooja","Teja");
         List<String> result= stringList.stream().filter( name->name.startsWith("A")).collect(Collectors.toList());
         System.out.println("result"+result);
         SpringApplication.run(SchoolPepProjectApplication.class, args);
	}
}
