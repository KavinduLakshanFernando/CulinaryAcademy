package lk.ijse.bo;


import lk.ijse.bo.custom.impl.ProgramBOImpl;
import lk.ijse.bo.custom.impl.UserBOImpl;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){
    }
    public static BoFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BoFactory() : boFactory;
    }

    public enum BOTypes{
        USER,PROGRAM
    }


    public SuperBo getBO(BOTypes types){
        switch (types){
            case PROGRAM:
                return new ProgramBOImpl();
            case USER:
                return new UserBOImpl();
        }
        return null;
    }
}
