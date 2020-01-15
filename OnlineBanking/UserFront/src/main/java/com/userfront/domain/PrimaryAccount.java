package com.userfront.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PrimaryAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int accountNumber;
	private BigDecimal accountBalance;
	
	
	/*
	 * Nje PrimaryAccount mund te kete shume PrimaryTransaction --> Lidhja OneToMany
	 * mappedBy = "primaryAccount" supozon se ne klasen PrimaryTransaction ka nje Objekt PrimaryAccount(Lidhja mes dyjave)
	 * CascadeType = cfaredo veprimi qe behet ne databaze, ndryshohet edhe ne klase
	 * JsonIgnore - ne klasen PrimaryAccount inicializohet PrimaryTransaction, si dhe ne klasen Primary Transaction 
	   inicializohet PrimaryAccount - kur provon me serializu ne json format hyn ne infinit loop.
	 */
	
	@OneToMany (mappedBy = "primaryAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PrimaryTransaction> primaryTransactionList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<PrimaryTransaction> getPrimaryTransactionList() {
		return primaryTransactionList;
	}

	public void setPrimaryTransactionList(List<PrimaryTransaction> primaryTransactionList) {
		this.primaryTransactionList = primaryTransactionList;
	}
	
	

}
