package com.restaurant.payBox.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
*
* @author Juliana Barrera, Lorena Espitia, Felipe García, Lina Sanabria
*/

@Entity
@Table(name = "Waiter")

public class Waiter{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWaiter; //ID cocinero
	
	@Column(name = "waiter")
    private Integer waiter; //ID mesero
	
	@Column(name = "scoreWaiter")
    private Integer scoreWaiter; //calificación mesero
	
	@Column(name = "tip")
    private Double tip; //propina mesero

	
	public Waiter() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Waiter(Integer waiter) {
		super();
		this.waiter = waiter;
		this.scoreWaiter = 0;
		this.tip = 0.0;
	}


	public Long getIdWaiter() {
		return idWaiter;
	}


	public void setIdWaiter(Long idWaiter) {
		this.idWaiter = idWaiter;
	}


	public Integer getWaiter() {
		return waiter;
	}


	public void setWaiter(Integer waiter) {
		this.waiter = waiter;
	}


	public Integer getScoreWaiter() {
		return scoreWaiter;
	}


	public void setScoreWaiter(Integer scoreWaiter) {
		this.scoreWaiter = scoreWaiter;
	}


	public Double getTip() {
		return tip;
	}


	public void setTip(Double tip) {
		this.tip = tip;
	}

	
	
	
   }
