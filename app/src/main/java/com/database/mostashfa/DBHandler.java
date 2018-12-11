package com.database.mostashfa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MostashfaDB.db";
    public static final String DEPARTMENTTABLE_NAME = "Department";
    public static final String DOCTORTABLE_NAME = "Doctor";
    public static final String DOCTORWORKINGHOURSTABLE_NAME = "Doctor_WorkingHours";
    public static final String HOSPITALTABLE_NAME = "Hospital";
    public static final String HOSPITALADMINTABLE_NAME = "Hospital_Admin";
    public static final String HOSPITALLOCATIONTABLE_NAME = "Hospital_Location";
    public static final String INSURANCECOMPANYTABLE_NAME = "Insurance_Company";
    public static final String OPERATIONTABLE_NAME = "Operation";

    public static final String COLUMN_DEPARTMENTNAME = "department_name";
    public static final String COLUMN_BEDCOUNT = "bed_count";
    public static final String COLUMN_COSTPERNIGHT = "cost_per_night";

    public static final String COLUMN_DOCTORID = "doctor_id";
    public static final String COLUMN_DOCTORNAME = "doctor_name";

    public static final String COLUMN_WORKINGHOUR = "doctor_workingHours";

    public static final String COLUMN_HOSPITALID = "hospital_id";
    public static final String COLUMN_HOSPITALNAME = "hospital_name";
    public static final String COLUMN_INCUBATORCOUNT = "incubator_count";
    public static final String COLUMN_ICUCOUNT = "icu_count";
    public static final String COLUMN_SECTOR = "sector";

    public static final String COLUMN_ADMINNAME = "admin_name";
    public static final String COLUMN_PASSWORD = "password";

    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";

    public static final String COLUMN_INSURANCECOMPANYNAME = "insurancecompany_name";

    public static final String COLUMN_OPERATIONID = "operation_id";
    public static final String COLUMN_OPERATIONCOST = "operation_cost";
    public static final String COLUMN_OPERATIONNAME = "operation_name";

    private static final String CREATE_TABLE_DEPARTMENT = "CREATE TABLE " + DEPARTMENTTABLE_NAME + " (" + COLUMN_DEPARTMENTNAME + " TEXT, "
            + COLUMN_HOSPITALID + " INTEGER, " + COLUMN_BEDCOUNT + " INTEGER, " + COLUMN_COSTPERNIGHT + " INTEGER);";

    private static final String CREATE_TABLE_DOCTOR = "CREATE TABLE " + DOCTORTABLE_NAME + "( " + COLUMN_DOCTORID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DOCTORNAME +" TEXT, " + COLUMN_DEPARTMENTNAME + " TEXT);";

    private static final String CREATE_TABLE_DOCTORWORKINGHOURS = "CREATE TABLE " + DOCTORWORKINGHOURSTABLE_NAME + "( " +COLUMN_DOCTORID+ " INTEGER, "
            + COLUMN_WORKINGHOUR + " TEXT);";

    private static final String CREATE_TABLE_HOSPITAL = "CREATE TABLE " + HOSPITALTABLE_NAME + "( " +COLUMN_HOSPITALID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_HOSPITALNAME + " TEXT, " +COLUMN_INCUBATORCOUNT + " INTEGER, "+ COLUMN_ICUCOUNT +" INTEGER, " + COLUMN_SECTOR + " TEXT);";

    private static final String CREATE_TABLE_HOSPITALADMIN = "CREATE TABLE " + HOSPITALADMINTABLE_NAME +" ( "+ COLUMN_HOSPITALID + " INTEGER, "
            + COLUMN_ADMINNAME + " TEXT, " + COLUMN_PASSWORD + " TEXT);";

    private static final String CREATE_TABLE_HOSPITALLOCATION = "CREATE TABLE " + HOSPITALLOCATIONTABLE_NAME + " ( " + COLUMN_HOSPITALID + " INTEGER, "
            + COLUMN_LATITUDE + " TEXT, " + COLUMN_LONGITUDE + ");";

    private static final String CREATE_TABLE_INSURANCECOMPANY = "CREATE TABLE " + INSURANCECOMPANYTABLE_NAME + " ( " +  COLUMN_HOSPITALID + " INTEGER, "
            + COLUMN_INSURANCECOMPANYNAME + " TEXT);";

    private static final String CREATE_TABLE_OPERATION = "CREATE TABLE " + COLUMN_OPERATIONID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DEPARTMENTNAME
            + " TEXT, " + COLUMN_OPERATIONCOST + " INTEGER, " + COLUMN_OPERATIONNAME + " TEXT);";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HOSPITAL);
        db.execSQL(CREATE_TABLE_HOSPITALADMIN);
        db.execSQL(CREATE_TABLE_HOSPITALLOCATION);
        db.execSQL(CREATE_TABLE_INSURANCECOMPANY);
        db.execSQL(CREATE_TABLE_DEPARTMENT);
        db.execSQL(CREATE_TABLE_DOCTOR);
        db.execSQL(CREATE_TABLE_DOCTORWORKINGHOURS);
        db.execSQL(CREATE_TABLE_OPERATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + CREATE_TABLE_OPERATION + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + CREATE_TABLE_DOCTORWORKINGHOURS + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + CREATE_TABLE_DOCTOR + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + CREATE_TABLE_DEPARTMENT + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + CREATE_TABLE_INSURANCECOMPANY + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + CREATE_TABLE_HOSPITALLOCATION + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + CREATE_TABLE_HOSPITALADMIN + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + CREATE_TABLE_HOSPITAL + "'");
        onCreate(db);
    }

    public void insertHospital(String name, int incubator_count, int icu_count, String sector){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_HOSPITALNAME, name);
        values.put(COLUMN_INCUBATORCOUNT, incubator_count);
        values.put(COLUMN_ICUCOUNT, icu_count);
        values.put(COLUMN_SECTOR, sector);
        
        long id = db.insertWithOnConflict(HOSPITALTABLE_NAME, null, values, SQLiteDatabase.CONFLICT_IGNORE);

    }

    public Hospital findHospital(String name){
        String query = "SELECT * FROM " + HOSPITALTABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);
        Hospital hospital = new Hospital();
        if(c.moveToFirst()) {
            do {
               hospital.setId(c.getInt(c.getColumnIndex(COLUMN_HOSPITALID)));
               hospital.setIcu_count(c.getInt(c.getColumnIndex(COLUMN_ICUCOUNT)));
               hospital.setIncubator_count(c.getInt(c.getColumnIndex(COLUMN_INCUBATORCOUNT)));
               hospital.setName(c.getString(c.getColumnIndex(COLUMN_HOSPITALNAME)));
               hospital.setSector(c.getString(c.getColumnIndex(COLUMN_SECTOR)));
            } while (c.moveToNext());
        }
        return hospital;    }
}


