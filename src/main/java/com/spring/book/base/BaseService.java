package com.spring.book.base;

import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;

@MappedSuperclass
public class BaseService<T extends BaseEntity , ID extends Number> {


}
