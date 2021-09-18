package interview.jsonparser;

public class Item {

    String key;
    Object value;
    ValueType valueType;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", valueType=" + valueType +
                '}';
    }
}
