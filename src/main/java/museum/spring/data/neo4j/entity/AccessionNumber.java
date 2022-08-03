package museum.spring.data.neo4j.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node(value = "ns0__accessionNumber")
public class AccessionNumber implements Serializable {

    @Id
    @Property(name = "uri")
    private String accessionNumber_uri;

    // Neo4j不支持java.lang.float或java.lang.Float，可以用Double。
    @Property(name = "ns0__height")
    private Double height;

    @Property(name = "ns0__width")
    private Double width;

    @Property(name = "ns0__length")
    private Double length;

    @Property(name = "ns0__weight")
    private Double weight;

    @Property(name = "ns0__site")
    private String site;

    @Property(name = "ns0__note")
    private String note;

    public AccessionNumber(String accessionNumber_uri) {
        this.accessionNumber_uri = accessionNumber_uri;
    }

    public AccessionNumber(String accessionNumber_uri, String note) {
        this.accessionNumber_uri = accessionNumber_uri;
        this.note = note;
    }

}
