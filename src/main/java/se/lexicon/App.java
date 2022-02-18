package se.lexicon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ApplicationConfiguration;
import se.lexicon.dao.*;
import se.lexicon.model.dto.LearnedSkillFormDTO;
import se.lexicon.model.entity.Student;
import se.lexicon.service.LearnedSkillService;

import java.util.Arrays;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws JsonProcessingException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);


        LearnedSkillService learnedSkillService = context.getBean(LearnedSkillService.class);


        StudentDAO studentDAO = context.getBean(StudentDAO.class);

        Student tobias = new Student("Tobias");
        studentDAO.save(tobias);

        studentDAO.findAll().forEach(System.out::println);


        Scanner scanner = context.getBean(Scanner.class);
        String s = scanner.nextLine();
        System.out.println(s);


        ObjectMapper objectMapper = context.getBean(ObjectMapper.class);
        System.out.println(objectMapper.writeValueAsString(tobias));




    }
}
