package day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestFreeIndexTest {
    SmallestFreeIndex slfi ;

    @BeforeEach
    void setUp() {
        slfi = new SmallestFreeIndex();
    }

    @Test
    @DisplayName(value = "Should be 2")
    void getIndex1() {
        int[] tab = {5,3,1};
        assertThat(slfi.getIndex(tab)).isEqualTo(2);
    }
    @Test
    void getIndex2() {
        int[] tab = {-5,-3,-1,0};
        assertThat(slfi.getIndex(tab)).isEqualTo(1);
    }
    @Test
    void getIndex3() {
        int[] tab = {5,3,1,1,-3,0,-5};
        assertThat(slfi.getIndex(tab)).isEqualTo(2);
    }
    @Test
    void getIndex4() {
        int[] tab = {};
        assertThat(slfi.getIndex(tab)).isEqualTo(1);
    }
    @Test
    void getIndex5() {
        int[] tab = {3,2,1,1,0,4,5,-3};
        assertThat(slfi.getIndex(tab)).isEqualTo(6);
    }





}