package kraz.slingshot;

/**
 * Created by ZackMisso on 10/18/14.
 */

import android.content.ContentProviderOperation;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.content.ContentProviderResult;
import java.util.ArrayList;

public class ContactShare implements ShareFunction{
    private MainActivity reference;

    public ContactShare(){
        reference=null;
        // implement
    }

    public void share(Object object){
        // implement
    }

    public void addContact(){
        if(reference==null){
            System.out.println("Error :: Reference Null :: ContactShare");
            return;
        }

        ArrayList<ContentProviderOperation> op_list = new ArrayList<ContentProviderOperation>();
        op_list.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                        //.withValue(RawContacts.AGGREGATION_MODE, RawContacts.AGGREGATION_MODE_DEFAULT)
                .build());

        // first and last names
        op_list.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
                .withValueBackReference(Data.RAW_CONTACT_ID, 0)
                .withValue(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE)
                .withValue(StructuredName.GIVEN_NAME, "Second Name")
                .withValue(StructuredName.FAMILY_NAME, "First Name")
                .build());

        op_list.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
                .withValueBackReference(Data.RAW_CONTACT_ID, 0)
                .withValue(ContactsContract.Data.MIMETYPE,ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, "09876543210")
                .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, Phone.TYPE_HOME)
                .build());
        op_list.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
                .withValueBackReference(Data.RAW_CONTACT_ID, 0)

                .withValue(ContactsContract.Data.MIMETYPE,ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Email.DATA, "abc@xyz.com")
                .withValue(ContactsContract.CommonDataKinds.Email.TYPE, Email.TYPE_WORK)
                .build());

        try{
            ContentProviderResult[] results = reference.getContentResolver().applyBatch(ContactsContract.AUTHORITY, op_list);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // getter methods
    public MainActivity getReference(){return reference;}

    // setter methods
    public void setReference(MainActivity param){reference=param;}
}
