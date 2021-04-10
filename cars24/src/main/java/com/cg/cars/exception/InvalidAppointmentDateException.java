package com.cg.cars.exception;

public class InvalidAppointmentDateException extends AppointmentExceptions {
    
    /**
     *
     */
    private static final long serialVersionUID = -2951573369975639410L;

    private String message;
    public InvalidAppointmentDateException(String message)
    {
        super(message);
        this.message=message;
    }

    @Override
    public String toString()
    {
        StringBuilder exceptionMessageBuilder=new StringBuilder();
        exceptionMessageBuilder.append(message+"\n");
        exceptionMessageBuilder.append("Exception occured at \n");
        for(StackTraceElement element: this.getStackTrace())
        {
            exceptionMessageBuilder.append(element.toString()+"\n");
        }
        return exceptionMessageBuilder.toString();
    }
    @Override
    public String getMessage()
    {
        return this.message;
    }
}
