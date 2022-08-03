package museum.spring.data.neo4j.dao;

import museum.spring.data.neo4j.entity.AccessionNumber;
import museum.spring.data.neo4j.entity.Artefact;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessionNumberRepository extends Neo4jRepository<AccessionNumber, String> {

    //// 获得特定accessionNumber
    //@Query("MATCH (n:ns0__accessionNumber{id:{id}}) RETURN n ")
    //AccessionNumber getAccessionNumber(@Param("id") int id);

    // 获得全部accessionNumber
    @Query( "MATCH (n:ns0__accessionNumber)-[]->()\n" +
            "OPTIONAL MATCH (n)-[:ns0__madeOf]->(a)\n" +
            "OPTIONAL MATCH (n)-[:ns0__hasType]->(b)\n" +
            "OPTIONAL MATCH (n)-[:ns0__hasStyle]->(c)\n" +
            "return n as accessionNumber, a.uri as material, b.uri as type, c.uri as style")
    List<Artefact> getAllAccessionNumber();

    // 根据uri找accessionNumber
    @Query( "MATCH (n:ns0__accessionNumber) WHERE n.uri Contains $uri RETURN n ")
    List<AccessionNumber> findAccessionNumberByUri(String uri);

    // 根据其他属性找accessionNumber
    @Query( "MATCH (n:ns0__accessionNumber)-[r]-(a) WHERE a.uri Contains $uri RETURN n")
    List<AccessionNumber> findAccessionNumberByAttributes(String uri);

    // iron都有
    @Query( "MATCH (n:ns0__accessionNumber)-[]->(m)\n" +
            "WHERE m.uri contains $uri\n" +
            "OPTIONAL MATCH (n)-[:ns0__madeOf]->(a)\n" +
            "OPTIONAL MATCH (n)-[:ns0__hasType]->(b)\n" +
            "OPTIONAL MATCH (n)-[:ns0__hasStyle]->(c)\n" +
            "OPTIONAL MATCH (n)-[:ns0__isLocatedOn]->(d)\n" +
            "return n as accessionNumber, a.uri as material, b.uri as type, c.uri as style, d.uri as site")
    List<Artefact> findAttributes(String uri);

    // 根据faceted search找artefact
    @Query( "OPTIONAL MATCH (n:ns0__accessionNumber)-[:ns0__madeOf]->(a) \n" +
            "OPTIONAL MATCH (n:ns0__accessionNumber)-[:ns0__hasType]->(b) \n" +
            "OPTIONAL MATCH (n:ns0__accessionNumber)-[:ns0__hasStyle]->(c) \n" +
            "OPTIONAL MATCH (n:ns0__accessionNumber)-[:ns0__isLocatedOn]->(d) \n" +
            "WHERE a.uri contains $material and b.uri contains $type and c.uri contains $style and d.uri contains $site\n" +
            "return n as accessionNumber, a.uri as material, b.uri as type, c.uri as style, d.uri as site")
    List<Artefact> findByFaceted(String material, String type, String style, String site);

}
