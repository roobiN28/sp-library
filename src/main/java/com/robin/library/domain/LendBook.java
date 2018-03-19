package com.robin.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LendBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn()
	private User user;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn()
	private Book book;

	private LocalDate lendingStart;

	private LocalDate lendingEnd;
}
