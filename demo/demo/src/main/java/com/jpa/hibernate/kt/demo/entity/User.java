package com.jpa.hibernate.kt.demo.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String email;
}
