package com.java.desenvolvimento.infnet.contactschedule.DAO;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfigureFirebase {

    private static DatabaseReference referenceFirebase;

    public static DatabaseReference getFirebase(){
        if (referenceFirebase == null){
            referenceFirebase = FirebaseDatabase.getInstance().getReference();
        }
        return referenceFirebase;
    }
}
