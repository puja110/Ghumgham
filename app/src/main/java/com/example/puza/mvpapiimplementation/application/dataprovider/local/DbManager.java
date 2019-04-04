package com.example.puza.mvpapiimplementation.application.dataprovider.local;

import com.google.gson.Gson;
import com.squareup.sqlbrite2.BriteDatabase;

import javax.inject.Inject;


public class DbManager {
    private BriteDatabase db;
    private Gson gson;

    @Inject
    public DbManager(BriteDatabase db, Gson gson) {
        this.db = db;
        this.gson = gson;
    }

//    public Observable<Boolean> insetIntoTable(final TableInfo tableInfo) {
//        // Seems using fromCallable is safer than creating an observable directly.
//        // If this one doesnot work, use defer.... i think this one will solve a lot of problems.
//        return Observable.fromCallable(() -> {
//                    long result = 0;
//                    if (tableInfo == null) {
//                        return true;
//                    }
//                    BriteDatabase.Transaction transaction = db.newTransaction();
//                    try {
//                        switch (tableInfo.getTableName()) {
//                            case "vdc":
//                                final ArrayList<VDCListData> vdcListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<ArrayList<VDCListData>>() {
//                                        }.getType());
//                                for (VDCListData o : vdcListData) {
//                                    result = db.insert(
//                                            DbSetup.VDCList.TABLE_CMIS_VDC_LIST,
//                                            DbSetup.VDCList.toContentValues(o), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//                                }
//                                break;
//                            case "ward":
//                                Log.e("ward", new Gson().toJson(tableInfo.getRows()));
//                                final ArrayList<WardListData> wardListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<ArrayList<WardListData>>() {
//                                        }.getType());
//                                for (WardListData o : wardListData) {
//                                    result = db.insert(
//                                            DbSetup.WardList.TABLE_CMIS_WARD_LIST,
//                                            DbSetup.WardList.toContentValues(o), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//                                }
//                                break;
//                            case "tole":
//
//                                Log.e("sdffsad", new Gson().toJson(tableInfo.getRows()));
//                                final ArrayList<ToleListData> toleListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<ArrayList<ToleListData>>() {
//                                        }.getType());
//                                for (ToleListData o : toleListData) {
//                                    result = db.insert(
//                                            DbSetup.ToleList.TABLE_CMIS_TOLE_LIST,
//                                            DbSetup.ToleList.toContentValues(o), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//                                }
//                                break;
//                            case "caste":
//                                final ArrayList<CasteListData> casteListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<ArrayList<CasteListData>>() {
//                                        }.getType());
//                                for (CasteListData o : casteListData) {
//                                    result = db.insert(
//                                            DbSetup.CasteList.TABLE_CMIS_CASTE_LIST,
//                                            DbSetup.CasteList.toContentValues(o), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//                                }
//                                break;
//                            case "waterSource":
//                                final ArrayList<WaterListData> waterListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<ArrayList<WaterListData>>() {
//                                        }.getType());
//                                for (WaterListData o : waterListData) {
//                                    result = db.insert(
//                                            DbSetup.WaterList.TABLE_CMIS_WATER_LIST,
//                                            DbSetup.WaterList.toContentValues(o), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//                                }
//                                break;
//                            case "qualification":
//                                final ArrayList<QualificationListData> qualificationListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<ArrayList<QualificationListData>>() {
//                                        }.getType());
//                                for (QualificationListData o : qualificationListData) {
//                                    result = db.insert(
//                                            DbSetup.QualificationList.TABLE_CMIS_QUALIFICATION_LIST,
//                                            DbSetup.QualificationList.toContentValues(o), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//                                }
//                                break;
//                            case "toiletType":
//                                final ArrayList<ToiletListData> toiletListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<ArrayList<ToiletListData>>() {
//                                        }.getType());
//                                for (ToiletListData o : toiletListData) {
//                                    result = db.insert(
//                                            DbSetup.ToiletList.TABLE_CMIS_TOILET_LIST,
//                                            DbSetup.ToiletList.toContentValues(o), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//                                }
//                                break;
////                            case "motherLang":
////                                final ArrayList<MotherListData> motherListData = gson.fromJson(
////                                        gson.toJson(tableInfo.getRows()),
////                                        new TypeToken<ArrayList<MotherListData>>() {
////                                        }.getType());
////
////                                for (MotherListData o : motherListData) {
////                                    result = db.insert(
////                                            DbSetup.MotherList.TABLE_CMIS_MOTHER_LIST,
////                                            DbSetup.MotherList.toContentValues(o), SQLiteDatabase.CONFLICT_REPLACE
////                                    );
////                                }
////                                break;
//                            case "disablityType":
//                                final ArrayList<DisabilityListData> disabilityListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<ArrayList<DisabilityListData>>() {
//                                        }.getType());
//                                for (DisabilityListData o : disabilityListData) {
//                                    result = db.insert(
//                                            DbSetup.DisabilityList.TABLE_CMIS_DISABILITY_LIST,
//                                            DbSetup.DisabilityList.toContentValues(o), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//                                }
//                                break;
//                            case "dropoutReason":
//                                final ArrayList<DropOutListData> dropOutListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<ArrayList<DropOutListData>>() {
//                                        }.getType());
//                                for (DropOutListData o : dropOutListData) {
//                                    result = db.insert(
//                                            DbSetup.DropOutList.TABLE_CMIS_DROPOUT_LIST,
//                                            DbSetup.DropOutList.toContentValues(o), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//                                }
//                                break;
//                            case "ocupation":
//                                final ArrayList<OccupationListData> occupationListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<ArrayList<OccupationListData>>() {
//                                        }.getType());
//                                for (OccupationListData o : occupationListData) {
//                                    result = db.insert(
//                                            DbSetup.OccupationList.TABLE_CMIS_OCCUPATION_LIST,
//                                            DbSetup.OccupationList.toContentValues(o), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//                                }
//                                break;
//
//                            case "language":
//                                final ArrayList<LanguageListData> languageListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<ArrayList<LanguageListData>>() {
//
//                                        }.getType());
//                                for (LanguageListData l : languageListData) {
//                                    result = db.insert(
//                                            DbSetup.LanguageList.TABLE_CMIS_LANGUAGE_LIST,
//                                            DbSetup.LanguageList.toContentValues(l), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//
//                                }
//                                break;
//
//                            case "income":
//                                final ArrayList<IncomeListData> incomeListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<ArrayList<IncomeListData>>() {
//                                        }.getType());
//                                for (IncomeListData i : incomeListData) {
//                                    result = db.insert(
//                                            DbSetup.IncomeList.TABLE_CMIS_INCOME_SOURCE_LIST,
//                                            DbSetup.IncomeList.toContentValues(i), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//                                }
//                                break;
//                            case "school":
//                                final SchoolListData schoolListData = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<SchoolListData>() {
//                                        }.getType());
//                                for (SchoolListData.SchoolCatchment o : schoolListData.getSchoolCatchment()) {
//
//                                    result = db.insert(
//                                            DbSetup.SchoolList.TABLE_CMIS_SCHOOL_LIST,
//                                            DbSetup.SchoolList.toContentValues(new SchoolListSave(
//                                                    schoolListData.getNepaliCurrentyear(),
//                                                    o.getID(),
//                                                    o.getSCHOOL_NAME(),
//                                                    o.getDISTRICT_ID(),
//                                                    o.getVDC_ID(),
//                                                    o.getWARD_ID(),
//                                                    o.getTOLE_ID()
//                                            )), SQLiteDatabase.CONFLICT_REPLACE
//                                    );
//                                }
//                                break;
//                            case DbSetup.MasterTable.TABLE_CMIS_MASTER:
//                                final SaveHouseholdRegister saveHouseholdRegister = gson.fromJson(
//                                        gson.toJson(tableInfo.getRows()),
//                                        new TypeToken<SaveHouseholdRegister>() {
//                                        }.getType());
//                                result = db.insert(
//                                        DbSetup.MasterTable.TABLE_CMIS_MASTER,
//                                        DbSetup.MasterTable.toContentValues(new MasterData(
//                                                1,
//                                                Long.parseLong(saveHouseholdRegister.getUserId()),
//                                                Integer.parseInt(saveHouseholdRegister.getAcademicYearId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmDistrictId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmVdcId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmWardId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmToleId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmSchoolNameId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmCasteId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmOccupationId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmMotherLanguageId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmStaysStatusId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmIncomeSourceId()),
//                                                Double.parseDouble(saveHouseholdRegister.getmCultivatedLandId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmProductMonthId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmAmimalStatusId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmAnimalNameId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmHomeMaidStatusId()),
//                                                Double.parseDouble(saveHouseholdRegister.getmMaidAgeId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmHomeMaidSchoolStatusId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmToiletStatusId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmToiletTypeId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmChildRespoId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmChildCommuniId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmChildPlayId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmChildStoryId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmChildFoodAndTalkId()),
//                                                Integer.parseInt(saveHouseholdRegister.getmChildToyId()),
//                                                "1",
//                                                Long.parseLong("1")
//                                        )), SQLiteDatabase.CONFLICT_REPLACE);
//                                break;
//                            default:
//                                break;
//                        }
//                        transaction.markSuccessful();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    } finally {
//                        transaction.end();
//                    }
//                    // Return Result
//
//
//                    Log.e("result", String.valueOf(result));
//
//
//                    return result > 0;
//                }
//        );
//    }


}

