package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

@FixedLengthRecord(ignoreTrailingChars = true)
public class EmployeeWithFixedLength {

    @DataField(pos=1, length = 3)
    private int id;
    @DataField(pos=2, length = 9,trim=true,align = "L")
    private String name;
    @DataField(pos=3, length = 9)
    private String role;

    @Override
    public String toString() {
        return "EmployeeWithFixedLength{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
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
}
