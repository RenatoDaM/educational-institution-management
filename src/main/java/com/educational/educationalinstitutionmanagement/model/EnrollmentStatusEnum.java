package com.educational.educationalinstitutionmanagement.model;

public enum EnrollmentStatusEnum {
    ATIVO("Ativo"),
    TRANCADO("Trancado"),
    CANCELADO("Cancelado"),
    FINALIZADO("Finalizado");

    private String status;

    private EnrollmentStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
