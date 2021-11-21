package DataStructure.SparseArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class sparseArray {
    public static void main(String[] args) throws IOException {
        //创建二维数组
        int [][] cherssArray = new int[11][11];
        cherssArray[1][2]=1;
        cherssArray[2][3]=2;
        cherssArray[5][6]=4;


        //遍历二维数组
        for (int [] a:cherssArray){
            for (int i :a){
                System.out.printf("%d\t",i);
            }
            System.out.println();

        }

        //遍历二维数组中非零个数
        int sum = 0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(cherssArray[i][j]!=0){
                    sum++;
                }
            }
        }
//        System.out.println(sum);

        //创建sparseArray数组
        int [][] sparseArray = new int[sum+1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=3;

        int count = 0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(cherssArray[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=cherssArray[i][j];
                }
            }
        }
//        FileOutputStream fos = new FileOutputStream("F:\\Java_Learning\\Java_Code\\IDEA_Code\\src\\Algorithm\\SparseArray\\1.txt");
//
//        for(int i =0;i<sparseArray.length;i++){
//            for (int j=0;j<sparseArray[0].length;j++){
//                fos.write(sparseArray[i][j]);
////                fos.write("\r\n".getBytes());
////                System.out.print(sparseArray[i][j]);
//            }
////            fos.write("\n".getBytes());
//        }
//        fos.close();
//
//        FileInputStream fis = new FileInputStream("F:\\Java_Learning\\Java_Code\\IDEA_Code\\src\\Algorithm\\SparseArray\\1.txt");
//        int bys;
//        while((bys=fis.read())!=-1){
//            System.out.print(bys);
//        }
//        fis.close();
        //稀疏数组写入文件
        saveArray(sparseArray);



        //遍历sparseArray
        System.out.println("---------稀疏数组---------");
        System.out.println(sparseArray.length);
        for(int i =0;i<sparseArray.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }


        //读取稀疏数组

        //稀疏数组恢复
        System.out.println("--------恢复后的数组-----------");
        int [][]cherssArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i=1;i<sparseArray.length;i++){
            cherssArr2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }

        for (int [] a:cherssArr2){
            for (int i :a){
                System.out.printf("%d\t",i);
            }
            System.out.println();

        }
    }

    public static void saveArray(int[][] array){
        //1.创建字符输出流
        FileWriter writeFile = null;
        try {
            //2.数据想写入的路径及文件
            File file = new File("F:\\Java_Learning\\Java_Code\\IDEA_Code\\src\\Heima\\Test\\IO\\Array.txt");
            //3.如果该文件不存在，就创建
            if(!file.exists()) {
                file.createNewFile();
            }
            //4.给字节输出流赋予实例
            writeFile = new FileWriter(file);
            //5.通过循环将数组写入txt文件中
            for(int i = 0; i < array.length; i++) {
                //6.数据前n - 1列尾部加入","
                for(int j = 0; j < array[0].length - 1; j++) {
                    writeFile.write(array[i][j] + ",");
                }
                //7.数组最后一列后面不加","
                writeFile.write(array[i][array[0].length - 1] + "");
                //8.加上换行符
                writeFile.write("\n");
            }
            //9.把writeFile里的数据全部刷新一次，全部写入文件中
            writeFile.flush();
        } catch (Exception e) {//10.异常捕获
            e.printStackTrace();
        } finally {
            try {
                //11.如果writeFile不为空，就将其关闭
                if(writeFile != null)
                    writeFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int[][] readArray() {
        //1.声明一个字符输入流
        FileReader reader = null;
        //2.声明一个字符输入缓冲流
        BufferedReader readerBuf = null;
        //3.声明一个二维数组
        int[][] array = null;
        try {
            //4.指定reader的读取路径
            reader = new FileReader("F:\\Java_Learning\\Java_Code\\IDEA_Code\\src\\Heima\\Test\\IO\\Array.txt");
            //5.通过BufferedReader包装字符输入流
            readerBuf = new BufferedReader(reader);
            //6.创建一个集合，用来存放读取的文件的数据
            List<String> strList = new ArrayList<>();
            //7.用来存放一行的数据
            String lineStr;
            //8.逐行读取txt文件中的内容
            while((lineStr = readerBuf.readLine()) != null) {
                //9.把读取的行添加到list中
                strList.add(lineStr);
            }
            //10.获取文件有多少行
            int lineNum = strList.size();
            //11.获取数组有多少列
            String s =  strList.get(0);
            int columnNum = s.split("\\,").length;
            //12.根据文件行数创建对应的数组
            array = new int[strList.size()][columnNum];
            //13.记录输出当前行
            int count = 0;
            //14.循环遍历集合，将集合中的数据放入数组中
            for(String str : strList) {
                //15.将读取的str按照","分割，用字符串数组来接收
                String[] strs = str.split("\\,");
                for(int i = 0; i < columnNum; i++) {
                    array[count][i] = Integer.valueOf(strs[i]);
                }
                //16.将行数 + 1
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //17.关闭字符输入流
            try {
                if(reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //18.关闭字符输入缓冲流
            try {
                if(readerBuf != null)
                    readerBuf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //19.返回稀疏数组
        return array;
    }

}
