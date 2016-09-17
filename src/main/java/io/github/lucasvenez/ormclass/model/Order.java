package io.github.lucasvenez.ormclass.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4124110809141682575L;

	@Id
	@Column
	@GeneratedValue
	private Integer idOrder;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date Orderdate;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date Ordertime;

	@OneToMany(
			mappedBy = "order", 
			targetEntity = OrderItem.class, 
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL)
	private final List<OrderItem> orderItems = new ArrayList<OrderItem>();

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "IdPerson")
	private Person person;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDate() {
		return Orderdate;
	}

	public void setDate(Date date) {
		this.Orderdate = date;
	}

	public Date getTime() {
		return Ordertime;
	}

	public void setTime(Date time) {
		this.Ordertime = time;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void addOrderItems(OrderItem orderItem) {
		orderItem.setOrder(this);
		this.orderItems.add(orderItem);
	}
	
	
	
}
