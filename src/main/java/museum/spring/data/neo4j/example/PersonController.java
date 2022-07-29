package museum.spring.data.neo4j.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("createNode")
    public Object createNode(@RequestParam(value = "nodeName") String nodeName) {
        Person person=new Person(nodeName);
        return personRepository.save(person);
    }

    @GetMapping("deleteNodeById")
    public Object deleteNodeById(@RequestParam(value = "nodeId") Long nodeId) {
        personRepository.deleteById(nodeId);
        return "删除成功";
    }

    @GetMapping("getById")
    public Object getById(@RequestParam(value = "id") Long id) {
        Optional<Person> person = personRepository.findById(id);
        System.out.println(person);
        Person person1=person.orElse(null);
        System.out.println(person1);

        return person1;
    }

}
