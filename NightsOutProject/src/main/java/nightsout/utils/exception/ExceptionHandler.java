package nightsout.utils.exception;

public class ExceptionHandler {
    private static ExceptionHandler instance= null;

    public ExceptionHandler getInstance() {
        if(instance == null){
            instance = new ExceptionHandler();
        }
        return instance;
    }

    /*
    public void handleException(Exception e) throws SystemException {

        if (e instanceof SQLException sql){

            int errorCode = sql.getErrorCode();
            sql.printStackTrace();
            if(errorCode ==0){
                throw new MysqlConnectionFailed();
            }
            else{
                e.printStackTrace();
                throw new SystemException();
            }
        }
        if(e instanceof IOException ||  e instanceof DataFormatException){
            throw new SystemException();
        }
        if(e instanceof CoseException || e instanceof CborParseException ){
            throw new SystemException();
        }
    }
     */

}

