public interface MyStack<Item> {
    MyStack<Item>push(Item item);
    Item pop();
    int size();
    boolean isEmpty();
}
