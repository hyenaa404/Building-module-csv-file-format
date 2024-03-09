
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class DataList {
    List<Data> dataList = new ArrayList<>();

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
    
    public void readFile(String filePath) {
        try {
            File file = new File(filePath);
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                String line = bufferedReader.readLine();
                
                while (line != null) {
                    String[] parts = line.split(",");
                    int id;
                    try{
                    id = Integer.parseInt(parts[0].trim());
                    } catch (NumberFormatException e){
                        id = 0;
                    }
                    String name = parts[1];
                    String mail = parts[2];
                    String phone = parts[3];
                    String address = parts[4];
                    Data data = new Data(id, name, mail, phone, address);
                    dataList.add(data);
                    line = bufferedReader.readLine();

                }
            } catch (FileNotFoundException ex) {
                System.err.println("File not found.");
            } finally {

                bufferedReader.close();
                fileReader.close();
            }
        } catch (IOException e) {
            System.err.println("Failed when reading file.");
        }
       
    }
     public void writeFile(String filePath) {
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Data data: dataList) {
                
                String line =  data.getId() + ", " + data.getName() + ", " + data.getMail() + ", " + data.getPhone() + ", " + data.getAddress();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Error when reading file!");
        }
        System.out.println("Saved successfully!");
    }
}
