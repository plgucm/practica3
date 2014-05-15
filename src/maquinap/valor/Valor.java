package maquinap.valor;

public abstract class Valor<T> {
	
	private T val;
	
	public Valor(T val){
		this.val = val;
	}
	
	public T getValor() {
		return val;
	}
	
	public void setValor(T otro){
		val = otro;
	}
	
	@Override
	public String toString() {
		return val.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return val.equals(((Valor<?>) obj).getValor());
	}
}
