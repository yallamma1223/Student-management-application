package com.user.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="user")
public class User {
	@Id
	@SequenceGenerator(name = "User_Sequence",sequenceName = "id_Sequence",allocationSize = 1)
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	private String username;
	private String name;
	private String email;

}
