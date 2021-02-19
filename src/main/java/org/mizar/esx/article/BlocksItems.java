package org.mizar.esx.article;

import java.util.*;

public class BlocksItems {

    private static Stack<Block> blocks = new Stack<>();
    private static Stack<Item> items = new Stack<>();

    public static void addBlock(Block block) {
        blocks.push(block);
    }

    public static void addItem(Item item) {
        items.push(item);
    }

    public static Block lastBlock() {
        return blocks.peek();
    }

    public static Item lastItem() {
        return items.peek();
    }

    public static Block removeLastBlock() {
       return blocks.pop();
    }

    public static Item removeLastItem() {
        return items.pop();
    }
}
