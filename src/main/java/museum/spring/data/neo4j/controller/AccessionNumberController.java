package museum.spring.data.neo4j.controller;

import museum.spring.data.neo4j.dao.AccessionNumberRepository;
import museum.spring.data.neo4j.entity.AccessionNumber;
import museum.spring.data.neo4j.entity.Artefact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // 后台接值方法
    @GetMapping("/findByFaceted")
    public List<Artefact> yourUrl(@RequestParam("material") String material, @RequestParam("type") String type, @RequestParam("style") String style, @RequestParam("site") String site) {

        if(material.equals("undefined")) {
            material = "";
        }
        if(type.equals("undefined")) {
            type = "";
        }
        if(style.equals("undefined")) {
            style = "";
        }
        if(site.equals("undefined")) {
            site = "";
        }

        System.out.println(material);
        System.out.println(type);
        List<Artefact> artefacts = accessionNumberRepository.findByFaceted(material, type, style, site);
        System.out.println(artefacts);
        return artefacts;
    }
}
