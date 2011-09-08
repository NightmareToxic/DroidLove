package nightmare.droid.helper;

public class Wrapper<T> {
	T obj;
	
	public T getValue(){
		return this.obj;
	}
	
	public void setValue(T obj){
		this.obj = obj;
	}
	
	public Wrapper(T obj){
		this.obj = obj;
	}
}
