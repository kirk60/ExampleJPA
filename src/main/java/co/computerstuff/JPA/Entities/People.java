package co.computerstuff.JPA.Entities;

import javax.persistence.*;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * This demonstrates a very simple entity.
 * 
 * Table People
 * - id : int : autoincrement
 * - name : varchar(60)
 * - phone : varchar(20)
 * - email : varchar(40)
 * 
 * 
 * @Data :  generates the getters & setters
 * @Accessors(chain=true) : makes the setters chainable
 * IE person.setName("fred").setPhone("123123") works
 * 
 * 
 * @author Kirk Larson
 *
 */

@Accessors(chain=true)
@Data
@Entity
@Table(name = "people")
public class People {
	@Id
	@GeneratedValue
	private int id;

	private String name;
	
	private String phone;
	private String email;

}