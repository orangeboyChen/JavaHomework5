package com.nowcent;

import com.alibaba.fastjson.JSON;
import com.nowcent.pojo.AccountRecord;
import com.nowcent.pojo.TransactionRecord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * @author orangeboy
 * @version 1.0`
 * @date 2020/11/21 18:04
 */
public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        final String PATH_PREFIX = "src/main/resources/";

        //a
        Scanner inOldMaster = new Scanner(new FileInputStream(PATH_PREFIX + "oldmast.txt"));

        //b
        Scanner inTransaction = new Scanner(new FileInputStream(PATH_PREFIX + "trans.txt"));

        //c
        Formatter outNewFormatter = new Formatter(PATH_PREFIX + "outNewMaster.txt");

        //d
        //初始化StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        while(inOldMaster.hasNextLine()){
            stringBuilder.append("\n").append(inOldMaster.nextLine());
        }
        AccountRecord accountRecord = JSON.parseObject(stringBuilder.toString(), AccountRecord.class);

        //e
        //这里不知道题目想表达什么意思
        stringBuilder = new StringBuilder();
        while(inTransaction.hasNextLine()){
            stringBuilder.append("\n").append(inTransaction.nextLine());
        }
        TransactionRecord transactionRecord = JSON.parseObject(stringBuilder.toString(), TransactionRecord.class);

        //f
        outNewFormatter.format("%d %s %s %.2f\n", accountRecord.getAccount(), accountRecord.getFirstName(), accountRecord.getLastName(), accountRecord.getBalance());
        outNewFormatter.close();
    }
}


