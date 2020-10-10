package ro.sda.spring.boot.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    protected Long id;

    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdTime;

    @Column(nullable = false,updatable = true)
    protected LocalDateTime lastUpdateTime;

}
