package beans;


public class Salle {
	private int id;
    private String code;
    private String type;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Marque [code=" + code + "]";
	}
	public Salle(int id, String code, String type) {
		super();
		this.id  = id;
		this.code = code;
		this.type = type;
	}
	public Salle(String code, String type) {
		super();
		this.code = code;
		this.type = type;
	}
	
	

}
