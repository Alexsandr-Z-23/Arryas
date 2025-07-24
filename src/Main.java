public class Main {
    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Hello");
        list.add("World");

        System.out.println("First element: " + list.get(0)); // Hello
        System.out.println("Size before remove: " + list.size()); // 2

        String removed = list.remove();
        System.out.println("Removed element: " + removed); // World
        System.out.println("Size after remove: " + list.size()); // 1

        // Демонстрация других методов
        list.set(0, "Java");
        System.out.println("After set: " + list.get(0)); // Java

        System.out.println("Current capacity: " + list.capacity());
        list.shrink();
        System.out.println("Capacity after shrink: " + list.capacity());
    }
}