package org.mizar.esx.article;

import java.util.*;

public class BlocksItems {

    private static Stack<Block> blocks = new Stack<>();
    private static Stack<Item> items = new Stack<>();

    public static void addBlock(Block block) {
//        System.out.println("+++ Block \"" + block.getKind() + "\" added.");
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
        Block result = blocks.pop();
//        System.out.println("--- Block \"" + result.getKind() + "\" removed.");
        return result;
    }

    public static Item removeLastItem() {
        return items.pop();
    }
}
