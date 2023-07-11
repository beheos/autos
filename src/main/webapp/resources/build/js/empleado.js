const validarFormulario = () => {
	if(nombre.value === ''){
		nombre.classList.add('is-invalid');
		return false;
	}else{
		nombre.classList.remove('is-invalid');
	}
	
	if(paterno.value === ''){
		paterno.classList.add('is-invalid');
		return false;
	}else{
		paterno.classList.remove('is-invalid');
	}
	
	if(edad.value === '' || edad.value  < 18){
		edad.classList.add('is-invalid');
		return false;
	}else{
		edad.classList.remove('is-invalid');
	}
	
	 if (sucursal.value === '-1') {
	        sucursal.classList.add('is-invalid');
	        return false;
	 }else{
	        sucursal.classList.remove('is-invalid');
	 }
	 
	 return true;
}

const editar = id => {
	fetch('/empleados/editar/' + id)
	.then(resp => resp.json())
	.then(data => {
		identificador.value = data.id;
		nombre.value = data.nombre;
		paterno.value = data.paterno;
		materno.value = data.materno;
		edad.value = data.edad;
		sucursal.value = data.sucursal.id;
	})
}

const eliminar = id => {
	fetch('/empleados/eliminar/' + id)
}

const limpiarcampos = () => {
	nombre.value = '';
	paterno.value = '';
	materno.value = '';
	edad.value = '';
	sucursal.value = '-1';
} 