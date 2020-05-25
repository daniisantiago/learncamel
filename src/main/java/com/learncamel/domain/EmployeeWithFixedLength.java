package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

import java.time.LocalDate;

@FixedLengthRecord(ignoreTrailingChars = true)
public class EmployeeWithFixedLength {

    @DataField(pos=1, length = 3)
    private int id;
    @DataField(pos=2, length = 10, trim=true, align = "L")
    private String name;
    @DataField(pos=3, length = 8)
    private String role;
    @DataField(pos = 4, length = 8, pattern = "ddMMyyyy")
    private LocalDate joinDate;

    @Override
    public String toString() {
        return "EmployeeWithFixedLength{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", joinDate=" + joinDate +
                '}';
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
