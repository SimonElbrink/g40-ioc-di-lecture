package se.lexicon;

import se.lexicon.dao.*;
import se.lexicon.dao.sequencer.SequencersImpl;
import se.lexicon.model.entity.Student;
import se.lexicon.service.LearnedSkillService;
import se.lexicon.service.LearnedSkillServiceImpl;
import se.lexicon.service.SkillServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentDAO studentDAO = new StudentDAOImpl(new SequencersImpl());

        studentDAO.save(new Student("Tobias"));

        studentDAO.findAll().forEach(System.out::println);

        LearnedSkillService skillService = new LearnedSkillServiceImpl(new LearnedSkillDAOImpl(new SequencersImpl()),
                new SkillServiceImpl(new SkillDAOImpl(new SequencersImpl())));

        skillService.findAll();


    }
}
