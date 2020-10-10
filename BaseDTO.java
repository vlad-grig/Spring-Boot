package ro.sda.spring.boot.dto;

import java.time.LocalDateTime;

public abstract class BaseDTO {

    protected Long id;

    protected LocalDateTime createdTime;

    protected LocalDateTime lastUpdateTime;

    public BaseDTO(Long id, LocalDateTime createdTime, LocalDateTime lastUpdateTime) {
        this.id = id;
        this.createdTime = createdTime;
        this.lastUpdateTime = lastUpdateTime;
    }

    public BaseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}

