package com.educational.security;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Necessário especificar RUNTIME por que é algo que em tempo de execução vamos querer ficar fazendo/verificando
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyRole('ADMIN','CLIENT') and hasAuthority('SCOPE_myuser:write')")
public @interface CanEditMyUser {
}
