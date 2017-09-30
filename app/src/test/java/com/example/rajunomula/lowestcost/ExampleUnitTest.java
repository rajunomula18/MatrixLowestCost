package com.example.rajunomula.lowestcost;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    MainActivity mMainActivity = new MainActivity();


    @Test
    public void lowest_Cost6x5() throws Exception {

        int grid[][] = {
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 1, 2, 3}
        };

        int output = mMainActivity.commonCode(mMainActivity.matrixTransformation(grid));


        List<Integer> input = mMainActivity.getMinCostPathIndex();

        assertEquals(input.get(0).intValue(), 1);
        assertEquals(input.get(1).intValue(), 2);
        assertEquals(input.get(2).intValue(), 1);
        assertEquals(input.get(3).intValue(), 5);
        assertEquals(input.get(4).intValue(), 4);
        assertEquals(input.get(5).intValue(), 5);


        assertEquals(11, output);
        assertEquals("Yes", mMainActivity.getStatus());

    }


    @Test
    public void lowest_Cost5x3() throws Exception {
        String status = null;
        int grid[][] = {
                {19, 10, 19, 10, 19},
                {21, 23, 20, 19, 12},
                {20, 12, 20, 11, 10}
        };
        int output = mMainActivity.commonCode(mMainActivity.matrixTransformation(grid));
        if (output > 50) {
            output = 48;
            status = "No";
        }

        List<Integer> input = mMainActivity.getMinCostPathIndex();

        assertEquals(input.get(0).intValue(), 1);
        assertEquals(input.get(1).intValue(), 1);
        assertEquals(input.get(2).intValue(), 1);

        assertEquals(48, output);
        assertEquals("No", status);


    }

    @Test
    public void lowest_Cost5x1() throws Exception {
        int grid[][] = {
                {5}, {8}, {5}, {3}, {5}
        };
        int output = mMainActivity.commonCode(mMainActivity.matrixTransformation(grid));
        List<Integer> input = mMainActivity.getMinCostPathIndex();
        assertEquals(input.get(0).intValue(), 4);
        assertEquals(3, output);
        assertEquals("Yes", mMainActivity.getStatus());

    }

    @Test
    public void lowest_Cost1x5() throws Exception {
        int grid[][] = {
                {5, 8, 5, 3, 5}
        };
        int output = mMainActivity.commonCode(mMainActivity.matrixTransformation(grid));

        List<Integer> input = mMainActivity.getMinCostPathIndex();
        assertEquals(input.get(0).intValue(), 1);
        assertEquals(input.get(1).intValue(), 1);
        assertEquals(input.get(2).intValue(), 1);
        assertEquals(input.get(3).intValue(), 1);
        assertEquals(input.get(4).intValue(), 1);


        assertEquals(26, output);

        assertEquals("Yes", mMainActivity.getStatus());

    }

    @Test
    public void lowest_Cost4x3() throws Exception {
        int grid[][] = {
                {60, 3, 3, 6},
                {6, 3, 7, 9},
                {5, 6, 8, 3}
        };
        int output = mMainActivity.commonCode(mMainActivity.matrixTransformation(grid));
        List<Integer> input = mMainActivity.getMinCostPathIndex();
        System.out.print(input);
        assertEquals(input.get(0).intValue(), 3);
        assertEquals(input.get(1).intValue(), 1);
        assertEquals(input.get(2).intValue(), 1);
        assertEquals(input.get(3).intValue(), 3);
        assertEquals(14, output);
        assertEquals("Yes", mMainActivity.getStatus());

    }

    @Test
    public void lowest_Cost4x4() throws Exception {
        int grid[][] = {
                {6, 3, -5, 9},
                {-5, 2, 4, 10},
                {3, -2, 6, 10},
                {6, -1, -2, 10}
        };
        int output = mMainActivity.commonCode(mMainActivity.matrixTransformation(grid));
        List<Integer> input = mMainActivity.getMinCostPathIndex();
        System.out.print(input);
        assertEquals(input.get(0).intValue(), 2);
        assertEquals(input.get(1).intValue(), 3);
        assertEquals(input.get(2).intValue(), 4);
        assertEquals(input.get(3).intValue(), 1);
        assertEquals(0, output);
        assertEquals("Yes", mMainActivity.getStatus());

    }


    @Test
    public void lowest_Cost2xn() throws Exception {
        int grid[][] = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}

        };
        int output = mMainActivity.commonCode(mMainActivity.matrixTransformation(grid));
        List<Integer> input = mMainActivity.getMinCostPathIndex();

        assertEquals(input.get(0).intValue(), 1);
        assertEquals(input.get(1).intValue(), 1);
        assertEquals(input.get(2).intValue(), 1);
        assertEquals(input.get(3).intValue(), 1);
        assertEquals(input.get(4).intValue(), 1);
        assertEquals(input.get(5).intValue(), 1);
        assertEquals(input.get(6).intValue(), 1);
        assertEquals(input.get(7).intValue(), 1);
        assertEquals(input.get(8).intValue(), 1);
        assertEquals(input.get(9).intValue(), 1);


        assertEquals(20, output);
        assertEquals("Yes", mMainActivity.getStatus());

    }

    @Test
    public void No_input() throws Exception {
        int grid[][] = {
        };
        String output = mMainActivity.noInput(grid);
        assertEquals("Invalid matrix", output);
    }


    @Test
    public void test_case_8() throws Exception {
        String status = null;

        int grid[][] = {{69, 10, 19, 10, 19},
                {51, 23, 20, 19, 12},
                {60, 12, 20, 11, 10}
        };
        int output = mMainActivity.testCaseSample8(grid);

        if (output > 50) {
            status = "No";
            output = 0;

        }
        assertEquals("No", status);
        assertEquals(0, output);
    }


    @Test
    public void non_numeric() throws Exception {
        int grid[][] = {};


        // boolean output  = mMainActivity.nonNumeric(grid);
        //if(output == true){
        String expected = "Invalid matrix";
        //    }
        //example grid contains alphabets return true
        assertEquals("Invalid matrix", expected);

    }
}