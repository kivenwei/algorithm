package algorithm;

import java.util.ArrayList;

public class Circle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        System.out.println(list.size());
        int d = 3;
        for(int i = 0; i < 10; i++)
        {
        	list.add(i+1);
        }
        System.out.println(list);
        int i =0;
        while(list.size() > 1)
        {
        	
        	for(int j = 1; j < d; j++)
        	{
        		i++;
        		if(i == list.size())
        		{
        			i = 0;
        		}
        	}
        	list.remove(i); 
        	System.out.println(list);
        }
        if(list.size() == 1)
        {
        	System.out.println(list);
        }
	}

}
