package com.quick.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginAdmin {


	@NotEmpty
	@NotNull
	@Id
	private Integer userId;
	
	private String name;
	private String password;
	
}