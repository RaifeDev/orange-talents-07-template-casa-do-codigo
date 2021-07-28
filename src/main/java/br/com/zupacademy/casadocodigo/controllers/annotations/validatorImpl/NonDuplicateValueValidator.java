package br.com.zupacademy.casadocodigo.controllers.annotations.validatorImpl;

import br.com.zupacademy.casadocodigo.controllers.annotations.NonDuplicateValue;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NonDuplicateValueValidator implements ConstraintValidator<NonDuplicateValue, Object> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> classeEmUso;
    private String atributoDaClasse;


    @Override
    public void initialize(NonDuplicateValue constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);
        atributoDaClasse = constraintAnnotation.fieldName();
        classeEmUso = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        Query query = entityManager.createQuery("select 1 from "+classeEmUso.getName()+" where " + atributoDaClasse + "=:value");
        query.setParameter("value", o);

        List<?> list = query.getResultList();
        return list.isEmpty();

    }




}
