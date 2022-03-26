package org.example;

import io.qameta.allure.Description;
import org.example.model.LinkedNode;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LinkedNodeBaseTest extends TestBase {

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

    @Description("Check how to work LinkedNode object creation")
    @ParameterizedTestWithDisplayName
    @MethodSource("differentArgumentsForNode")
    void shouldCreateNodeWithDifferentArguments(LinkedNode innerNode, Integer expectedValue) {
        LinkedNode createdLinkedNode = new LinkedNode(innerNode, expectedValue);

        assertNotNull(createdLinkedNode);
        assertEquals(innerNode, createdLinkedNode.node);
        assertEquals(expectedValue, createdLinkedNode.value);
    }

    static List<Arguments> parametersForCheckingFindMethods() {
        LinkedNode initialNode = new LinkedNode(null, 0);
        LinkedNode nextNode = new LinkedNode(initialNode, 1);
        LinkedNode nextNodeWithSameValue = new LinkedNode(initialNode, 0);

        return List.of(
                Arguments.of(initialNode, 0, null),
                Arguments.of(initialNode, -1, null),
                Arguments.of(nextNode, 1, initialNode),
                Arguments.of(nextNode, 10, null),
                Arguments.of(new LinkedNode(nextNode, 10), 1, nextNode),
                Arguments.of(new LinkedNode(nextNode, 10), 0, initialNode),
                Arguments.of(nextNodeWithSameValue, 0, initialNode) // ToDo: Discuss this case
        );
    }

    @Description("Check how to work findNodeByValueWithIncorrectImplementation method")
    @ParameterizedTestWithDisplayName
    @MethodSource("parametersForCheckingFindMethods")
    void checkFindMethodWithIncorrectImplementationWorks(LinkedNode linkedNodeForSearch, Integer expectedValue, LinkedNode expectedNode) {
        assertEquals(expectedNode, linkedNodeForSearch.findNodeByValueWithIncorrectImplementation(expectedValue));
    }

    @Description("Check how to work findNodeByValue method")
    @ParameterizedTestWithDisplayName
    @MethodSource("parametersForCheckingFindMethods")
    void checkFindMethodWorks(LinkedNode linkedNodeForSearch, Integer valueForSearch, LinkedNode expectedNode) {
        assertEquals(expectedNode, linkedNodeForSearch.findNodeByValue(valueForSearch));
    }

}
