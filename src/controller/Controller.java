package controller;

import java.io.File;
import java.util.List;
import model.Data;
import model.DataList;
import util.FormatString;
import util.InputUtils;

/**
 *
 * @author nhs
 */
public class Controller {

    File file;
    DataList dtList = new DataList();

    public void importFile() {
        System.out.println("Enter path: ");
        String filePath = InputUtils.inputString();
        file = new File(filePath);
        if (file.exists()) {
            if (file.isFile()) {
                dtList.readFile(filePath);
                System.out.println("Import: Done");
            } else {
                System.out.println("Not a file.");
            }
        } else {
            System.out.println("Invalid file path.");
        }
    }

    public void exportFile() {
        System.out.println("Enter path: ");
        String filePath = InputUtils.inputString();
        if (InputUtils.checkFilePath(filePath)) {
            dtList.writeFile(filePath);
        } else {
            System.out.println("Invalid file path to export. A valid path is end with '.csv'. ");
        }
    }

    public void formatName() {
        List<Data> list = dtList.getDataList();
        if (list.isEmpty()) {
            System.out.println("Data not found! Import file before format. ");
        } else {
            for (Data dt : list) {
                dt.setName(FormatString.formatName(dt.getName()));
            }
            System.out.println("Format: done.");

        }
    }

    public void formatAddress() {
        List<Data> list = dtList.getDataList();
        if (list.isEmpty()) {
            System.out.println("Data not found! Import file before format. ");
        } else {
            for (Data dt : list) {
                dt.setAddress(FormatString.removeRedundantSpace(dt.getAddress()));
            }
            System.out.println("Format: done.");

        }
    }
}
