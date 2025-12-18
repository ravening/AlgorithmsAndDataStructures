package com.rakeshv.models;

public class Email {
    private Long id;

    public Email(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                '}';
    }
}
