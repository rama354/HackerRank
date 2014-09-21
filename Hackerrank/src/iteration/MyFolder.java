package iteration;

import java.util.Queue;

public class MyFolder<T,U> implements Folder<T, U> {

	@Override
	public U fold(U u, Queue<T> list, Function2<T, U, U> function) 
	{
		if(u == null || list == null || function == null)
            throw new IllegalArgumentException();

        if (list.isEmpty()) {
            return u;
        }

        T t=list.poll();
        while(t!=null){
        	u=function.apply(t, u);
        	t=list.poll();
        }
        return fold(u,list,function);
        //return null;
	}

	

}
