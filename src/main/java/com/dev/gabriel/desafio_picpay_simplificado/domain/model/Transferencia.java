package com.dev.gabriel.desafio_picpay_simplificado.domain.model;

import com.dev.gabriel.desafio_picpay_simplificado.domain.enums.StatusTransferencia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tb_transacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transferencia {
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
  private StatusTransferencia status;
}
