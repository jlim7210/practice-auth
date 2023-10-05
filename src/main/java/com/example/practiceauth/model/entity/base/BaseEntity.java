package com.example.practiceauth.model.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String uuid;

  @Column(nullable = false, updatable = false)
  private String createdBy;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  @Column(nullable = true, updatable = false)
  private String updatedBy;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = true, updatable = true)
  private LocalDateTime updatedAt = LocalDateTime.now();

  @Column(name = "is_deleted", nullable = true, updatable = true)
  private boolean isDeleted = false;

  @Column(name = "deleted_at", nullable = true, updatable = true)
  private LocalDateTime deletedAt = null;
}
