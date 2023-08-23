package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

    class StringListImplTest {
        private StringListImpl[] stringLists;

        public StringListImplTest() {
            stringLists = new StringListImpl[4];
            stringLists[0] = new StringListImpl("000", "111", "222", "333", "444", "555", "666", "777", "888",null);
            stringLists[1] = new StringListImpl("333", "444", "555", "666", "777", "888",null,null,null,null,null,);
            stringLists[2] = new StringListImpl("ggg", "444", "555", "666", "777", "www",null,null,null,null,null,);
            stringLists[3] = new StringListImpl("908", "097", "897", "666", "777", "231",null,null,null,null,null,);
        }

        @Test
        void add_sizeLessCapacity_addWithoutGrowCapacity() {
            String result = testStrings09.add("123");
            assertTrue(testStrings09.contains("123"));
            assertEquals("123", result);
            assertEquals(10, testStrings09.size());
        }

        @Test
        void add_sizeEqualsCapacity_addWithGrowCapacity() {
            String result = testStrings10.add("123");
            assertTrue(testStrings10.contains("123"));
            assertEquals("123", result);
            assertEquals(11, testStrings10.size());
        }

        @Test
        void addByIndex_indexMoreSize_thrownException() {
            assertThrows(OutOfBoundsException.class, () -> testStrings09.add(11, "123"));
        }

        @Test
        void addByIndex_indexNoMoreSize_addByIndexAndIncreaseSize() {
            String result = testStrings09.add(7, "123");
            assertTrue(testStrings09.contains("123"));
            assertEquals("123", result);
            assertEquals("123", testStrings09.get(7));
            assertEquals(10, testStrings09.size());
        }

        @Test
        void set_indexMoreSize_thrownException() {
            assertThrows(OutOfBoundsException.class, () -> testStrings09.set(11, "123"));
        }

        @Test
        void set_indexNoMoreSize_replacedItemsByIndex() {
            String result = testStrings09.set(7, "123");
            assertTrue(testStrings09.contains("123"));
            assertEquals("123", result);
            assertEquals("123", testStrings09.get(7));
            assertEquals(9, testStrings09.size());
        }

        @Test
        void removeByItem_noHasItemInStringList_thrownException() {
            assertThrows(ItemNotFoundException.class, () -> testStrings09.remove("123"));
        }

        @Test
        void removeByItem_haveItemInStringList_deleteAndDecreaseSize() {
            String result = testStrings09.remove("444");
            assertFalse(testStrings09.contains("444"));
            assertEquals("444", result);
            assertEquals(8, testStrings09.size());
        }

        @Test
        void removeByIndex_indexMoreSize_thrownException() {
            assertThrows(ItemNotFoundException.class, () -> testStrings09.remove(11));
        }

        @Test
        void removeByIndex_indexNoMoreSize_deleteItemAndDecreaseSize() {
            String result = testStrings09.remove(4);
            assertFalse(testStrings09.contains("444"));
            assertEquals("444", result);
            assertEquals(8, testStrings09.size());
        }

        @Test
        void contains_noHasItemInStringList_returnFalse() {
            assertFalse(testStrings09.contains("123"));
        }

        @Test
        void contains_haveItemInStringList_returnTrue() {
            assertTrue(testStrings09.contains("444"));
        }

        @Test
        void indexOf_noHasItemInStringList_return_minus1() {
            assertEquals(-1, testStrings11.indexOf("123"));
        }

        @Test
        void indexOf_haveItemInStringList_returnIndex() {
            assertEquals(1, testStrings11.indexOf("111"));
        }

        @Test
        void lastIndexOf_noHasItemInStringList_return_minus1() {
            assertEquals(-1, testStrings11.indexOf("123"));
        }

        @Test
        void lastIndexOf_haveItemInStringList_returnIndex() {
            assertEquals(5, testStrings11.lastIndexOf("111"));
        }

        @Test
        void get_indexMoreSize_thrownException() {
            assertThrows(RuntimeException.class, () -> testStrings09.remove(11));
        }

        @Test
        void get_indexNoMoreSize_returnItem() {
            assertEquals("222", testStrings09.get(2));
        }

        @Test
        void equals_otherListIsNull_thrownException() {
            assertThrows(RuntimeException.class, () -> testStrings09.equals(testStrings09.clear()));
        }

        @Test
        void equals_stringListsNotEqualToEachOtherBySize_returnFalse() {
            assertFalse(testStrings09.equals(testStrings10));
        }

        @Test
        void equals_stringListsNotEqualToEachOtherByItems_returnFalse() {
            assertFalse(testStrings09.equals(testStrings99));
        }

        @Test
        void equals_stringListsEqualToEachOther_returnTrue() {
            assertTrue(testStrings09.equals(testStrings9));
        }

        @Test
        void equals_stringListsEqualToSelf_returnTrue() {
            assertTrue(testStrings09.equals(testStrings09));
        }

        @Test
        void size__returnedSizeIsCorrect() {
            assertEquals(9, testStrings09.size());
        }

        @Test
        void isEmpty_stringListIsEmpty_returnTrue() {
            StringListImpl emptyStrList = new StringListImpl();
            assertTrue(emptyStrList.isEmpty());
        }

        @Test
        void isEmpty_stringListNoEmpty_returnFalse() {
            assertFalse(testStrings09.isEmpty());
        }

        @Test
        void toArray__returnedArrayIsCorrect() {

        }
}