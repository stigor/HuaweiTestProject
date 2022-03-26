package org.example;

import org.example.model.LinkedNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedNodeBaseTest {

    static List<Arguments> differentArgumentsForNode() {
        LinkedNode initialNode = new LinkedNode(null, 0);

        return List.of(
                Arguments.of(null, 1),
                Arguments.of(null, null),
                Arguments.of(null, Integer.MAX_VALUE),
                Arguments.of(null, Integer.MIN_VALUE),
                Arguments.of(initialNode, -1),
                Arguments.of(initialNode, null),
                Arguments.of(initialNode, Integer.MAX_VALUE),
                Arguments.of(initialNode, Integer.MIN_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("differentArgumentsForNode")
    void shouldCreateNodeWithDifferentArguments(LinkedNode innerNode, Integer expectedValue) {
        LinkedNode createdLinkedNode = new LinkedNode(innerNode, expectedValue);

        assertNotNull(createdLinkedNode);
        assertEquals(innerNode, createdLinkedNode.node);
        assertEquals(expectedValue, createdLinkedNode.value);
    }

    static List<Arguments> dataProviderForCheckingFindMethod() {
        LinkedNode initialNode = new LinkedNode(null, 0);
        LinkedNode nextNode = new LinkedNode(initialNode, 0);

        return List.of(
                Arguments.of(initialNode, 0, null),
                Arguments.of(initialNode, 100, null),
                Arguments.of(nextNode, 0, initialNode),
                Arguments.of(nextNode, 10, null)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProviderForCheckingFindMethod")
    void checkFindMethodWorks(LinkedNode whereFindNode, Integer expectedValue, LinkedNode expectedNode) {
        assertEquals(expectedNode, whereFindNode.findNode(expectedValue));
    }

    @Test
    void someTest() {
        LinkedNode initialNode = new LinkedNode(null, 5);
        LinkedNode nextNode = new LinkedNode(initialNode, 10);

        assertNull(initialNode.findNode(5));
        assertEquals(nextNode, nextNode);
    }

}
