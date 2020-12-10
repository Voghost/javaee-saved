package com.example.demo.Model.function;

import com.example.demo.Model.Database.DatabaseDepartment;
import com.example.demo.Model.Database.DatabaseFolder;
import com.example.demo.Model.Database.DatabaseStaff;
import com.example.demo.Model.Database.DatabaseStaffDepartment;
import com.example.demo.Model.Entity.Department;
import com.example.demo.Model.Entity.Folder;
import com.example.demo.Model.Entity.Staff;
import com.example.demo.Model.Entity.StaffDepartment;

import java.util.ArrayList;

/**
 * Created by Edgar Liu
 */
public class FolderProcess {
    Folder folder;

    public FolderProcess() {
    }

    public FolderProcess(Folder folder) {
        this.folder = folder;
    }


    //得到所有的folder
    public ArrayList<Folder> getAllFolder(){
        DatabaseFolder databaseFolder=new DatabaseFolder();
        return databaseFolder.searchFolder(new Folder(null,null,null));
    }

    //插入一条folder数据
    public int newFolder(Folder folder){
        DatabaseFolder databaseFolder=new DatabaseFolder();
        databaseFolder.insertFolder(folder);
        return 1;
    }

    //删除folder数据
    public int deleteFolder(Folder folder){
        DatabaseFolder databaseFolder=new DatabaseFolder();

        databaseFolder.deleteFolder(folder);

        return 1;
    }
}
