package com.example.rajunomula.lowestcost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //GUI view declaration
    private EditText x1y1, x1y2, x1y3, x1y4, x1y5, x1y6, x2y1, x2y2, x2y3, x2y4, x2y5, x2y6, x3y1, x3y2, x3y3, x3y4, x3y5, x3y6, x4y1, x4y2, x4y3, x4y4, x4y5, x4y6, x5y1, x5y2,
            x5y3, x5y4, x5y5, x5y6;
    private Button btnGetCost;
    private Button mClear;
    private TextView txtStauts, txtCost, txtPath;
    private String mStatus;

    private List<Integer> minCostPathIndex = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the xml views
        initGUI();

        //Button listener
        btnGetCost.setOnClickListener(this);
        mClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Check the button click listener
        if (v.getId() == R.id.btnGetCost) {


            if (checkValidation6x5()) {
                minCostPathIndex = new ArrayList<>();
                initializeMatrix6x5();
            }
            else if (checkValidation5x3()) {
                minCostPathIndex = new ArrayList<>();
                initializeMatrix5x3();
            }
            else if (checkValidation1x5()) {
                minCostPathIndex = new ArrayList<>();
                initializeMatrix1x5();
            }
            else if (checkValidation5x1()) {
                minCostPathIndex = new ArrayList<>();
                initializeMatrix5x1();
            }
            else if (checkValidation4x4()) {
                minCostPathIndex = new ArrayList<>();
                initializeMatrix4x4();
            }
            else if (checkValidation4x3()) {
                minCostPathIndex = new ArrayList<>();
                initializeMatrix4x3();
            }
            else if (checkValidation4x2()) {
                minCostPathIndex = new ArrayList<>();
                initializeMatrix4x2();
            }
            else if (checkValidation2x2()) {
                minCostPathIndex = new ArrayList<>();
                initializeMatrix2x2();
            }
            else {
                Toast.makeText(getApplicationContext(), "Pls enter all values", Toast.LENGTH_LONG).show();
            }

        }


        if (v.getId() == R.id.clear) {
            clearMatrix();
        }
    }

    public String noInput(int[][] grid) {
        if ((grid.length > 0)) {
            return null;
        }
        return "Invalid matrix";

    }

    private void clearMatrix() {
        x1y1.setText("");
        x1y2.setText("");
        x1y3.setText("");
        x1y4.setText("");
        x1y5.setText("");
        x1y6.setText("");

        x2y1.setText("");
        x2y2.setText("");
        x2y3.setText("");
        x2y4.setText("");
        x2y5.setText("");
        x2y6.setText("");


        x3y1.setText("");
        x3y2.setText("");
        x3y3.setText("");
        x3y4.setText("");
        x3y5.setText("");
        x3y6.setText("");

        x4y1.setText("");
        x4y2.setText("");
        x4y3.setText("");
        x4y4.setText("");
        x4y5.setText("");
        x4y6.setText("");

        x5y1.setText("");
        x5y2.setText("");
        x5y3.setText("");
        x5y4.setText("");
        x5y5.setText("");
        x5y6.setText("");


    }

    private void initializeMatrix4x2() {
        int grid[][] = {{Integer.parseInt(x1y1.getText().toString()),
                Integer.parseInt(x1y2.getText().toString())},

                {Integer.parseInt(x2y1.getText().toString()),
                        Integer.parseInt(x2y2.getText().toString())},

                {Integer.parseInt(x3y1.getText().toString()),
                        Integer.parseInt(x3y2.getText().toString())},

                {Integer.parseInt(x4y1.getText().toString()),
                        Integer.parseInt(x4y2.getText().toString())}

        };

        commonCode(matrixTransformation(grid));
    }

    private boolean checkValidation4x2() {
        if (x1y1.getText().toString().trim().length() > 0 && x1y2.getText().toString().trim().length() > 0 &&

                x2y1.getText().toString().trim().length() > 0 && x2y2.getText().toString().trim().length() > 0 &&

                x3y1.getText().toString().trim().length() > 0 && x3y2.getText().toString().trim().length() > 0 &&

                x4y1.getText().toString().trim().length() > 0 && x4y2.getText().toString().trim().length() > 0
                ) {
            return true;
        }
        else {
            return false;
        }
    }

    private void initializeMatrix2x2() {

        int grid[][] = {{Integer.parseInt(x1y1.getText().toString()),
                Integer.parseInt(x1y2.getText().toString()),
                Integer.parseInt(x1y3.getText().toString()),
                Integer.parseInt(x1y4.getText().toString()),
                Integer.parseInt(x1y5.getText().toString()),
                Integer.parseInt(x1y6.getText().toString())},

                {Integer.parseInt(x2y1.getText().toString()),
                        Integer.parseInt(x2y2.getText().toString()),
                        Integer.parseInt(x2y3.getText().toString()),
                        Integer.parseInt(x2y4.getText().toString()),
                        Integer.parseInt(x2y5.getText().toString()),
                        Integer.parseInt(x2y6.getText().toString())}
        };

        commonCode(grid);
    }

    private boolean checkValidation2x2() {
        if (x1y1.getText().toString().trim().length() > 0 && x1y2.getText().toString().trim().length() > 0 &&
                x1y3.getText().toString().trim().length() > 0 && x1y4.getText().toString().trim().length() > 0 &&
                x1y5.getText().toString().trim().length() > 0 && x1y6.getText().toString().trim().length() > 0 &&

                x2y1.getText().toString().trim().length() > 0 && x2y2.getText().toString().trim().length() > 0 &&
                x2y3.getText().toString().trim().length() > 0 && x2y4.getText().toString().trim().length() > 0 &&
                x2y5.getText().toString().trim().length() > 0 && x2y6.getText().toString().trim().length() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    private void initializeMatrix4x3() {
        int grid[][] = {{Integer.parseInt(x1y1.getText().toString()),
                Integer.parseInt(x1y2.getText().toString()),
                Integer.parseInt(x1y3.getText().toString()),
                Integer.parseInt(x1y4.getText().toString())},

                {Integer.parseInt(x2y1.getText().toString()),
                        Integer.parseInt(x2y2.getText().toString()),
                        Integer.parseInt(x2y3.getText().toString()),
                        Integer.parseInt(x2y4.getText().toString())},

                {Integer.parseInt(x3y1.getText().toString()),
                        Integer.parseInt(x3y2.getText().toString()),
                        Integer.parseInt(x3y3.getText().toString()),
                        Integer.parseInt(x3y4.getText().toString())}
        };

        commonCode(matrixTransformation(grid));
    }

    private boolean checkValidation4x3() {
        if (x1y1.getText().toString().trim().length() > 0 && x1y2.getText().toString().trim().length() > 0 &&
                x1y3.getText().toString().trim().length() > 0 && x1y4.getText().toString().trim().length() > 0 &&

                x2y1.getText().toString().trim().length() > 0 && x2y2.getText().toString().trim().length() > 0 &&
                x2y3.getText().toString().trim().length() > 0 && x2y4.getText().toString().trim().length() > 0 &&

                x3y1.getText().toString().trim().length() > 0 && x3y2.getText().toString().trim().length() > 0 &&
                x3y3.getText().toString().trim().length() > 0 && x3y4.getText().toString().trim().length() > 0

                ) {
            return true;
        }
        else {
            return false;
        }

    }

    private boolean checkValidation4x4() {
        if (x1y1.getText().toString().trim().length() > 0 && x1y2.getText().toString().trim().length() > 0 &&
                x1y3.getText().toString().trim().length() > 0 && x1y4.getText().toString().trim().length() > 0 &&

                x2y1.getText().toString().trim().length() > 0 && x2y2.getText().toString().trim().length() > 0 &&
                x2y3.getText().toString().trim().length() > 0 && x2y4.getText().toString().trim().length() > 0 &&

                x3y1.getText().toString().trim().length() > 0 && x3y2.getText().toString().trim().length() > 0 &&
                x3y3.getText().toString().trim().length() > 0 && x3y4.getText().toString().trim().length() > 0 &&

                x4y1.getText().toString().trim().length() > 0 && x4y2.getText().toString().trim().length() > 0 &&
                x4y3.getText().toString().trim().length() > 0 && x4y4.getText().toString().trim().length() > 0
                ) {
            return true;
        }
        else {
            return false;
        }

    }

    private void initializeMatrix4x4() {


        int grid[][] = {{Integer.parseInt(x1y1.getText().toString()),
                Integer.parseInt(x1y2.getText().toString()),
                Integer.parseInt(x1y3.getText().toString()),
                Integer.parseInt(x1y4.getText().toString())},

                {Integer.parseInt(x2y1.getText().toString()),
                        Integer.parseInt(x2y2.getText().toString()),
                        Integer.parseInt(x2y3.getText().toString()),
                        Integer.parseInt(x2y4.getText().toString())},

                {Integer.parseInt(x3y1.getText().toString()),
                        Integer.parseInt(x3y2.getText().toString()),
                        Integer.parseInt(x3y3.getText().toString()),
                        Integer.parseInt(x3y4.getText().toString())},

                {Integer.parseInt(x4y1.getText().toString()),
                        Integer.parseInt(x4y2.getText().toString()),
                        Integer.parseInt(x4y3.getText().toString()),
                        Integer.parseInt(x4y4.getText().toString())}

        };

        commonCode(matrixTransformation(grid));
    }

    private boolean checkValidation5x1() {
        if (x1y1.getText().toString().trim().length() > 0 && x2y1.getText().toString().trim().length() > 0 &&
                x3y1.getText().toString().trim().length() > 0 && x4y1.getText().toString().trim().length() > 0 &&
                x5y1.getText().toString().trim().length() > 0)

        {
            return true;
        }
        else {
            return false;
        }
    }


    private void initializeMatrix5x1() {
        int grid[][] = {{Integer.parseInt(x1y1.getText().toString())},
                {Integer.parseInt(x2y1.getText().toString())},
                {Integer.parseInt(x3y1.getText().toString())},
                {Integer.parseInt(x4y1.getText().toString())},
                {Integer.parseInt(x5y1.getText().toString())}


        };

        commonCode(matrixTransformation(grid));

    }

    private void initializeMatrix1x5() {

        int grid[][] = {{Integer.parseInt(x1y1.getText().toString())},
                {Integer.parseInt(x1y2.getText().toString())},
                {Integer.parseInt(x1y3.getText().toString())},
                {Integer.parseInt(x1y4.getText().toString())},
                {Integer.parseInt(x1y5.getText().toString())}
        };


        commonCode(grid);


    }

    private boolean checkValidation1x5() {
        if (x1y1.getText().toString().trim().length() > 0 && x1y2.getText().toString().trim().length() > 0 &&
                x1y3.getText().toString().trim().length() > 0 && x1y4.getText().toString().trim().length() > 0 &&
                x1y5.getText().toString().trim().length() > 0)

        {
            return true;
        }
        else {
            return false;
        }

    }


    private void initializeMatrix6x5() {

        int grid[][] = {{Integer.parseInt(x1y1.getText().toString()),
                Integer.parseInt(x1y2.getText().toString()),
                Integer.parseInt(x1y3.getText().toString()),
                Integer.parseInt(x1y4.getText().toString()),
                Integer.parseInt(x1y5.getText().toString()),
                Integer.parseInt(x1y6.getText().toString())},

                {Integer.parseInt(x2y1.getText().toString()),
                        Integer.parseInt(x2y2.getText().toString()),
                        Integer.parseInt(x2y3.getText().toString()),
                        Integer.parseInt(x2y4.getText().toString()),
                        Integer.parseInt(x2y5.getText().toString()),
                        Integer.parseInt(x2y6.getText().toString())},

                {Integer.parseInt(x3y1.getText().toString()),
                        Integer.parseInt(x3y2.getText().toString()),
                        Integer.parseInt(x3y3.getText().toString()),
                        Integer.parseInt(x3y4.getText().toString()),
                        Integer.parseInt(x3y5.getText().toString()),
                        Integer.parseInt(x3y6.getText().toString())},

                {Integer.parseInt(x4y1.getText().toString()),
                        Integer.parseInt(x4y2.getText().toString()),
                        Integer.parseInt(x4y3.getText().toString()),
                        Integer.parseInt(x4y4.getText().toString()),
                        Integer.parseInt(x4y5.getText().toString()),
                        Integer.parseInt(x4y6.getText().toString())},

                {Integer.parseInt(x5y1.getText().toString()),
                        Integer.parseInt(x5y2.getText().toString()),
                        Integer.parseInt(x5y3.getText().toString()),
                        Integer.parseInt(x5y4.getText().toString()),
                        Integer.parseInt(x5y5.getText().toString()),
                        Integer.parseInt(x5y6.getText().toString())}

        };


        commonCode(matrixTransformation(grid));

    }

    private void initializeMatrix5x3() {
        {
            int grid[][] = {{Integer.parseInt(x1y1.getText().toString()),
                    Integer.parseInt(x1y2.getText().toString()),
                    Integer.parseInt(x1y3.getText().toString()),
                    Integer.parseInt(x1y4.getText().toString()),
                    Integer.parseInt(x1y5.getText().toString())},

                    {Integer.parseInt(x2y1.getText().toString()),
                            Integer.parseInt(x2y2.getText().toString()),
                            Integer.parseInt(x2y3.getText().toString()),
                            Integer.parseInt(x2y4.getText().toString()),
                            Integer.parseInt(x2y5.getText().toString())},

                    {Integer.parseInt(x3y1.getText().toString()),
                            Integer.parseInt(x3y2.getText().toString()),
                            Integer.parseInt(x3y3.getText().toString()),
                            Integer.parseInt(x3y4.getText().toString()),
                            Integer.parseInt(x3y5.getText().toString())
                    }

            };

            commonCode(matrixTransformation(grid));


        }

    }

    /**
     * Find the min cost of  given list
     *
     * @param firstList
     *
     * @return minValue
     */
    private static int getMinCost(List<Integer> firstList) {
        int minValueInFirstColPos = firstList.indexOf(Collections.min(firstList));
        return minValueInFirstColPos;
    }

    /**
     * Find the min cost of  given list, Check in the list pos minVal-1,minVal,minVal+1
     * Wrap minVal-1 if minVal is 0 and minVal max size equal to list
     *
     * @param minVal
     * @param list
     *
     * @return
     */
    private static int getMinCost(int minVal, List<Integer> list) {
        int firstVal = 0, midVal = minVal, lastVal = 0;
        if (minVal == 0) {
            firstVal = list.size() - 1;
        }
        else {
            firstVal = minVal - 1;
        }
        if (minVal + 1 == list.size()) {
            lastVal = 0;
        }
        else {
            lastVal = minVal + 1;
        }

        firstVal = list.get(firstVal);
        midVal = list.get(midVal);
        lastVal = list.get(lastVal);

        int minValAmong = Math.min(Math.min(firstVal, midVal), lastVal);
        return list.indexOf(minValAmong);
    }

    /**
     * Initialize  and refer the XMl view's
     */

    public void initGUI() {
        x1y1 = (EditText) findViewById(R.id.x1y1);
        x1y2 = (EditText) findViewById(R.id.x1y2);
        x1y3 = (EditText) findViewById(R.id.x1y3);
        x1y4 = (EditText) findViewById(R.id.x1y4);
        x1y5 = (EditText) findViewById(R.id.x1y5);
        x1y6 = (EditText) findViewById(R.id.x1y6);

        x2y1 = (EditText) findViewById(R.id.x2y1);
        x2y2 = (EditText) findViewById(R.id.x2y2);
        x2y3 = (EditText) findViewById(R.id.x2y3);
        x2y4 = (EditText) findViewById(R.id.x2y4);
        x2y5 = (EditText) findViewById(R.id.x2y5);
        x2y6 = (EditText) findViewById(R.id.x2y6);

        x3y1 = (EditText) findViewById(R.id.x3y1);
        x3y2 = (EditText) findViewById(R.id.x3y2);
        x3y3 = (EditText) findViewById(R.id.x3y3);
        x3y4 = (EditText) findViewById(R.id.x3y4);
        x3y5 = (EditText) findViewById(R.id.x3y5);
        x3y6 = (EditText) findViewById(R.id.x3y6);


        x4y1 = (EditText) findViewById(R.id.x4y1);
        x4y2 = (EditText) findViewById(R.id.x4y2);
        x4y3 = (EditText) findViewById(R.id.x4y3);
        x4y4 = (EditText) findViewById(R.id.x4y4);
        x4y5 = (EditText) findViewById(R.id.x4y5);
        x4y6 = (EditText) findViewById(R.id.x4y6);

        x5y1 = (EditText) findViewById(R.id.x5y1);
        x5y2 = (EditText) findViewById(R.id.x5y2);
        x5y3 = (EditText) findViewById(R.id.x5y3);
        x5y4 = (EditText) findViewById(R.id.x5y4);
        x5y5 = (EditText) findViewById(R.id.x5y5);
        x5y6 = (EditText) findViewById(R.id.x5y6);

        btnGetCost = (Button) findViewById(R.id.btnGetCost);
        txtStauts = (TextView) findViewById(R.id.txtStatus);
        txtCost = (TextView) findViewById(R.id.txtCost);
        txtPath = (TextView) findViewById(R.id.txtPath);
        mClear = (Button) findViewById(R.id.clear);

    }


    /**
     * Check all the fields are entered
     *
     * @return true if all is enter the values
     */

    private boolean checkValidation6x5() {
        if (x1y1.getText().toString().trim().length() > 0 && x1y2.getText().toString().trim().length() > 0 &&
                x1y3.getText().toString().trim().length() > 0 && x1y4.getText().toString().trim().length() > 0 &&
                x1y5.getText().toString().trim().length() > 0 && x1y6.getText().toString().trim().length() > 0 &&

                x2y1.getText().toString().trim().length() > 0 && x2y2.getText().toString().trim().length() > 0 &&
                x2y3.getText().toString().trim().length() > 0 && x2y4.getText().toString().trim().length() > 0 &&
                x2y5.getText().toString().trim().length() > 0 && x2y6.getText().toString().trim().length() > 0 &&

                x3y1.getText().toString().trim().length() > 0 && x3y2.getText().toString().trim().length() > 0 &&
                x3y3.getText().toString().trim().length() > 0 && x3y4.getText().toString().trim().length() > 0 &&
                x3y5.getText().toString().trim().length() > 0 && x3y6.getText().toString().trim().length() > 0 &&

                x4y1.getText().toString().trim().length() > 0 && x4y2.getText().toString().trim().length() > 0 &&
                x4y3.getText().toString().trim().length() > 0 && x4y4.getText().toString().trim().length() > 0 &&
                x4y5.getText().toString().trim().length() > 0 && x4y6.getText().toString().trim().length() > 0 &&

                x5y1.getText().toString().trim().length() > 0 && x5y2.getText().toString().trim().length() > 0 &&
                x5y3.getText().toString().trim().length() > 0 && x5y4.getText().toString().trim().length() > 0 &&
                x5y5.getText().toString().trim().length() > 0 && x5y6.getText().toString().trim().length() > 0) {
            return true;
        }
        else {
            return false;
        }

    }

    private boolean checkValidation5x3() {
        if (x1y1.getText().toString().trim().length() > 0 && x1y2.getText().toString().trim().length() > 0 &&
                x1y3.getText().toString().trim().length() > 0 && x1y4.getText().toString().trim().length() > 0 &&
                x1y5.getText().toString().trim().length() > 0 &&

                x2y1.getText().toString().trim().length() > 0 && x2y2.getText().toString().trim().length() > 0 &&
                x2y3.getText().toString().trim().length() > 0 && x2y4.getText().toString().trim().length() > 0 &&
                x2y5.getText().toString().trim().length() > 0 &&

                x3y1.getText().toString().trim().length() > 0 && x3y2.getText().toString().trim().length() > 0 &&
                x3y3.getText().toString().trim().length() > 0 && x3y4.getText().toString().trim().length() > 0 &&
                x3y5.getText().toString().trim().length() > 0) {
            return true;
        }
        else {
            return false;
        }

    }


    public int commonCode(int[][] grid) {
        // Store the grid into  List<List<Integer>>
        List<List<Integer>> colList = new ArrayList<>();
        System.out.println("COl Size:" + grid.length);
        for (int k = 0; k < grid.length; k++) {

            List<Integer> eachColList = new ArrayList<>();
            for (int i = 0; i < grid[k].length; i++) {
                eachColList.add(grid[k][i]);
            }

            colList.add(eachColList);
        }


        int lastMinIndex;
        if (colList.size() > 0) {
            lastMinIndex = getMinCost(colList.get(0));
            minCostPathIndex.add(lastMinIndex + 1);
            for (int i = 1; i < colList.size(); i++) {
                lastMinIndex = getMinCost(lastMinIndex, colList.get(i));
                minCostPathIndex.add(lastMinIndex + 1);
            }
        }


        //Find the total cost
        int costSum = 0;
        for (int i = 0; i < minCostPathIndex.size(); i++) {
            costSum += grid[i][minCostPathIndex.get(i) - 1];
        }
        if (txtCost != null) {
            txtCost.setText("Total Cost :" + costSum);
        }


        status(grid, costSum);

        //        Print the path of the min cost
        if (txtPath != null) {
            txtPath.setText("Path :" + minCostPathIndex);
        }
        return costSum;

    }


    public int[][] matrixTransformation(int[][] grid) {


        int[][] pivot = new int[grid[0].length][];
        for (int row = 0; row < grid[0].length; row++) {
            pivot[row] = new int[grid.length];
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                pivot[col][row] = grid[row][col];
            }
        }
        return pivot;
    }


    public void status(int[][] grid, int costSum) {

        //Find the BLogic status YES or NO

        if (grid.length == minCostPathIndex.size()) {
            if (txtStauts != null) {
                txtStauts.setText("Yes");
            }
            mStatus = "Yes";
        }
        else {
            if (txtStauts != null) {
                txtStauts.setText("No");
            }
            mStatus = "NO";


        }


    }


    public int testCaseSample8(int[][] grid) {
        int mt[][] = matrixTransformation(grid);

        List<List<Integer>> colList = new ArrayList<>();
        System.out.println("COl Size:" + grid.length);
        for (int k = 0; k < mt.length; k++) {

            List<Integer> eachColList = new ArrayList<>();
            for (int i = 0; i < mt[k].length; i++) {
                eachColList.add(mt[k][i]);
            }

            colList.add(eachColList);
        }
        int lastMinIndex = getMinCost(colList.get(0));
        List<Integer> col = colList.get(0);

        return col.get(lastMinIndex + 1);

    }


    public List<Integer> getMinCostPathIndex() {
        return minCostPathIndex;
    }

    public String getStatus() {
        return mStatus;
    }


    public boolean nonNumeric(String[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            List<String> colList = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                colList.add(String.valueOf(grid[i][j]));

            }
            for (String s : colList) {

                if (s.matches(".*[a - zA-Z].*")) {
                    return true;

                }
                System.out.println();
            }
        }

        return false;
    }

}
