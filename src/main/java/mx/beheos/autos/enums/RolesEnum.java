package mx.beheos.autos.enums;

public enum RolesEnum {
	
	ADMINISTRADOR("ADMIN"),
	USUARIO("USER");

	
	private String value;

    private RolesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
