package com.restaurant.payBox.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* @author Juliana Barrera, Lorena Espitia, Felipe García,Nicolás Ramos, Lina Sanabria
*/

@Entity
@Table(name = "ClientRestaurant")
public class ClientRestaurant {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idClient;
	
	@Column(name = "clientRestaurant")
	private Integer clientRestaurant;

	
	
	public ClientRestaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientRestaurant(Integer clientRestaurant) {
		this.clientRestaurant = clientRestaurant;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Integer getClient() {
		return clientRestaurant;
	}

	public void setClient(Integer clientRestaurant) {
		this.clientRestaurant = clientRestaurant;
	}
	
	
}
