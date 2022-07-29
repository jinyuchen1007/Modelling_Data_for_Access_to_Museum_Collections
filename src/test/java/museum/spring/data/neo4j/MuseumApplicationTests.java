package museum.spring.data.neo4j;

import museum.spring.data.neo4j.dao.AccessionNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@EntityScan("movies.spring.data.neo4j.entity")
@SpringBootTest
public class MuseumApplicationTests {

    @Autowired
    AccessionNumberRepository accessionNumberRepository;


    //@Test
    //public void test1() {
    //    List<AccessionNumber> list = accessionNumberRepository.getAccessionNumberByMaterial("gold");
    //    System.out.println(list);
    //}

}
