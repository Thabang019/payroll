package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

import static za.ac.cput.util.Helper.isValidEmail;

public class ContactFactory {

    public static Contact createContact(String email, String mobile, String workTelephone){
        if(!Helper.isValidEmail(email))
            return null;
        if(Helper.isNotTenDigits(mobile) || Helper.isNotTenDigits(workTelephone))
           return null;

        return new Contact.Builder()
                .setEmail(email)
                .setMobile(mobile)
                .setWorkTelephone(workTelephone)
                .build();
    }
}
