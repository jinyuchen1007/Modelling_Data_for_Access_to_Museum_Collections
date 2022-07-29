package museum.spring.data.neo4j.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artefact implements Serializable {

    private AccessionNumber accessionNumber;

    private String material;

    private String type;

    private String style;

    //private String site;


}
