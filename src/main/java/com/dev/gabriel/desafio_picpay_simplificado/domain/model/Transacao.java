package com.dev.gabriel.desafio_picpay_simplificado.domain.model;

import com.dev.gabriel.desafio_picpay_simplificado.domain.enums.StatusTransacao;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tb_transacao")
public class Transacao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private BigDecimal valor;

  @ManyToOne
  @JoinColumn(name = "payer_id", nullable = false)
  private Usuario payer;

  @ManyToOne
  @JoinColumn(name = "payee_id", nullable = false)
  private Usuario payee;

  @Column(nullable = false)
  @CreationTimestamp
  private Instant timestamp;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private StatusTransacao status;

  public Transacao() {}

  public Transacao(
      Long id,
      BigDecimal valor,
      Usuario payer,
      Usuario payee,
      Instant timestamp,
      StatusTransacao status) {
    this.id = id;
    this.valor = valor;
    this.payer = payer;
    this.payee = payee;
    this.timestamp = timestamp;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public Usuario getPayer() {
    return payer;
  }

  public void setPayer(Usuario payer) {
    this.payer = payer;
  }

  public Usuario getPayee() {
    return payee;
  }

  public void setPayee(Usuario payee) {
    this.payee = payee;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  public StatusTransacao getStatus() {
    return status;
  }

  public void setStatus(StatusTransacao status) {
    this.status = status;
  }
}
