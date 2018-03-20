package com.robin.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer debt;

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void increaseDebtBy(Integer gain) {
		debt += gain;
	}
}
