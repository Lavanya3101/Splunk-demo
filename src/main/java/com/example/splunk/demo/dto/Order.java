package com.example.splunk.demo.dto;

import java.util.Date;
import java.util.Objects;

public class Order {
	 private int id;
	    private String name;
	    private int qty;
	    private double price;
	    private String transactionId;
	    private Date orderPlacedDate;
		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Order(int id, String name, int qty, double price, String transactionId, Date orderPlacedDate) {
			super();
			this.id = id;
			this.name = name;
			this.qty = qty;
			this.price = price;
			this.transactionId = transactionId;
			this.orderPlacedDate = orderPlacedDate;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
		public Date getOrderPlacedDate() {
			return orderPlacedDate;
		}
		public void setOrderPlacedDate(Date orderPlacedDate) {
			this.orderPlacedDate = orderPlacedDate;
		}
		@Override
		public String toString() {
			return "Order [id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price + ", transactionId="
					+ transactionId + ", orderPlacedDate=" + orderPlacedDate + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(id, name, orderPlacedDate, price, qty, transactionId);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Order other = (Order) obj;
			return id == other.id && Objects.equals(name, other.name)
					&& Objects.equals(orderPlacedDate, other.orderPlacedDate)
					&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && qty == other.qty
					&& Objects.equals(transactionId, other.transactionId);
		}
	    
		 // Builder pattern implementation
	    public static class Builder {
	        private int id;
	        private String name;
	        private int qty;
	        private double price;
	        private String transactionId;
	        private Date orderPlacedDate;

	        public Builder setId(int id) {
	            this.id = id;
	            return this;
	        }

	        public Builder setName(String name) {
	            this.name = name;
	            return this;
	        }

	        public Builder setQty(int qty) {
	            this.qty = qty;
	            return this;
	        }

	        public Builder setPrice(double price) {
	            this.price = price;
	            return this;
	        }

	        public Builder setTransactionId(String transactionId) {
	            this.transactionId = transactionId;
	            return this;
	        }

	        public Builder setOrderPlacedDate(Date orderPlacedDate) {
	            this.orderPlacedDate = orderPlacedDate;
	            return this;
	        }

	        public Order build() {
	            return new Order(id, name, qty, price, transactionId, orderPlacedDate);
	        }
	    }
	
}
