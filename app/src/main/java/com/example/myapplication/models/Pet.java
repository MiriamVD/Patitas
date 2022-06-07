package com.example.myapplication.models;

public class Pet {
    private String petName, nameContactPerson, email, description, selectedStatus, selectedType;
    private Integer telephone;


    public Pet(String petName, String nameContactPerson, String email, String description,  Integer telephone) {
        this.petName = petName;
        this.nameContactPerson = nameContactPerson;
        this.email = email;
        this.description = description;
        //this.selectedStatus = selectedStatus;
       // this.selectedType = selectedType;
        this.telephone = telephone;
    }
    public Pet(){

    }

    public String getpetName() {
        return petName;
    }

    public void setpetName(String petName) {
        this.petName = petName;
    }

    public String getNameContactPerson() {
        return nameContactPerson;
    }

    public void setNameContactPerson(String nameContactPerson) {
        this.nameContactPerson = nameContactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* public String getSelectedStatus() {
        return selectedStatus;
    }

    public void setSelectedStatus(String selectedStatus) {
        this.selectedStatus = selectedStatus;
    }

    public String getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
    }*/

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petName='" + petName + '\'' +
                ", nameContactPerson='" + nameContactPerson + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
               /* ", selectedStatus='" + selectedStatus + '\'' +
                ", selectedType='" + selectedType + '\'' +*/
                ", telephone=" + telephone +
                '}';
    }
}
