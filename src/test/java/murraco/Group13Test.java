package murraco;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Group13Test {
    @Test
    public void testEmptyArray() {
        Integer[] data = {};
        BubbleSort.bubbleSort(data);
        assertArrayEquals(new Integer[]{}, data);
    }
    // This test targets the boundary condition of an empty array, which is the minimal valid input for a sorting algorithm. 
    // According to black-box testing techniques, empty inputs often expose handling errors like index-out-of-bounds or null pointer exceptions. 
    // This test verifies that BubbleSort correctly identifies that no sorting is necessary and returns an empty array, ensuring stability and correctness at this extreme input.

    @Test
    public void testSingleElementArray() {
        Integer[] data = {5};
        SelectionSort.selectionSort(data);
        assertArrayEquals(new Integer[]{5}, data);
    }
    // This test examines the smallest non-empty array possible, which is a array containing only one element. 
    // Using boundary value analysis, a single element array should remain the same after sorting. 
    // This ensures that SelectionSort does not perform unnecessary operations or introduce errors when processing minimal input sizes. 
    // It also validates that the algorithm properly handles trivial cases without accessing invalid indices.

    @Test
    public void testSortedArray() {
        Integer[] data = {1, 2, 4, 5, 9};
        InsertionSort.insertionSort(data);
        assertArrayEquals(new Integer[]{1, 2, 4, 5, 9}, data);
    }
    // This test is designed to evaluate the algorithm’s behavior on already sorted data, an important equivalence partition. 
    // Black-box testing suggests checking typical cases, including pre-sorted sequences, because some algorithms may perform unnecessary operations or swaps. 
    // For InsertionSort, this ensures that the algorithm does not disrupt correct order and efficiently handles best-case scenarios, 
    // maintaining correctness even when all elements are already in order.


    @Test
    public void testReverseSortedArray() {
        Integer[] data = {5, 4, 3, 2, 1};
        BubbleSort.bubbleSort(data);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, data);
    }
     // This test targets the worst-case scenario where elements are in descending order. 
    // Boundary value analysis in black-box testing indicates that reverse-sorted input can reveal performance or correctness issues in iterative sorting loops. 
    // By passing a reverse-sorted array to BubbleSort, we ensure that the algorithm correctly processes multiple swaps and produces a fully sorted output, 
    // while also indirectly testing the behavior of the loop structure under maximum iterations.


    @Test
    public void testArrayWithDuplicates() {
        Integer[] data = {3, 1, 2, 3, 1};
        SelectionSort.selectionSort(data);
        assertArrayEquals(new Integer[]{1, 1, 2, 3, 3}, data);
    }
    // This test was motivated by a surviving mutant in SelectionSort, where the comparison operator < was changed to <=. 
    // Arrays containing duplicate values expose the difference in behavior caused by such mutants, which may affect which element is selected as the minimum. 
    // Here, the test ensures that SelectionSort correctly handles duplicates, preserving order and maintaining correctness, 
    // highlighting cases that previous tests with unique elements could not detect.

    @Test
    public void testAllEqualElements() {
        Integer[] data = {2, 2, 2, 2};
        InsertionSort.insertionSort(data);
        assertArrayEquals(new Integer[]{2, 2, 2, 2}, data);
    }
    // This test covers the equivalence class where all array elements are identical. 
    // Black-box techniques emphasize testing such uniform inputs to verify that the algorithm maintains stability and does not perform unnecessary changes. 
    // InsertionSort should leave the array unchanged, and the test ensures that the code handles these cases without errors or exceptions, 
    // confirming proper handling of non-diverse input values.

    @Test
    public void testNegativeNumbers() {
        Integer[] data = {-3, -1, -7, -2, -4};
        BubbleSort.bubbleSort(data);
        assertArrayEquals(new Integer[]{-7, -4, -3, -2, -1 }, data);
    }
    // This test evaluates the algorithm’s behavior when all elements are negative, forming a distinct equivalence partition. 
    // Sorting algorithms often rely on comparisons, so including negative values ensures that arithmetic comparisons and loop conditions correctly handle sign differences. 
    // BubbleSort should correctly sort negative numbers from smallest to largest, demonstrating robustness across the full integer range.

    @Test
    public void testMixedNegativeAndPositiveValues() {
        Integer[] data = {-1, 3, 0, -5, 8, 2};
        SelectionSort.selectionSort(data);
        assertArrayEquals(new Integer[]{-5, -1, 0, 2, 3,8}, data);
    }
    // This test explores the input partition where negative, zero, and positive values coexist, highlighting boundary transitions between value ranges. 
    // SelectionSort must correctly compare and place elements across the negative-to-positive spectrum. 
    // Black-box techniques encourage testing these mixed inputs to catch subtle comparison errors or mishandling of extremes that could arise in sorting logic.

    @Test
    public void testRepeatedMinimumValues() {
        Integer[] data = {2, 1, 3, 1};
        SelectionSort.selectionSort(data);
        assertArrayEquals(new Integer[]{1, 1, 2, 3}, data);
    }
    // Inspired by surviving mutants, this test ensures that when multiple minimum values exist, the selection mechanism behaves correctly. 
    // This reveals potential faults related to conditional selection (e.g., < vs <=), which can affect the choice of index for swaps. 
    // By including repeated minimum values, SelectionSort is challenged to maintain correct ordering and stability, which previous tests may not have fully covered.


    @Test
    public void testSelectionSortWithDuplicates() {
        Integer[] data = {4, 2, 5, 2, 3, 5, 1};
        SelectionSort.selectionSort(data);
        assertArrayEquals(new Integer[]{1, 2, 2, 3, 4, 5, 5}, data);
    }
    // Justification: One surviving mutant altered
    // Surviving mutants sometimes fail when elements are equal, especially if a conditional uses < vs <=. Testing duplicates ensures the algorithm handles equality correctly.

}
