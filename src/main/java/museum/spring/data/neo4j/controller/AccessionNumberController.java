package museum.spring.data.neo4j.controller;

import museum.spring.data.neo4j.dao.AccessionNumberRepository;
import museum.spring.data.neo4j.entity.AccessionNumber;
import museum.spring.data.neo4j.entity.Artefact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccessionNumberController {

    @Autowired
    AccessionNumberRepository accessionNumberRepository;

    // 找所有AccessionNumber
    @GetMapping("/findAll")
    public List<Artefact> findAllAccessionNumber() {
        List<Artefact> all = accessionNumberRepository.getAllAccessionNumber();
        System.out.println(all);
        return all;
    }

    @GetMapping("/findByUri")
    public List<AccessionNumber> findByUri(@RequestParam("uri") String uri) {
        List<AccessionNumber> accessionNumber = accessionNumberRepository.findAccessionNumberByUri(uri);
        System.out.println(accessionNumber);
        return accessionNumber;
    }

    //@GetMapping("/findByAttributes")
    //public List<AccessionNumber> findByAttributes(@RequestParam("uri") String uri) {
    //    List<AccessionNumber> accessionNumber = accessionNumberRepository.findAccessionNumberByAttributes(uri);
    //    System.out.println(accessionNumber);
    //    return accessionNumber;
    //}

    @GetMapping("/findByAttributes")
    public List<Artefact> findAttributes(@RequestParam("uri") String uri) {
        List<Artefact> artefacts = accessionNumberRepository.findAttributes(uri);
        System.out.println(artefacts);
        return artefacts;
    }

}
