package fr.dawan.cart.validator;

import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.dawan.cart.bean.User;
import fr.dawan.cart.dao.ConnectionDB;
import fr.dawan.cart.dao.UserDao;

public class UserValidator {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean eMailValidate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }


    public static String userValidator(String email, String password){
        String message = "";
        if(password.equals("")) {
            message += "password|";
        }
        if(email.equals("")) {
            message += "emailNotNull|";
        }
        if(!eMailValidate(email)) {
            message += "invalidEmail|";
        }
        try {
            Connection cnx = ConnectionDB.getConnection();
            Boolean isMatches = UserDao.pswAndLoginMatche(email, password, cnx, false);
            if(!isMatches)
                message += "EmailAndPasswordNotCorrespondant";
        }catch(Exception e){

        }
        //System.out.println("je retourne message = " + message);
        return message;
    }

    public static String userValidator(User user, String passwordConfirmation){
        String message = "";
        if(user.getForeName().isEmpty())
            message += "forename";
        if(user.getPassword().isEmpty())
            message += "password";
        if(user.getEmail().isEmpty())
            message += "emailNotNull";
        if(!eMailValidate(user.getEmail())) {
            message += "invalidEmail";
        } else {
            try {
                Connection cnx = ConnectionDB.getConnection();
                Boolean isExist = UserDao.doesEmailExist(user.getEmail(), cnx, false);
                if(isExist) {
                    message += "alreadyExistMail";
                }
            } catch(Exception e){
                System.out.println("IMPOSSIBLE D'ETABLIR LA CONNEXION");
            }
        }
        if(!user.getPassword().equals(passwordConfirmation))
            message += "errorPasswordConfirmation";
        return message;
    }
}

