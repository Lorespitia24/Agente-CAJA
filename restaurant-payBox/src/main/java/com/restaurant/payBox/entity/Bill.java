package com.restaurant.payBox.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
*
* @author Juliana Barrera, Lorena Espitia, Felipe García,Nicolás Ramos, Lina Sanabria
*/

@Entity
@Table(name = "Bill")

public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBill; //ID de la factura
	
	@Column(name = "dateBill")
	private LocalDate date = LocalDate.now();
	
//	@Column(name = "typeBill")
//    private TypeBill typeBill; //tipo de factura
//	
//	@Column(name = "typePayment")
//	@Enumerated(value = EnumType.STRING)
//    private TypePayment typePayment; //tipo de pago de la factura

	@Column(name = "delivered")
    private boolean delivered; //entregada la factura
	
	@Column(name = "total")
    private Double total;
	

	@Column(name = "tips")
    private boolean tips; //entregada la factura
	
	//ordenes
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "BillID")
//	@JoinColumn(name = "orderID", referencedColumnName = "idOrderClient")
	private List<OrderClient> orderClientList = new ArrayList<>();

	
	
	public Bill() {
		super();
	}

	public Bill(boolean delivered, Double total) {
		super();
		this.delivered = delivered;
		this.total = total;
		this.orderClientList = new ArrayList<>();
		this.tips = false;
	}

	public Long getIdBill() {
		return idBill;
	}

	public void setIdBill(Long idBill) {
		this.idBill = idBill;
	}

//	public TypeBill getTypeBill() {
//		return typeBill;
//	}
//
//	public void setTypeBill(TypeBill typeBill) {
//		this.typeBill = typeBill;
//	}
//
//	public TypePayment getTypePayment() {
//		return typePayment;
//	}
//
//	public void setTypePayment(TypePayment typePayment) {
//		this.typePayment = typePayment;
//	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<OrderClient> getOrderClientList() {
		return orderClientList;
	}

	public void setOrderClientList(List<OrderClient> orderClientList) {
		this.orderClientList = orderClientList;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isTips() {
		return tips;
	}

	public void setTips(boolean tips) {
		this.tips = tips;
	}

	
	
	}
