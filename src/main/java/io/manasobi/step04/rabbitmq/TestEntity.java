package io.manasobi.step04.rabbitmq;

import java.io.Serializable;

/**
 * Don't forget to implement {@code Serializable} in classes destined for transmission over the wire.
 */
public class TestEntity implements Serializable {

    private final String value;

    public TestEntity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // boilerplate

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestEntity that = (TestEntity) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "value='" + value + '\'' +
                '}';
    }

}
