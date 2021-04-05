package com.cg.cars.exception;

public class InvalidAppointmentInspectionTypeException extends Exception{


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidAppointmentInspectionTypeException(String message)
    {
        super(message);
    }

    @Override
    public String toString()
    {
        StringBuilder exceptionMessageBuilder=new StringBuilder();
        exceptionMessageBuilder.append("Exception occured at \n");
        for(StackTraceElement element: this.getStackTrace())
        {
            exceptionMessageBuilder.append(element.toString()+"\n");
        }
        return exceptionMessageBuilder.toString();
    }
    
}
