package pl.adrian99.javaprobackend.initializers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.adrian99.javaprobackend.entities.Code;
import pl.adrian99.javaprobackend.entities.CodeCategory;
import pl.adrian99.javaprobackend.entities.CodeExample;
import pl.adrian99.javaprobackend.repositories.CodeCategoryRepository;
import pl.adrian99.javaprobackend.repositories.CodeExampleRepository;
import pl.adrian99.javaprobackend.repositories.CodeRepository;

@Component
@RequiredArgsConstructor
public class CodeInitializer implements ApplicationRunner {

    private final CodeCategoryRepository codeCategoryRepository;
    private final CodeExampleRepository codeExampleRepository;
    private final CodeRepository codeRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (codeCategoryRepository.count() == 0 &&
            codeExampleRepository.count() == 0 &&
            codeRepository.count() == 0) {
            var category1 = new CodeCategory();
            category1.setName("Laboratorium 1");
            codeCategoryRepository.save(category1);

            var example11 = new CodeExample();
            example11.setName("Zadanie 1.1.");
            example11.setContext("""
                    Plik 1Program.java
                    Skompilować (usunąć błędy!!!) i uruchomić program z poziomu konsoli DOS
                    >javac PierwszyProgram.java
                    >java PierwszyProgram
                    Sprawdzić działanie opcji kompilatora: >javac -verbose PierwszyProgram.java
                    """);
            example11.setExampleOrder(1);
            example11.setCategory(category1);
            codeExampleRepository.save(example11);

            var code111 = new Code();
            code111.setName("1Program.java");
            code111.setCode("""
                    /* Pierwszy program
                    public class PierwszyProgram {
                       public static void main(String[] args) {
                           System.out.println("Mój pierwszy program w języku Java !);
                       }
                    }
                    """);
            code111.setCodeOrder(1);
            code111.setCodeExample(example11);
            codeRepository.save(code111);

            var example12 = new CodeExample();
            example12.setName("Zadanie 1.2.");
            example12.setContext("""
                    Plik DrugiProgram.java – przekazywanie parametrów do aplikacji – usunąć błąd wykonania!
                    >java DrugiProgram
                    >java DrugiProgram Jeden Dwa Trzy""");
            example12.setExampleOrder(2);
            example12.setCategory(category1);
            codeExampleRepository.save(example12);

            var code121 = new Code();
            code121.setName("DrugiProgram.java");
            code121.setCode("""
                    public class DrugiProgram {
                       public static void main(String[] args) {
                           if (args.length == 0) {
                               System.out.println("No arguments");
                               System.exit(0);
                           }
                           for (int i = 0; i <= args.length; i++) {
                               System.out.println("args[" + i + "]:" + args[i]);
                           }
                       }
                    }
                    """);
            code121.setCodeOrder(1);
            code121.setCodeExample(example12);
            codeRepository.save(code121);

            var example13 = new CodeExample();
            example13.setName("Zadanie 1.3.");
            example13.setContext("Aplikacja Quiz.java – czytanie z pliku questions.txt – program konsolowy interaktywny");
            example13.setExampleOrder(3);
            example13.setCategory(category1);
            codeExampleRepository.save(example13);

            var code131 = new Code();
            code131.setName("Quiz.java");
            code131.setCode("""
                    import java.io.*;
                    import java.util.*;

                    public class Quiz {
                       public static void main(String[] args) {
                           int sum = 0;
                           try {
                               Scanner file = new Scanner(new File("questions.txt"));
                               Scanner user = new Scanner(System.in);
                               while (file.hasNext()) {
                                   for (int i = 0; i < 4; i++) {
                                       System.out.println(file.nextLine());
                                   }
                                   String ok = file.nextLine();
                                   System.out.println("What is the correct ? ");
                                   String ans = user.next();
                                   ans = ans.toUpperCase();
                                   if (ans.length() > 1) {
                                       ans = ans.substring(0, 1);
                                   }
                                   if (ans.equals(ok)) {
                                       sum++;
                                       System.out.println("OK !\\n");
                                   } else {
                                       System.out.println("NO !\\n");
                                   }
                               }
                               System.out.println("\\nResult:" + sum + " of 3");
                           } catch (FileNotFoundException e) {
                               System.out.println("No questions !");
                           }
                       }
                    }""");
            code131.setCodeOrder(1);
            code131.setCodeExample(example13);
            codeRepository.save(code131);

            var code132 = new Code();
            code132.setName("questions.txt");
            code132.setCode("""
                    Question 1 ?
                    A - Answer 1
                    B - Answer 2
                    C - Answer 3
                    A
                    Question 2 ?
                    A - Answer 1
                    B - Answer 2
                    C - Answer 3
                    C
                    Question 3 ?
                    A - Answer 1
                    B - Answer 2
                    C - Answer 3
                    B""");
            code132.setCodeOrder(2);
            code132.setCodeExample(example13);
            codeRepository.save(code132);

            codeCategoryRepository.flush();
            codeExampleRepository.flush();
            codeRepository.flush();
        }
    }
}
