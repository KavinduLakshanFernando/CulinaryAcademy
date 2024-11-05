package lk.ijse.bo;


import lk.ijse.bo.custom.impl.StudentBOImpl;
import lk.ijse.bo.custom.impl.UserBOImpl;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){
    }
    public static BoFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BoFactory() : boFactory;
    }

    public enum BOTypes{
        STUDENT,USER,PROGRAM,REGISTRATION
    }


    public SuperBo getBO(BOTypes types){
        switch (types){
            case STUDENT:
                return new StudentBOImpl();
            case USER:
                return new UserBOImpl();
        }
        return null;
    }
}
