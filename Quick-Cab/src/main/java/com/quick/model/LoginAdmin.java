package com.quick.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class LoginAdmin {


	@NotEmpty
	@NotNull
	@Id
	private Integer userId;
	
	private String name;
	private String password;
	
}