package museum.spring.data.neo4j.example;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.io.Serializable;

@Data
@Node(value = "Person")
public class Person implements Serializable {
    @Id
    @GeneratedValue //设置主键自增
    private Long id;
    @Property
    private String name;

    public Person(String name) {
        this.name = name;
    }
}

