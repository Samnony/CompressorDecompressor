/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Shivam
 */
public class decompressor {
    public static void method(File file)throws IOException{
        String fileDirectory = file.getParent();
        String fileName = file.getName();
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/" + fileName.substring(0, fileName.length() - 20) + " (decompressed)" + fileName.substring(fileName.length() - 20, fileName.length() - 16));
        byte[] buffer = new byte[1024];
        int len;
        while((len=gzip.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        gzip.close();
        fos.close();
        fis.close();
        
    }
    public static void main(String[] args) throws IOException{
//        File path = new File("");
//        method(path);
        
    }
}

//public static void method(File file) throws IOException{
//        String fileDirectory = file.getParent();
//        FileInputStream fis = new FileInputStream(file);
//        FileOutputStream fos = new FileOutputStream(fileDirectory+"/CompressedFile.gz");
//        GZIPOutputStream gzip = new GZIPOutputStream(fos);
//        byte[] buffer = new byte[1024];
//        int len;
//        while((len=fis.read(buffer))!=-1){
//            gzip.write(buffer,0,len);
//        }
//        gzip.close();
//        fos.close();
//        fis.close();
//    }
//    public static void main(String[] args) throws IOException{
//        File path = new File("");
//        method(path);
//    }
