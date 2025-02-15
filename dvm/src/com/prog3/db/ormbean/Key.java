package com.prog3.db.ormbean;

import javax.persistence.*;

/**
 * Key.java
 * This is a model class represents a Key entity
 *
 * @author Vittorio Fones
 */
@Entity
@Table(name="key")
public class Key {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_key")
  private int id_key;
  @Column(name="balance", nullable = false)
  private float balance;

  /**
   * Instantiates a new Key.
   */
  public Key() {
  }

  /**
   * Instantiates a new Key.
   *
   * @param balance the balance
   */
  public Key(float balance) {
    this.balance = balance;
  }


  /**
   * Gets id key.
   *
   * @return the id key
   */
  public int getId_key() {
    return id_key;
  }

  /**
   * Sets id key.
   *
   * @param id_key the id key
   */
  public void setId_key(int id_key) {
    this.id_key = id_key;
  }

  /**
   * Gets balance.
   *
   * @return the balance
   */
  public float getBalance() {
    return balance;
  }

  /**
   * Sets balance.
   *
   * @param balance the balance
   */
  public void setBalance(float balance) {
    this.balance = balance;
  }
}