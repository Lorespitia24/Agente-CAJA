package com.restaurant.payBox.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author Juliana Barrera, Lorena Espitia, Felipe García, Lina Sanabria
 */
@Entity
@Table(name = "WorkingDay")
public class WorkingDay {
	
	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "work", length = 30)
	private Integer work;
	
	@Column(name = "wait", length = 30)
	private Integer wait;
	
	@Column(name = "frequencyWait", length = 30)
	private Integer frequencyWait;
	
	
	
	public WorkingDay() {
	}

	public WorkingDay(Integer id, Integer work, Integer wait, Integer frequencyWait) {
		this.id = id;
		this.work = work;
		this.wait = wait;
		this.frequencyWait = frequencyWait;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWork() {
		return work;
	}

	public void setWork(Integer work) {
		this.work = work;
	}

	public Integer getWait() {
		return wait;
	}

	public void setWait(Integer wait) {
		this.wait = wait;
	}

	public Integer getFrequencyWait() {
		return frequencyWait;
	}

	public void setFrequencyWait(Integer frequencyWait) {
		this.frequencyWait = frequencyWait;
	}


	
	}
