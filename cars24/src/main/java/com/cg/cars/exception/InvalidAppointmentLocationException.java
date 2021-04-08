package com.cg.cars.exception;

public class InvalidAppointmentLocationException extends AppointmentExceptions {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidAppointmentLocationException(String message)
    {
        super(message);
        this.message=message;
    }

    private String message;

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
