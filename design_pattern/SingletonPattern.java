package design_pattern;

public class SingletonPattern
{
    
    private static  volatile SingletonPattern  uniqueInstance;
    
    private SingletonPattern(){}
    
    public static   SingletonPattern  getInstance()
    {
        if (uniqueInstance ==null )
        {
            synchronized(SingletonPattern.class)
            {
                if (uniqueInstance ==null )
                {
                    uniqueInstance=new SingletonPattern();
                }
            }
        }
        return uniqueInstance ;
    }
    
    // other useful methods here
}
