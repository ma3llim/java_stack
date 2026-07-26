void main() {
    Object value = 19;

    // if (value instanceof Object) {
    // System.err.println("value of Object is " + value);
    // }
    switch (value) {
        case int i -> System.out.println("value is int");
        case doule i -> System.out.println("value is doule");
        default -> System.out.println("value is not int and doule");
    }
}