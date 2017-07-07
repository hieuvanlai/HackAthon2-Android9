package tabian.com.actionbartest.databases;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hieuv on 7/3/2017.
 */

public class DatabaseHandle {
    private MyDatabase myDatabase;
    public DatabaseHandle(Context context){
        myDatabase = new MyDatabase(context);
    }
    private static DatabaseHandle instance;
    public static DatabaseHandle getInstance(Activity context){
        if(instance==null){
            instance = new DatabaseHandle(context);

        }
        return instance;

    }
    private SQLiteDatabase cpuDatabase;
    public List<CpuModel> getListCpuModels(int i){
        cpuDatabase = myDatabase.getReadableDatabase();
        List<CpuModel> cpuModelList= new ArrayList<>();
        Cursor cursor =null;
        if (i==0 || i==3){
            cursor = cpuDatabase.rawQuery("select C.species,C.description ,C.price,C.images,C.socket  from Cpu C Where C.species like '%Core i%' or  C.species like '%Ryzen 5%'",null);

        }else {
            cursor = cpuDatabase.rawQuery("select C.species,C.description ,C.price,C.images,C.socket  from Cpu C Where C.species like '%Xeon%' or  C.species like '%Ryzen 7%'",null);
        }
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String species =cursor.getString(0);
            String description=cursor.getString(1);
            Integer price=cursor.getInt(2);
            String image=cursor.getString(3);
            String socket=cursor.getString(4);
            CpuModel cpuModel = new CpuModel(species,description,price,image,socket);
            cpuModelList.add(cpuModel);
            cursor.moveToNext();
        }
        return cpuModelList;

    }
    private SQLiteDatabase mainDatabase;
    public List<MainModel> getListMainModels(String socketx,String color){
        mainDatabase = myDatabase.getReadableDatabase();
        List<MainModel> mainModelList = new ArrayList<>();
        Cursor cursor =null;
        cursor = mainDatabase.rawQuery("select M.species,M.description,M.price,M.images,M.socket,M.ram_support,M.size  from Main M Where M.socket like '%"+socketx+"%' and (M.color like '%RGB%'or M.color like '%"+color+"%'or M.color like '%BLACK%')",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String species =cursor.getString(0);
            String description=cursor.getString(1);
            Integer price=cursor.getInt(2);
            String image=cursor.getString(3);
            String socket = cursor.getString(4);
            String ramsupport = cursor.getString(5);
            String size = cursor.getString(6);

            MainModel mainModel = new MainModel(species,description,price,image,socket,ramsupport,size);
            mainModelList.add(mainModel);
            cursor.moveToNext();
        }
        return mainModelList;
    }

    private SQLiteDatabase productDatabase;

    public List<ProductModel> getListProductModels( String table, String color, String ramofsize){
        productDatabase = myDatabase.getReadableDatabase();
        List<ProductModel> productModelList = new ArrayList<>();
        Cursor cursor =null;
        if (table.equals("Vga")){
            cursor = productDatabase.rawQuery("select M.species,M.description,M.price,M.images from Vga M Where (M.color like '%"+color+"%' or M.color like '%RGB%'or M.color like '%BLACK%')",null);
        }
        if (table.equals("Ram")){
            cursor = productDatabase.rawQuery("select M.species,M.description,M.price,M.images  from Ram M Where M.type_ram like'%"+ramofsize+"%' and  (M.color like '%"+color+"%' or M.color like '%RGB%'or M.color like '%BLACK%')",null);
        }
        if (table.equals("Psu")){
            cursor = productDatabase.rawQuery("select M.species,M.descrition,M.price,M.images from Psu M",null);
        }
        if (table.equals("Ssd_Hdd")){
            cursor = productDatabase.rawQuery("select M.species,M.description,M.price,M.image from SSD_HDD M",null);
        }
        if (table.equals("Case")){
            if (ramofsize.equals("")||ramofsize.equals("ITX")){
                cursor = productDatabase.rawQuery("select M.species,M.description,M.price,M.images from Cas M Where  (M.color like '%"+color+"%' or M.color like '%RGB%'or M.color like '%BLACK%')",null);
            }
            if (ramofsize.equals("ATX")){
                cursor = productDatabase.rawQuery("select M.species,M.description,M.price,M.images from Cas M Where M.size='ATX' and (M.color like '%"+color+"%' or M.color like '%RGB%'or M.color like '%BLACK%')",null);
            }
            if (ramofsize.equals("M-ATX")){
                cursor = productDatabase.rawQuery("select M.species,M.description,M.price,M.images from Cas M Where (M.size='ATX' or M.size='M-ATX' ) and (M.color like '%"+color+"%' or M.color like '%RGB%'or M.color like '%BLACK%')",null);
            }

        }
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String species =cursor.getString(0);
            String description=cursor.getString(1);
            Integer price=cursor.getInt(2);
            String image=cursor.getString(3);
            ProductModel mainModel = new ProductModel(species,description,price,image);
            productModelList.add(mainModel);
            cursor.moveToNext();
        }
        return productModelList;
    }
}
