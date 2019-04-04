package com.example.puza.mvpapiimplementation.application.dataprovider.local;

public class DbSetup {
    public static final String DB_NAME = "Reecharger.db";
    public static final int DB_VERSION = 1;

    public DbSetup() {
    }

    public static abstract class MasterTable {
        /*Table Name of  MasterTable*/
        public final static String TABLE_CMIS_MASTER = "TABLE_CMIS_MASTER";

//        /*column name of Master table*/
//        public final static String ID = "ID";
//        public final static String PARTNER_ID = "PARTNER_ID";
//        public final static String ACADEMIC_YEAR = "ACADEMIC_YEAR";
//        public final static String DISTRICT_ID = "DISTRICT_ID";
//        public final static String VDC_ID = "VDC_ID";
//        public final static String WARD_ID = "WARD_ID";
//        public final static String TOLE_ID = "TOLE_ID";
//        public final static String SCHOOL_ID = "SCHOOL_ID";
//        public final static String ETHINICITY_ID = "ETHINICITY_ID";
//        public final static String OCCUPATION_ID = "OCCUPATION_ID";
//        public final static String LANGUAGE_ID = "LANGUAGE_ID";
//        public final static String LIVING_STATUS = "LIVING_STATUS";
//        public final static String INCOME_ID = "INCOME_ID";
//        public final static String LAND_AREA_PROPERTY = "LAND_AREA_PROPERTY";
//        public final static String YIELDS_MONTH = "YIELDS_MONTH";
//        public final static String DOMESTICATED_INCOME = "DOMESTICATED_INCOME";
//        public final static String DOMESTICATED_ANIMAL = "DOMESTICATED_ANIMAL";
//        public final static String HOUSEHOLD_WORKER = "HOUSEHOLD_WORKER";
//        public final static String HOUSEHOLD_WORKER_AGE = "HOUSEHOLD_WORKER_AGE";
//        public final static String HOUSEHOLD_WORKER_SCHOOL_STATUS = "HOUSEHOLD_WORKER_SCHOOL_STATUS";
//        public final static String TOILET_STATUS = "TOILET_STATUS";
//        public final static String TOILET_TYPE = "TOILET_TYPE";
//        public final static String CHILD_NANNY = "CHILD_NANNY";
//        public final static String CONVERSATION_WITH_CHILD = "CONVERSATION_WITH_CHILD";
//        public final static String PLAY_WITH_CHILD = "PLAY_WITH_CHILD";
//        public final static String STORY_TELLING_CHILD = "STORY_TELLING_CHILD";
//        public final static String CHILD_MEAL_ACTIVITY = "CHILD_MEAL_ACTIVITY";
//        public final static String TOYS_AT_HOME = "TOYS_AT_HOME";
//        public final static String GPS = "GPS";
//        public final static String IMEI = "IMEI";
//
//        static final String CREATE_TABLE =
//                "CREATE TABLE " + TABLE_CMIS_MASTER + " ( " +
//                        ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, " +
//                        PARTNER_ID + " INTEGER NOT NULL, " +
//                        ACADEMIC_YEAR + " INTEGER NOT NULL, " +
//                        DISTRICT_ID + " INTEGER NOT NULL, " +
//                        VDC_ID + " INTEGER NOT NULL, " +
//                        WARD_ID + " INTEGER NOT NULL, " +
//                        TOLE_ID + " INTEGER NOT NULL, " +
//                        SCHOOL_ID + " INTEGER NOT NULL, " +
//                        ETHINICITY_ID + " INTEGER NOT NULL, " +
//                        OCCUPATION_ID + "  NOT NULL, " +
//                        LANGUAGE_ID + "  INTEGER NOT NULL, " +
//                        LIVING_STATUS + " INTEGER NOT NULL, " +
//                        INCOME_ID + " VARCHAR(10) NOT NULL, " +
//                        LAND_AREA_PROPERTY + " REAL NOT NULL, " +
//                        YIELDS_MONTH + " INTEGER NOT NULL, " +
//                        DOMESTICATED_INCOME + " INTEGER NOT NULL, " +
//                        DOMESTICATED_ANIMAL + " INTEGER NULL, " +
//                        HOUSEHOLD_WORKER + " INTEGER NOT NULL, " +
//                        HOUSEHOLD_WORKER_AGE + " REAL NULL, " +
//                        HOUSEHOLD_WORKER_SCHOOL_STATUS + " INTEGER NULL, " +
//                        TOILET_STATUS + " INTEGER  NOT NULL, " +
//                        TOILET_TYPE + " INTEGER  NULL, " +
//                        CHILD_NANNY + " INTEGER NOT NULL, " +
//                        CONVERSATION_WITH_CHILD + " INTEGER NOT NULL, " +
//                        PLAY_WITH_CHILD + " INTEGER NOT NULL, " +
//                        STORY_TELLING_CHILD + " INTEGER NOT NULL, " +
//                        CHILD_MEAL_ACTIVITY + " INTEGER NOT NULL, " +
//                        TOYS_AT_HOME + " INTEGER NOT NULL, " +
//                        GPS + " VARCHAR(50) NOT NULL, " +
//                        IMEI + " INTEGER NOT NULL" + ");";
//

//        static ContentValues toContentValues(MasterData data) {
//            ContentValues values = new ContentValues();
////            values.put(ID, data.getID());
//            values.put(PARTNER_ID, data.getPARTNER_ID());
//            values.put(ACADEMIC_YEAR, data.getACADEMIC_YEAR());
//            values.put(DISTRICT_ID, data.getDISTRICT_ID());
//            values.put(VDC_ID, data.getVDC_ID());
//            values.put(WARD_ID, data.getWARD_ID());
//            values.put(TOLE_ID, data.getTOLE_ID());
//            values.put(SCHOOL_ID, data.getSCHOOL_ID());
//            values.put(ETHINICITY_ID, data.getETHINICITY_ID());
//            values.put(OCCUPATION_ID, data.getOCCUPATION_ID());
//            values.put(LANGUAGE_ID, data.getLANGUAGE_ID());
//            values.put(LIVING_STATUS, data.getLIVING_STATUS());
//            values.put(INCOME_ID, data.getINCOME_ID());
//            values.put(LAND_AREA_PROPERTY, data.getLAND_AREA_PROPERTY());
//            values.put(YIELDS_MONTH, data.getYIELDS_MONTH());
//            values.put(DOMESTICATED_INCOME, data.getDOMESTICATED_INCOME());
//            values.put(DOMESTICATED_ANIMAL, data.getDOMESTICATED_ANIMAL());
//            values.put(HOUSEHOLD_WORKER, data.getHOUSEHOLD_WORKER());
//            values.put(HOUSEHOLD_WORKER_AGE, data.getHOUSEHOLD_WORKER_AGE());
//            values.put(HOUSEHOLD_WORKER_SCHOOL_STATUS, data.getHOUSEHOLD_WORKER_SCHOOL_STATUS());
//            values.put(TOILET_STATUS, data.getTOILET_STATUS());
//            values.put(TOILET_TYPE, data.getTOILET_TYPE());
//            values.put(CHILD_NANNY, data.getCHILD_NANNY());
//            values.put(CONVERSATION_WITH_CHILD, data.getCONVERSATION_WITH_CHILD());
//            values.put(PLAY_WITH_CHILD, data.getPLAY_WITH_CHILD());
//            values.put(STORY_TELLING_CHILD, data.getSTORY_TELLING_CHILD());
//            values.put(CHILD_MEAL_ACTIVITY, data.getCHILD_MEAL_ACTIVITY());
//            values.put(TOYS_AT_HOME, data.getTOYS_AT_HOME());
//            values.put(GPS, data.getGPS());
//            values.put(IMEI, data.getIMEI());
//            return values;
//        }
//
//        static ArrayList<MasterData> parseListCursor(Cursor cursor) {
//            ArrayList<MasterData> customerKycUse = new ArrayList<>();
//            if (cursor.getCount() >= 1) {
//                while (cursor.moveToNext()) {
//                    customerKycUse.add(new MasterData(
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
//                                    cursor.getLong(cursor.getColumnIndexOrThrow(PARTNER_ID)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(ACADEMIC_YEAR)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(DISTRICT_ID)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(VDC_ID)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(WARD_ID)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(TOLE_ID)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(SCHOOL_ID)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(ETHINICITY_ID)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(OCCUPATION_ID)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(LANGUAGE_ID)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(LIVING_STATUS)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(INCOME_ID)),
//                                    cursor.getDouble(cursor.getColumnIndexOrThrow(LAND_AREA_PROPERTY)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(YIELDS_MONTH)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(DOMESTICATED_INCOME)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(DOMESTICATED_ANIMAL)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(HOUSEHOLD_WORKER)),
//                                    cursor.getDouble(cursor.getColumnIndexOrThrow(HOUSEHOLD_WORKER_AGE)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(HOUSEHOLD_WORKER_SCHOOL_STATUS)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(TOILET_STATUS)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(TOILET_TYPE)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(CHILD_NANNY)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(CONVERSATION_WITH_CHILD)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(PLAY_WITH_CHILD)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(STORY_TELLING_CHILD)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(CHILD_MEAL_ACTIVITY)),
//                                    cursor.getInt(cursor.getColumnIndexOrThrow(TOYS_AT_HOME)),
//                                    cursor.getString(cursor.getColumnIndexOrThrow(GPS)),
//                                    cursor.getLong(cursor.getColumnIndexOrThrow(IMEI))
//                            )
//                    );
//                }
//            }
//            return customerKycUse;
//        }
    }


}

