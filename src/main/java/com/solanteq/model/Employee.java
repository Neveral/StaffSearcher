package com.solanteq.model;

import com.solanteq.util.PatternConstants;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 7372903550200323474L;

    @Id
    @Column(name="id", nullable = false, unique = true, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = PatternConstants.NAME_PATTERN, message = "{employeeName.err}")
    @Column(name = "first_name", length = 40)
    private String firstName;

    @Pattern(regexp = PatternConstants.NAME_PATTERN, message = "{employeeMiddleName.err}")
    @Column(name = "middle_name", length = 40)
    private String middleName;

    @Pattern(regexp = PatternConstants.NAME_PATTERN, message = "{employeeLastName.err}")
    @Column(name = "last_name", length = 40)
    private String lastName;

    @Pattern(regexp = PatternConstants.POSITION_PATTERN, message = "{employeePosition.err}")
    @Column(name = "position", length = 40)
    private String position;

    @Column(name = "birthday")
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //@Pattern(regexp = PatternConstants.BIRTHDAY_PATTERN, message = "{employeeBirthday.err}")
    private Date birthday;

    public Employee() {
    }

    public Employee(Long id, String firstName, String middleName, String lastName, String position, Date birthday) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.position = position;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!id.equals(employee.id)) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (middleName != null ? !middleName.equals(employee.middleName) : employee.middleName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (position != null ? !position.equals(employee.position) : employee.position != null) return false;
        return birthday != null ? birthday.equals(employee.birthday) : employee.birthday == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
