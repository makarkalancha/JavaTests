/*
 * Software property of Acquisio. Copyright 2003-2019.
 */
package com.everything.generic;

import com.google.common.base.Objects;

/**
 * @author Macar Calancea (mcalancea@acquisio.com)
 */
public class Field {
    private Long id = null;
    private String name = null;
    private String label = null;
    private String value = null;
    private String type = null;

    public static Field.FieldBuilder builder() {
        return new Field.FieldBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLabel() {
        return this.label;
    }

    public String getValue() {
        return this.value;
    }

    public String getType() {
        return this.type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Field) {
            Field that = (Field) other;
            return Objects.equal(getId(), that.getId())
                    && Objects.equal(getName(), that.getName())
                    && Objects.equal(getLabel(), that.getLabel())
                    && Objects.equal(getValue(), that.getValue())
                    && Objects.equal(getType(), that.getType())
                    ;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                getId(),
                getName(),
                getLabel(),
                getValue(),
                getType());
    }

    public Field() {
    }

    public Field(Long id, String name, String label, String value, String type) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.value = value;
        this.type = type;
    }

    public static class FieldBuilder {
        private Long id;
        private String name;
        private String label;
        private String value;
        private String type;

        FieldBuilder() {
        }

        public Field.FieldBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Field.FieldBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Field.FieldBuilder label(String label) {
            this.label = label;
            return this;
        }

        public Field.FieldBuilder value(String value) {
            this.value = value;
            return this;
        }

        public Field.FieldBuilder type(String type) {
            this.type = type;
            return this;
        }

        public Field build() {
            return new Field(this.id, this.name, this.label, this.value, this.type);
        }

    }
}
