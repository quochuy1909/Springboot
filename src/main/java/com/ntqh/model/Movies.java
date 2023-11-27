package com.ntqh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Movies3")
public class Movies {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id;
	String image;
	String description;
	String link;
	String title;
	int views;
}
