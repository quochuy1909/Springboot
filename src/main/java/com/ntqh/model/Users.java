package com.ntqh.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users2")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String username;
	String password;
	String gmail;
	@ManyToOne
	@JoinColumn (name="likedMovie")
	Movies likedMovie;
}
