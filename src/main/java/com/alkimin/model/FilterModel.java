package com.alkimin.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Month;


@Getter
@Builder
public class FilterModel {

    private String categoria;

    private Month mes;

    private String data;

    private BigDecimal valor;
}
