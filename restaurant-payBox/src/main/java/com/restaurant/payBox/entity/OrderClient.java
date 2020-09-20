package com.restaurant.payBox.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
*
* @author Juliana Barrera, Lorena Espitia, Felipe García, Lina Sanabria
*/

@Entity
@Table(name = "OrderClient")
public class OrderClient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder; //ID del platoCalificado
	
	
	@Column(name = "typeBill")
    private TypeBill typeBill; //tipo de pago

	@Column(name = "orderClient")
	private Integer orderClient; //
	
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "OrderID")
	private List<Plate> plateList = new ArrayList<>(); //lista de platos del cliente
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_waiter")
	private Waiter waiter;//mesero que que atendio
	
	@Column(name = "typePayment")
	@Enumerated(value = EnumType.STRING)
	private TypePayment typePayment; // tipo de pago 
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idClient")
	private Client client; //cliente

	
	
	public OrderClient() {
//		this.plateList = new ArrayList<>();
	}

	public OrderClient(Integer orderClient, TypeBill typeBill, Waiter waiter,
			TypePayment typePayment, Client client) {
		super();
		this.orderClient = orderClient;
		this.typeBill = typeBill;
		this.waiter = waiter;
		this.typePayment = typePayment;
		this.client = client;
	}






	public Long getIdOrder() {
		return idOrder;
	}






	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}






	public Integer getOrderClient() {
		return orderClient;
	}






	public void setOrderClient(Integer orderClient) {
		this.orderClient = orderClient;
	}






	public TypeBill getTypeBill() {
		return typeBill;
	}






	public void setTypeBill(TypeBill typeBill) {
		this.typeBill = typeBill;
	}






	public List<Plate> getPlateList() {
		return plateList;
	}






	public void setPlateList(List<Plate> plateList) {
		this.plateList = plateList;
	}






	public Waiter getWaiter() {
		return waiter;
	}






	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}






	public TypePayment getTypePayment() {
		return typePayment;
	}






	public void setTypePayment(TypePayment typePayment) {
		this.typePayment = typePayment;
	}






	public Client getClient() {
		return client;
	}






	public void setClient(Client client) {
		this.client = client;
	}






	@Override
	public String toString() {
		return "OrderClient [idOrderClient="  + ", typeBill=" + typeBill + ", plateList=" + plateList
				+ ", waiter=" + waiter + ", typePayment=" + typePayment  + ", client=" + client + "]";
	}

	
}