package io.jrovieri.kitanda.api.domain;

import io.jrovieri.kitanda.api.BooleanConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "CATG")
public class Category {

	@Id
	@Column(name = "CATG_ID")
	@SequenceGenerator(sequenceName = "SQ_CATG", name = "categorySequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "categorySequence")
	private Long id;

	@Column(name = "CATG_NAME", columnDefinition = "VARCHAR(32)", nullable = false)
	private String name;
	
	@Column(name = "CATG_ENBL", columnDefinition = "CHAR(1)", nullable = false)
	@Convert(converter = BooleanConverter.class)
	private Boolean enabled;
	
}
