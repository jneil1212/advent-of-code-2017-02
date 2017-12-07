package com.doof.aoc;

public class AoCChecksum {
    public static void main(String[] args) {

        String spreadsheet = "1136\t1129\t184\t452\t788\t1215\t355\t1109\t224\t1358\t1278\t176\t1302\t186\t128\t1148\n" +
                "242\t53\t252\t62\t40\t55\t265\t283\t38\t157\t259\t226\t322\t48\t324\t299\n" +
                "2330\t448\t268\t2703\t1695\t2010\t3930\t3923\t179\t3607\t217\t3632\t1252\t231\t286\t3689\n" +
                "89\t92\t903\t156\t924\t364\t80\t992\t599\t998\t751\t827\t110\t969\t979\t734\n" +
                "100\t304\t797\t81\t249\t1050\t90\t127\t675\t1038\t154\t715\t79\t1116\t723\t990\n" +
                "1377\t353\t3635\t99\t118\t1030\t3186\t3385\t1921\t2821\t492\t3082\t2295\t139\t125\t2819\n" +
                "3102\t213\t2462\t116\t701\t2985\t265\t165\t248\t680\t3147\t1362\t1026\t1447\t106\t2769\n" +
                "5294\t295\t6266\t3966\t2549\t701\t2581\t6418\t5617\t292\t5835\t209\t2109\t3211\t241\t5753\n" +
                "158\t955\t995\t51\t89\t875\t38\t793\t969\t63\t440\t202\t245\t58\t965\t74\n" +
                "62\t47\t1268\t553\t45\t60\t650\t1247\t1140\t776\t1286\t200\t604\t399\t42\t572\n" +
                "267\t395\t171\t261\t79\t66\t428\t371\t257\t284\t65\t25\t374\t70\t389\t51\n" +
                "3162\t3236\t1598\t4680\t2258\t563\t1389\t3313\t501\t230\t195\t4107\t224\t225\t4242\t4581\n" +
                "807\t918\t51\t1055\t732\t518\t826\t806\t58\t394\t632\t36\t53\t119\t667\t60\n" +
                "839\t253\t1680\t108\t349\t1603\t1724\t172\t140\t167\t181\t38\t1758\t1577\t748\t1011\n" +
                "1165\t1251\t702\t282\t1178\t834\t211\t1298\t382\t1339\t67\t914\t1273\t76\t81\t71\n" +
                "6151\t5857\t4865\t437\t6210\t237\t37\t410\t544\t214\t233\t6532\t2114\t207\t5643\t6852";

        // Convert to a 2d array
        String[] rows = spreadsheet.split("\n");

        int rowNum = 0;
        String[][] matrix = new String[rows.length][];

        // Add rows to 2d array
        for (String row : rows) {
            matrix[rowNum] = row.split("\t");
            rowNum++;
        }

        int checksum = 0;

        // Process through 2d array, find max/min, add the difference to checksum
        for (int r = 0; r < matrix.length; r++) {
            int min = 0;
            int max = 0;

            for (int c = 0; c < matrix[r].length; c++) {
                int num = Integer.parseInt(matrix[r][c]);

                if (c == 0) {
                    min = max = num;
                } else {
                    if (min > num) {
                        min = num;
                    }
                    if (max < num) {
                        max = num;
                    }
                }
            }

            checksum += (max - min);
        }

        System.out.println(checksum);
    }
}
