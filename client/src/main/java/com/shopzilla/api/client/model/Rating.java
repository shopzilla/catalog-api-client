package com.shopzilla.api.client.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * @author Rachel Baldovino
 * @created 4/30/14
 */
public class Rating {

    private String dimension;
    private BigDecimal value;
    private int max;
    private int min;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("dimension", dimension)
                .append("value", value)
                .append("max", max)
                .append("min", min)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || !(o instanceof Rating)) {
            return false;
        }

        Rating rhs = (Rating) o;
        return new EqualsBuilder()
                .append(dimension, rhs.dimension)
                .append(value, rhs.value)
                .append(max, rhs.max)
                .append(min, rhs.min)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(dimension)
                .append(value)
                .append(max)
                .append(min)
                .toHashCode();
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
