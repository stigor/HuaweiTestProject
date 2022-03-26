package org.example.model;

public class LinkedNode {
    public LinkedNode node;
    public Integer value;

    public LinkedNode(LinkedNode node, Integer value) {
        this.node = node;
        this.value = value;
    }

    // ToDo: This method has incorrect implementation
    public LinkedNode findNodeByValueWithIncorrectImplementation(Integer expectedValue) {
        LinkedNode currentNode = this.node;

        if (currentNode == null) return null;

        while (currentNode.node != null) {
            if (currentNode.value.equals(expectedValue)) {
                return currentNode;
            }
            currentNode = currentNode.node;
        }

        return null;
    }

    public LinkedNode findNodeByValue(Integer expectedValue) {
        if (this.value.equals(expectedValue)) {
            return this.node;
        }
        LinkedNode currentNode = this.node;

        while (currentNode != null) {
            if (currentNode.value.equals(expectedValue)) {
                return currentNode;
            }
            currentNode = currentNode.node;
        }

        return null;
    }
}
